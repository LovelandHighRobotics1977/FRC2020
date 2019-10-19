package frc.robot.commands.pneumatic;

import frc.robot.commands.CommandBase;

public class PneumaticDown extends CommandBase{
	long startTime;
	long endTime;
	long commandTime = 5000;
	
	public PneumaticDown() {
		requires(pneumatic);

	}
	
	protected void initialize() {
		System.out.println("Pneumatic going down!");
		startTime = System.currentTimeMillis();
    	endTime = startTime + commandTime;
    }
	
	public void execute() {	
		pneumatic.lower();	
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