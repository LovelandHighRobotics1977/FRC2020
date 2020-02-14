package frc.robot.commands.drive;

import edu.wpi.first.wpilibj.GenericHID.RumbleType;
import frc.robot.commands.CommandBase;

//import edu.wpi.first.wpilibj.Joystick;

public class UserDrive extends CommandBase {
	//Time for 180 degree turn

	RumbleType type = RumbleType.kRightRumble;
	boolean turning;
	
	public UserDrive() {
		requires(drive);
	}

	public void vibrator(){
		oi.getDriveJoystick().setRumble(type, 0.5);
	}

	public void stopVibrator(){
		oi.getDriveJoystick().setRumble(type, 0.0);
	}

	public double cap(double value, double cap){
		if(value > cap){
			value = cap;
		} else if(value < -cap){
			value = -cap;
		}
		return value;
	}
	
	protected void execute() {
		double hPower = oi.getDriveJoystick().getLeftX();
		double vPower = oi.getDriveJoystick().getLeftY();
		double turn = (oi.getDriveJoystick().getLeftTriggerAxis() * 0.7)
				- (oi.getDriveJoystick().getRightTriggerAxis() * 0.7);
		
		if (Math.abs(hPower) < .2) {
			hPower = 0;
		}

		if (Math.abs(vPower) < .2) {
			vPower = 0;
		}

		if (Math.abs(turn) < .2) {
			turn = 0;
			turning = false;
		} else {
			turning = true;
		}
		drive.drive(cap(vPower, .8));
		//oi.getDriveJoystick().setRumble(type, 0.5);
		if(turning){
		drive.turn(cap(-turn, .6));
		}

		//boolean aButton = 
		/*if(oi.getDriveJoystick().getAButtonValue()){
			shooter.setPower(1);
		}
		else if(oi.getDriveJoystick().getXButtonValue()){
			shooter.setPower(2);
		}
		else if(oi.getDriveJoystick().getBButtonValue()){
			shooter.setPower(3);
		}
		else{
			shooter.setPower(0);
		}*/
		
	}
	
	// Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	drive.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	drive.stop();
    }
}