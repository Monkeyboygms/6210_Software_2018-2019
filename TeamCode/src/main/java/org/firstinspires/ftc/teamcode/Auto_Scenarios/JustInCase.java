package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

@Autonomous(name="JustInCase")
//@Disabled
public class JustInCase extends LinearOpMode {

    private DcMotor leftDrive = null;
    private DcMotor rightDrive = null;

    @Override
    public void runOpMode() throws InterruptedException {

        //initialize
        leftDrive = hardwareMap.dcMotor.get("LF");
        rightDrive = hardwareMap.dcMotor.get("RF");

        leftDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        //begin program
        waitForStart();
        //Photo scan for gold mineral - will do later (assume center)
        //1- right 2-center 3-left
        int goldLoc = 1;

        //If gold is on the right turn right X degrees
        if(goldLoc == 1){
            //Move forward until touching crate

        }else if(goldLoc == 2){
            //If gold is in the middle move forward until touching crater
            //Move forward until touching crater
        }else if(goldLoc == 3){
            //If gold is on the left turn left X degrees
            //Move forward until touching crater
        }

        //methods
        public void moveForward(double power, long time) throws InterruptedException{
            leftDrive.setPower(power);
            rightDrive.setPower(power);
            sleep(time);
        }
        public void turnLeft(double power, long time) throws InterruptedException{
            leftDrive.setPower(-power);
            rightDrive.setPower(power);
            sleep(time);
        }
        public void turnRight(double power, long time)throws InterruptedException{
            leftDrive.setPower(power);
            rightDrive.setPower(-power);
            sleep(time);
        }
        public void stopDrive(){
            leftDrive.setPower(0);
            rightDrive.setPower(0);
        }








    }
