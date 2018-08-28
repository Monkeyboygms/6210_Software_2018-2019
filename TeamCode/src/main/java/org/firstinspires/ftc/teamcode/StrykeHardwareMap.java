package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class StrykeHardwareMap {
    public DcMotor leftMotor = null;
    public DcMotor rightMotor = null;
    public Servo servo = null;

    HardwareMap map = null;

    private DcMotor.RunMode initialMode = null;

    public StrykeHardwareMap(DcMotor.RunMode enteredMode){
        initialMode = enteredMode;
    }

    public void init(HardwareMap themap){
        map = themap;

        leftMotor = map.dcMotor.get("LF");
        rightMotor = map.dcMotor.get("RF");
        //servo = map.servo.get("servo");

        leftMotor.setMode(initialMode);
        rightMotor.setMode(initialMode);

        leftMotor.setDirection(DcMotorSimple.Direction.FORWARD);
        rightMotor.setMode(DcMotorSimple.Direction.FORWARD);
        servo.setPosition(0);

        stop();
    }
    public void stop(){
        leftMotor.setPower(0);
        rightMotor.setPower(0);
    }
}
