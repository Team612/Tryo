/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.OI;
import frc.robot.Robot;

public class DefaultPivot extends Command {
  public DefaultPivot() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.pivot);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    double right_joystic_value = OI.gunner.getY(Hand.kRight);
    
    if(Math.abs(right_joystic_value) < .1){
      Robot.pivot.getPivotTalon().set(0);
    } else {
      Robot.pivot.getPivotTalon().set(right_joystic_value);
    }
    if(Robot.limitSwitches.limit_switch_zero.get() && right_joystic_value < -0.1){
      Robot.pivot.getPivotTalon().set(0);
    }
    if(Robot.limitSwitches.limit_switch_one.get() && right_joystic_value > 0.1){
      Robot.pivot.getPivotTalon().set(0);
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
