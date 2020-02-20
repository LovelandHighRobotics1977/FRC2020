package frc.robot.subsystems;


import edu.wpi.first.wpilibj.Compressor;
//import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Pneumatic extends Subsystem{
	public static Pneumatic instance;
	private Compressor compressor1;
	//Relay compressorRelay = new Relay(0);
	DoubleSolenoid hook;
	DoubleSolenoid boxDump;
	DoubleSolenoid boxLift1;
	DoubleSolenoid boxLift2;
	DoubleSolenoid boxOpen;
	DoubleSolenoid boxCover;

	

	Pneumatic(){
		hook = new DoubleSolenoid(2, 3);
		boxDump = new DoubleSolenoid(4,5);
		boxOpen = new DoubleSolenoid(6,7);
		boxLift1 = new DoubleSolenoid(8,9);
		boxLift2 = new DoubleSolenoid(10,11);
		boxCover = new DoubleSolenoid(12,13);
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
	
	public void boxCoverOpen(){

		boxCover.set(DoubleSolenoid.Value.kForward);
	}

	public void boxCoverClose(){

		boxCover.set(DoubleSolenoid.Value.kReverse);
	}

	public void boxOpen(){

		boxOpen.set(DoubleSolenoid.Value.kForward);
	}

	public void boxClose(){

		boxOpen.set(DoubleSolenoid.Value.kReverse);
	}
	public void hookExtend(){

		hook.set(DoubleSolenoid.Value.kForward);
	}
	
	public void hookContract(){

		hook.set(DoubleSolenoid.Value.kReverse);
	}

	public void boxUp(){

		boxDump.set(DoubleSolenoid.Value.kForward);
	}

	public void boxDown(){

		boxDump.set(DoubleSolenoid.Value.kReverse);
	}


	public void boxElevate(){

		boxLift1.set(DoubleSolenoid.Value.kForward);
		boxLift2.set(DoubleSolenoid.Value.kForward);
	}

	public void boxDescend(){

		boxLift1.set(DoubleSolenoid.Value.kReverse);
		boxLift2.set(DoubleSolenoid.Value.kReverse);
	}
	public void stop() {
		hook.set(DoubleSolenoid.Value.kOff);
		boxDump.set(DoubleSolenoid.Value.kOff);
		boxLift1.set(DoubleSolenoid.Value.kOff);
		boxLift2.set(DoubleSolenoid.Value.kOff);
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