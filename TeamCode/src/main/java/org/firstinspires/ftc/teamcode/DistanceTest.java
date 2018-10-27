package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import java.util.Arrays;

@Autonomous(name = "DistanceTest", group = "Sensor")
//@Disabled
public class DistanceTest extends AutoLinearOpMode{

    @Override
    public void runOpMode() throws InterruptedException {

        init(hardwareMap);

        waitForStart();


            telemetry.addData("Distance", getDist());
            driveDistance(0.3, getDist());
            telemetry.update();

    }
}
