package frc.robot.commands.colorwheel;

import frc.robot.RobotMap;
import frc.robot.commands.CommandBase;
import frc.robot.commands.drive.UserDrive;

import frc.robot.subsystems.*;



import com.ctre.phoenix.motorcontrol.ControlMode;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;



//import com.ctre.TalonSRX;



import edu.wpi.first.wpilibj.command.Subsystem;


  public class startColorWheel extends CommandBase{

    long startTime;

  long endTime;

  long commandTime = 5000;

    public startColorWheel(){
      
        requires(colorwheel);
    }

    @Override
    protected void execute(){

      
      
    }

    @Override
  protected boolean isFinished() {
    return ( System.currentTimeMillis() >= endTime );
  }

    
  }