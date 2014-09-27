/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.ADXL345_I2C;
import edu.wpi.first.wpilibj.AnalogChannel;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OI {
    
    public static final Joystick jy_LeftAttack = new Joystick(RobotMap.leftJoystickUSBPort);
    public static final Joystick jy_RightAttack = new Joystick(RobotMap.rightJoystickUSBPort);
    public static final Joystick jy_Gamepad = new Joystick(RobotMap.gamepadUSBPort);
    
    public static final JoystickButton jb_GamepadX = new JoystickButton(jy_Gamepad, 1);
    public static final JoystickButton jb_GamepadA = new JoystickButton(jy_Gamepad, 2);
    public static final JoystickButton jb_GamepadB = new JoystickButton(jy_Gamepad, 3);
    public static final JoystickButton jb_GamepadY = new JoystickButton(jy_Gamepad, 4);
    public static final JoystickButton jb_LeftGamepadTrigger = new JoystickButton(jy_Gamepad, 5);
    public static final JoystickButton jb_RightGamepadTrigger = new JoystickButton(jy_Gamepad, 6);
    public static final JoystickButton jb_LeftGamepadThrottle = new JoystickButton(jy_Gamepad, 7);
    public static final JoystickButton jb_RightGamepadThrottle = new JoystickButton(jy_Gamepad, 8);
    public static final JoystickButton jb_Start = new JoystickButton(jy_Gamepad, 10);

    public static final JoystickButton jb_LeftAttackTrigger = new JoystickButton(jy_LeftAttack, 1);
    public static final JoystickButton jb_RightAttackTrigger = new JoystickButton(jy_RightAttack, 1);
    public static final JoystickButton jb_LeftAttackBottom = new JoystickButton(jy_LeftAttack, 2);
    public static final JoystickButton jb_RightAttackBottom = new JoystickButton(jy_RightAttack, 2);
    public static final JoystickButton jb_LeftAttackTop = new JoystickButton(jy_LeftAttack, 3);
    public static final JoystickButton jb_RightAttackTop = new JoystickButton(jy_RightAttack, 3);
    public static final JoystickButton jb_LeftAttack4 = new JoystickButton(jy_LeftAttack, 4);
    public static final JoystickButton jb_LeftAttack5 = new JoystickButton(jy_LeftAttack, 5);
    public static final JoystickButton jb_LeftAttack6 = new JoystickButton(jy_LeftAttack, 6);
    public static final JoystickButton jb_LeftAttack7 = new JoystickButton(jy_LeftAttack, 7);
    public static final JoystickButton jb_LeftAttack8 = new JoystickButton(jy_LeftAttack, 8);
    public static final JoystickButton jb_LeftAttack9 = new JoystickButton(jy_LeftAttack, 9);
    public static final JoystickButton jb_LeftAttack10 = new JoystickButton(jy_LeftAttack, 10);
    public static final JoystickButton jb_LeftAttack11 = new JoystickButton(jy_LeftAttack, 11);
    public static final JoystickButton jb_RightAttack4 = new JoystickButton(jy_RightAttack, 4);
    public static final JoystickButton jb_RightAttack5 = new JoystickButton(jy_RightAttack, 5);
    public static final JoystickButton jb_RightAttack6 = new JoystickButton(jy_RightAttack, 6);
    public static final JoystickButton jb_RightAttack7 = new JoystickButton(jy_RightAttack, 7);
    public static final JoystickButton jb_RightAttack8 = new JoystickButton(jy_RightAttack, 8);
    public static final JoystickButton jb_RightAttack9 = new JoystickButton(jy_RightAttack, 9);
    public static final JoystickButton jb_RightAttack10 = new JoystickButton(jy_RightAttack, 10);
    public static final JoystickButton jb_RightAttack11 = new JoystickButton(jy_RightAttack, 11);

    public static final DigitalInput ls_rackLimit = new DigitalInput(1, 1);
    public static final DigitalInput ls_advanceLatchLimit = new DigitalInput(1, 2);
    public static final DigitalInput ls_withdrawLatchLimit = new DigitalInput(1, 3);
    public static final DigitalInput ls_pneumaticControlSwitch = new DigitalInput(1,8);
    
}
