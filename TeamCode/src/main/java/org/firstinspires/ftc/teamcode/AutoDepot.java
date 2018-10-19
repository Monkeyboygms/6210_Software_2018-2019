package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.RandomTests.StrykeHardwareMap;

@Autonomous(name="AutoDepot", group = "auto")
//@Disabled
public class AutoDepot extends AutoLinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {

        init(hardwareMap);

        //Use gamepad buttons to determine wait time

        telemetry.addData("Wait time: ", "WAIT TIME HERE");
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        waitForStart();

        // If the cube is on the left side
        //turn towards cube
        sleep(1000);
        //Push cube
        driveDistance(0.3, 10);
        sleep(1000);
        rotate(75, .1);

        driveDistance(0.3, -5);
        driveDistance(0.3,10);
        //Backup
        /*driveDistance(-1, 12);
        sleep(1000);
        //Turn towards wall
        rotate(60, 1);
        sleep(1000);
        //Move towards wall
        driveDistance(1, 36);
        sleep(1000);
        //Turn to face depot
        rotate(60, 1);
        sleep(1000);
        //Drive into depot
        driveDistance(1, 36);
        //Drop marker
        sleep(1000);
        //Back up into crater
        driveDistance(-1, 48);


        //If the cube is on the right
        rotate(30, 1);
        sleep(1000);
        //Push cube
        driveDistance(1, 12);
        sleep(1000);
        //turn towards the depot

            */

        }
    }

