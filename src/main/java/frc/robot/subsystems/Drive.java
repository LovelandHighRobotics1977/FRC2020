package frc.robot.subsystems;

import frc.robot.RobotMap;
import frc.robot.commands.drive.UserDrive;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

//import com.ctre.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Drive extends Subsystem {
	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	
	private static Drive instance;
	//used for getInstance
	int directCoefficient = 1;
	private boolean direction = true;
	private boolean speedToggle = false;
	//for speedToggle function to halve speed
	
	/*private TALON frontLeft;
	private TALON frontRight;
	private TALON backLeft;
	private TALON backRight;*/
	
	
	private TalonSRX frontLeft;
	private TalonSRX frontRight;
	private TalonSRX backLeft;
	private TalonSRX backRight;
	
	
	private UserDrive userDrive;
	
	//May use if this we need to
	//robotDrive.setInvertedMotor(MotorType.frontLeft, true);
	
	private double voltageCoefficient = 1;
	private double turnPowerCoefficient = 1;

	
	public Drive(){
		//Define motor controllers for drive train on test chassis
		frontLeft = new TalonSRX(RobotMap.DRIVE_FRONT_LEFT_TAlON);
    	frontRight = new TalonSRX(RobotMap.DRIVE_FRONT_RIGHT_TALON);
    	backLeft = new TalonSRX(RobotMap.DRIVE_BACK_LEFT_TALON);
    	backRight = new TalonSRX(RobotMap.DRIVE_BACK_RIGHT_TALON);
    	
    	/* Define motor controllers for drive train on main chassis
    	 * Need this because FIRST only has TALON plugins and they have no idea what its like trying to find and install plugins from third party sites that look fairly sketchy and don't really install right and why can't just add the commonly used motor controllers that they have in their FIRST Choice Program
    	 * http://www.ctr-electronics.com/downloads/pdf/CTRE%20Toolsuite%20Installation%20Guide.pdf*/
    /*	frontLeft = new TalonSRX(RobotMap.DRIVE_FRONT_LEFT_TALON);
    	frontRight = new TalonSRX(RobotMap.DRIVE_FRONT_RIGHT_TALON);
    	backLeft = new TalonSRX(RobotMap.DRIVE_BACK_LEFT_TALON);
    	backRight = new TalonSRX(RobotMap.DRIVE_BACK_RIGHT_TALON);*/
    	
	}
	
	public void initDefaultCommand() {
	       userDrive = new UserDrive();
	       setDefaultCommand(userDrive);
	    }
	
	public static Drive getInstance() {
    	if (instance == null) {
    		instance = new Drive();
    	}
    	return instance;
    }
	
	/**
     * Set the four drive TALONs based upon the specified power values 
     * multiplied by the drivetrain voltage coefficient.
     * @param hPower Horizontal (strafing) power.  Pulled from the X axis of the
     * left stick. Positive goes right!
     * @param vPower Vertical (forward) power.  Pulled from the Y axis of the 
     * left stick. Positive goes forward!
     * @param turn Turning power.  Pulled from the left and right triggers.
     */
	
	ControlMode iJustWantToSleep = ControlMode.PercentOutput;
	public void drive(double hPower, double vPower, double turn) {
        frontLeft.set(iJustWantToSleep, (-hPower + vPower + (turn * turnPowerCoefficient)) * voltageCoefficient * directCoefficient);
        frontRight.set(iJustWantToSleep, (-hPower - vPower + (turn * turnPowerCoefficient)) * voltageCoefficient * directCoefficient);
        backLeft.set(iJustWantToSleep, (hPower + vPower + (turn * turnPowerCoefficient)) * voltageCoefficient * directCoefficient);
        backRight.set(iJustWantToSleep, (hPower - vPower + (turn * turnPowerCoefficient)) * voltageCoefficient * directCoefficient);
    }
	
	public void stop() {
    	drive(0, 0, 0);
    }
	
	public boolean isSpeedToggle() {
		
    	return speedToggle;
    }
    
    public void setSpeedToggle(boolean speedToggle) {
    	this.speedToggle = speedToggle;
    	if (speedToggle) {
    		voltageCoefficient = 0.5;
    	} else {
    		voltageCoefficient = 1.0;
    	}
	}
	
	public boolean isForward() {
		
    	return this.direction;
    }
    
    public void setDirection(boolean direction) {
    	this.direction = direction;
    	if (direction) {
    		directCoefficient = 1;
    	} else {
    		directCoefficient = -1;
		}
		System.out.println("Direction is " + directCoefficient);
    }
}