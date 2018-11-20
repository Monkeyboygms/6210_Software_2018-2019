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

        driveDistance(-0.3, 0.5);
        int gold = findGold(5);
        double angleOff = 0;
        telemetry.addData("gold is at", gold);
        telemetry.addData("align is ", checkAlign());
        telemetry.update();

        driveDistance(-0.3,5.5);
        switch (gold){
            case 2:
                while (!checkAlign() && !isStopRequested()){
                    if (getXpos() < 400) {
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
                angleOff = getYaw();
                driveDistance(-0.3, 3.5);
                sleep(1000);
                driveDistance(0.3,5);
                break;
            case 1:
                while (!checkAlign() && !isStopRequested()){
                    LF.setPower(0.3);
                    RF.setPower(-0.3);
                    LB.setPower(-0.3);
                    RB.setPower(0.3);
                }
                angleOff = getYaw();
                driveDistance(-0.3, 3.5);
                sleep(1000);
                driveDistance(0.3,5);
                break;
            case 3:
                while (!checkAlign() && !isStopRequested()){
                    LF.setPower(-0.3);
                    RF.setPower(0.3);
                    LB.setPower(0.3);
                    RB.setPower(-0.3);
                }
                angleOff = getYaw();
                driveDistance(-0.3, 3.5);
                sleep(1000);
                driveDistance(0.3,5);
                break;
        }
        disableDetector();
        telemetry.addData("turn amount", 90 - angleOff);
        telemetry.update();
        sleep(1000);
        rotate(0.2, 90 - angleOff, true, 5);
        sleep(1000);
        driveDistance(-0.5, 10);
        //strafe(5, false);

        telemetry.addData("Status ", " auto done");
    }
}

