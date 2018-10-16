package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name="MainTeleOp", group="teleop")
//@Disabled
public class MainTeleOp extends AutoLinearOpMode {

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

            if(Math.abs(gamepad1.left_stick_y) > 0.05){
                leftPower = gamepad1.left_stick_y * scale;
            }else{
                leftPower = 0;
            }
            if(Math.abs(gamepad1.right_stick_y) > 0.05){
                rightPower = gamepad1.right_stick_y * scale;
            }else{
                rightPower = 0;
            }

            setMotorPowers(leftPower,  rightPower);

            telemetry.addData("Status", "Run Time: " + runtime.toString());
            telemetry.addData("Motors", "left (%.2f), right (%.2f)", leftPower, rightPower);
            telemetry.update();
        }
    }
}
