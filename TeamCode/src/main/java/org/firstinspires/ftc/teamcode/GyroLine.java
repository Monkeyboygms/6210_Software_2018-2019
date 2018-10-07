package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.robotcore.external.navigation.Orientation;


@Autonomous(name="GyroLine", group = "Sensor")

//@Disabled

public class GyroLine extends AutoLinearOpMode {

    double power, correction;

    @Override
    public void runOpMode() {

        init(hardwareMap);

        waitForStart();

        telemetry.addData("Mode", "running");
        telemetry.update();

        sleep(1000);

        while (opModeIsActive()){
            // Use gyro to drive in a straight line.
            correction = checkDirection();

            telemetry.addData("1 imu heading", lastAngles.firstAngle);
            telemetry.addData("2 global heading", globalAngle);
            telemetry.addData("3 correction", correction);
            telemetry.update();

            setMotorPowers(-power + correction,-power);

            // backup.
            setMotorPowers(power, power);

            sleep(500);

            stopMotors();

            rotate(-90, power);

            // turn 90 degrees left.
            rotate(90, power);
        }

        stopMotors();

    }

    private double checkDirection()
    {
        double correction, angle, gain = .10;

        angle = getAngle();

        if (angle == 0)
            correction = 0;             // no adjustment.
        else
            correction = -angle;        // reverse sign of angle for correction.

        correction = correction * gain;

        return correction;
    }
}