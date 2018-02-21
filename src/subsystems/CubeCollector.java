package org.usfirst.frc.team2815.robot.subsystems;

import org.usfirst.frc.team2815.robot.RobotMap;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class CubeCollector extends Subsystem {

	private Spark cubeMotorL1;
	private Spark cubeMotorL2;
    private Spark cubeMotorR1;
    private Spark cubeMotorR2;
    	
    public CubeCollector(){
    	cubeMotorL1 = new Spark(RobotMap.CubeCollectorMotors[0]);
    	cubeMotorL2 = new Spark(RobotMap.CubeCollectorMotors[1]);
    	cubeMotorR1 = new Spark(RobotMap.CubeCollectorMotors[2]);
    	cubeMotorR2 = new Spark(RobotMap.CubeCollectorMotors[3]);
    }
	
	public void collect(double collect){
		cubeMotorL1.set(collect);
		cubeMotorR2.set(collect*0.8);
		cubeMotorL2.set(-collect*0.8);
		cubeMotorR1.set(-collect);
	}
	
    public void initDefaultCommand() {
        
    }
}

