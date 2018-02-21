/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2815.robot;

import edu.wpi.first.wpilibj.Joystick;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	Joystick xbox = new Joystick(0);
	Joystick flight = new Joystick(1);
	
	public double getLeft(){
		if(Math.abs(xbox.getRawAxis(1)) <= 0.1){
			return 0;
		}
		return xbox.getRawAxis(1);
	}
	
	public double getRightX(){
		if(Math.abs(xbox.getRawAxis(4)) <= 0.1){
			return 0;
		}
		return xbox.getRawAxis(4);
	}
	
	public double getRightY(){
		if(Math.abs(xbox.getRawAxis(5)) <= 0.1){
			return 0;
		}
		return xbox.getRawAxis(5);
	}
	
	public double getCollect(){
		if(Math.abs(flight.getRawAxis(1)) <= 0.1){
			return 0;
		}
		return flight.getRawAxis(1);
	}
	
	/*public double getElevatorUp(){
		if(Math.abs(flight.getRawAxis(0)) <= 0.1){
			return 0;
		}
		return flight.getRawAxis(0);
	}
	*/
	
	public boolean getCollectorPistonOpen(){
		return flight.getRawButton(1);
	}
	
	public boolean getCollectorPistonClose(){
		return flight.getRawButton(2);
	}
	
	public boolean getArmPistonBOpen(){
		return flight.getRawButton(9);
	}
	
	public boolean getArmPistonBClose(){
		return flight.getRawButton(10);
	}
	
	public boolean getArmPistonTOpen(){
		return flight.getRawButton(11);
	}
	
	public boolean getArmPistonTClose(){
		return flight.getRawButton(12);
	}
	
	public boolean getElevatorUp(){
		return flight.getRawButton(3);
	}
	
	public boolean getElevatorDown(){
		return flight.getRawButton(4);
	}
	
	public boolean getClimb(){
		return flight.getRawButton(7);
	}
	
	public boolean getClimbReverse(){
		return flight.getRawButton(8);
	}
	
}