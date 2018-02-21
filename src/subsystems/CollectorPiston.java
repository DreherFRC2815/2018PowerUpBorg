package org.usfirst.frc.team2815.robot.subsystems;

import org.usfirst.frc.team2815.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class CollectorPiston extends Subsystem {

	DoubleSolenoid Solenoids;
    
	public CollectorPiston(){
		Solenoids = new DoubleSolenoid(RobotMap.CollectorPiston[0], RobotMap.CollectorPiston[1]);
	}
    
    public void controlPiston(boolean open, boolean close){
    	if(open){
    		Solenoids.set(DoubleSolenoid.Value.kForward);
    	}
		else if(close){
    		Solenoids.set(DoubleSolenoid.Value.kReverse);
		}
    }

    public void initDefaultCommand() {
    	
    }
}

