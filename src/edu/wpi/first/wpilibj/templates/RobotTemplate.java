

package edu.wpi.first.wpilibj.templates;


import edu.wpi.first.wpilibj.SimpleRobot;

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
        
    }

    /**
     * This function is called once each time the robot enters operator control.
     */
    public void operatorControl() {
        while(this.isEnabled() && this.isOperatorControl()){
            
            if(OI.jy_LeftAttack.getTrigger()){
                drive.setLeftSide(OI.jy_LeftAttack.getY());
            }
            if(OI.jy_LeftAttack.getTrigger()){
                drive.setRightSide(OI.jy_RightAttack.getY());
            }
            
        }
    }
    
    /**
     * This function is called once each time the robot enters test mode.
     */
    public void test() {
    
    }
}
