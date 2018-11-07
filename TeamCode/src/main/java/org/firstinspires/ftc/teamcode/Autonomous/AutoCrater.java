package org.firstinspires.ftc.teamcode.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;

import org.firstinspires.ftc.teamcode.AutoLinearOpMode;

@Autonomous(name="AutoCrater", group = "auto")
//@Disabled
public class AutoCrater extends AutoLinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {

        init(hardwareMap);
        int startPos = 0;
        boolean hit = false;

        waitForStart();

        driveDistance(0.2,22); //move forward
           /*sleep(1000);
           rotate(290,0.2); //Turn left
           sleep(1000);
          // driveDistance(-0.2, 9); //Back up to line up with the last mineral
           //sleep(1000);
           //startPos = LF.getCurrentPosition();
           /*int dist = LF.getCurrentPosition() - startPos;
           while (!hit && (dist < (25/encoderToInches))){  //Move forward checking for gold mineral, if found, knock and exit while loop
               setMotorPowers(0.1,0.1);
               if (isGold()){
                   //knockGold();
                   hit = true;
                   telemetry.addData("gold knocked:", true);
               }else{
                   telemetry.addData("gold knocked:", false);
               }
               dist = LF.getCurrentPosition() - startPos;
           }
           //driveDistance(0.2, 20-dist); //Drive up next to the wall
        //driveDistance(0.2, 20);
        driveDistance(0.2, 24);
        sleep(1000);
        rotate(323, 0.2); //turn parallel to the wall
        sleep(1000 );
        driveDistance(0.3, 28); //Move forward into the depot
        sleep(1000);
        //openBox();
        sleep(1000);
        driveDistance(1,-2);
        sleep(1000);
        driveDistance(0.5, -44);            //Back up into the crater
        */
        telemetry.addData("Status ", " auto done");
        }
    }

