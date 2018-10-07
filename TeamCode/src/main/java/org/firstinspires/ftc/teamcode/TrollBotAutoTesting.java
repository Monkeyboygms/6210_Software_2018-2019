package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous(name="TrollBotAutoTesting", group = "auto")

//@Disabled

public class TrollBotAutoTesting extends AutoLinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {

        init(hardwareMap);

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        waitForStart();

        for(int i = 0; i< 4; i++){
            driveDistance(0.5,12);
            rotate(90,0.3);
        }

        stopMotors();

        telemetry.addData("Distance: ", String.valueOf(getDist()));
        telemetry.update();
    }
}