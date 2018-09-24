package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp(name="Iterative_TeleOp", group="Iterative Opmode")
//@Disabled
public class Iterative_TeleOp extends OpMode{

    StrykeHardwareMap robot = new StrykeHardwareMap(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    private ElapsedTime runtime = new ElapsedTime();

    @Override
    public void init(){
        robot.init(hardwareMap);
        telemetry.addData("Initialization Complete", "Complete");
    }
    @Override
    public void init_loop(){

    }
    @Override
    public void start(){
        runtime.reset();
    }
    @Override
    public void loop(){
        robot.rightDrive.setPower(gamepad1.left_stick_y);
        robot.leftDrive.setPower(gamepad1.right_stick_y);
        //robot.servo.setPosition(gamepad1.left_trigger);
    }
}
