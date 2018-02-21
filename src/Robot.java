/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2815.robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team2815.robot.autocommands.CenterAuto;
import org.usfirst.frc.team2815.robot.autocommands.CenterLeftAuto;
import org.usfirst.frc.team2815.robot.autocommands.CenterRightAuto;
import org.usfirst.frc.team2815.robot.autocommands.ForwardAuto;
import org.usfirst.frc.team2815.robot.autocommands.LeftAuto;
import org.usfirst.frc.team2815.robot.autocommands.LeftTurnAuto;
import org.usfirst.frc.team2815.robot.autocommands.RightAuto;
import org.usfirst.frc.team2815.robot.autocommands.RightTurnAuto;
import org.usfirst.frc.team2815.robot.commands.CollectCube;
import org.usfirst.frc.team2815.robot.commands.ControlArmPistonB;
import org.usfirst.frc.team2815.robot.commands.ControlArmPistonT;
import org.usfirst.frc.team2815.robot.commands.ControlClimber;
import org.usfirst.frc.team2815.robot.commands.ControlCollectorPiston;
import org.usfirst.frc.team2815.robot.commands.ControlElevator;
import org.usfirst.frc.team2815.robot.commands.DriveArcade;
import org.usfirst.frc.team2815.robot.subsystems.ArmPistonB;
import org.usfirst.frc.team2815.robot.subsystems.ArmPistonT;
import org.usfirst.frc.team2815.robot.subsystems.Climber;
import org.usfirst.frc.team2815.robot.subsystems.CollectorPiston;
import org.usfirst.frc.team2815.robot.subsystems.CubeCollector;
import org.usfirst.frc.team2815.robot.subsystems.DriveTrain;
import org.usfirst.frc.team2815.robot.subsystems.Elevator;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
public class Robot extends IterativeRobot {
	
	public static DriveTrain driveTrain;
	public static CubeCollector cubeCollector;
	public static CollectorPiston collectorPiston;
	public static ArmPistonB armPistonB;
	public static ArmPistonT armPistonT;
	public static Elevator elevator;
	public static Climber climber;
	public static OI oi;

	Command autonomousCommand;
	Command testAuto;
	Command driveArcade;
	Command collectCube;
	Command controlCollectorPiston;
	Command controlArmPistonB;
	Command controlArmPistonT;
	Command controlElevator;
	Command controlClimber;
	
	Command centerRightAuto;
	Command centerLeftAuto;
	Command forwardAuto;
	Command leftTurnAuto;
	Command rightTurnAuto;
	
	SendableChooser chooser = new SendableChooser<>();

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		oi = new OI();
		driveTrain = new DriveTrain();
		cubeCollector = new CubeCollector();
		collectorPiston = new CollectorPiston();
		armPistonB = new ArmPistonB();
		armPistonT = new ArmPistonT();
		elevator = new Elevator();
		climber = new Climber();
		
		chooser.addDefault("Center Auto", new CenterAuto());
		chooser.addObject("Left Auto", new LeftAuto());
		chooser.addObject("Right Auto", new RightAuto());
		
		driveArcade = new DriveArcade();
		collectCube = new CollectCube();
		controlCollectorPiston = new ControlCollectorPiston();
		controlArmPistonB = new ControlArmPistonB();
		controlArmPistonT = new ControlArmPistonT();
		controlElevator = new ControlElevator();
		controlClimber = new ControlClimber();
		
		centerRightAuto = new CenterRightAuto();
		centerLeftAuto = new CenterLeftAuto();
		forwardAuto = new ForwardAuto();
		leftTurnAuto = new LeftTurnAuto();
		rightTurnAuto = new RightTurnAuto();
		
		SmartDashboard.putData("Auto mode", chooser);
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * <p>You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		autonomousCommand = (Command)chooser.getSelected();
		
		SmartDashboard.putString("auto", autonomousCommand.getName());
		
		String gameData;
		gameData = DriverStation.getInstance().getGameSpecificMessage();
        if(gameData.length() > 0){
        	if(gameData.charAt(0) == 'L'){
        		if(autonomousCommand.getName().equals("CenterAuto")){
        			autonomousCommand = centerLeftAuto;
        		}
        		else if(autonomousCommand.getName().equals("LeftAuto")){
        			autonomousCommand = forwardAuto;
        		}
        		else{
        			autonomousCommand = rightTurnAuto;
        		}
        	}
        	else if(gameData.charAt(0) == 'R'){
        		if(autonomousCommand.getName().equals("CenterAuto")){
        			autonomousCommand = centerRightAuto;
        		}
        		else if(autonomousCommand.getName().equals("LeftAuto")){
        			autonomousCommand = leftTurnAuto;
        		}
        		else{
        			autonomousCommand = forwardAuto;
        		}
        	}
		
		if (autonomousCommand != null){
			autonomousCommand.start();
			}
		Scheduler.getInstance().removeAll();
        }
	}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autonomousCommand != null) {
			autonomousCommand.cancel();
		}
		
		driveArcade.start();
		collectCube.start();
		controlCollectorPiston.start();
		controlArmPistonB.start();
		controlArmPistonT.start();
		controlElevator.start();
		controlClimber.start();
		
	}

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
	}
}