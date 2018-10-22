package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;

@Autonomous(name="AutoCrater", group = "auto")
//@Disabled
public class AutoCrater extends AutoLinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {

        init(hardwareMap);

        //Use gamepad buttons to determine wait time

        telemetry.addData("Wait time: ", "WAIT TIME HERE");
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        waitForStart();
            // If the cube is on the left side
            //drive up to cube
            driveDistance(0.3, 10);
            sleep(1000);
            //turn parallel to mineral line
            rotate(-80, 0.2);
            sleep(1000);
            //drive to farthest cube from wall connecting team depot to crater
            driveDistance(-0.3, 7);
            sleep(1000);
            //Start color sensor scanning
            //Move forward until next to wall
            driveDistance(0.3, 17);
            //turn towards depot
            rotate(30, 0.2 );


            /*
            //move towards wall
            driveDistance(0.3, 25);
            sleep(1000);
            //turn towards depot
            rotate(37, 0.3);
*/

            //driveDistance(0.3, -5);
            //driveDistance(0.3,10);

            //lower robot
            //turn left to right while scanning for gold (tbd)
            //when find gold stop and get angle to gold
            //move forward and knock off gold
            //back up and turn left
            //move forward until lines up with wall
            //Move forward to crater and park

        }
    }

