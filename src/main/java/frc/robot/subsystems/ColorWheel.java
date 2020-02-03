package frc.robot.subsystems;

import frc.robot.RobotMap;

import frc.robot.commands.drive.UserDrive;



import com.ctre.phoenix.motorcontrol.ControlMode;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;



//import com.ctre.TalonSRX;



import edu.wpi.first.wpilibj.command.Subsystem;

public class ColorWheel extends Subsystem {


    private TalonSRX colorWheel;

    ControlMode iJustWantToSleep = ControlMode.PercentOutput;
    

    ColorWheel() {
        colorWheel = new TalonSRX(RobotMap.COLOR_WHEEL);

    }

    public void run(){
        colorWheel.set(iJustWantToSleep, 0.2);

    }

    
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}
}







