package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name="MainTeleOp", group="teleop")
//@Disabled
public class MainTeleOp extends AutoLinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {

        init(hardwareMap);

        //setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        double leftPower = 0, rightPower = 0, scale = 1, liftPower = 0, intakePower = 1;

        boolean halfSpeed = false;

        telemetry.addData("Mode: ", "Waiting for start");
        telemetry.update();

        waitForStart();

        runtime.reset();

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

            //lift down
            if(gamepad2.left_stick_y < -0.05){
                liftPower = gamepad2.left_stick_y;
                telemetry.addData("status: ", "retracting");
                telemetry.update();
                liftL.setPower(liftPower);
                liftR.setPower(-liftPower);
            //lift up
            }else if(gamepad2.left_stick_y > 0.05){
                liftPower = gamepad2.left_stick_y;
                telemetry.addData("status: ", "extending");
                telemetry.update();
                liftL.setPower(liftPower);
                liftR.setPower(-liftPower);
            }else{
                liftL.setPower(0);
                liftR.setPower(0);
            }

            //intake
            if(gamepad2.left_bumper){
                telemetry.addData("status: ", "intaking");
                telemetry.update();
                intake.setPower(-1);
            //expel
            }else if(gamepad2.right_bumper){
                telemetry.addData("status: ", "expelling");
                telemetry.update();
                intake.setPower(1);
            }else{
                intake.setPower(0);
            }

            //lift intake
            if(gamepad2.right_stick_y > 0.05){
                deployment.setPower(0.3);
            //lower intake
            }else if(gamepad2.right_stick_y < -0.05){
                deployment.setPower(-0.3);
            }
            else{
                deployment.setPower(0);
            }

            setMotorPowers(leftPower, rightPower);

            telemetry.addData("Status", "Run Time: " + runtime.toString());
            telemetry.addData("Motors", "left (%.2f), right (%.2f)", leftPower, rightPower);
            telemetry.addData("Half Speed", halfSpeed);
            telemetry.update();
        }
    }
}
