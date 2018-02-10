package org.usfirst.frc.team2815.robot.commands;

import org.usfirst.frc.team2815.robot.Robot;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DriveTank extends Command {

    public DriveTank() {
        
    	requires(Robot.driveTrain);
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	NetworkTable limelight = NetworkTableInstance.getDefault().getTable("limelight");
    	
    	double tx = limelight.getEntry("tx").getDouble(0);
    	double ty = limelight.getEntry("ty").getDouble(0);
    	double ta = limelight.getEntry("ta").getDouble(0);
    	double ts = limelight.getEntry("ts").getDouble(0);
    	
    	while(Robot.oi.getAutoDrive() && Math.abs(ta - 5.9) > 0.3){
    		Robot.driveTrain.driveTank(ty/100, tx/100);
    	}
    	
    	Robot.driveTrain.driveTank(Robot.oi.getLeft()/2, Robot.oi.getRight()/2);
    	
    	SmartDashboard.putNumber("tx", tx);
    	SmartDashboard.putNumber("ty", ty);
    	SmartDashboard.putNumber("x", Robot.oi.getLeft());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
