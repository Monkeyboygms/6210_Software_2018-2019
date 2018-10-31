package org.firstinspires.ftc.teamcode.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.AutoLinearOpMode;

@Autonomous(name="AutoCraterTime", group = "auto")
//@Disabled
public class AutoCraterTimeBased extends AutoLinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {

        init(hardwareMap);
        int startPos = 0;
        boolean hit = false;

        waitForStart();
           driveTime(0.2,4); //move forward
           sleep(1000);
           turnTime(-0.2,3); //Turn 90
           sleep(1000);
           driveTime(-0.2,4); //Back up to line up with the last mineral
           sleep(1000);
           startPos = LF.getCurrentPosition();
           int dist = LF.getCurrentPosition() - startPos;
           while (getRuntime() < 7){  //Move forward checking for gold mineral, if found, knock and exit while loop
               setMotorPowers(0.1,0.1);
               if (isGold()){
                   knockGold();
                   hit = true;
                   telemetry.addData("gold knocked:", true);
               }else{
                   telemetry.addData("gold knocked:", false);
               }
           }
           driveTime(0.2, 3); //Drive up next to the wall
           sleep(1000);
           turnTime(-0.2, 3); //turn parallel to the wall
           sleep(1000 );
           driveTime(0.3, 7); //Move forward into the depot
           sleep(1000);
           driveDistance(-0.3, 8);  //Back up into the crater
           telemetry.addData("Status ", " auto done");
        }
    }

