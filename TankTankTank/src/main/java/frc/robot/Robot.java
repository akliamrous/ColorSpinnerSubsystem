
package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import com.revrobotics.CANEncoder;
import com.revrobotics.CANDigitalInput;
import com.revrobotics.CANPIDController;
import com.revrobotics.CANSparkMax;
import com.revrobotics.EncoderType;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.ControlType;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.*;


public class Robot extends TimedRobot {

  XboxController controller = new XboxController(0);
  CANSparkMax m_left = new CANSparkMax(0, MotorType.kBrushless);
  CANSparkMax m_right = new CANSparkMax(1, MotorType.kBrushless);


  @Override
  public void robotInit() {
   
  }

  
  @Override
  public void robotPeriodic() {
  }

  
  @Override
  public void autonomousInit() {
 
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
  
  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
    m_left.set(controller.getY(Hand.kleft));
    m_right.set(controller.getY(Hand.kleft));
    m_left.set(controller.getX(Hand.kright));
    m_right.set(controller.getX(Hand.kright));

  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }
}
