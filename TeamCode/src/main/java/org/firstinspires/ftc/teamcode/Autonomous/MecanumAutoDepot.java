package org.firstinspires.ftc.teamcode.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.AutoLinearOpMode;

@Autonomous(name="MecanumAutoCrater", group = "auto")
//@Disabled
public class MecanumAutoDepot extends AutoLinearOpMode {

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
        //Scan (if block found move forward, turn towards depot, move slightly, deploy marker, move into depot, turn left 90, move into enemy crater
        //Strafe Left if scan = false
        //Scan (if block found move forward and into depot, deploy marker, turn left towards crater, move into crater
        //Strafe Left if scan = false
        //Scan (if block found move forward, turn towards depot, move slightly, deploy marker, move into depot, reverse into crater
        sleep(2000);
        driveDistance(0.5, -45);//Back up into the crater
        telemetry.addData("Status ", " auto done");
    }
}

