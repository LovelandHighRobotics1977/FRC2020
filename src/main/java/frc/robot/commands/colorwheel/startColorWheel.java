package frc.robot.commands.colorwheel;
import frc.robot.commands.CommandBase;
//import com.ctre.TalonSRX;



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