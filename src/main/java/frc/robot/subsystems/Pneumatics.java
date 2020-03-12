package frc.robot.subsystems;


import edu.wpi.first.wpilibj.Compressor;
//import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Pneumatics extends Subsystem{
	public static Pneumatics instance;
	public Compressor compressor1;
	//Relay compressorRelay = new Relay(0);
    DoubleSolenoid dumpPiston;
	DoubleSolenoid climbPiston;
	
	
	Pneumatics(){
		dumpPiston = new DoubleSolenoid(2,5);
		climbPiston = new DoubleSolenoid(0,1);
		compressor1 = new Compressor(0);
		compressor1.setClosedLoopControl(true);
		//compressorRelay.set(Relay.Value.kOn);
		compressor1.start();
		System.out.print("Compressing running? " + compressor1.enabled());
	}
	
	
	public static Pneumatics getInstance() {
		if (instance == null) {
    		instance = new Pneumatics();
    	}
    	return instance;
	}
	
    public void dump(){
        dumpPiston.set(DoubleSolenoid.Value.kForward);
    }
    public void back(){
        dumpPiston.set(DoubleSolenoid.Value.kReverse);
	}
	
	public void climb(){
		climbPiston.set(DoubleSolenoid.Value.kForward);
	}

	public void lower(){
		climbPiston.set(DoubleSolenoid.Value.kReverse);
	}
	
	public void stop() {
		dumpPiston.set(DoubleSolenoid.Value.kOff);
		climbPiston.set(DoubleSolenoid.Value.kOff);
		//compressorRelay.set(Relay.Value.kOff);
	}
	
	/*public void startClosedLoop(){
		compressor1.setClosedLoopControl(true);
	}*/
	
	public void stopCompressor() {
		compressor1.stop();
		
	}


	@Override
	protected void initDefaultCommand() {
		
	}
}