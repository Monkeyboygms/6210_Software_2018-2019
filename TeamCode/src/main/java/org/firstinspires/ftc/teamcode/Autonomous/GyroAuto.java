package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;


//Indicates whether file is auto or teleop and assigns the name of program which will show up in driver station

@Autonomous(name="GyroAuto")

//if you want your program to show up in driver station, comment out the @Disabled line

//@Disabled

public class SkeletonAuto extends LinearOpMode {

    //Declare DcMotor variables

    private DcMotor leftDrive = null;
    private DcMotor rightDrive = null;

    @Override
    public void runOpMode() throws InterruptedException {

        //Get motors from robot configuration

        leftDrive = hardwareMap.dcMotor.get("LF");
        rightDrive = hardwareMap.dcMotor.get("RF");

        robot.init(hardwareMap);
        gyro = (ModernRoboticsI2cGyro)hardwareMap.gyroSensor.get("gyro");

        // Ensure the robot it stationary, then reset the encoders and calibrate the gyro.
        robot.leftDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.rightDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        // Send telemetry message to alert driver that we are calibrating;
        telemetry.addData(">", "Calibrating Gyro");    //
        telemetry.update();

        gyro.calibrate();

        // make sure the gyro is calibrated before continuing
        while (!isStopRequested() && gyro.isCalibrating())  {
            sleep(50);
            idle();
        }

        telemetry.addData(">", "Robot Ready.");    //
        telemetry.update();

        robot.leftDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot.rightDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        // Wait for the game to start (Display Gyro value), and reset gyro before we move..
        while (!isStarted()) {
            telemetry.addData(">", "Robot Heading = %d", gyro.getIntegratedZValue());
            telemetry.update();
        }
        //wait until start button is pressed

        waitForStart();

        gyro.resetZAxisIntegrator();

        // Step through each leg of the path,
        // Note: Reverse movement is obtained by setting a negative distance (not speed)
        // Put a hold after each turn
        gyroTurn( TURN_SPEED, -30.0);         // Turn  CCW to -30 Degrees
        gyroHold( TURN_SPEED, -30.0, 0.5);    // Hold -30 Deg heading for a 1/2 second
        gyroDrive(DRIVE_SPEED, 12.0, -30.0);  // Drive FWD 12 inches at -30 degrees
        gyroTurn( DRIVE_SPEED, -12.0, -30.0); // Reverse BWD 12 inches at -30 Degrees
        gyroHold( TURN_SPEED, 90.0);        // Turn CW to 90 Degrees
        gyroTurn( TURN_SPEED, 90.0, 0.5);   // Hold 90 Deg heading for 1/2 second
        gyroHold( DRIVE_SPEED, 24.0, 90.0);    // Drive FWD 24 inches at 90 degrees

        telemetry.addData("Path", "Complete");
        telemetry.update();


        //WRITE MAIN CODE HERE
        //If needed, you would create methods below and call them in here and pass parameters

        /* Ex:

            moveForward(0.5, 10000); moves for 10 seconds

            DOWN THERE YOU WOULD MAKE THE METHOD:

            public static void moveForward(double power, long time){
                leftDrive.setPower(power);
                rightDrive.setPower(power);
                sleep(time); motors run for that amount of time
            }

         */

    }

    //OPTIONAL METHODS: Delete if you don't use

    public void someMethodName (double someParameter){

        //Do something with parameters

    }
}

