package org.usfirst.frc.team2815.robot.autocommands;

import org.usfirst.frc.team2815.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ElevatorStopAuto extends Command {

	Timer timer = new Timer();
	
	public ElevatorStopAuto() {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.elevator);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		this.setInterruptible(false);
		timer.start();
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		// if(Timer.getMatchTime()<=(STARTTIME+drive_Time))
		// Robot.driveTrain.setMotors(-.25, -.25);
		// else{
		// Robot.driveTrain.setMotors(0, 0);
		// state = FINISHED;
		Robot.elevator.operateElevator(false);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return timer.get() > 0.5;
	}

	// Called once after isFinished returns true
	protected void end() {
		timer.reset();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}