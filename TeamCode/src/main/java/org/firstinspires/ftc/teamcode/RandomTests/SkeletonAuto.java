package org.firstinspires.ftc.teamcode.RandomTests;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

//Indicates whether file is auto or teleop and assigns the name of program which will show up in driver station

@Autonomous(name="ENTER FILE NAME HERE")

//if you want your program to show up in driver station, comment out the @Disabled line

@Disabled

public class SkeletonAuto extends LinearOpMode {

    //Declare DcMotor variables

    private DcMotor leftDrive = null;
    private DcMotor rightDrive = null;

    @Override
    public void runOpMode() throws InterruptedException {

        //Get motors from robot configuration

        leftDrive = hardwareMap.dcMotor.get("LF");
        rightDrive = hardwareMap.dcMotor.get("RF");

        //Indicate whether or not you are using encoders

        leftDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        //wait until start button is pressed

        waitForStart();

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

