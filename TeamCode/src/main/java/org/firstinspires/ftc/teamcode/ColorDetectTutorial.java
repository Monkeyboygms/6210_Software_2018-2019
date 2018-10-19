package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import java.util.Arrays;

@TeleOp (name = "ColorTutorial", group = "Sensor")
//@Disabled
public class ColorDetectTutorial extends AutoLinearOpMode{

    @Override
    public void runOpMode() {

        init(hardwareMap);

        waitForStart();

        while (opModeIsActive() && !isStopRequested()){

            telemetry.addData("All ", Arrays.toString(getAutoColor()));
            telemetry.addData("Hue: ", getAutoColor()[0]);
            telemetry.addData("Saturation: ", getAutoColor()[1]);

            if ((getAutoColor()[0] > 35 && getAutoColor()[0] < 50) && (getAutoColor()[1] < 50)) // Change values later
                telemetry.addData("Gold ", "Detected");
            else
                telemetry.addData("Gold", "Not found");

            telemetry.update();
        }
    }
}
