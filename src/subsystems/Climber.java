package org.usfirst.frc.team2815.robot.subsystems;


import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Climber extends Subsystem {

    public WPI_TalonSRX ClimberSRX = new WPI_TalonSRX(3);

    private double speed;
    private double increment;
    private double negate = -1;
    
	public Climber(){
		speed = 0.75;
		increment = 0;
	}
	
	public void setNegateValue(double reverse){
		negate = reverse;
	}
	
	public void controlClimber(boolean climber){
		if(climber){
    		if(increment != speed){
    			if(increment > speed){
    				increment -= .1;
    			}
    			if(increment < speed){
    				increment += .1;
    			}
    		}
		}
    	else{
			if(increment != 0){
    			if(increment > 0){
    				increment -= .1;
    			}
    			if(increment < 0){
    				increment += .1;
    			}
			}
		}
		
		ClimberSRX.set(negate*increment);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

