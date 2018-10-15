package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name="MainTeleOp", group="teleop")
@Disabled
public class MainTeleOp extends TeleOpMode {

    @Override
    public void runOpMode() throws InterruptedException {

        init(hardwareMap);

        DcMotor leftDrive  = hardwareMap.get(DcMotor.class, "LF");
        DcMotor rightDrive = hardwareMap.get(DcMotor.class, "RF");
        DcMotor leftDriveback  = hardwareMap.get(DcMotor.class, "LB");
        DcMotor rightDriveback = hardwareMap.get(DcMotor.class, "RB");

        setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        waitForStart();

        runtime.reset();

        while (opModeIsActive() && !isStopRequested()) {

            double leftPower = 0.0;
            double rightPower = 0.0;

            double drive = -gamepad1.left_stick_y;
            double turn  =  gamepad1.right_stick_x;
            leftPower    = Range.clip(drive + turn, -1.0, 1.0) ;
            rightPower   = Range.clip(drive - turn, -1.0, 1.0) ;

            if(Math.abs(gamepad1.left_stick_y) > 0.05){
                leftPower = gamepad1.left_stick_y;
                leftDrive.setPower(leftPower);
                leftDriveback.setPower(leftPower);
            }
            if(Math.abs(gamepad1.right_stick_y) > 0.05){
                rightPower = gamepad1.right_stick_y;
                rightDrive.setPower(rightPower);
                rightDriveback.setPower(rightPower);
            }else{
                rightPower = 0;
                leftPower = 0;
            }

            leftDrive.setPower(leftPower);
            rightDrive.setPower(-rightPower);



            telemetry.addData("Status", "Run Time: " + runtime.toString());
            telemetry.addData("Motors", "left (%.2f), right (%.2f)", leftPower, rightPower);
            telemetry.update();
        }


            // Assign actions to gamepad elements


        }
    }
