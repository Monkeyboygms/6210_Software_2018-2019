package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name="Gyro", group="sensor")
//@Disabled
public class GyroTeleOp extends AutoLinearOpMode {


    @Override
    public void runOpMode() {

        init(hardwareMap);

        while (opModeIsActive()) {

            resetAngle();
            telemetry.addData("Z Axis: ", lastAngles.firstAngle);
            telemetry.addData("Y Axis: ", lastAngles.secondAngle);
            telemetry.addData("X Axis: ", lastAngles.thirdAngle);
            telemetry.update();
        }
    }
}
