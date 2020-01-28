package frc.robot.subsystems;


import edu.wpi.first.wpilibj.Compressor;
//import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Pneumatics extends Subsystem{
	public static Pneumatics instance;
	private Compressor compressor1;
	//Relay compressorRelay = new Relay(0);
    DoubleSolenoid liftPiston;
    DoubleSolenoid dumpPiston;

	
	
	Pneumatics(){
        liftPiston = new DoubleSolenoid(6, 7);
        dumpPiston = new DoubleSolenoid(4,5);
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
	
	public void climb() {
		liftPiston.set(DoubleSolenoid.Value.kForward);
	}
	
	public void lower() {
		liftPiston.set(DoubleSolenoid.Value.kReverse);
    }
    
    public void dump(){
        dumpPiston.set(DoubleSolenoid.Value.kForward);
    }
    public void back(){
        dumpPiston.set(DoubleSolenoid.Value.kReverse);
    }
	
	public void stop() {
        liftPiston.set(DoubleSolenoid.Value.kOff);
        dumpPiston.set(DoubleSolenoid.Value.kOff);
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