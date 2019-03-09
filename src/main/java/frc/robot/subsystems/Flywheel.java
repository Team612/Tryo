/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.DefaultFly;

/**
 * Add your docs here.
 */
public class Flywheel extends Subsystem {

  private WPI_TalonSRX flywheelTalon = new WPI_TalonSRX(RobotMap.flywheelMotor); 
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  public WPI_TalonSRX getFlywheelTalon(){
    return flywheelTalon; 
  }

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new DefaultFly());
  }
}
