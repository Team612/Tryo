/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Add your docs here.
 */

 // NOTE: YOU MIGHT NEED TO DELETE THIS LATER
public class LimitSwitches extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  public DigitalInput limit_switch_zero = new DigitalInput(0);
  public DigitalInput limit_switch_one = new DigitalInput(1);

  
  //TODO: ADD ROBOTMAP PORTS FOR LIMITSWITCHES

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
