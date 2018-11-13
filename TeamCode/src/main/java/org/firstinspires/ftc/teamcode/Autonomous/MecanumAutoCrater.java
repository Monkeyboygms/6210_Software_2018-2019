package org.firstinspires.ftc.teamcode.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.AutoLinearOpMode;

@Autonomous(name="MecanumAutoCrater", group = "auto")
//@Disabled
public class MecanumAutoCrater extends AutoLinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {

        init(hardwareMap);
        int startPos = 0;
        boolean hit = false;

        waitForStart();
        //The robot will have to make multiple turns to get out of the latch. We have been testing next to the latch to have our measurements as accurate to when we delatch as possible.
        driveDistance(0.2,10); //move forward
        sleep(1000);
        //Strafe Right
        //Scan (if block found move forward then back to original position)
        //Strafe Left if scan = false
        //Scan (if block found move forward then back to original position)
        //Strafe Left if scan = false (again)
        //Scan (if block found move forward then back to original position)
        //turn towards wall (subtract distance of strafes when calculating distance
        sleep(1000);
        driveDistance(0.2, 23/*minus whatever the distance we strafed was*/); //Drive up next to wall
        sleep(1000);
        rotate(335, 0.2); //turn parallel to the wall
        sleep(1000 );
        driveDistance(0.2, 20); //Move forward into the depot
        //Deploy marker
        sleep(2000);
        driveDistance(0.5, -45);//Back up into the crater
        telemetry.addData("Status ", " auto done");
    }
}

