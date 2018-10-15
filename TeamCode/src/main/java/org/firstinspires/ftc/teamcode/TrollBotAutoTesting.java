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

        /*while (7 > 4){
            setMotorPowers(0.3,0.3);
            telemetry.addData("Distance: ", 9);
            telemetry.update();
        }*/
        rotate(85,0.3);

        stopMotors();

    }
}