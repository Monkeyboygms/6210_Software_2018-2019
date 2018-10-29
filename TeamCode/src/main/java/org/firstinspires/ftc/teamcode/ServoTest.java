package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.Servo;

@Autonomous(name = "ServoTest", group = "Sensor")
//@Disabled
public class ServoTest extends AutoLinearOpMode{

    @Override
    public void runOpMode() throws InterruptedException {

        Servo goldHitter = hardwareMap.servo.get("goldHitter");

        waitForStart();

        goldHitter.setPosition(90);

        telemetry.addData("Status", "Finished");
        telemetry.update();

    }
}
