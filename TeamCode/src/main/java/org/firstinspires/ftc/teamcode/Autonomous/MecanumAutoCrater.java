package org.firstinspires.ftc.teamcode.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.AutoLinearOpMode;
import org.firstinspires.ftc.teamcode.MecanumLinearOpMode;

@Autonomous(name="MecanumAutoCrater", group = "auto")
//@Disabled
public class MecanumAutoCrater extends MecanumLinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {

        init(hardwareMap, true);

        waitForStart();

        driveDistance(-0.3, 2);
        int gold = findGold(10);
        telemetry.addData("gold is at", gold);
        telemetry.addData("align is ", checkAlign());
        telemetry.update();
        sleep(5000);
        driveDistance(-0.3,8);
        switch (gold){
            case 2:
                driveDistance(-0.3, 10);
                sleep(1000);
                driveDistance(0.3,8);
                break;
            case 1:
                while (!checkAlign() && !isStopRequested()){
                    LF.setPower(0.3);
                    RF.setPower(-0.3);
                    LB.setPower(-0.3);
                    RB.setPower(0.3);
                }
                driveDistance(-0.3, 10);
                sleep(1000);
                driveDistance(0.3,8);
                break;
            case 3:
                while (!checkAlign() && !isStopRequested()){
                    LF.setPower(-0.3);
                    RF.setPower(0.3 );
                    LB.setPower(0.3);
                    RB.setPower(-0.3);
                }
                driveDistance(-0.3, 10);
                sleep(1000);
                driveDistance(0.3,8);
                break;
        }
        disableDetector();
        rotate(0.2, 90, true, 5);
        //sleep(1000);
        //driveDistance(0.5, 15);
        //strafe(5, false);

        telemetry.addData("Status ", " auto done");
    }
}

