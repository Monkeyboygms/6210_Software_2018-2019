package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class StrykeHardwareMap {
    public DcMotor leftDrive = null;
    public DcMotor rightDrive = null;
    //public Servo servo = null;

    HardwareMap map = null;

    private DcMotor.RunMode initialMode = null;

    public StrykeHardwareMap(DcMotor.RunMode enteredMode){
        initialMode = enteredMode;
    }

    public void init(HardwareMap themap){
        map = themap;

        leftDrive = map.dcMotor.get("LF");
        rightDrive = map.dcMotor.get("RF");
        //servo = map.servo.get("servo");

        leftDrive.setMode(initialMode);
        rightDrive.setMode(initialMode);

        leftDrive.setDirection(DcMotorSimple.Direction.FORWARD);
        rightDrive.setDirection(DcMotorSimple.Direction.FORWARD);
        //servo.setPosition(0);

        stop();
    }
    public void stop(){
        leftDrive.setPower(0);
        rightDrive.setPower(0);
    }
}
