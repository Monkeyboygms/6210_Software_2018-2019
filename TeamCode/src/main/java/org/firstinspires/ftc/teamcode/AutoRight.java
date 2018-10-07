package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;

@Autonomous(name="AutoRight", group = "auto")
@Disabled
public class AutoRight extends AutoLinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {

        init(hardwareMap);

        //Use gamepad buttons to determine wait time

        telemetry.addData("Wait time: ", "WAIT TIME HERE");
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        waitForStart();

        while (opModeIsActive() && !isStopRequested()){

            //lower robot
            //turn left to right while scanning for gold (tbd)
            //when find gold stop and get angle to gold
            //move forward and knock off gold
            //back up and turn left
            //move forward until lines up with wall
            //Move forward to crater and park

        }
    }
}
