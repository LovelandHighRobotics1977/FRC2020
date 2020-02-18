package frc.robot.subsystems;

import frc.robot.RobotMap;
import frc.robot.commands.drive.UserDrive;
import frc.robot.commands.CommandBase;

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

	int directCoefficient = 1;

	private boolean direction = true;
	private boolean speedToggle = false;
	
	
	public TalonSRX frontLeft;
	public TalonSRX frontRight;
	public TalonSRX backLeft;
	public TalonSRX backRight;
	
	
	public UserDrive userDrive;
	
	
	private double voltageCoefficient = 1;
	private double turnPowerCoefficient = 1;
	
	private int currentLimit = 5;

	
	public Drive(){
		//Define motor controllers for drive train on test chassis
		frontLeft = new TalonSRX(RobotMap.DRIVE_FRONT_LEFT_TAlON);
    	frontRight = new TalonSRX(RobotMap.DRIVE_FRONT_RIGHT_TALON);
    	backLeft = new TalonSRX(RobotMap.DRIVE_BACK_LEFT_TALON);
		backRight = new TalonSRX(RobotMap.DRIVE_BACK_RIGHT_TALON);
		
		
		//Accounts for left motors facing opposite directions, allows positive values to relate to forward movement
		frontLeft.setInverted(true);
		backLeft.setInverted(true);

		//Limit current draw to prevent brownout
		frontLeft.enableCurrentLimit(true);
		frontRight.enableCurrentLimit(true);
		backLeft.enableCurrentLimit(true);
		backRight.enableCurrentLimit(true);

		frontLeft.configContinuousCurrentLimit(currentLimit);
		frontRight.configContinuousCurrentLimit(currentLimit);
		backLeft.configContinuousCurrentLimit(currentLimit);
		backRight.configContinuousCurrentLimit(currentLimit);


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
     * @param vPower Vertical (forward) power.  Pulled from the Y axis of the 
     * left stick. Positive goes forward!
     * @param turn Turning power.  Pulled from the left and right triggers.
     */
	
	ControlMode iJustWantToSleep = ControlMode.PercentOutput;
	public void drive(double vPower) {
        frontLeft.set(iJustWantToSleep, vPower);
        frontRight.set(iJustWantToSleep, vPower);
        backLeft.set(iJustWantToSleep, vPower);
        backRight.set(iJustWantToSleep, vPower);
	}
	
	public void turn(double turn){
		frontLeft.set(iJustWantToSleep, -turn);
		frontRight.set(iJustWantToSleep, turn);
		backLeft.set(iJustWantToSleep, -turn);
		backRight.set(iJustWantToSleep, turn);
	}
	
	public void stop() {
		drive(0);
		turn(0);
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