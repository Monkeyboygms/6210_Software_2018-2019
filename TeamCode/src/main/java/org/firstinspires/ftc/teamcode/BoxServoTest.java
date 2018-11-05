package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;

@Autonomous(name = "BoxServoTest", group = "Sensor")
@Disabled
public class BoxServoTest extends AutoLinearOpMode{

    @Override
    public void runOpMode() throws InterruptedException {

        init(hardwareMap);

        waitForStart();

        //boxServo.setPosition(1);
        telemetry.addData("Pos: ", 1);
        telemetry.update();

        telemetry.addData("Status", "Finished");
        telemetry.update();

    }
}
