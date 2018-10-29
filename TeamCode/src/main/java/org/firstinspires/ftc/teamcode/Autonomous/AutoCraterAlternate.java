package org.firstinspires.ftc.teamcode.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.AutoLinearOpMode;
import org.firstinspires.ftc.teamcode.RandomTests.StrykeHardwareMap;

@Autonomous(name="AutoDepot", group = "auto")
//@Disabled
public class AutoCraterAlternate extends AutoLinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {

        init(hardwareMap);

        //Use gamepad buttons to determine wait time

        telemetry.addData("Wait time: ", "WAIT TIME HERE");
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        boolean hit = false;

        waitForStart();

        //move forward
        driveDistance(0.1, 12);
        sleep(1000);
        //Turn 90
        rotate(90, 0.1);
        sleep(1000);
        //Back up to line up with the last mineral
        driveDistance(0.1, -7);
        sleep(1000);
        //Move forward checking for gold mineral
        if (isGold() && !hit)
            knockGold();
        hit = true;
        driveDistance(0.1, 7);
        sleep(1000);
        if (isGold() && !hit)
            knockGold();
        hit = true;
        driveDistance(0.1, 7);
        sleep(1000);
        if (isGold() && !hit)
            knockGold();
        hit = true;
        //Drive up until past lander leg
        driveDistance(0.1, 5);
        sleep(1000);
        //Turn left
        rotate(-90, 0.1);
        sleep(1000);
        //Move forward until next to wall
        driveDistance(0.1, 60);
        sleep(1000);
        //Turn right until facing depot
        rotate(120, 0.1);
        sleep(1000);
        //Drive into depot
        driveDistance(0.1, 32);
        sleep(1000);
        //Back up into enemy crater
        driveDistance(-0.1, 40);
        sleep(1000);
        telemetry.addData("status ", "done");
    }
}

