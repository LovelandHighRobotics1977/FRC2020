 package frc.robot.commands.autonomous;


 import edu.wpi.first.wpilibj.command.CommandGroup;

 import frc.robot.commands.drive.*;

 public class AutonomousDefault extends CommandGroup {	
	

     public AutonomousDefault() {
		// Takes in command then time in seconds, NOT miliseconds
        addSequential(new DriveTime(.5), 2);
        addSequential(new TurnTime(.5), 2);
        addSequential(new DriveTime(.5), 2);

 	}
	
 }
