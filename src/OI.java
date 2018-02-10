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
	
	public double getRight(){
		if(Math.abs(xbox.getRawAxis(4)) <= 0.1){
			return 0;
		}
		return xbox.getRawAxis(4);
	}
	
	public boolean getAutoDrive(){
		return xbox.getRawButton(1);
	}
	
	public boolean getCollectCube(){
		return flight.getRawButton(1);
	}
	
	public boolean getPlaceCube(){
		return flight.getRawButton(2);
	}
	
	public boolean getElevatorUp(){
		return flight.getRawButton(3);
	}

	public boolean getElevatorDown(){
		return flight.getRawButton(4);
	}
	
	public boolean getClimb(){
		return flight.getRawButton(5);
	}
	
}
