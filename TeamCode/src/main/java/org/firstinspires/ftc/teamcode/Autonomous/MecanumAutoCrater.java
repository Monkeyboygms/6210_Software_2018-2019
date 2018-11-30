package org.firstinspires.ftc.teamcode.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.MecanumLinearOpMode;

@Autonomous(name="MecanumAutoCrater", group = "auto")
//@Disabled
public class MecanumAutoCrater extends MecanumLinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {

        init(hardwareMap, true);

        waitForStart();

        driveDistance(-0.3, 0.5); //MOVE A BIT TO TRIGGER CAMERA VIEWING
        int gold = findGoldCrater(5); //GET GOLD POSITION
        int x = 0;
        double angleOff = 0;
        telemetry.addData("gold is at", gold);
        telemetry.addData("align is ", checkAlign());
        telemetry.update();
        driveDistance(-0.3,5.5); //MOVE FORWARD OUT OF LANDER ZONE
        resetTime();
        switch (gold){
            case 2:
                while (!checkAlign() && !isStopRequested() && getTime() < 4){ //IF GOLD IN CENTER, ADJUST
                    if (getXpos() < 400){
                        LF.setPower(0.3);
                        RF.setPower(-0.3);
                        LB.setPower(-0.3);
                        RB.setPower(0.3);
                    }else{
                        LF.setPower(-0.3);                                               
                        RF.setPower(0.3);
                        LB.setPower(0.3);
                        RB.setPower(-0.3);
                    }
                }
                driveDistance(-0.3, 5); //PUSH GOLD
                sleep(1000);
                driveDistance(0.3,5); //BACK UP
                x = 10;
                break;
            case 1:
                while (!checkAlign() && !isStopRequested() && getTime() < 4){ //IF GOLD ON LEFT, MOVE LEFT TIL ALIGNED
                    LF.setPower(0.3);
                    RF.setPower(-0.3);
                    LB.setPower(-0.3);
                    RB.setPower(0.3);
                }
                driveDistance(-0.3, 5); //PUSH AND BACK UP
                sleep(1000);
                driveDistance(0.3,5);
                x = 20;
                break;
            case 3:
                while (!checkAlign() && !isStopRequested() && getTime() < 4){ //IF GOLD ON RIGHT, MOVE RIGHT TIL ALIGNED
                    LF.setPower(-0.3);
                    RF.setPower(0.3 );
                    LB.setPower(0.3);
                    RB.setPower(-0.3);
                }
                driveDistance(-0.3, 5); //PUSH AND BACK UP
                sleep(1000);
                driveDistance(0.3,5);
                break;
        }
        angleOff = getYaw(); //UPDATE ANGLE
        disableDetector();
        rotate(0.2, 90 - angleOff, true, 5); //TURN 90 DEGREES RIGHT
        sleep(1000);
        driveDistance(-0.5, 30-x); // DRIVE TO WALL
        strafeDistance(0.5, 10, false); //STRAFE TO DEPOT
        marker.setPosition(180); //DROP TEAM MARKER
        marker.setPosition(0); //LIFT STICK
        strafeDistance(0.5, 30, true); //PARK ON CRATER
        telemetry.addData("Status ", " auto done");
    }
}