package frc.robot;

import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj.I2C;
import com.revrobotics.ColorSensorV3;
import com.revrobotics.ColorMatchResult;
import com.revrobotics.ColorMatch;


public class ColorSensor {

  private final Color kBlueTarget;
  private final Color kGreenTarget;
  private final Color kRedTarget;
  private final Color kYellowTarget;
  final String givenColor;
  private I2C.Port port;
  private final ColorSensorV3 m_colorSensor;
  private final ColorMatch m_colorMatcher;
  String colorString;
  Color detectedColor;
  ColorMatchResult match;
  
  public ColorSensor(double[] red, double[] blue, double[] green, double[] yellow, I2C.Port sensorPort, String color){
        
  kBlueTarget = ColorMatch.makeColor(blue[0], blue[1], blue[2]);
  kGreenTarget = ColorMatch.makeColor(green[0], green[1], green[2]);
  kRedTarget = ColorMatch.makeColor(red[0], red[1], red[2]);
  kYellowTarget = ColorMatch.makeColor(yellow[0], yellow[1], yellow[2]);
  givenColor = color;
  port = sensorPort;
  m_colorSensor = new ColorSensorV3(port);
  m_colorMatcher = new ColorMatch();



 }

 public void initializeColorTargets()
 {
    
    m_colorMatcher.addColorMatch(kBlueTarget);
    m_colorMatcher.addColorMatch(kGreenTarget);
    m_colorMatcher.addColorMatch(kRedTarget);
    m_colorMatcher.addColorMatch(kYellowTarget);  

    
 }

 public String detectColor()
 {
     detectedColor = m_colorSensor.getColor();
     match = m_colorMatcher.matchClosestColor(detectedColor);
 
    if (match.color == kBlueTarget) {
      colorString = "Blue";
    } else if (match.color == kRedTarget) {
      colorString = "Red";
    } else if (match.color == kGreenTarget) {
      colorString = "Green";
    } else if (match.color == kYellowTarget) {
      colorString = "Yellow";
    } else {
      colorString = "Unknown";
    }




    return colorString;
 }






}