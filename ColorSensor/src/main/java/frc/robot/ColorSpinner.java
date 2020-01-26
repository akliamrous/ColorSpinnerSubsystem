/*

.______   .______          ___   ____    ____  _______ .______     ______   .___________.    _______.
|   _  \  |   _  \        /   \  \   \  /   / |   ____||   _  \   /  __  \  |           |   /       |
|  |_)  | |  |_)  |      /  ^  \  \   \/   /  |  |__   |  |_)  | |  |  |  | `---|  |----`  |   (----`
|   _  <  |      /      /  /_\  \  \      /   |   __|  |   _  <  |  |  |  |     |  |        \   \    
|  |_)  | |  |\  \----./  _____  \  \    /    |  |____ |  |_)  | |  `--'  |     |  |    .----)   |   
|______/  | _| `._____/__/     \__\  \__/     |_______||______/   \______/      |__|    |_______/    
                                                                                                     
         
                                                       
*/
package frc.robot;
import com.revrobotics.CANEncoder;
import com.revrobotics.CANDigitalInput;
import com.revrobotics.CANPIDController;
import com.revrobotics.CANSparkMax;
import com.revrobotics.EncoderType;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.ControlType;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.*;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj.I2C;
import com.revrobotics.ColorSensorV3;
import com.revrobotics.ColorMatchResult;
import com.revrobotics.ColorMatch;

public class ColorSpinner extends ColorSensor{

    private CANSparkMax m_spinner;
    private CANEncoder m_encoder;
    private int device_id;
    private String colorDetected;

    public ColorSpinner(double[] red, double[] blue, double[] green, double[] yellow, I2C.Port sensorPort, String color, int did)
    {
        super(red, blue, green, yellow, sensorPort, color);
        this.device_id = did;
        this.m_spinner = new CANSparkMax(device_id, MotorType.kBrushless);
        this.m_encoder = m_spinner.getEncoder();
    }


    //When a button is pressed on the Xbox Controller, Stage 2 rotation will activate
    public void activateRotationalControl()
    {
        m_spinner.restoreFactoryDefaults();

        double encoder_position = m_encoder.getPosition();

        while(true)
        {
            if(encoder_position >= 358.3)
            {
                m_spinner.set(0);
                m_encoder.setPosition(0);
                break;
            }

            else{
               m_spinner.set(0.1); 
            }
        }

    }


    public void activationPositionControl()
    {
        while(true){

            colorDetected = detectColor();
            if(givenColor.equals(colorDetected))
            {
                m_spinner.set(0);
                break;
            }
            m_spinner.set(0.1);

        }

    }





}