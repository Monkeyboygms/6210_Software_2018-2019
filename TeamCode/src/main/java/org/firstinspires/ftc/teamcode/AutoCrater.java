package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;

@Autonomous(name="AutoCrater", group = "auto")
//@Disabled
public class AutoCrater extends AutoLinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {

        init(hardwareMap);

        //Use gamepad buttons to determine wait time


      //  telemetry.addData("Wait time: ", "WAIT TIME HERE");
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        boolean hit = false;

        waitForStart();
           //move forward
            driveDistance(0.3,5);
            //Turn 90
            rotate(75,0.3);
            //Back up
            driveDistance(0.3, -4);
            if(isGold() && !hit)
                knockGold();
                hit = true;
            driveDistance(0.3, 4);
            if(isGold() && !hit)
                knockGold();
                hit = true;
            driveDistance(0.3, 4);
                knockGold();
                hit = true;

            telemetry.addData("status ", "done");
        //turn towards wall
            /*rotate(55, 0.3);
             //move towards wall
            driveDistance(0.3, 7);
            rotate(50, 0.1);
            //turn towards depot
            rotate(37, 0.3);*/
        }
    }

