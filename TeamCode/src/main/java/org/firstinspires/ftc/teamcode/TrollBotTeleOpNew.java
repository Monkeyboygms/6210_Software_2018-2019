package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name="TrollbotTeleOpNew", group="teleop")
//@Disabled
public class TrollBotTeleOpNew extends TeleOpMode {

    @Override
    public void runOpMode() throws InterruptedException {

        init(hardwareMap);

        setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        double leftPower = 0, rightPower = 0, scale = 1;

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        waitForStart();

        runtime.reset();

        while (opModeIsActive() && !isStopRequested()) {

            if(Math.abs(gamepad1.left_stick_y) > 0.5){
                leftPower = gamepad1.left_stick_y * scale;
            }
            if(Math.abs(gamepad1.right_stick_y) > 0.5){
                rightPower = gamepad1.right_stick_y * scale;
            }

            leftMotor.setPower(leftPower);
            rightMotor.setPower(rightPower);

            telemetry.addData("Status", "Run Time: " + runtime.toString());
            telemetry.addData("Motors", "left (%.2f), right (%.2f)", leftPower, rightPower);
            telemetry.update();
        }
    }
}
