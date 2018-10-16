package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.robotcore.external.navigation.Orientation;

public class TeleOpMode extends LinearOpMode{

    // DECLARE VARIABLES TO BE USED
    ElapsedTime runtime;

    //motors and sensors
    public DcMotor leftMotor;
    public DcMotor rightMotor;
    public DcMotor leftBackMotor;
    public DcMotor rightBackMotor;
    ColorSensor mineralColor = null;

    // INITIALIZE
    public void init(HardwareMap map){
        runtime     = new ElapsedTime();
        leftMotor   = map.dcMotor.get("LF");
        rightMotor  = map.dcMotor.get("RF");
        leftBackMotor   = map.dcMotor.get("LB");
        rightBackMotor  = map.dcMotor.get("RB");
        mineralColor = map.get(ColorSensor.class, "minColor");

        leftMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        rightMotor.setDirection(DcMotorSimple.Direction.FORWARD);
        rightBackMotor.setDirection(DcMotorSimple.Direction.FORWARD);
        leftBackMotor.setDirection(DcMotorSimple.Direction.REVERSE);

        leftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        leftBackMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightBackMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);;

        mineralColor.enableLed(true); // Turn light on

        telemetry.addData("Mode", "waiting for start");
        telemetry.addData("color sensor ", "LED on");
        telemetry.update();

    }

    //SET POWER TO DRIVE MOTORS
    public void setMotorPowers(double leftPower, double rightPower) {
        leftMotor.setPower(Range.clip(leftPower, -1, 1));
        rightMotor.setPower(Range.clip(rightPower, -1, 1));
        leftBackMotor.setPower(Range.clip(leftPower, -1, 1));
        rightBackMotor.setPower(Range.clip(rightPower, -1, 1));
    }
    @Override
    public void runOpMode() throws InterruptedException{

    }
}
