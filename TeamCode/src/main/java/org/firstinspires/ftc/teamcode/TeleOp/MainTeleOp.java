package org.firstinspires.ftc.teamcode.TeleOp;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.MecanumLinearOpMode;

@TeleOp(name="MainTeleOp", group="teleop")
//@Disabled
public class MainTeleOp extends MecanumLinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {

        init(hardwareMap, false);

        //setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        double leftPower = 0, rightPower = 0, scale = 1, liftPower = 0, intakePower = 1;

        boolean halfSpeed = false;

        boolean servoDown = false;

        telemetry.addData("Mode: ", "Waiting for start");
        telemetry.update();

        waitForStart();

        while (opModeIsActive() && !isStopRequested()) {

            //left motor
            if(Math.abs(gamepad1.left_stick_y) > 0.05){
                leftPower = gamepad1.left_stick_y * scale;
            }else{
                leftPower = 0;
            }
            //right motor
            if(Math.abs(gamepad1.right_stick_y) > 0.05){
                rightPower = gamepad1.right_stick_y * scale;
            }else{
                rightPower = 0;
            }

            //halfspeed
            if (gamepad1.right_bumper) {
                halfSpeed = true;
                leftPower = leftPower / 2;
                rightPower = rightPower / 2;
            }else{
                halfSpeed = false;
            }

            //lift
            if (gamepad2.right_bumper) {
                lift.setPower(0.5);
            }else if(gamepad2.left_bumper){
                lift.setPower(-0.5);
            }else{
                lift.setPower(0);
            }

            if (gamepad2.b) {
                if (servoDown)
                    marker.setPosition(0);
                else
                    marker.setPosition(180);
            }

            setMotorPowers(leftPower, rightPower);

            telemetry.addData("Motors", "left (%.2f), right (%.2f)", leftPower, rightPower)
                    .addData("Half Speed", halfSpeed)
                    .addData("Servo down: ", servoDown);
            telemetry.update();
        }
    }
}
