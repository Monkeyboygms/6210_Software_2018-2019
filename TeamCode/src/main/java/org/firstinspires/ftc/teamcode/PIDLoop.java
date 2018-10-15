package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;

public class PIDLoop extends AutoLinearOpMode {


    public void control(){

        double Kp = 0.02; //.025 < PID <.03
        double error = 12; //inches
        double totalError = 0;
        double tolerance = 0.01;
        double prevTime = getRuntime();
        while (Math.abs(error) > tolerance)    //not reaching target yet
        {
            double currTime = getRuntime();
            double deltaTime = currTime - prevTime;
            prevTime = currTime;
            double currPosition = rightMotor.getCurrentPosition();
            error = 12 - currPosition;
            totalError += error*deltaTime;
            double pTerm = Kp*error;    // This term is proportional to the error
            double motorPower = pTerm;
            setMotorPowers(motorPower, motorPower);
        }
    }
}

