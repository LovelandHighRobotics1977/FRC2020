package frc.robot.subsystems;


import edu.wpi.first.wpilibj.Compressor;
//import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Pneumatic extends Subsystem{
	public static Pneumatic instance;
	private Compressor compressor1;
	//Relay compressorRelay = new Relay(0);
	DoubleSolenoid piston1;
	DoubleSolenoid piston2;
	DoubleSolenoid piston3;
	DoubleSolenoid piston4;

	

	Pneumatic(){
		piston1 = new DoubleSolenoid(0, 0);
		piston2 = new DoubleSolenoid(0,0);
		piston3 = new DoubleSolenoid(0,0);
		piston4 = new DoubleSolenoid(0,0);

		compressor1 = new Compressor(0);
		compressor1.setClosedLoopControl(true);
		//compressorRelay.set(Relay.Value.kOn);
		compressor1.start();
		System.out.print("Compressing running? " + compressor1.enabled());
	}
	
	
	public static Pneumatic getInstance() {
		if (instance == null) {
    		instance = new Pneumatic();
    	}
    	return instance;
	}
	
	public void clawraise() {
		piston1.set(DoubleSolenoid.Value.kForward);
		piston2.set(DoubleSolenoid.Value.kForward);
	}
	
	public void clawlower() {
		piston1.set(DoubleSolenoid.Value.kReverse);
		piston2.set(DoubleSolenoid.Value.kReverse);

	}
	
	public void armraise() {
		piston3.set(DoubleSolenoid.Value.kForward);
		piston4.set(DoubleSolenoid.Value.kForward);

	}

	public void armlower() {
		piston3.set(DoubleSolenoid.Value.kReverse);
		piston4.set(DoubleSolenoid.Value.kReverse);
	}
	public void stop() {
		piston1.set(DoubleSolenoid.Value.kOff);
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
		// TODO Auto-generated method stub
		
	}
}