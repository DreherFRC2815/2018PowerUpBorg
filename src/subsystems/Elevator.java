package org.usfirst.frc.team2815.robot.subsystems;

import org.usfirst.frc.team2815.robot.RobotMap;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Elevator extends Subsystem {
	
    private Spark elevatorL;
    private Spark elevatorR;
    
    private double setPoint;
    private double incVal;
    
    private double negateVal = -1;
    
	public Elevator(){
		
		setPoint = 1;
		incVal = 0;
		
		elevatorL = new Spark(RobotMap.ElevatorMotors[0]);
		elevatorR = new Spark(RobotMap.ElevatorMotors[1]);
		
	}
	
	public void setNegateValue(double negate){
		
		negateVal = negate;
		
	}
	
	public void controlElevator(boolean on){
		if(on){
    		if(incVal != setPoint){
    			if(incVal > setPoint){
    				incVal -= 0.1;
    			}
    			if(incVal < setPoint){
    				incVal += 0.1;
    			}
    		}
		}
		
		if(incVal != 0){
			if(incVal > 0){
				incVal -= 0.1;
			}
			if(incVal < 0){
				incVal += 0.1;
			}
		}
    		
		elevatorL.set(negateVal * incVal);
		elevatorR.set(-negateVal * incVal);
		
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

