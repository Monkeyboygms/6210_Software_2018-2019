package org.firstinspires.ftc.teamcode.Testing;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;

import org.firstinspires.ftc.teamcode.AutoLinearOpMode;
import org.firstinspires.ftc.teamcode.MecanumLinearOpMode;

@Autonomous(name = "BoxServoTest", group = "Sensor")
//@Disabled
public class BoxServoTest extends MecanumLinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {

        init(hardwareMap, false);

        waitForStart();

        while (opModeIsActive() && !isStopRequested()){
            telemetry.addData("position: ", marker.getPosition());
            telemetry.update();
        }


    }
}
