/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotMap;
import frc.robot.commands.DefaultDrive;

/**
 * Add your docs here.
 */
public class DriveTrain extends Subsystem {

  private WPI_TalonSRX leftFDriveTalon = new WPI_TalonSRX(0);
  private WPI_TalonSRX leftBDriveTalon = new WPI_TalonSRX(1); 
  private WPI_TalonSRX rightFDriveTalon = new WPI_TalonSRX(11);  
  private WPI_TalonSRX rightBDriveTalon = new WPI_TalonSRX(5); 
  public Servo leftServo = new Servo(RobotMap.leftServoPort);
  public Servo rightServo = new Servo(RobotMap.rightServoPort);
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  public WPI_TalonSRX getTalonLeft(int num){
    if(num == 0){
      return leftFDriveTalon;

    } else {
     return leftBDriveTalon;
    }
  }
  public WPI_TalonSRX getTalonRight(int num){
    if(num == 0){
      return rightFDriveTalon;

    } else {
     return rightBDriveTalon;
    }
  }

  

  @Override
  public void initDefaultCommand() {
    
    setDefaultCommand(new DefaultDrive());
  }
}
