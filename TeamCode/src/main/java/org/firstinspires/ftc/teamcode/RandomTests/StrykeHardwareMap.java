package org.firstinspires.ftc.teamcode.RandomTests;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cRangeSensor;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.RangeSensor;
import org.firstinspires.ftc.teamcode.colorRangeTest;

public class StrykeHardwareMap {
    public DcMotor leftDrive = null;
    public DcMotor rightDrive = null;
    public ModernRoboticsI2cRangeSensor rangeSensor = null;
    public BNO055IMU imu = null;
    ColorSensor sensorColor = null;
    DistanceSensor sensorDistance = null;

    HardwareMap map = null;

    private DcMotor.RunMode initialMode = null;

    public StrykeHardwareMap(DcMotor.RunMode enteredMode){
        initialMode = enteredMode;
    }

    public void init(HardwareMap themap){
        map = themap;

        leftDrive = map.dcMotor.get("LF");
        rightDrive = map.dcMotor.get("RF");
        imu = map.get(BNO055IMU.class, "imu");
        sensorColor = map.get(ColorSensor.class, "colorRange");
        sensorDistance = map.get(DistanceSensor.class, "colorRange");

        leftDrive.setMode(initialMode);
        rightDrive.setMode(initialMode);

        leftDrive.setDirection(DcMotorSimple.Direction.FORWARD);
        rightDrive.setDirection(DcMotorSimple.Direction.REVERSE);

        rangeSensor = map.get(ModernRoboticsI2cRangeSensor.class, "rangeSensor");

        stop();
    }
    public void stop(){
        leftDrive.setPower(0);
        rightDrive.setPower(0);
    }
}
