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
        // TODO: When encoders are wired for deployment drawbridge, then can treat it like a servo with starting and deployed positions
        // TODO: Then just need to use deployment.setTargetPosition(Deploy|Start); and it will move back and forth to wherever it needs
        // TODO: It will also hold it in place nicely, whereas now even setting to "BRAKE" doesn't stop it
        //deployment.setPower(0.5); // RUN_TO_POSITION == 100, so will hold in place until needed
           driveDistance(0.1,10); //move forward
           sleep(1000);
           rotate(290,0.1); //Turn left
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
           }*/
           //driveDistance(0.2, 20-dist); //Drive up next to the wall
        //driveDistance(0.2, 20);
        driveDistance(0.1, 24);
        sleep(1000);
        rotate(323, 0.1); //turn parallel to the wall
        sleep(1000 );
        driveDistance(0.2, 28); //Move forward into the depot
        sleep(1000);
        //openBox();
        sleep(1000);
        driveDistance(1,-2);
        sleep(1000);
        driveDistance(0.5, -44);            //Back up into the crater
        telemetry.addData("Status ", " auto done");
        }
    }

