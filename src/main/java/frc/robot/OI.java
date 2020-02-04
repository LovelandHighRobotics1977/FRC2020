/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import frc.robot.input.XBoxController;
import frc.robot.commands.pneumatics.*;
import frc.robot.commands.winch.*;
import frc.robot.commands.colorsensor.*;
/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	//// CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	//// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());
	
	//Test
	private static OI instance;
	// XBox Controller references
	private XBoxController driveJoystick;
	private XBoxController auxJoystick;
	//Other joystick will be put here as well
	
	public OI() {
		driveJoystick = new XBoxController(0);
		auxJoystick = new XBoxController(1);
		//Set other controller here once we know if it is used 
		//manipulatorJoystick = new XBoxController(1);
	}
	
	public void init() {
		//Put things here when you want buttons to trigger
		//Speed toggle
		//driveJoystick.leftWhenPressed(new SpeedToggle());
		//Turn functions for shoulders
		//driveJoystick.rightWhileHeld(new TurnTime(500,-1));
		//driveJoystick.leftWhileHeld(new TurnTime(500,1));
		//180 turn function
		//driveJoystick.rightWhenPressed(new TurnTime(500,1)); //THIS NEEDS TO BE Adjusted
		//auxJoystick.startWhenPressed(new CommandAutonomous());
		//auxJoystick.rightThumbWhileHeld(command);

		driveJoystick.yWhenPressed(new Extend());
		driveJoystick.xWhenPressed(new Retract());
		driveJoystick.aWhenPressed(new Dump());
		driveJoystick.bWhenPressed(new Back());

		auxJoystick.rightWhenPressed(new ManualRight());
		auxJoystick.leftWhenPressed(new ManualLeft());
	}
	
	public static OI getInstance() {
		if (instance == null) {
			instance = new OI();
		}
		return instance;
	}
	
	public XBoxController getDriveJoystick() {
		return driveJoystick;
	}

	public XBoxController getAuxJoystick(){
		return auxJoystick;
	}
}
