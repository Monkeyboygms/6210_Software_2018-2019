package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

@Autonomous(name="moveSquare")
//@Disabled jf
public class moveSquare extends LinearOpMode {

    private DcMotor leftDrive = null;
    private DcMotor rightDrive = null;

    @Override
    public void runOpMode() throws InterruptedException {

        //initialize
        leftDrive = hardwareMap.dcMotor.get("LF");
        rightDrive = hardwareMap.dcMotor.get("RF");

        leftDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

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
        leftDrive.setPower(power);
        rightDrive.setPower(power);
        sleep(time);
    }
    public void turnLeftTime(double power, long time) throws InterruptedException{
        leftDrive.setPower(-power);
        rightDrive.setPower(power);
        sleep(time);
    }
    public void turnRightTime(double power, long time)throws InterruptedException{
        leftDrive.setPower(power);
        rightDrive.setPower(-power);
        sleep(time);
    }
    public void stopDrive(){
        leftDrive.setPower(0);
        rightDrive.setPower(0);
    }
       /*telemetry.addData("Status", "Initialized");
       telemetry.update();*/
}
