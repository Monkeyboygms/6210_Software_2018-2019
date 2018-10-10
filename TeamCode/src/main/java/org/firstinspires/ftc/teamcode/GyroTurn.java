package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;


@Autonomous(name="GyroTurn", group = "Sensor")

//@Disabled

public class GyroTurn extends AutoLinearOpMode {

    Orientation lastAngles = new Orientation();
    double globalAngle;
    double power = .1;

    @Override
    public void runOpMode() {

        init(hardwareMap);

        waitForStart();

        telemetry.addData("Mode", "running");
        telemetry.update();

        sleep(1000);

        // Turn 90 degrees
        rotate(90, power);


        while (opModeIsActive() && !isStopRequested()){

            telemetry.addData("imu heading", lastAngles.firstAngle);
            telemetry.addData("global heading", globalAngle);
            telemetry.update();

        }


        stopMotors();

    }
}

