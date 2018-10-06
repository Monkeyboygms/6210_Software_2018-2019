package org.firstinspires.ftc.teamcode.RandomTests;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.IMU;

@Autonomous(name="moveSquareHM")
@Disabled
public class moveSquare_HM extends LinearOpMode {

    StrykeHardwareMap robot = new StrykeHardwareMap(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

    @Override
    public void runOpMode() throws InterruptedException {

        //initialize

        waitForStart();
        //begin program
        turnLeftAngle(0.2,3000);
        telemetry.addData("cali stat", robot.imu.getCalibrationStatus());
        telemetry.update();

        stopDrive();
    }


    public void moveForwardTime(double power, long time) throws InterruptedException{
        robot.leftDrive.setPower(power);
        robot.rightDrive.setPower(power);
        sleep(time);
    }
    public void turnLeftAngle(double power, long time) throws InterruptedException{
        robot.leftDrive.setPower(-power);
        robot.rightDrive.setPower(power);
        sleep(time);
    }
    public void turnRightAngle(double power, long time)throws InterruptedException{
        robot.leftDrive.setPower(power);
        robot.rightDrive.setPower(-power);
        sleep(time);
    }
    public void stopDrive(){
        robot.leftDrive.setPower(0);
        robot.rightDrive.setPower(0);
    }
}
