package org.firstinspires.ftc.teamcode;

import com.disnodeteam.dogecv.CameraViewDisplay;
import com.disnodeteam.dogecv.DogeCV;
import com.disnodeteam.dogecv.detectors.roverrukus.GoldAlignDetector;
import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.robotcore.external.navigation.Orientation;

public class MecanumLinearOpMode extends LinearOpMode{

    // DECLARE VARIABLES TO BE USED
    ElapsedTime runtime;

    //motors and sensors
    public DcMotor LF;
    public DcMotor RF;
    public DcMotor LB;
    public DcMotor RB;
    public BNO055IMU imu;
    public DcMotor liftR;
    public DcMotor liftL;
    public Servo marker;

    //gyro variables
    Orientation angles;

    static final double     COUNTS_PER_MOTOR_REV    = 1120 ;    // REV Motor Encoder
    static final double     DRIVE_GEAR_REDUCTION    = 1.0 ;     // This is < 1.0 if geared UP
    static final double     WHEEL_DIAMETER_INCHES   = 4.0 ;     // For figuring circumference

    public double encoderToInches = (COUNTS_PER_MOTOR_REV * DRIVE_GEAR_REDUCTION)/(WHEEL_DIAMETER_INCHES * Math.PI); //Multiply desired distance (inches)


    private GoldAlignDetector detector;

    // INITIALIZE
    public void init(HardwareMap map, boolean auto){

        runtime     = new ElapsedTime();
        LF  = map.dcMotor.get("LF");
        RF  = map.dcMotor.get("RF");
        LB  = map.dcMotor.get("LB");
        RB  = map.dcMotor.get("RB");
        marker = map.servo.get("marker");
        imu            = map.get(BNO055IMU.class, "imu"); // Check which IMU is being used
     // liftL  = map.dcMotor.get("liftL");
     // liftR  = map.dcMotor.get("liftR");


        LF.setDirection(DcMotorSimple.Direction.REVERSE);
        RF.setDirection(DcMotorSimple.Direction.FORWARD);
        RB.setDirection(DcMotorSimple.Direction.FORWARD);
        LB.setDirection(DcMotorSimple.Direction.REVERSE);


        LF.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        RF.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        LB.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        RB.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        resetEncoders();

        //SET UP GYRO
        if (auto) {
            angles = new Orientation();

            BNO055IMU.Parameters parameters = new BNO055IMU.Parameters();
            parameters.mode = BNO055IMU.SensorMode.IMU;
            parameters.angleUnit = BNO055IMU.AngleUnit.DEGREES;
            parameters.accelUnit = BNO055IMU.AccelUnit.METERS_PERSEC_PERSEC;
            parameters.loggingEnabled = false;

            imu.initialize(parameters);

            telemetry.addData("Mode", "calibrating...");
            telemetry.update();

            while (!isStopRequested() && !imu.isGyroCalibrated()) {
                sleep(50);
                idle();
            }

            telemetry.addData("imu calib status", imu.getCalibrationStatus().toString());
            telemetry.update();

            // Set up detector

            telemetry.addData("Mode", "setting up detector...");
            telemetry.update();

            detector = new GoldAlignDetector(); // Create detector
            detector.init(hardwareMap.appContext, CameraViewDisplay.getInstance(), 1, false); // Initialize it with the app context and camera
            detector.useDefaults(); // Set detector to use default settings

            // Optional tuning
            detector.alignSize = 100; // How wide (in pixels) is the range in which the gold object will be aligned. (Represented by green bars in the preview)
            detector.alignPosOffset = 0; // How far from center frame to offset this alignment zone.
            detector.downscale = 0.4; // How much to downscale the input frames

            detector.areaScoringMethod = DogeCV.AreaScoringMethod.MAX_AREA; // Can also be PERFECT_AREA
            //detector.perfectAreaScorer.perfectArea = 10000; // if using PERFECT_AREA scoring
            detector.maxAreaScorer.weight = 0.005; //

            detector.ratioScorer.weight = 5; //
            detector.ratioScorer.perfectRatio = 1.0; // Ratio adjustment

            detector.enable(); // Start the detector!

            findGoldCrater(2);

            telemetry.addData("detector", "enabled");
            telemetry.update();
        }
        telemetry.addData("Status: ", "Initialized");
        telemetry.update();
    }

