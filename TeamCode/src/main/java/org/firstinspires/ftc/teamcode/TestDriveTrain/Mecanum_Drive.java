package org.firstinspires.ftc.teamcode.TestDriveTrain;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name="Mecanum_Drive", group="Linear Opmode")
//@Disabled
public class Mecanum_Drive extends LinearOpMode {

    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor leftMotor = null;
    private DcMotor rightMotor = null;

    @Override
    public void runOpMode() {
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        DcMotor LF  = hardwareMap.get(DcMotor.class, "LF");
        DcMotor RF = hardwareMap.get(DcMotor.class, "RF");
        DcMotor LB  = hardwareMap.get(DcMotor.class, "LB");
        DcMotor RB = hardwareMap.get(DcMotor.class, "RB");

        LF.setDirection(DcMotor.Direction.FORWARD);
        RF.setDirection(DcMotor.Direction.FORWARD);

        waitForStart();
        runtime.reset();

        while (opModeIsActive()) {

            double G1leftstickY = gamepad1.left_stick_y;
            double G1rightstickY = gamepad1.right_stick_y;
            boolean G1rightBumper = gamepad1.right_bumper;
            boolean G1leftBumper = gamepad1.left_bumper;

            //double drive = -gamepad1.left_stick_y;
            //double turn  =  gamepad1.right_stick_x;
            //leftPower    = Range.clip(drive + turn, -1.0, 1.0) ;
            //rightPower   = Range.clip(drive - turn, -1.0, 1.0) ;

            if(Math.abs(G1leftstickY) > 0.05){
                LF.setPower(G1leftstickY);
            }
            if(Math.abs(G1rightstickY) > 0.05){
                RF.setPower(G1rightstickY);
            }
            if(G1rightBumper){
                RF.setPower(1);
                RB.setPower(-1);
                LF.setPower(1);
                LB.setPower(-1);
            }
            if(G1leftBumper){
                RF.setPower(-1);
                RB.setPower(1);
                LF.setPower(-1);
                LB.setPower(1);
            }

            telemetry.addData("Status", "Run Time: " + runtime.toString());
            telemetry.addData("Motors", "left (%.2f), right (%.2f)", G1leftstickY, G1rightstickY);
            telemetry.update();
        }
    }
}
