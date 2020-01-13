/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.MotorTest;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.commands.CommandBase;
/**
 * An example command.  You can replace me with your own command.
 */
public class directionTwo extends CommandBase {
  long startTime;
  long endTime;
  long commandTime = 150;


  public directionTwo() {
    // Use requires() here to declare subsystem dependencies
    requires(motorTest);
  }

  // Called just before this Command runs the first time
  protected void initialize() {
      startTime = System.currentTimeMillis();
      endTime = startTime + commandTime;
  }

  // Called repeatedly when this Command is scheduled to run
  protected void execute() {
    motorTest.directionTwo();
  }

  // Make this return true when this Command no longer needs to run execute()
  protected boolean isFinished() {
    if(System.currentTimeMillis() >= endTime){
      return true;
    }
    return false;
  }

  // Called once after isFinished returns true
  protected void end() {
    motorTest.stop();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  protected void interrupted() {
    motorTest.stop();
  }
}
