package org.firstinspires.ftc.teamcode.Testing;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.AutoLinearOpMode;
import org.firstinspires.ftc.teamcode.MecanumLinearOpMode;

@Autonomous(name = "HangFrontTest", group = "Hang")
//@Disabled
public class HangTest extends MecanumLinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {

        init(hardwareMap, false);
        waitForStart();

        while (opModeIsActive() && !isStopRequested() ) {

            LF.setPower(1);
            RF.setPower(1);
        }

    }
}
