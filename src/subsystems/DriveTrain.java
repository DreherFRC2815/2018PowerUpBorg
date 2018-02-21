
package org.usfirst.frc.team2815.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 *
 */
public class DriveTrain extends Subsystem {

	public WPI_TalonSRX TalonSRX[] = new WPI_TalonSRX[4];

	private DifferentialDrive tank;
	
	public DriveTrain() {
		
		TalonSRX[0] = new WPI_TalonSRX(1);
		TalonSRX[1] = new WPI_TalonSRX(5);
		
		SpeedControllerGroup left = new SpeedControllerGroup(TalonSRX[0], TalonSRX[1]);

		TalonSRX[2] = new WPI_TalonSRX(2);
		TalonSRX[3] = new WPI_TalonSRX(4);
		
		SpeedControllerGroup right = new SpeedControllerGroup(TalonSRX[2], TalonSRX[3]);

		tank = new DifferentialDrive(left, right);
		
	}
	
	public void driveArcade(double left, double rightX){
		tank.arcadeDrive(left, rightX);
	}
	
	public void driveTank(double left, double rightY){
		tank.tankDrive(left, rightY);
	}
	
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
	
}
