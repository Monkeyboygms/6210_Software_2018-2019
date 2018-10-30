package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "ServoTest", group = "Sensor")
//@Disabled
public class ServoTest extends AutoLinearOpMode{

    @Override
    public void runOpMode() throws InterruptedException {

        Servo goldHitter = hardwareMap.servo.get("goldHitter");

        waitForStart();

        runtime.reset();

        while (opModeIsActive() && !isStopRequested()){
            if(Math.abs(gamepad1.left_stick_y) > 0){
                goldHitter.setPosition(gamepad1.left_stick_y);
                telemetry.addData("Pos: ", gamepad1.left_stick_y);
                telemetry.update();
            }
        }

        telemetry.addData("Status", "Finished");
        telemetry.update();

    }
}
