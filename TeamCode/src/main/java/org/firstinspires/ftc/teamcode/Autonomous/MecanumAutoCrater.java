package org.firstinspires.ftc.teamcode.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.MecanumLinearOpMode;

@Autonomous(name="MecanumAutoCrater", group = "auto")
//@Disabled
public class MecanumAutoCrater extends MecanumLinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {

        init(hardwareMap, true);

        waitForStart();
        unlatch();
        lift.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        sleep(2000);

        int liftTarget = lift.getCurrentPosition()-600;
        while (!isStopRequested() && lift.getCurrentPosition() > liftTarget){
            lift.setPower(-1);
        }
        lift.setPower(0);
        strafeDistance(-0.5, 2, true); //MOVE A BIT TO TRIGGER CAMERA VIEWING
        lock.setPosition(0);
        //driveDistance(-0.3, 0.5); //MOVE A BIT TO TRIGGER CAMERA VIEWING
        int gold = findGold(2); //GET GOLD POSITION
        double angleOff = 0;
        int x = 0;
        telemetry.addData("gold is at", gold);
        telemetry.addData("align is ", checkAlign());
        telemetry.update();
        driveDistance(-0.3,10); //MOVE FORWARD OUT OF LANDER ZONE
        resetTime();
        switch (gold){
            case 2:
                while (!checkAlign() && !isStopRequested() && getTime() < 4){ //IF GOLD IN CENTER, ADJUST
                    if (getXpos() < 400){
                        LF.setPower(0.4);
                        RF.setPower(-0.4);
                        LB.setPower(-0.4);
                        RB.setPower(0.4);
                    }else{
                        LF.setPower(-0.4);
                        RF.setPower(0.4);
                        LB.setPower(0.4);
                        RB.setPower(-0.4);
                    }
                }
                driveDistance(-0.3, 5); //PUSH GOLD
                sleep(1000);
                driveDistance(0.3, 5);
                x = 5;
                break;
            case 1:
                while (!checkAlign() && !isStopRequested() && getTime() < 4){ //IF GOLD ON LEFT, MOVE LEFT TIL ALIGNED
                    LF.setPower(0.4);
                    RF.setPower(-0.4);
                    LB.setPower(-0.4);
                    RB.setPower(0.4);
                }
                driveDistance(-0.3, 5); //PUSH AND BACK UP
                sleep(1000);
                driveDistance(0.3, 5);
                x = 10;
                break;
            case 3:
                telemetry.addData("status", "about to move right");
                telemetry.update();
                sleep(1000);
                while (!checkAlign() && !isStopRequested() && getTime() < 4){ //IF GOLD ON RIGHT, MOVE RIGHT TIL ALIGNED
                    telemetry.addData("status", "moving right");
                    telemetry.addData("aligning right", checkAlign());
                    telemetry.update();
                    telemetry.update();
                    LF.setPower(-0.4);
                    RF.setPower(0.4);
                    LB.setPower(0.4);
                    RB.setPower(-0.4);
                }
                driveDistance(-0.3, 5); //PUSH AND BACK UP
                sleep(1000);
                driveDistance(0.3, 5);
                break;
        }
        angleOff = getYaw(); //UPDATE ANGLE
        disableDetector();
        rotate(0.2, 90 - angleOff, false, 5); //TURN 270 DEGREES RIGHT
        sleep(1000);
        driveDistance(0.4, 30-x); // DRIVE  TO WALL
        rotate(0.2, 45, false, 5);
        sleep(1000);
        driveDistance(0.4, 0.5);
        strafeDistance(0.5, 30, true); //STRAFE TO DEPOT
        sleep(1000);
        marker.setPosition(1); //DROP TEAM MARKER
        sleep(1000);
        marker.setPosition(0); //LIFT STICK
        sleep(1000);
        strafeDistance(0.5, 40, false); //PARK ON CRATER
        telemetry.addData("Status ", " auto done");
    }
}