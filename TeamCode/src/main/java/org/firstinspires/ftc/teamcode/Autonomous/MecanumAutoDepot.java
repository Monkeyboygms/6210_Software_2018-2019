package org.firstinspires.ftc.teamcode.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.MecanumLinearOpMode;

@Autonomous(name="MecanumAutoDepot", group = "auto")
//@Disabled
public class MecanumAutoDepot extends MecanumLinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {

        init(hardwareMap, true);

        waitForStart();

        driveDistance(-0.3, 1);
        int gold = findGoldDepot(5);
        double angleOff = 0;
        double storex = getXpos();
        telemetry.addData("gold is at", gold);
        telemetry.addData("align is ", checkAlign());
        telemetry.update();
        driveDistance(-0.3,5.5);
        resetTime();
        switch (gold){
            case 2:
                while (!checkAlign() && !isStopRequested() && getTime() < 4){
                    if (getXpos() > 400){
                        LF.setPower(-0.3);
                        RF.setPower(0.3);
                        LB.setPower(0.3);
                        RB.setPower(-0.3);
                    }else{
                        LF.setPower(0.3);
                        RF.setPower(-0.3);
                        LB.setPower(-0.3);
                        RB.setPower(0.3);
                    }
                }
                driveDistance(-0.3, 3.5);
                sleep(1000);
                driveDistance(0.3,5);
                break;
            case 1:
                while (!checkAlign() && !isStopRequested() && getTime() < 4){
                    LF.setPower(-0.3);
                    RF.setPower(0.3);
                    LB.setPower(0.3);
                    RB.setPower(-0.3);
                }
                driveDistance(-0.3, 3.5);
                sleep(1000);
                driveDistance(0.3,5);
                break;
            case 3:
                while (!checkAlign() && !isStopRequested() && getTime() < 4){
                    LF.setPower(0.3);
                    RF.setPower(-0.3 );
                    LB.setPower(-0.3);
                    RB.setPower(0.3);
                }
                driveDistance(-0.3, 3.5);
                sleep(1000);
                driveDistance(0.3,5);
                break;
        }
        angleOff = getYaw(); //I update angleOff here instead of right after hitting block
        disableDetector();
        rotate(0.2, 90 - angleOff, true, 5);
        sleep(1000);
        //driveDistance(0.5, 15);
        //strafe(5, false);

        telemetry.addData("Status ", " auto done");
    }
}

