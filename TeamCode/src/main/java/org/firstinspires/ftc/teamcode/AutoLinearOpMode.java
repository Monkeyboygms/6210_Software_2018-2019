package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cRangeSensor;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;

import static java.lang.Double.isNaN;

public class AutoLinearOpMode extends LinearOpMode{

    // DECLARE VARIABLES TO BE USED
    ElapsedTime runtime;

    //motors and sensors
    public DcMotor leftMotor;
    public DcMotor rightMotor;
    public ModernRoboticsI2cRangeSensor rangeSensor;
    //public ColorSensor colorSensor;
    public BNO055IMU imu;

    //gyro variables
    Orientation lastAngles;
    double globalAngle;

    static final double     COUNTS_PER_MOTOR_REV    = 1120 ;    // REV Motor Encoder
    static final double     DRIVE_GEAR_REDUCTION    = 1.0 ;     // This is < 1.0 if geared UP
    static final double     WHEEL_DIAMETER_INCHES   = 4.0 ;     // For figuring circumference

    public double encoderToInches = (COUNTS_PER_MOTOR_REV * DRIVE_GEAR_REDUCTION)/(WHEEL_DIAMETER_INCHES * Math.PI); //Multiply desired distance (inches)

    // INITIALIZE
    public void init(HardwareMap map){
        runtime     = new ElapsedTime();
        leftMotor   = map.dcMotor.get("LF");
        rightMotor  = map.dcMotor.get("RF");
        imu         = map.get(BNO055IMU.class, "imu");
        rangeSensor = map.get(ModernRoboticsI2cRangeSensor.class, "rangeSensor");
        //colorSensor = map.get(ColorSensor.class, "colorSensor");

        leftMotor.setDirection(DcMotorSimple.Direction.FORWARD);
        rightMotor.setDirection(DcMotorSimple.Direction.REVERSE);

        leftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        //SET UP GYRO

        lastAngles = new Orientation();

        BNO055IMU.Parameters parameters = new BNO055IMU.Parameters();
        parameters.mode                 = BNO055IMU.SensorMode.IMU;
        parameters.angleUnit            = BNO055IMU.AngleUnit.DEGREES;
        parameters.accelUnit            = BNO055IMU.AccelUnit.METERS_PERSEC_PERSEC;
        parameters.loggingEnabled       = false;

        imu.initialize(parameters);

        telemetry.addData("Mode", "calibrating...");
        telemetry.update();

        while (!isStopRequested() && !imu.isGyroCalibrated())
        {
            sleep(50);
            idle();
        }

        telemetry.addData("Mode", "waiting for start");
        telemetry.addData("imu calib status", imu.getCalibrationStatus().toString());
        telemetry.update();

    }

    //SET POWER TO DRIVE MOTORS
    public void setMotorPowers(double leftPower, double rightPower) {
        leftMotor.setPower(Range.clip(leftPower, -1, 1));
        rightMotor.setPower(Range.clip(rightPower, -1, 1));
    }

    // TIME BASED MOVEMENT
    public void driveTime(double power, long seconds){
        setMotorPowers(power, power);
        sleep(seconds * 1000);
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

    // ENCODER BASED MOVEMENT
    public void driveDistance(double power, double distance) throws InterruptedException {
        setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        distance = distance * encoderToInches;

        leftMotor.setTargetPosition((int)distance);
        rightMotor.setTargetPosition((int)distance);

        setMode(DcMotor.RunMode.RUN_TO_POSITION);
        setMotorPowers(power, power);

        while (leftMotor.isBusy() && rightMotor.isBusy()){
            idle();
        }

        stopMotors();
        setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    // GET DISTANCE TO OBJECT USING RANGE SENSOR
    //Possibly use color/distance sensor instead of MR range sensor
    public double getDist() {
        double dist = rangeSensor.getDistance(DistanceUnit.INCH);
        while (dist > 1000 || isNaN(dist) && opModeIsActive()) {
            dist = rangeSensor.getDistance(DistanceUnit.INCH);
        }
        return dist;
    }

//comment out
    public void resetAngle()
    {
        lastAngles = imu.getAngularOrientation(AxesReference.INTRINSIC, AxesOrder.ZYX, AngleUnit.DEGREES);
        globalAngle = 0;
    }

    public double getAngle()
    {
        Orientation angles = imu.getAngularOrientation(AxesReference.INTRINSIC, AxesOrder.ZYX, AngleUnit.DEGREES);

        double deltaAngle = angles.firstAngle - lastAngles.firstAngle;

        if (deltaAngle < -180)
            deltaAngle += 360;
        else if (deltaAngle > 180)
            deltaAngle -= 360;

        globalAngle += deltaAngle;
        lastAngles = angles;
        return globalAngle;
    }

    public void rotate(int degrees, double power)
    {
        telemetry.addData("imu heading", lastAngles.firstAngle);
        telemetry.addData("global heading", globalAngle);
        telemetry.update();

        double leftPower, rightPower;
        resetAngle();

        // getAngle() returns + when rotating counter clockwise (left) and - when rotating clockwise (right).

        if (degrees < 0)
        {   // turn right.
            leftPower = -power;
            rightPower = power;
        }
        else if (degrees > 0)
        {   // turn left.
            leftPower = power;
            rightPower = -power;
        }
        else return;

        setMotorPowers(leftPower,rightPower);

        // rotate until turn is completed.
        if (degrees < 0)
        {
            // On right turn we have to get off zero first.
            while (opModeIsActive() && getAngle() == 0) {}

            while (opModeIsActive() && getAngle() > degrees) {}
        }
        else    // left turn.
            while (opModeIsActive() && getAngle() < degrees) {}

        setMotorPowers(0,0);
        sleep(1000);
        resetAngle();
    }
//comment out

    @Override
    public void runOpMode() {

    }
}
