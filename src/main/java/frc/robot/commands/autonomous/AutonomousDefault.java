package frc.robot.commands.autonomous;


import edu.wpi.first.wpilibj.command.CommandGroup;

import frc.robot.commands.drive.*;

public class AutonomousDefault extends CommandGroup {	
	
	int time;
	public AutonomousDefault() {
		// Pause for 118 or any additional teams
		time = 0;
		addTime(3000);
		addSequential(new DriveTime(0, time));
		addTime(3000);
		addSequential(new DriveTime(.4, time));
		addTime(4000);
		addSequential(new TurnTime(0.5, time));
		addTime(2000);
		addSequential(new DriveTime(.4, time));
	}
	// This function allows us to only set the time we want the function to run for, rather than manually needing to add up
	// the time eaach time
	void addTime(int timeAdd) {
		time += timeAdd;
	}
	
}
