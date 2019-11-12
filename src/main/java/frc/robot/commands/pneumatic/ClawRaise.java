package frc.robot.commands.pneumatic;

import frc.robot.commands.CommandBase;

public class ClawRaise extends CommandBase{
	long startTime;
	long endTime;
	long commandTime = 5000;
	
	public ClawRaise() {
		requires(pneumatic);

	}
	
	protected void initialize() {
		System.out.println("Pneumatic going down!");
		startTime = System.currentTimeMillis();
    	endTime = startTime + commandTime;
    }
	
	public void execute() {	
		pneumatic.clawRaise();	
	}
	
	protected boolean isFinished() {
		return ( System.currentTimeMillis() >= endTime );
	}
	
	protected void interrupted() {
		pneumatic.stop();
	}
	
	protected void end() {
		pneumatic.stop();
	}

}