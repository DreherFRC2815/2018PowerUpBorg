package org.usfirst.frc.team2815.robot.commands;

import org.usfirst.frc.team2815.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ControlClimber extends Command {

	boolean negate;
	
	
    public ControlClimber() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.climber);
    	negate = false;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(Robot.oi.getClimbReverse()){
    		Robot.climber.setNegateValue(-1);
    		negate = true;
    	}
    	else{
    		Robot.climber.setNegateValue(1);
    		negate = false;
    	}
    	
    	if(Robot.oi.getClimb()){
    		Robot.climber.controlClimber(true);
    	}
    	else{
    		Robot.climber.controlClimber(false);
    	}
    }

    //
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
