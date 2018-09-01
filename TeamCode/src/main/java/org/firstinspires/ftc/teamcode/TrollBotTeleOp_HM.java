package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name="Basic: Linear OpMode", group="Linear Opmode")
//@Disabled
public class TrollBotTeleOp_HM extends LinearOpMode {

    StrykeHardwareMap robot = new StrykeHardwareMap(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor leftMotor = null;
    private DcMotor rightMotor = null;

    @Override
    public void runOpMode() {
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        robot.init(hardwareMap);

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

            robot.leftDrive.setPower(leftPower);
            robot.rightDrive.setPower(rightPower);

            telemetry.addData("Status", "Run Time: " + runtime.toString());
            telemetry.addData("Motors", "left (%.2f), right (%.2f)", leftPower, rightPower);
            telemetry.update();
        }
    }
}
