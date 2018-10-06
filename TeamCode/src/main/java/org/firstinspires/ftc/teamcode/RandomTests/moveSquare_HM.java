package org.firstinspires.ftc.teamcode.RandomTests;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name="moveSquareHM")
//@Disabled
public class moveSquare_HM extends LinearOpMode {

    SensorBNO055IMU gyro = new SensorBNO055IMU();

    @Override
    public void runOpMode() throws InterruptedException {

        //initialize

        double wantAngle = 90.0;
        String currAngle = gyro.formatAngle(gyro.angles.angleUnit, gyro.angles.firstAngle);

        waitForStart();
        //begin program
        //turnLeftAngle(0.2,3000);
       // telemetry.addData("cali stat", robot.imu.getCalibrationStatus());
        //telemetry.update();
        while(opModeIsActive()){
            if(Double.valueOf(currAngle) >= wantAngle){
                telemetry.addData("state: ", "passed or at");
            }else{
                telemetry.addData("state ", "approaching " + wantAngle);
                telemetry.addData("currangle: ", currAngle);
            }
            telemetry.update();
        }

        //stopDrive();
    }

    /*
    public void moveForwardTime(double power, long time) throws InterruptedException{
        robot.leftDrive.setPower(power);
        robot.rightDrive.setPower(power);
        sleep(time);
    }
    public void turnLeftAngle(double power, long time) throws InterruptedException{
        robot.leftDrive.setPower(-power);
        robot.rightDrive.setPower(power);
        sleep(time);
    }
    public void turnRightAngle(double power, long time)throws InterruptedException{
        robot.leftDrive.setPower(power);
        robot.rightDrive.setPower(-power);
        sleep(time);
    }
    public void stopDrive(){
        robot.leftDrive.setPower(0);
        robot.rightDrive.setPower(0);
    }*/
}
