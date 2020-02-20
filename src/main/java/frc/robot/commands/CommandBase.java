package frc.robot.commands;
import frc.robot.subsystems.Drive;
import frc.robot.OI;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.Pneumatic;
import frc.robot.subsystems.ColorWheel;

public abstract class CommandBase extends Command {
	/**
	 * Inherited static access to the OI.
	 */
	protected static OI oi;
	protected static Drive drive;
	protected static Pneumatic pneumatic;
	protected static ColorWheel colorwheel;
	/**
	 * Initialize the CommandBase, in doing so accessing and initializing every
	 * primary subsystem on the robot. Use this during robot initialization to
	 * prevent unnecessary redundancy.
	 */
	
	public static void init() {
		oi = OI.getInstance();
		drive = Drive.getInstance();
		colorwheel = ColorWheel.getInstance();
		pneumatic = Pneumatic.getInstance();
	}
}