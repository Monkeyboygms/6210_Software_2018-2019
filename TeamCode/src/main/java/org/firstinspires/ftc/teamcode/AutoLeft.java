package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.RandomTests.StrykeHardwareMap;

@Autonomous(name="AutoLeft", group = "auto")
@Disabled
public class AutoLeft extends AutoLinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {

        init(hardwareMap);

        //Use gamepad buttons to determine wait time

        telemetry.addData("Wait time: ", "WAIT TIME HERE");
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        waitForStart();

        // turn to the left, hit the cube, back up, return to original orientation.
        rotate(30, 1);
        sleep(1000);
        driveDistance(1, 12);
        sleep(1000);
        driveDistance(-1, 12);
        sleep(1000);
        rotate(60, 1);
        sleep(1000);
        driveDistance(1, 36);
        sleep(1000);
        rotate(60, 1);
        sleep(1000);
        driveDistance(1, 36);
        sleep(1000);
        driveDistance(-1, 48);



        //while (opModeIsActive() && !isStopRequested()){

            //lower robot
            //turn left to right while scanning for gold (tbd)
            //when find gold stop and get angle to gold
            //move forward and knock off gold
            //back up and turn left
            //move until lines up with wall
            //determine wait time
            //move forward to push in team marker
            //back up to crater and park

        }
    }

