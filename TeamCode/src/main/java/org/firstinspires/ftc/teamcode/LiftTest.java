package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name="LiftTest", group="teleop")
@Disabled
public class LiftTest extends AutoLinearOpMode {


    @Override
    public void runOpMode() {

        // TEST AND FIX VALUES

        init(hardwareMap);

        double power = 0.1;
        while (opModeIsActive() && !isStopRequested()) {
            if(gamepad1.x){
                power *= -1;
                telemetry.addData("status: ", "retracting");
                telemetry.update();
                liftL.setPower(power);
                liftR.setPower(-power);
            }else if(gamepad1.y){
                power *= 1;
                telemetry.addData("status: ", "extending");
                telemetry.update();
                liftL.setPower(power);
                liftR.setPower(-power);
            }


        }
    }
}
