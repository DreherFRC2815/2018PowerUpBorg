package org.usfirst.frc.team2815.robot.autocommands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class LeftTurnAuto extends CommandGroup {

    public LeftTurnAuto() {
    	addSequential(new PistonAuto(false));
		addSequential(new EjectCubeAuto(0.5, 1));
		addSequential(new DriveAuto(-0.75, 0.72, 0.2));
		addSequential(new DriveAuto(-0.75, -0.72, 2.5));
		addSequential(new DriveAuto(0.75, -0.72, 0.2));
		addSequential(new DriveAuto(-0.75, -0.72, 1.5));
    }
}
