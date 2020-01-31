package frc.robot.commands;

import frc.robot.OI;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.Drive;
import frc.robot.subsystems.Pneumatics;
import frc.robot.subsystems.ColorSensor;
import frc.robot.subsystems.Winch;


public abstract class CommandBase extends Command {
	/**
	 * Inherited static access to the OI.
	 */
	protected static OI oi;
	public static Drive drive;
	protected static Pneumatics pneumatics;
	public static ColorSensor colorSensor;
	protected static Winch winch;
	/**
	 * Initialize the CommandBase, in doing so accessing and initializing every
	 * primary subsystem on the robot. Use this during robot initialization to
	 * prevent unnecessary redundancy.
	 */
	
	public static void init() {
		oi = OI.getInstance();
		drive = Drive.getInstance();
		pneumatics = Pneumatics.getInstance();
		colorSensor = ColorSensor.getInstance();
		winch = Winch.getInstance();
	}
}