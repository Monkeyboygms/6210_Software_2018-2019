package org.firstinspires.ftc.teamcode.Testing;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.AutoLinearOpMode;
import org.firstinspires.ftc.teamcode.MecanumLinearOpMode;

@TeleOp(name = "MecTest", group = "Drive")
//@Disabled
public class MecanumTest extends MecanumLinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {

        init(hardwareMap, false);
        waitForStart();

        while (opModeIsActive() && !isStopRequested()) {

            setMotorPowers(gamepad1.left_stick_y, gamepad1.right_stick_y);

            if (gamepad1.right_bumper){
                LF.setPower(-1);
                RF.setPower(1);
                LB.setPower(1);
                RB.setPower(-1);
            }else if (gamepad1.left_bumper){
                LF.setPower(1);
                RF.setPower(-1);
                LB.setPower(-1);
                RB.setPower(1);
            }

        }

    }
}
