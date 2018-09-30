package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;

@Autonomous(name="EncoderTutorial")
//@Disabled
public class EncoderTutorial extends LinearOpMode {

    StrykeHardwareMap robot = new StrykeHardwareMap(DcMotor.RunMode.RUN_USING_ENCODER);

    @Override
    public void runOpMode() throws InterruptedException {

        //initialize
        robot.init(hardwareMap);

        waitForStart();

        DriveForwardDistance(0.5,20);
        int curpos = robot.leftDrive.getCurrentPosition();
        telemetry.addData("motor position", curpos);
    }

    public void DriveForwardDistance(double power, double distance){
        robot.leftDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.rightDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        distance = distance * 1120/(4*3.1415926535897932384626433832795028841971693993751);

        robot.leftDrive.setTargetPosition((int)distance);
        robot.rightDrive.setTargetPosition((int)distance);

        robot.leftDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.rightDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        DriveForward(power);

        while (robot.leftDrive.isBusy() && robot.rightDrive.isBusy()){
            idle();
        }

        StopDrive();
        robot.leftDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot.rightDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    public void DriveForward(double power){
        robot.leftDrive.setPower(power);
        robot.rightDrive.setPower(power);
    }
    public void TurnLeft(double power){
        robot.leftDrive.setPower(power);
        robot.rightDrive.setPower(power);
    }
    public void TurnRight(double power){
        robot.leftDrive.setPower(power);
        robot.rightDrive.setPower(power);
    }
    public void StopDrive(){
        robot.leftDrive.setPower(0);
        robot.rightDrive.setPower(0);
    }



}
