package org.usfirst.frc.team2815.robot.autocommands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class CenterRightAuto extends CommandGroup {

    public CenterRightAuto() {
    	addSequential(new PistonAuto(false));
		addSequential(new EjectCubeAuto(0.5, 1));
		addSequential(new ElevatorAuto(2.5));
		addSequential(new ElevatorStopAuto());
		addSequential(new DriveAuto(0.75, -0.72, 0.3));
		addSequential(new DriveAuto(-0.75, -0.72, 2));
		addSequential(new DriveAuto(-0.75, 0.72, 0.3));
		addSequential(new DriveAuto(-0.75, -0.72, 1.5));
		addSequential(new PistonAuto(true));
		addSequential(new EjectCubeAuto(-0.75, 1));
    }
}