    //SET POWER TO DRIVE MOTORS
    public void setMotorPowers(double leftPower, double rightPower) {
        LF.setPower(Range.clip(leftPower, -1, 1));
        RF.setPower(Range.clip(rightPower, -1, 1));
        LB.setPower(Range.clip(leftPower, -1, 1));
        RB.setPower(Range.clip(rightPower, -1, 1));
    }

    // TIME BASED MOVEMENT
    public void driveTime(double power, long seconds){
        setMotorPowers(power, power);
        sleep(seconds);
    }

    // TIME BASED TURNING
    public void turnTime(double power, boolean right, long seconds){
        if (right)
            setMotorPowers(power, -power);
        else
            setMotorPowers(-power, power);

        sleep(seconds);
    }

    // SET RUNMODE TO DRIVE MOTORS
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

    // STOP DRIVE MOTORS
    public void stopMotors(){
        setMotorPowers(0,0);
    }

    public int getEncoderAvg(){
        //divided by three for now because RB encoder returns 0
        int avg = (Math.abs(LF.getCurrentPosition()) + Math.abs(RF.getCurrentPosition()) + Math.abs(LB.getCurrentPosition()) + Math.abs(RB.getCurrentPosition()))/3;
        return avg;
    }

    public void resetEncoders(){
        RF.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        idle();
        RB.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        idle();
        LF.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        idle();
        LB.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        idle();

        RF.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        idle();
        RB.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        idle();
        LF.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        idle();
        LB.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        idle();
    }

    // ENCODER BASED MOVEMENT - FIXED

    public void driveDistance(double power, double distance) throws InterruptedException{
        resetEncoders();

        while (!isStopRequested() && getEncoderAvg() < distance * encoderToInches && !isStopRequested()){
            setMotorPowers(power, power);
        }

        stopMotors();
    }

    public void strafeDistance(double power, double distance, boolean right) throws InterruptedException{
        resetEncoders();
        while (getEncoderAvg() < distance * 55 && !isStopRequested()){
            if (right){
                LF.setPower(-power);
                RF.setPower(power);
                LB.setPower(power);
                RB.setPower(-power);
            }else {
                LF.setPower(power);
                RF.setPower(-power);
                LB.setPower(-power);
                RB.setPower(power);
            }
        }
        stopMotors();
    }

    // ENCODER BASED MOVEMENT
    /**
     public void driveDistance(double power, double distance) throws InterruptedException {

        setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        distance = -1 * distance * encoderToInches;

        LF.setTargetPosition(LF.getCurrentPosition() + (int)distance);
        LB.setTargetPosition(LB.getCurrentPosition() + (int)distance);
        RF.setTargetPosition(RF.getCurrentPosition() + (int)distance);
        RB.setTargetPosition(RB.getCurrentPosition() + (int)distance);

        setMode(DcMotor.RunMode.RUN_TO_POSITION);
        setMotorPowers(power, power);

        while (LF.isBusy() && RF.isBusy() && LB.isBusy() && RB.isBusy() && opModeIsActive() && !isStopRequested()){
            idle();
        }
        stopMotors();
        setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }**/

    //UPDATE ANGLE
    public void updateValues() {
        angles = imu.getAngularOrientation();
    }

    //GET ANGLE
    public double getYaw() {
        updateValues();
        return angles.firstAngle;
    }

    //ROTATE USING GYRO
    public void rotateP(double targetAngleChange, boolean turnRight, int timeout) {

        runtime.reset();

        double initAngle = getYaw();
        telemetry.addData("Initial Angle", initAngle);
        telemetry.update();

        double currAngleChange = getYaw() - initAngle;
        telemetry.addData("CurrAngleChange", currAngleChange);
        telemetry.update();

        while ((Math.abs(getYaw() - initAngle) < targetAngleChange) && opModeIsActive() && (runtime.seconds() < timeout)) {
            currAngleChange = getYaw() - initAngle;
            double kP = .5/90;
            double power = .1 + currAngleChange * kP;
            if (turnRight){
                setMotorPowers(power,-power);
            }else {
                setMotorPowers(-power, power);
            }

            telemetry.addData("Angle left", targetAngleChange - currAngleChange);
            telemetry.update();

        }
        stopMotors();
    }


