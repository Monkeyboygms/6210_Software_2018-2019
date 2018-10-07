package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

public class TeleOpMode extends LinearOpMode{

    // DECLARE VARIABLES TO BE USED
    ElapsedTime runtime;

    //motors and sensors
    public DcMotor leftMotor;
    public DcMotor rightMotor;
    public ColorSensor colorSensor;

    // INITIALIZE
    public void init(HardwareMap map){
        runtime     = new ElapsedTime();
        leftMotor   = map.dcMotor.get("LF");
        rightMotor  = map.dcMotor.get("RF");
        //colorSensor = map.get(ColorSensor.class, "colorSensor");

        leftMotor.setDirection(DcMotorSimple.Direction.FORWARD);
        rightMotor.setDirection(DcMotorSimple.Direction.REVERSE);

        leftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

    }

    //SET POWER TO DRIVE MOTORS
    public void setMotorPowers(double leftPower, double rightPower) {
        leftMotor.setPower(Range.clip(leftPower, -1, 1));
        rightMotor.setPower(Range.clip(rightPower, -1, 1));
    }

    // SET RUNMODE TO DRIVE MOTORS
    public void setMode(DcMotor.RunMode runMode) throws InterruptedException {
        leftMotor.setMode(runMode);
        idle();
        rightMotor.setMode(runMode);
        idle();
    }

    // STOP DRIVE MOTORS
    public void stopMotors(){
        setMotorPowers(0,0);
    }

    @Override
    public void runOpMode() throws InterruptedException{

    }
}
