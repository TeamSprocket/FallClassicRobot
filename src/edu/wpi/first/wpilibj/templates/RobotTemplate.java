package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.SimpleRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the SimpleRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class RobotTemplate extends SimpleRobot {

    public RobotTemplate.Sensors sensors = new RobotTemplate.Sensors();
    public RobotTemplate.Arm arm = new RobotTemplate.Arm();
    public RobotTemplate.Cock cock = new RobotTemplate.Cock();

    /**
     * This function is called once each time the robot enters autonomous mode.
     */
    DifferentialDriveTrain drive = new DifferentialDriveTrain();
    boolean gear = true;

    public void autonomous() {
        boolean ran = false;
        while (this.isAutonomous() && this.isEnabled() && !ran) {

            drive.allBack(0.5);        //must use allBack() to go forward

            Timer.delay(2);

            drive.stop();
            ran = true;
        }
//       cock();

    }

    /**
     * This function is called once each time the robot enters operator control.
     */
    public void operatorControl() {
        cock();
        while (true) {

            tankDriveListener();
            rollListener();
            tankDriveListener();
            flapListener();
            transmissionListener();
            shootListener();

        }
    }

    public void cock() {
        cock.initialize();

        while (true) {
            cock.execute();
            if (cock.isFinished()) {
                break;
            }
        }
    }

    public void transmissionListener() {
        RobotMap.s_drivetrain.set(gear);
        if (OI.jb_LeftAttackTop.get() && OI.jb_RightAttackTop.get()) {
            gear = !gear;
            while (OI.jb_LeftAttackTop.get() && OI.jb_RightAttackTop.get()) {
                //do nothing
            }
        }
    }

    public void flapListener() {
        if (OI.jy_Gamepad.getRawAxis(6) == -1) {
            arm.harvesterUp();
        } else if (OI.jy_Gamepad.getRawAxis(6) == 1) {
            arm.harvesterDown();
        } else {
            arm.harvesterStop();
        }
    }

    public void shootListener() {
        if (OI.jb_RightGamepadThrottle.get()) {
//            if (sensors.advanceLatchLimit() || sensors.cockLimit() ||sensors.withdrawLatchLimit()) {

            if (!OI.ls_advanceLatchLimit.get()) {
                arm.withdrawLatch();
            } else {
                arm.stopLatch();
            }

//            }
//            if (sensors.withdrawLatchLimit()) {
//                arm.stopLatch();
//            }
        }
        arm.stopLatch();
    }

    public void rollListener() {
        if (OI.jb_GamepadA.get()) {
            arm.rollIn();
        } else if (OI.jb_GamepadB.get()) {
            arm.rollOut();
        } else {
            arm.rollStop();
        }
    }

    public void tankDriveListener() {
        if (OI.jy_LeftAttack.getTrigger()) {
            drive.setLeftSide(OI.jy_LeftAttack.getY());
        } else {
            drive.setLeftSide(0);
        }

        if (OI.jy_LeftAttack.getTrigger()) {
            drive.setRightSide(OI.jy_RightAttack.getY());
        } else {
            drive.setRightSide(0);
        }
    }

    /**
     * This function is called once each time the robot enters test mode.
     */
    public void test() {

    }

    class Arm {

        public void harvesterUp() {
            RobotMap.v_harvesterActuator.set(-1);
        }

        public void harvesterDown() {
            RobotMap.v_harvesterActuator.set(1);
        }

        public void harvesterStop() {
            RobotMap.v_harvesterActuator.set(0);
        }

        public void withdrawRack() {
            RobotMap.v_mainRackDriver.set(-0.8);
        }

        public void advanceRack() {
            RobotMap.v_mainRackDriver.set(1);
        }

        public void stopRack() {
            RobotMap.v_mainRackDriver.set(0);
        }

        public void advanceLatch() {
            RobotMap.v_triggerWindowMotor.set(1);
        }

        public void withdrawLatch() {
            RobotMap.v_triggerWindowMotor.set(-1);
        }

        public void stopLatch() {
            RobotMap.v_triggerWindowMotor.set(0);
        }

        public void rollIn() {
            RobotMap.v_collectorMotor.set(-1);
        }

        public void rollOut() {                      //Cattlebots, Roll Out!
            RobotMap.v_collectorMotor.set(1);
        }

        public void rollIn(double speed) {
            RobotMap.v_collectorMotor.set(-speed);
        }

        public void rollOut(double speed) {                      //Cattlebots, Roll Out!
            RobotMap.v_collectorMotor.set(speed);
        }

        public void rollStop() {
            RobotMap.v_collectorMotor.set(0);
        }

        public void initDefaultCommand() {
            // Set the default command for a subsystem here.
            //setDefaultCommand(new MySpecialCommand());
        }
    }

    class Cock {

        private boolean done = false;
        private final double rackTime = 0.4;           //how long to run the motor to reset (advance) rack
        private boolean cocked = false;

        protected void initialize() {
            done = false;
            cocked = false;
        }

        protected void execute() {
            if (!sensors.cockLimit() && !cocked) {
                if (!sensors.withdrawLatchLimit()) {
                    unlatch();
                }
                if (sensors.withdrawLatchLimit()) {
                    arm.stopLatch();
                    arm.withdrawRack();
                }
            }
            if (sensors.cockLimit() || cocked) {
                cocked = true;
                if (sensors.withdrawLatchLimit()) {
                    arm.advanceLatch();
                }
                if (sensors.advanceLatchLimit()) {
                    arm.stopLatch();

                    arm.stopRack();
                    arm.advanceRack();
                    Timer.delay(rackTime);
                    arm.stopRack();
                    done = true;
                }
            }

            /*while(!sensors.cockLimit()){
             unlatch();
             while(!sensors.cockLimit()){
             arm.withdrawRack();
             }
             }
             latch();
             arm.stopRack();
             arm.advanceRack();
             Timer.delay(rackTime);
             arm.stopRack();
             done = true;*/
        }

        private void unlatch() {
            arm.advanceLatch();
        }

        private void latch() {
            while (!sensors.advanceLatchLimit()) {
                arm.advanceLatch();
            }
            arm.stopLatch();
        }

        protected boolean isFinished() {
            return done;
        }

        protected void end() {
        }

        protected void interrupted() {
        }
    }

    class Sensors {

        private final double conversionFactor = 0.0098;
        private final double microsecond = 0.000001;
        private NetworkTable server = NetworkTable.getTable("SmartDashboard");
        private boolean hot = false;
        private Timer tim = new Timer();

        public void setHot(boolean state) {
            hot = state;
        }

        public void stopTimer() {
            tim.stop();
        }

        public void startTimer() {
            tim.start();
        }

        public void resetTimer() {
            tim.reset();
        }

        public double getTimer() {
            return tim.get();
        }

        public boolean getHot() {
            return hot;
        }

        public double getBlobCount() {
            try {
                return server.getNumber("BLOB_COUNT");
            } catch (Exception e) {
                System.out.println("Error");
            }
            return -1;
        }

        public boolean cockLimit() {
            return OI.ls_rackLimit.get();
        }

        public boolean advanceLatchLimit() {
            return OI.ls_advanceLatchLimit.get();
        }

        public boolean withdrawLatchLimit() {
            return OI.ls_withdrawLatchLimit.get();
        }

        public void initDefaultCommand() {
            // Set the default command for a subsystem here.
            //setDefaultCommand(new MySpecialCommand());
        }
    }
}
