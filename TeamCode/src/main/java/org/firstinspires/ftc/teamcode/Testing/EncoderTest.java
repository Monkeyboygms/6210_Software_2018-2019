package org.firstinspires.ftc.teamcode.Testing;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.AutoLinearOpMode;

@Autonomous(name="EncoderTest", group = "auto")

@Disabled

public class EncoderTest extends AutoLinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {

        init(hardwareMap);

        telemetry.addData("Status", "Initialized");
        telemetry.addData("LF encoder:", LF.getCurrentPosition());
        telemetry.addData("LB encoder:", LB.getCurrentPosition());
        telemetry.addData("RF encoder:", RF.getCurrentPosition());
        telemetry.addData("RB encoder:", RB.getCurrentPosition());
        telemetry.update();

        waitForStart();

        driveDistance(0.3, 15);

        stopMotors();

        telemetry.addData("LF encoder:", LF.getCurrentPosition());
        telemetry.addData("LB encoder:", LB.getCurrentPosition());
        telemetry.addData("RF encoder:", RF.getCurrentPosition());
        telemetry.addData("RB encoder:", RB.getCurrentPosition());
        telemetry.update();
    }
}