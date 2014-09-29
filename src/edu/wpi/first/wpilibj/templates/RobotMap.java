/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Victor;

public class RobotMap {
    
    //Digital IO Module # for Arm Motors
    public static final int driveTrainDigitalModule         = 1;
    public static final int rackDriverDigitalModule         = 1;
    public static final int triggerWindowMotorDigitalModule = 1;
    public static final int collectorMotorDigitalModule     = 1;
    public static final int armActuatorDigitalModule        = 1;
    public static final int harvesterActuatorDigitalModule  = 1;
    
    //PWM Port # for Drive Train Motors
    public static final int frontLeftDriveTrainMotorPort    = 7;
    public static final int frontRightDriveTrainMotorPort   = 3;
    public static final int backLeftDriveTrainMotorPort     = 8;
    public static final int backRightDriveTrainMotorPort    = 4;
    
    //PWM Port # for Arm Motors
    public static final int triggerWindowMotorPort          = 1;
    public static final int harvesterActuatorMotorPort      = 2;
    public static final int rackDriverMotorPort             = 5;
    public static final int collectorMotorPort              = 6;

    
    
    //USB Port # for Interface Devices
    public static final int leftJoystickUSBPort             = 1;
    public static final int rightJoystickUSBPort            = 2;
    public static final int gamepadUSBPort                  = 3;
    
    public static final int drivetrainSolenoidModule        = 1;
    public static final int drivetrainSolenoidPort          = 1;
    
    //Static instatiations of all DriveTrain victors
    public static final Victor v_FrontLeftDriveTrain = new Victor(driveTrainDigitalModule, frontLeftDriveTrainMotorPort);
    public static final Victor v_FrontRightDriveTrain = new Victor(driveTrainDigitalModule, frontRightDriveTrainMotorPort);
    public static final Victor v_BackLeftDriveTrain = new Victor(driveTrainDigitalModule, backLeftDriveTrainMotorPort);
    public static final Victor v_BackRightDriveTrain = new Victor(driveTrainDigitalModule, backRightDriveTrainMotorPort);
    
    //Static instantiations of all Arm victors
  public static final Victor v_mainRackDriver = new Victor(rackDriverDigitalModule, rackDriverMotorPort);
    public static final Victor v_triggerWindowMotor = new Victor(triggerWindowMotorDigitalModule, triggerWindowMotorPort);
    public static final Victor v_collectorMotor = new Victor(collectorMotorDigitalModule, collectorMotorPort);
    public static final Victor v_harvesterActuator = new Victor(harvesterActuatorDigitalModule, harvesterActuatorMotorPort);
    
    
    //Static instantiations of all pneumatic solenoids
    public static final Solenoid s_drivetrain = new Solenoid(drivetrainSolenoidModule, drivetrainSolenoidPort);
    
}
