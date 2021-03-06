package org.usfirst.frc.team2815.robot.subsystems;

import org.usfirst.frc.team2815.robot.RobotMap;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Elevator extends Subsystem {

    private Spark elevatorMotors;
    
    private double speed;
    private double increment;
    private double negate = -1;
    
	public Elevator(){
		elevatorMotors = new Spark(RobotMap.ElevatorMotor);
		speed = 0.75;
		increment = 0;
	}
	
	public void setNegateValue(double down){
		negate = down;
	}
	
	public void operateElevator(boolean up){
		if(up){
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
				
		elevatorMotors.set(negate*increment);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

