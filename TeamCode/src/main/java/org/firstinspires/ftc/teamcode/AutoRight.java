package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;

@Autonomous(name="AutoRight", group = "auto")
//@Disabled
public class AutoRight extends AutoLinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {

        init(hardwareMap);

        //Use gamepad buttons to determine wait time

        telemetry.addData("Wait time: ", "WAIT TIME HERE");
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        waitForStart();
            // If the cube is on the left side
            //turn towards cube
            rotate(20, 0.3);
            sleep(1000);
            //Push cube
            driveDistance(0.3, 16);
            sleep(1000);
            driveDistance(0.3, -4);
            //turn towards wall
            rotate(55, 0.3);
            sleep(1000);
            /*
            //move towards wall
            driveDistance(0.3, 25);
            sleep(1000);
            //turn towards depot
            rotate(37, 0.3);
*/

            driveDistance(0.3, -5);
            driveDistance(0.3,10);

            //lower robot
            //turn left to right while scanning for gold (tbd)
            //when find gold stop and get angle to gold
            //move forward and knock off gold
            //back up and turn left
            //move forward until lines up with wall
            //Move forward to crater and park

        }
    }

