package org.firstinspires.ftc.teamcode.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;

import org.firstinspires.ftc.teamcode.AutoLinearOpMode;

@Autonomous(name="AutoDepot", group = "auto")
//@Disabled
public class AutoDepot extends AutoLinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {

        init(hardwareMap);
        int startPos = 0;
        boolean hit = false;

        waitForStart();
        driveDistance(0.2,25); //move forward
        sleep(1000);
        deploy(1000);
        expel(2000);
        rotate(232,0.2); //Turn left
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
        //Back up into the crater
        driveDistance(0.5, -40);
        telemetry.addData("Status ", " auto done");
    }
}
