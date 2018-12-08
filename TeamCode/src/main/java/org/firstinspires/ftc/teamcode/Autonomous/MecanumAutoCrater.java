package org.firstinspires.ftc.teamcode.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.MecanumLinearOpMode;

@Autonomous(name="MecanumAutoCrater", group = "auto")
//@Disabled
public class MecanumAutoCrater extends MecanumLinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {

        double startAng = init(hardwareMap, true);

        init(hardwareMap, true);
        double dist = 45;
        waitForStart();
        lift.setPower(0.75);
        lock.setPosition(1);
        lift.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        sleep(2000);
        int liftTarget = lift.getCurrentPosition()-640;
        while (!isStopRequested() && lift.getCurrentPosition() > liftTarget){
            lift.setPower(-1);
        }
        lift.setPower(0);
        driveDistance(0.3,0.5);
        double ang = getYaw();
        // rotate(0.2,-ang,false, 2 );
        strafeDistance(-0.3, 6.5, true); //MOVE A BIT TO TRIGGER CAMERA VIEWING
        lock.setPosition(0);
        int gold = findGold(3); //GET GOLD POSITION
        sleep(1000);
        int x = 0;
        double angleOff = 0;
        telemetry.addData("gold is at", gold);
        telemetry.addData("align is ", checkAlign());
        telemetry.update();
        driveDistance(-0.3,9); //MOVE FORWARD OUT OF LANDER ZONE
        resetTime();
        switch (gold){
            case 2:
                while (!checkAlign() && !isStopRequested() && getTime() < 4){ //IF GOLD IN CENTER, ADJUST
                    //if (getXpos() < 400){
                        //LF.setPower(0.4);
                        //RF.setPower(-0.4);
                        //LB.setPower(-0.4);
                      //  RB.setPower(0.4);
                    //}else{
                        LF.setPower(-0.4);
                        RF.setPower(0.4);
                        LB.setPower(0.4);
                        RB.setPower(-0.4);
                    //}
                }
                sleep(1000);
                strafeDistance(-0.5, 3, true); // better aligns to not hit other mineral
                sleep(1000);
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
                strafeDistance(-0.25, 3, true); // better aligns to not hit other mineral
                sleep(1000);
                driveDistance(-0.3, 5); //PUSH AND BACK UP
                sleep(1000);
                driveDistance(0.3, 5);
                x = 10;
                break;
            case 3://
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
        rotate(0.2, 90 - angleOff, false, 5);
        sleep(1000);
        driveDistance(0.5, 35 - x); //MOVE TOWARD WALL
        sleep(1000);
       // rotate(0.2, 45, false, 5);
        driveDistance(0.4, 5);
        driveDistance(-0.4, 0.5);
        strafeDistance(0.7, 17,true);
        driveDistance(0.4,5);
        strafeDistance(0.7, 17,true);
        marker.setPosition(1);
        sleep(1000);
        //marker.setPosition(0);
        strafeDistance(0.7, 17,false);
        driveDistance(0.4,5);
        strafeDistance(0.7, 17,false);
        sleep(1000);
        lock.setPosition(1);
        sleep(1000);
        telemetry.addData("Status ", " auto done");
    }
}