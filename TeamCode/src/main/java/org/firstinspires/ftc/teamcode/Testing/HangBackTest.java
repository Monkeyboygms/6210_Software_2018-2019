package org.firstinspires.ftc.teamcode.Testing;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.MecanumLinearOpMode;

@Autonomous(name = "HangBackTest", group = "Hang")
//@Disabled
public class HangBackTest extends MecanumLinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {

        init(hardwareMap, false);
        waitForStart();

        while (opModeIsActive() && !isStopRequested() ) {

            LF.setPower(-1);
            RF.setPower(-1);
        }

    }
}
