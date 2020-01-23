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
	DoubleSolenoid hookLift;
	DoubleSolenoid boxDump;
	DoubleSolenoid boxScoop;
	DoubleSolenoid boxLift1;
	DoubleSolenoid boxLift2;

	

	Pneumatic(){
		hook = new DoubleSolenoid(0, 0);
		hookLift = new DoubleSolenoid(0,0);
		boxDump = new DoubleSolenoid(0,0);
		boxScoop = new DoubleSolenoid(0,0);
		boxLift1 = new DoubleSolenoid(0,0);
		boxLift2 = new DoubleSolenoid(0,0);

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
	public void hookRaise(){

		hookLift.set(DoubleSolenoid.Value.kForward);
	}

	public void hookLower(){

		hookLift.set(DoubleSolenoid.Value.kReverse);
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

	public void boxOpen(){

		boxScoop.set(DoubleSolenoid.Value.kForward);
	}

	public void boxClose(){

		boxScoop.set(DoubleSolenoid.Value.kReverse);
	}

	public void boxElevate(){

		boxLift1.set(DoubleSolenoid.Value.kForward);
		boxLift2.set(DoubleSolenoid.Value.kForward);
	}

	public void boxDecend(){

		boxLift1.set(DoubleSolenoid.Value.kReverse);
		boxLift2.set(DoubleSolenoid.Value.kReverse);
	}
	public void stop() {
		hook.set(DoubleSolenoid.Value.kOff);
		hookLift.set(DoubleSolenoid.Value.kOff);
		boxDump.set(DoubleSolenoid.Value.kOff);
		boxScoop.set(DoubleSolenoid.Value.kOff);
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