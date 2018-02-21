package org.usfirst.frc.team2815.robot.autocommands;

import org.usfirst.frc.team2815.robot.Robot;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class VisionAuto extends Command {
	
	Timer timer = new Timer();
	
	NetworkTable limelight = NetworkTableInstance.getDefault().getTable("limelight");
	
	double tx = limelight.getEntry("tx").getDouble(0);
	double ty = limelight.getEntry("ty").getDouble(0);
	double ta = limelight.getEntry("ta").getDouble(0);
	double ts = limelight.getEntry("ts").getDouble(0);
	
	double left, right;

    public VisionAuto() {
        requires(Robot.driveTrain);
    }

	public double Estimate_Distance(){
		return ((9.25-16) / Math.tan(ts));
	}
	
    // Called just before this Command runs the first time
    protected void initialize() {
    	timer.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	tx = limelight.getEntry("tx").getDouble(0);
    	ty = limelight.getEntry("ty").getDouble(0);
    	ta = limelight.getEntry("ta").getDouble(0);
    	ts = limelight.getEntry("ts").getDouble(0);
    	
    	float KpAim = -0.1f;
    	float KpDistance = -0.1f;
    	float min_aim_command = 0.05f;
    	
    	float heading_error = (float) -tx;
    	float distance_error = (float) -ty;
    	float steering_adjust = 0.0f;
    	if (tx > 1.0)
    	{
    	steering_adjust = KpAim*heading_error - min_aim_command;
    	}
    	else if (tx < 1.0)
    	{
    	steering_adjust = KpAim*heading_error + min_aim_command;
    	}
    	float distance_adjust = KpDistance * distance_error;
    	left += steering_adjust + distance_adjust;
    	right -= steering_adjust + distance_adjust;
    	
    	Robot.driveTrain.driveTank(left, right);
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return timer.get() >= 5;
    	
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
