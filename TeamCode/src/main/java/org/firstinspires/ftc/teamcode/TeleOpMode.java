package org.firstinspires.ftc.teamcode;

import android.app.Activity;
import android.view.View;

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
    public DcMotor LF;
    public DcMotor RF;
    public DcMotor LB;
    public DcMotor RB;
    ColorSensor mineralColor = null;

    // INITIALIZE
    public void init(HardwareMap map){
        runtime     = new ElapsedTime();
        LF  = map.dcMotor.get("LF");
        RF  = map.dcMotor.get("RF");
        LB  = map.dcMotor.get("LB");
        RB  = map.dcMotor.get("RB");
        mineralColor = map.get(ColorSensor.class, "colorRange");

        LF.setDirection(DcMotorSimple.Direction.REVERSE);
        RF.setDirection(DcMotorSimple.Direction.FORWARD);
        RB.setDirection(DcMotorSimple.Direction.FORWARD);
        LB.setDirection(DcMotorSimple.Direction.REVERSE);

        LF.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        RF.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        LB.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        RB.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        mineralColor.enableLed(true); // Turn light on

        int relativeLayoutId = map.appContext.getResources().getIdentifier("RelativeLayout", "id", map.appContext.getPackageName());
        final View relativeLayout = ((Activity) map.appContext).findViewById(relativeLayoutId);

        telemetry.addData("Mode", "waiting for start");
        telemetry.addData("color sensor ", "LED on");
        telemetry.update();

    }

    //SET POWER TO DRIVE MOTORS
    public void setMotorPowers(double leftPower, double rightPower) {
        LF.setPower(Range.clip(leftPower, -1, 1));
        RF.setPower(Range.clip(rightPower, -1, 1));
        LB.setPower(Range.clip(leftPower, -1, 1));
        RB.setPower(Range.clip(rightPower, -1, 1));
    }

    public void setMode(DcMotor.RunMode runMode) throws InterruptedException {
        LF.setMode(runMode);
        idle();
        RF.setMode(runMode);
        idle();
        LB.setMode(runMode);
        idle();
        RB.setMode(runMode);
        idle();
    }
    @Override
    public void runOpMode() throws InterruptedException{

    }
}
