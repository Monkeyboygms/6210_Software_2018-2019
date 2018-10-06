package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.RandomTests.StrykeHardwareMap;

@TeleOp(name="Trollbot TeleOpHM", group="Linear Opmode")
//@Disabled
public class TrollBotTeleOpNew extends StrykeLinearOpMode {

    @Override
    public void runOpMode() {

        init(hardwareMap);

        //delete if needed
        try {
            setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        waitForStart();
        runtime.reset();

        while (opModeIsActive() && !isStopRequested()) {

            double leftPower = 0;
            double rightPower = 0;

            if(Math.abs(gamepad1.left_stick_y) > 0.05){
                leftPower = gamepad1.left_stick_y;
            }
            if(Math.abs(gamepad1.right_stick_y) > 0.05){
                rightPower = gamepad1.right_stick_y;
            }

            setMotorPowers(leftPower, rightPower);

            telemetry.addData("Status", "Run Time: " + runtime.toString());
            telemetry.addData("Motors", "left (%.2f), right (%.2f)", leftPower, rightPower);
            telemetry.addData("LeftMotorPosition", "encoder position is: " + leftMotor.getCurrentPosition());
            telemetry.addData("RightMotorPosition", "encoder position is: " + rightMotor.getCurrentPosition());
            telemetry.update();
        }
    }
}
