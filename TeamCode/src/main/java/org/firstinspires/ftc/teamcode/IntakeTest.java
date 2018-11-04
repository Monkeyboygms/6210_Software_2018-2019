package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous(name = "IntakeTest", group = "teleop")
//@Disabled
public class IntakeTest extends AutoLinearOpMode{

    @Override
    public void runOpMode() throws InterruptedException {

        init(hardwareMap);

        waitForStart();

        telemetry.addData("status", "expelling");
        telemetry.update();
        expel(3000);
        telemetry.addData("status", "taking in");
        telemetry.update();
        takeIn(3000);
        telemetry.addData("status", "done");
        telemetry.update();


    }
}