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

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class MotorTest extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  public static MotorTest instance;
  private TalonSRX controllerOne;
  private TalonSRX controllerTwo;
  private ControlMode TalonControlMode  = ControlMode.PercentOutput;

  MotorTest(){
    controllerOne = new TalonSRX(0);
    controllerTwo = new TalonSRX(1);
  }

  public static MotorTest getInstance(){
      if (instance == null){
        instance = new MotorTest();
      }
      return instance;
  }

  public void directionOne(){
    controllerOne.set(TalonControlMode, 0.3);
    controllerTwo.set(TalonControlMode, 0.3);
  }

  public void directionTwo(){
    controllerOne.set(TalonControlMode, -0.3);
    controllerTwo.set(TalonControlMode, -0.3);
  }

  public void stop(){
    controllerOne.set(TalonControlMode, 0);
    controllerTwo.set(TalonControlMode, 0);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
