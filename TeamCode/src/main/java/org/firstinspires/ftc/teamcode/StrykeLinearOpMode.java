package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cRangeSensor;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

public class StrykeLinearOpMode extends LinearOpMode{

    public DcMotor leftMotor;
    public DcMotor rightMotor;
    public ModernRoboticsI2cRangeSensor rangeSensor;
    public BNO055IMU imu;

    public void initialize(){
        leftMotor = hardwareMap.dcMotor.get("LF");
        rightMotor = hardwareMap.dcMotor.get("RF");
        imu = hardwareMap.get(BNO055IMU.class, "imu");
        rangeSensor = hardwareMap.get(ModernRoboticsI2cRangeSensor.class, "rangeSensor");

        ElapsedTime runtime = new ElapsedTime();
    }

    /*public void DriveForwardDistance(double power, double distance){
        leftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        distance = distance * 1120/(4*Math.PI);

        leftMotor.setTargetPosition((int)distance);
        rightMotor.setTargetPosition((int)distance);

        leftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        leftMotor.setPower(power);
        rightMotor.setPower(power);
        while (leftMotor.isBusy() && rightMotor.isBusy()){
            idle();
        }

        StopMotors();
        leftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    public void StopMotors(){
        leftMotor.setPower(0);
        rightMotor.setPower(0);
    }
*/
    @Override
    public void runOpMode() {

    }
}
