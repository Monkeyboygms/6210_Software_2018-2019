package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name="Gyro", group="sensor")
//@Disabled
public class GyroTeleOp extends AutoLinearOpMode {


    @Override
    public void runOpMode() {

        init(hardwareMap);

        while (opModeIsActive()) {

            resetAngle();
            telemetry.addData("Z Axis: ", oldAngle.firstAngle);
            telemetry.addData("Y Axis: ", oldAngle.secondAngle);
            telemetry.addData("X Axis: ", oldAngle.thirdAngle);
            telemetry.update();
        }
    }
}
