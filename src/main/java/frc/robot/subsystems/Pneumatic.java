package frc.robot.subsystems;


import edu.wpi.first.wpilibj.Compressor;
//import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Pneumatic extends Subsystem{
	public static Pneumatic instance;
	private Compressor compressor1;
	//Relay compressorRelay = new Relay(0);
	DoubleSolenoid arm;
	DoubleSolenoid claw;

	
	
	Pneumatic(){
		arm = new DoubleSolenoid(6,7);
		claw = new DoubleSolenoid(4,5);
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

	public void armRaise(){
		arm.set(DoubleSolenoid.Value.kForward);
	}

	public void armLower(){
		arm.set(DoubleSolenoid.Value.kReverse);
	}
	
	public void clawRaise() {
		claw.set(DoubleSolenoid.Value.kForward);
	}
	
	public void clawLower() {
		claw.set(DoubleSolenoid.Value.kReverse);
	}

	public void stop(){
		claw.set(DoubleSolenoid.Value.kOff);
		arm.set(DoubleSolenoid.Value.kOff);
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