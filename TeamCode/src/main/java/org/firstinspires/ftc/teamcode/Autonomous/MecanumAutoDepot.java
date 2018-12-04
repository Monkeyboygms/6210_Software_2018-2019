package org.firstinspires.ftc.teamcode.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.MecanumLinearOpMode;

@Autonomous(name="MecanumAutoDepot", group = "auto")
//@Disabled
public class MecanumAutoDepot extends MecanumLinearOpMode {

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
        int gold = findGold(5); //GET GOLD POSITION
        int x = 0;
        double angleOff = 0;
        telemetry.addData("gold is at", gold);
        telemetry.addData("align is ", checkAlign());
        telemetry.update();
        driveDistance(-0.3,10); //MOVE FORWARD OUT OF LANDER ZONE
        resetTime();
        switch (gold){
            case 2:
                while (!checkAlign() && !isStopRequested() && getTime() < 4){ //IF GOLD IN CENTER, ADJUST
                    if (getXpos() < 400){
                        LF.setPower(0.3);
                        RF.setPower(-0.3);
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
                x= 5;
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
                x = 10;
                break;
            case 3:
                while (!checkAlign() && !isStopRequested() && getTime() < 3){ //IF GOLD ON RIGHT, MOVE RIGHT TIL ALIGNED
                    LF.setPower(-0.4);
                    RF.setPower(0.4);
                    LB.setPower(0.4);
                    RB.setPower(-0.4);
                }
                driveDistance(-0.3, 5); //PUSH AND BACK UP
                sleep(1000);
                break;
        }
        driveDistance(0.3, 5.7);
        angleOff = getYaw(); //UPDATE ANGLE
        disableDetector();
        rotate(0.2, 90 - angleOff, true, 5);
        driveDistance(-0.5, 18 - x); //MOVE TOWARD DEPOT
        rotate(0.2, 45, false, 5);
        driveDistance(-0.4, 10);
        driveDistance(0.4, 0.5);
        strafeDistance(0.7, 35,true);
        marker.setPosition(1);
        sleep(1000);
        marker.setPosition(0);
        strafeDistance(0.7, 73,false);
        sleep(1000);
        telemetry.addData("Status ", " auto done");
    }
}

