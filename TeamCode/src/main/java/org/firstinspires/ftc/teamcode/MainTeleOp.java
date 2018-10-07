package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name="MainTeleOp", group="teleop")
@Disabled
public class MainTeleOp extends TeleOpMode {

    @Override
    public void runOpMode() throws InterruptedException {

        init(hardwareMap);

        setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        waitForStart();

        runtime.reset();

        while (opModeIsActive() && !isStopRequested()) {


            // Assign actions to gamepad elements


        }
    }
}