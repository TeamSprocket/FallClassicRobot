/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.Joystick;

public class OI {
    
    public static final Joystick jy_LeftAttack = new Joystick(RobotMap.leftJoystickUSBPort);
    public static final Joystick jy_RightAttack = new Joystick(RobotMap.rightJoystickUSBPort);
    public static final Joystick jy_Gamepad = new Joystick(RobotMap.gamepadUSBPort);
    
}
