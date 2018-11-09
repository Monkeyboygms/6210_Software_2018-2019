package org.firstinspires.ftc.teamcode.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;

import org.firstinspires.ftc.teamcode.AutoLinearOpMode;

@Autonomous(name="AutoDepot_Intake", group = "auto")
//@Disabled
public class AutoDepot_Intake extends AutoLinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {

        init(hardwareMap);
        int startPos = 0;
        boolean hit = false;

        waitForStart();
        //The robot will have to make multiple turns to get out of the latch. We have been testing next to the latch to have our measurements as accurate to when we delatch as possible.
        driveDistance(0.2,33); //move forward
        sleep(1000);
        expel(3000);
        sleep(3000);
        rotate(40,0.2); //Turn left
        sleep(1000);
            //driveDistance(0.2, 2);
            //sleep(500);
            //rotate(275, 0.2);
            //sleep(1000);
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
            // driveDistance(0.2, 23); //Drive up next to wall
            //sleep(1000);
            //rotate(335, 0.2); //turn parallel to the wall
            //sleep(1000 );
            //driveDistance(0.2, 17); //Move forward into the depot
        //Expel marker
        //deployment.setTargetPosition(575);
        //sleep(1000);
            //expel(2000);
            //sleep(2000);
        //pullBack(500); //EDIT time
        //deployment.setTargetPosition(0);
            driveDistance(0.2, -40);//Back up into the crater
        telemetry.addData("Status ", " auto done");
    }
}
