package org.firstinspires.ftc.teamcode.TeleOp;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name="Omni_Stealth_Compliant Test", group="Linear Opmode")
@Disabled
public class Omni_Stealth_Compliant extends LinearOpMode {

    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor leftMotor = null;
    private DcMotor rightMotor = null;

    @Override
    public void runOpMode() {
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        DcMotor leftDrive  = hardwareMap.get(DcMotor.class, "LF");
        DcMotor rightDrive = hardwareMap.get(DcMotor.class, "RF");

        leftDrive.setDirection(DcMotor.Direction.FORWARD);
        rightDrive.setDirection(DcMotor.Direction.FORWARD);

        waitForStart();
        runtime.reset();

        while (opModeIsActive()) {

            double leftPower;
            double rightPower;

            double drive = -gamepad1.left_stick_y;
            double turn  =  gamepad1.right_stick_x;
            leftPower    = Range.clip(drive + turn, -1.0, 1.0) ;
            rightPower   = Range.clip(drive - turn, -1.0, 1.0) ;

            if(Math.abs(gamepad1.left_stick_y) > 0.05){
                leftPower = gamepad1.left_stick_y;
            }
            if(Math.abs(gamepad1.right_stick_y) > 0.05){
                rightPower = gamepad1.right_stick_y;
            }

            leftDrive.setPower(leftPower);
            rightDrive.setPower(rightPower);

            telemetry.addData("Status", "Run Time: " + runtime.toString());
            telemetry.addData("Motors", "left (%.2f), right (%.2f)", leftPower, rightPower);
            telemetry.update();
        }
    }
}