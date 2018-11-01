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
           driveDistance(0.1,12); //move forward
           sleep(1000);
           rotate(90,0.2); //Turn 90
           sleep(1000);
           driveDistance(0.1, -7); //Back up to line up with the last mineral
           sleep(1000);
           startPos = LF.getCurrentPosition();
           int dist = LF.getCurrentPosition() - startPos;
           while (!hit && (dist < (25/encoderToInches))){  //Move forward checking for gold mineral, if found, knock and exit while loop
               setMotorPowers(0.1,0.1);
               if (isGold()){
                   knockGold();
                   hit = true;
                   telemetry.addData("gold knocked:", true);
               }else{
                   telemetry.addData("gold knocked:", false);
               }
               dist = LF.getCurrentPosition() - startPos;
           }
           driveDistance(0.1, 25-dist); //Drive up next to the wall
           sleep(1000);
           rotate(-30, 0.1); //turn parallel to the wall
           sleep(1000 );
           driveDistance(0.1, 24); //Move forward into the depot
           sleep(1000);
           // openBox();
           driveDistance(0.2, 3);
           sleep(500);
           // closeBox();
           driveDistance(-0.2, 3);
           sleep(500);
           //Back up into the crater
           driveDistance(-0.1, 32);
           telemetry.addData("Status ", " auto done");
        }
    }

