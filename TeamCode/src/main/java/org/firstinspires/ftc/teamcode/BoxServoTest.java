package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous(name = "BoxServoTest", group = "Sensor")
//@Disabled
public class BoxServoTest extends AutoLinearOpMode{

    @Override
    public void runOpMode() throws InterruptedException {

        init(hardwareMap);

        waitForStart();

        boxServo.setPosition(-1);
        telemetry.addData("Pos: ", -1);
        telemetry.update();
        sleep(2000);
        boxServo.setPosition(0);
        telemetry.addData("Pos: ", 0);
        telemetry.update();
        sleep(2000);
        boxServo.setPosition(1);
        telemetry.addData("Pos: ", 1);
        telemetry.update();
        sleep(2000);

        telemetry.addData("Status", "Finished");
        telemetry.update();

    }
}
