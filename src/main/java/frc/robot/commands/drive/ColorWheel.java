package frc.robot.commands.drive;

import frc.robot.RobotMap;

import frc.robot.commands.drive.UserDrive;



import com.ctre.phoenix.motorcontrol.ControlMode;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;



//import com.ctre.TalonSRX;



import edu.wpi.first.wpilibj.command.Subsystem;

public class ColorWheel {

private TalonSRX colorWheel;


public ColorWheel() {

    colorWheel = new TalonSRX(RobotMap.COLOR_WHEEL);
    ControlMode iJustWantToSleep = ControlMode.PercentOutput;

    colorWheel.set(iJustWantToSleep, 0.2);

}

}





