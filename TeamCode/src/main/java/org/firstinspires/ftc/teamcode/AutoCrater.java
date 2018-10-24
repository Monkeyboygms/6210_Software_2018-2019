package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;

@Autonomous(name="AutoCrater", group = "auto")
//@Disabled
public class AutoCrater extends AutoLinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {

        runtime.reset();

        init(hardwareMap);

        int waitTime = getWait();

        telemetry.addData("Wait time: ", waitTime);
        telemetry.update();

        boolean hit = false;

        waitForStart();
           //move forward
           driveDistance(0.1,12);
           sleep(1000);
            //Turn 90
           rotate(90,0.1);
           sleep(1000);
            //Back up
           driveDistance(0.1, -7);
            sleep(1000);
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
            wait(waitTime);
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

