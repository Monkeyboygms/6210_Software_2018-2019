package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name="Gyro", group="sensor")
@Disabled
public class GyroTeleOp extends AutoLinearOpMode {


    @Override
    public void runOpMode() {

        init(hardwareMap);

        while (opModeIsActive()) {

            resetAngle();
            telemetry.addData("Raw angle: ", oldAngle.firstAngle);
            telemetry.addData("Converted 360 angle: ", getAngle());
            telemetry.update();
        }
    }
}
