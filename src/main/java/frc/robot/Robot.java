/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;


import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import frc.robot.XBoxController;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;


/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
public class Robot extends TimedRobot {
	private XBoxController driveJoystick;

	ControlMode iJustWantToSleep = ControlMode.PercentOutput;

	private TalonSRX frontLeft;
	private TalonSRX frontRight;
	private TalonSRX backLeft;
	private TalonSRX backRight;

	boolean turning;

	@Override
	public void robotInit() {

		//Talon Initialization
		frontLeft = new TalonSRX(RobotMap.DRIVE_FRONT_LEFT_TAlON);
    	frontRight = new TalonSRX(RobotMap.DRIVE_FRONT_RIGHT_TALON);
    	backLeft = new TalonSRX(RobotMap.DRIVE_BACK_LEFT_TALON);
		backRight = new TalonSRX(RobotMap.DRIVE_BACK_RIGHT_TALON);

		driveJoystick = new XBoxController(0);
		
		//Accounts for left motors facing opposite directions, allows positive values to relate to forward movement
		frontLeft.setInverted(true);
		backLeft.setInverted(true);
	}

	@Override
	public void robotPeriodic() {
	}
	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {
	}
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

	public void fullDrive(double drive, double turn){
		
	}
	
	public void stop() {
		drive(0);
		turn(0);
    }

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * <p>You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
	}

	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		System.out.println("Control?");
	}

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();

		double vPower = driveJoystick.getLeftY();
		double turn = (driveJoystick.getLeftTriggerAxis() * 0.7)
				- (driveJoystick.getRightTriggerAxis() * 0.7);

		if (Math.abs(vPower) < .2) {
			vPower = 0;
		}

		if (Math.abs(turn) < .2) {
			turn = 0;
			turning = false;
		} else {
			turning = true;
		}

		drive(-vPower);
		if(turning){
			turn(-turn);
		}
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
	}
}
