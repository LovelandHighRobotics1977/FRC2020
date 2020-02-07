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

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import com.revrobotics.ColorSensorV3;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class ColorSensor extends Subsystem {

  TalonSRX wheelMotor;
  static ColorSensor instance;
  public char setColor;

  public double speed = 0.5;

  private final I2C.Port i2cPort = I2C.Port.kOnboard;
  private final ColorSensorV3 m_colorSensor;

  double IR;

  ControlMode wheel = ControlMode.PercentOutput;
  ColorSensorV3.RawColor detectedColor;



  ColorSensor(){
    wheelMotor = new TalonSRX(RobotMap.WHEEL_MOTOR);
    m_colorSensor = new ColorSensorV3(i2cPort);
  }

  	
	public static ColorSensor getInstance() {
		if (instance == null) {
    		instance = new ColorSensor();
    	}
    	return instance;
	}
  
  public String readColor(){
    detectedColor = m_colorSensor.getRawColor();
    int r = detectedColor.red;
    int g = detectedColor.green;
    int b = detectedColor.blue;
    //Prototype Color Reader
    String color = "";
    if(b > g && g > r){
      //Blue
      System.out.println("Blue!?");
      color = "Blue";
    } else if (g > b && b > r){
      //Green
      System.out.println("Green!?");
      color = "Green";
      } else if (r > g && g > b){
        //Red
        System.out.println("Red!?");
        color = "Red";
      } else if (g > r && r > b){
        //Yellow
        System.out.println("Yellow!?");
        color = "Yellow";
      }
      SmartDashboard.putString("I'm Seeing: ", color);
      return color;
    }
  

  public double readIR(){
    IR = m_colorSensor.getIR();
    return IR;
  }

  public void rotControl(){
    double wheelCir = 10; //Need to set to Cir in in
    double rotAmount = 32 / wheelCir;
    
  }

  public void posControl(){
    String color = readColor();
    /* If we're reading:
      - Blue it's set to Red
      - Green it's set to Yellow
      - Red it's set to Blue
      - Yellow it's set to Green
    */
      if(setColor == 'B'){
        if(color == "Red"){
          stop();
        } else {
          wheelMotor.set(wheel, speed);
        }
      }
      if(setColor == 'G'){
        if(color == "Yellow"){
          stop();
        } else {
          wheelMotor.set(wheel, speed);
        }
      }
      if(setColor == 'R'){
        if(color == "Blue"){
          stop();
        } else {
          wheelMotor.set(wheel, speed);
        }
      }
      if(setColor == 'Y'){
        if(color == "Green"){
          stop();
        } else {
          wheelMotor.set(wheel, speed);
        }
      }
  }

  public void manualRight(){
    wheelMotor.set(wheel, speed);
  }

  public void manualLeft(){
    wheelMotor.set(wheel, -speed);
  }

  public void stop(){
    wheelMotor.set(wheel, 0);
  }



  public void outputValues(){
    SmartDashboard.putNumber("Red", detectedColor.red);
    SmartDashboard.putNumber("Green", detectedColor.green);
    SmartDashboard.putNumber("Blue", detectedColor.blue);
    SmartDashboard.putNumber("IR", IR);

    SmartDashboard.putString("Set Wheel:", String.valueOf(setColor));
  }




  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
