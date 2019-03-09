/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.GenericHID.RumbleType;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.OI;
import frc.robot.Robot;

public class DefaultDrive extends Command {
  public DefaultDrive() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.drivetrain);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    Robot.drivetrain.rightServo.setAngle(72);
    Robot.drivetrain.leftServo.setAngle(36);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
   OI.driver.setRumble(RumbleType.kLeftRumble, 0.001);
   OI.driver.setRumble(RumbleType.kRightRumble, 0.001);
    if (Math.abs(OI.driver.getY(Hand.kLeft)) < .1){
      Robot.drivetrain.getTalonLeft(0).set(0);
      Robot.drivetrain.getTalonLeft(1).set(0);
    } else {
    Robot.drivetrain.getTalonLeft(0).set(OI.driver.getY(Hand.kLeft));
    Robot.drivetrain.getTalonLeft(1).set(OI.driver.getY(Hand.kLeft));
    }

    if (Math.abs(OI.driver.getY(Hand.kRight)) < .1){ 
    Robot.drivetrain.getTalonRight(1).set(0);
    Robot.drivetrain.getTalonRight(0).set(0);

    } else{
    Robot.drivetrain.getTalonRight(0).set(OI.driver.getY(Hand.kRight));
    Robot.drivetrain.getTalonRight(1).set(OI.driver.getY(Hand.kRight));
    }

    if (OI.driver_button_LB.get()){
      Robot.drivetrain.leftServo.setAngle(36);
      Robot.drivetrain.rightServo.setAngle(72);
    } 
    if (OI.driver_button_RB.get()){
      Robot.drivetrain.leftServo.set(72);
      Robot.drivetrain.rightServo.set(36);
    }



  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
