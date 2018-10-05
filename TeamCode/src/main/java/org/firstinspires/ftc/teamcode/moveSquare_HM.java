package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous(name="moveSquareHM")
//@Disabled
public class moveSquare_HM extends LinearOpMode {

    StrykeHardwareMap robot = new StrykeHardwareMap(DcMotor.RunMode.RUN_WITHOUT_ENCODER);


    @Override
    public void runOpMode() throws InterruptedException {

        //initialize
        robot.init(hardwareMap);

        waitForStart();
        //begin program
        moveForwardTime(0.2, 3000);
        turnLeftTime(0.2,3000);
        moveForwardTime(0.2,3000);
        Thread.sleep(1000);
        turnLeftTime(0.2,3000);
        moveForwardTime(0.2, 3000);
        turnLeftTime(0.2,3000);
        moveForwardTime(0.2,3000);
        turnLeftTime(0.2,3000);
        stopDrive();
    }
    //methods
    public void moveForwardTime(double power, long time) throws InterruptedException{
        robot.leftDrive.setPower(power);
        robot.rightDrive.setPower(power);
        sleep(time);
    }
    public void turnLeftTime(double power, long time) throws InterruptedException{
        robot.leftDrive.setPower(-power);
        robot.rightDrive.setPower(power);
        sleep(time);
    }
    public void turnRightTime(double power, long time)throws InterruptedException{
        robot.leftDrive.setPower(power);
        robot.rightDrive.setPower(-power);
        sleep(time);
    }
    public void stopDrive(){
        robot.leftDrive.setPower(0);
        robot.rightDrive.setPower(0);
    }
}
