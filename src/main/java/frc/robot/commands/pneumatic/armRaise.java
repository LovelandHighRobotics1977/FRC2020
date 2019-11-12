package frc.robot.commands.pneumatic;

import frc.robot.commands.CommandBase;

public class armRaise extends CommandBase{
	long startTime;
	long endTime;
	long commandTime = 5000;
	
	public armRaise() {
		requires(pneumatic);
		
	}
	
	protected void initialize() {
		System.out.println("Pneumatic going up!");
		startTime = System.currentTimeMillis();
    	endTime = startTime + commandTime;
    }
	
	public void execute() {	
		pneumatic.armraise();	
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