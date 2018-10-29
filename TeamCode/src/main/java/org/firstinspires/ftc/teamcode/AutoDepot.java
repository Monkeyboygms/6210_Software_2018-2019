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

        boolean hit = false;

        waitForStart();

        //move forward
        driveDistance(0.1,12);
        sleep(1000);
        //Turn 90
        rotate(90,0.1);
        sleep(1000);
        //Back up to line up with the last mineral
        driveDistance(0.1, -7);
        sleep(1000);
        //Move forward checking for gold mineral
        if(isGold() && !hit)
            knockGold();
        hit = true;
        driveDistance(0.1, 7);
        sleep(1000);
        if(isGold() && !hit)
            knockGold();
        hit = true;
        driveDistance(0.1, 7);
        sleep(1000);
        if(isGold() && !hit)
            knockGold();
        hit = true;
        //Drive up next to the wall
        driveDistance(0.1, 5);
        sleep(1000);
        //turn parallel to the wall and facing the depot
        rotate(-120, 0.1);
        sleep(1000 );
        //Move forward into the depot
        driveDistance(0.1, 30);
        sleep(1000);
        //Back up into the crater
        driveDistance(-0.1, 40);
        telemetry.addData("status ", "done");





       /* rotate(20, .3);
        sleep(3000);
        //Move and Push cube
        driveDistance(0.3, 10);
        sleep(5000);
        //Rotate
        rotate(-30, .3);
        sleep(5000);
        //Parking backwards
        driveDistance(0.3, 10);
        sleep(5000);
        /*
        driveDistance(0.3, -5);
        driveDistance(0.3,10);
        //Backup
        driveDistance(-1, 12);
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

