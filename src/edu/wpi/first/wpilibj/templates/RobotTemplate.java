

package edu.wpi.first.wpilibj.templates;


import edu.wpi.first.wpilibj.SimpleRobot;
import edu.wpi.first.wpilibj.Timer;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the SimpleRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class RobotTemplate extends SimpleRobot {
    /**
     * This function is called once each time the robot enters autonomous mode.
     */
    
    DifferentialDriveTrain drive = new DifferentialDriveTrain();
    
    public void autonomous() {
        
        while(this.isAutonomous() && this.isEnabled()){
            
            drive.allBack(0.5);        //must use allBack() to go forward
            
            Timer.delay(1);
            
            drive.stop();
            
        }
        
    }

    /**
     * This function is called once each time the robot enters operator control.
     */
    public void operatorControl() {
        while(this.isEnabled() && this.isOperatorControl()){
            
            tankDriveListener();
            rollListener();
            tankDriveListener();
            flapListener();
            
        }
    }
    
    public void flapListener(){
        
    }
    
    public void shootListener(){
        
    }
    
    public void rollListener(){
        
    }
    
    public void tankDriveListener(){
        if(OI.jy_LeftAttack.getTrigger()){
                drive.setLeftSide(OI.jy_LeftAttack.getY());
            }
            else{
                drive.setLeftSide(0);
            }
            
            if(OI.jy_LeftAttack.getTrigger()){
                drive.setRightSide(OI.jy_RightAttack.getY());
            }
            else{
                drive.setRightSide(0);
            }
    }
    
    /**
     * This function is called once each time the robot enters test mode.
     */
    public void test() {
    
    }
}
