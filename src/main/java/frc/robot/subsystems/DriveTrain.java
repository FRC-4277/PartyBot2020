/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.commands.JoystickDriveCommand;

/**
 * Add your docs here.
 */
public class DriveTrain extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  private Talon leftFrontMotor, leftBackMotor, rightFrontMotor, rightBackMotor;
  private SpeedControllerGroup leftGroup, rightGroup;
  private DifferentialDrive drive;

  public DriveTrain(int leftFront, int leftBack, int rightFront, int rightBack) {
    super("DriveTrain");
    leftFrontMotor = new Talon(leftFront);
    rightFrontMotor = new Talon(rightFront);
    rightBackMotor = new Talon(rightBack);
    leftBackMotor = new Talon(leftBack);

    leftGroup = new SpeedControllerGroup(leftFrontMotor, leftBackMotor);
    rightGroup = new SpeedControllerGroup(rightFrontMotor, rightBackMotor);

    drive = new DifferentialDrive(leftGroup, rightGroup);
    System.out.println("@A");
  }

  public void drive(double x, double y) {
    System.out.println("DRIVE: [x" + x + ", y" + y + "]");
    drive.tankDrive(x, y);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new JoystickDriveCommand());
    System.out.println("@DEFAULT COMMAND");
  }
}
