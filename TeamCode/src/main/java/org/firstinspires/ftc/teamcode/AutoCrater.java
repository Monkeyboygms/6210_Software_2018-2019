package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;

@Autonomous(name="AutoCrater", group = "auto")
//@Disabled
public class AutoCrater extends AutoLinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {

        init(hardwareMap);

       /* int waitTime = getWait();

        telemetry.addData("Wait time: ", waitTime);
        telemetry.update();*/

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
            //turn parallel to the wall
            rotate(-30, 0.1);
            sleep(1000 );
            //Move forward into the depot
            driveDistance(0.1, 24);
            sleep(1000);
            //Back up into the crater
            driveDistance(0.1, 32);


            //wait(waitTime);
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

