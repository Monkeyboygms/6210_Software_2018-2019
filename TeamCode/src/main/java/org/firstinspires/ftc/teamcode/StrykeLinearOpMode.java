package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cRangeSensor;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class StrykeLinearOpMode extends LinearOpMode{

    public DcMotor leftDrive;
    public DcMotor rightDrive;
    public ModernRoboticsI2cRangeSensor rangeSensor;
    public BNO055IMU imu;

    public void initialize(){
        leftDrive = hardwareMap.dcMotor.get("LF");
        rightDrive = hardwareMap.dcMotor.get("RF");
        imu = hardwareMap.get(BNO055IMU.class, "imu");
        rangeSensor = hardwareMap.get(ModernRoboticsI2cRangeSensor.class, "rangeSensor");
    }


    @Override
    public void runOpMode() {

    }
}
