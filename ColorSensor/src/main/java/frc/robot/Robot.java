/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj.I2C;
import com.revrobotics.ColorSensorV3;
import com.revrobotics.ColorMatchResult;
import com.revrobotics.ColorMatch;
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
  //Declare the Color Constants as double arrays
  private final double[] red = new double[]{0.143, 0.427, 0.429};
  private final double[] blue = new double[]{0.197, 0.561, 0.240};
  private final double[] green = new double[]{0.561, 0.232, 0.114};
  private final double[] yellow = new double[]{0.361, 0.524, 0.113};

  //Declare the Xbox Controller
  XboxController m_controller = XboxController(0);

  @Override
  public void robotInit()//Intialize the Spinner
  //@param color array for RGBY(NOT RWBY, Cutler!), i2c port, given color, and device ID;
  ColorSpinner color = new ColorSpinner(red,blue,green,yellow, I2C.Port.kOnboard, "Red", 4 );
  }

  @Override
  public void robotPeriodic() {
  }

  @Override
  public void autonomousInit() {
   
  }

  @Override
  public void autonomousPeriodic() {
  
  }

  @Override
  public void teleopPeriodic() {
    
    if(m_controller.getBButtonPressed())
    {
      
    }
    
  }

  @Override
  public void testPeriodic() {
  }
}
