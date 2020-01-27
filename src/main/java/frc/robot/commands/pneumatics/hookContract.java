/*----------------------------------------------------------------------------*/

/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */

/* Open Source Software - may be modified and shared by FRC teams. The code   */

/* must be accompanied by the FIRST BSD license file in the root directory of */

/* the project.                                                               */

/*----------------------------------------------------------------------------*/



package frc.robot.commands.pneumatics;



//import edu.wpi.first.wpilibj.command.Command;

import frc.robot.commands.CommandBase;

//import frc.robot.subsystems.Pneumatics;

//import frc.robot.Robot;



/**

 * An example command.  You can replace me with your own command.

 */

public class hookContract extends CommandBase {

  long startTime;

  long endTime;

  long commandTime = 5000;

  public hookContract() {

    // Use requires() here to declare subsystem dependencies

    requires(pneumatic);

  }



  // Called just before this Command runs the first time

  @Override

  protected void initialize() {

    startTime = System.currentTimeMillis();

    endTime = startTime + commandTime;

  }



  // Called repeatedly when this Command is scheduled to run

  @Override

  protected void execute() {

    pneumatic.hookContract();

  }



  // Make this return true when this Command no longer needs to run execute()

  @Override

  protected boolean isFinished() {

    return ( System.currentTimeMillis() >= endTime );



  }



  // Called once after isFinished returns true

  @Override

  protected void end() {

    pneumatic.stop();

  }



  // Called when another command which requires one or more of the same

  // subsystems is scheduled to run

  @Override

  protected void interrupted() {

    pneumatic.stop();

  }

}