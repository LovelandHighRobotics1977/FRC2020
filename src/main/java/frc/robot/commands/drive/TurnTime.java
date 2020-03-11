package frc.robot.commands.drive;

import frc.robot.commands.CommandBase;


public class TurnTime extends CommandBase {

	/*private final String commandName = "Drive Forward";
    private final String subsytemName = "Drive";*/

    private final double vPower;

    private double turnSpeed;
    
    //Percentage goes from -1 to 1 - See CTRE documentation http://www.ctr-electronics.com/downloads/api/java/html/index.html
    public TurnTime(double speedPercent) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(drive);
        
        vPower = speedPercent;
        //System.out.println("drive time is go");
    }
    //EPIC
 // Called just before this Command runs the first time
    protected void initialize() {
        turnSpeed = vPower;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	System.out.println("Calling Drive: " + turnSpeed);
        drive.turn(turnSpeed);
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