package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name="LiftTest", group="teleop")
//@Disabled
public class LiftTest extends AutoLinearOpMode {


    @Override
    public void runOpMode() {

        // TEST AND FIX VALUES

        init(hardwareMap);
        double power = 0.2;
        while (opModeIsActive()) {
            if(gamepad1.left_bumper){
                power *= -1;
                telemetry.addData("status: ", "retracting");
            }else if(gamepad1.right_bumper){
                power *= 1;
                telemetry.addData("status: ", "extending");
            }
            liftL.setPower(power);
            liftR.setPower(power);
            telemetry.update();
        }
    }
}
