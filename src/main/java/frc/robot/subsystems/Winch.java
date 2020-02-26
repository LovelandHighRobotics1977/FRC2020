/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import frc.robot.RobotMap;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class Winch extends Subsystem {

    public static Winch instance;

    TalonSRX winchMotor;
    ControlMode winchMode = ControlMode.PercentOutput;
    float speed = 0.5f;

    Winch(){
      winchMotor = new TalonSRX(RobotMap.WINCH_MOTOR);

    }

    public static Winch getInstance() {
      if (instance == null) {
          instance = new Winch();
        }
        return instance;
    }

    public void retract(){
      winchMotor.set(winchMode, -speed);
    }

    public void extend(float givenSpeed){
      winchMotor.set(winchMode, givenSpeed);
    }

    public void stop(){
      winchMotor.set(winchMode, 0);
    }


  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