    //ROTATE USING GYRO
    public void rotate(double power, double targetAngleChange, boolean turnRight, int timeout) {

        runtime.reset();

        targetAngleChange -= 5;

        double initAngle = getYaw();
        telemetry.addData("Initial Angle", initAngle);
        telemetry.update();

        double currAngleChange = getYaw() - initAngle;
        telemetry.addData("CurrAngleChange", currAngleChange);
        telemetry.update();

        while ((Math.abs(getYaw() - initAngle) < targetAngleChange) && opModeIsActive() && (runtime.seconds() < timeout)) {
            if (turnRight){
                setMotorPowers(power,-power);
            }else {
                setMotorPowers(-power, power);
            }

            telemetry.addData("Angle left", targetAngleChange - currAngleChange);
            telemetry.update();

        }
        stopMotors();
    }

    //GOLD SAMPLING

    public int findGoldCrater(int timeLimit){

        int pos = 3;

        while (runtime.seconds() < timeLimit){

            telemetry.addData("IsAligned" , detector.getAligned()); // Is the bot aligned with the gold mineral?
            telemetry.addData("X Pos" , detector.getXPosition()); // Gold X position.

            if (detector.getXPosition() > 0 && detector.getXPosition() < 250){
                telemetry.addData("Left", 1);
                pos = 1;
            }else if (detector.getXPosition() > 250 && detector.getXPosition() < 600){
                telemetry.addData("Middle", 2);
                pos = 2;
            }else{
                telemetry.addData("Right", 3);
            }

            telemetry.update();
        }
        return pos;
    }

    public int findGoldDepot(int timeLimit){

        int pos = 1;

        while (runtime.seconds() < timeLimit){

            telemetry.addData("IsAligned" , detector.getAligned()); // Is the bot aligned with the gold mineral?
            telemetry.addData("X Pos" , detector.getXPosition()); // Gold X position.

            if (detector.getXPosition() > 0 && detector.getXPosition() < 250){
                telemetry.addData("Middle", 2);
                pos = 1;
            }else if (detector.getXPosition() > 250 && detector.getXPosition() < 600){
                telemetry.addData("Right", 3);
                pos = 2;
            }else{
                telemetry.addData("Left", 1);
            }

            telemetry.update();
        }
        return pos;
    }

    public double getXpos(){
        return detector.getXPosition();
    }

    public void resetTime(){
        runtime.reset();
    }

    public double getTime(){
        return runtime.seconds();
    }

    public void disableDetector(){
        detector.disable();
    }

    /*public void sample(int limit) throws InterruptedException {
        if (findGoldCrater(limit) == 0){
            telemetry.addData("Do nothing for now", ""); // Maybe just move forward
        }else if (findGoldCrater(limit) == 1){
            driveDistance(0.5, 7);
            sleep(1000);
            //strafe(5, false,0.3);
            sleep(1000);
            driveDistance(0.5, 10);
            sleep(1000);
            driveDistance(-0.5, 10);
        }else if (findGoldCrater(limit) == 2){
            driveDistance(0.5,15);
            sleep(1000);
            driveDistance(-0.5, 10);
        }else if (findGoldCrater(limit) == 3){
            driveDistance(0.5, 7);
            sleep(1000);
            //strafe(5, true,0.3);
            sleep(1000);
            driveDistance(0.5, 10);
            sleep(1000);
            driveDistance(-0.5, 10);
        }
        sleep(1000);
    }*/

    public boolean checkAlign(){
        return detector.getAligned();
    }

   //SET WAIT TIME IN AUTO
   /**public int getWait(){
        int seconds = 0;
        do{
            if (gamepad1.x)
                seconds++;
        }while (!gamepad1.y && runtime.time() < 10);
        return seconds;
    }**/

    @Override
    public void runOpMode() throws InterruptedException {

    }
}