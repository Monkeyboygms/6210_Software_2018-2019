package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous(name = "IntakeTest", group = "teleop")
//@Disabled
public class IntakeTest extends AutoLinearOpMode{

    @Override
    public void runOpMode() throws InterruptedException {

        init(hardwareMap);
        double leftPower = 0, rightPower = 0;

        //Do we want the intake to go "full speed" when the trigger is pushed or do we want the speed proportional to the trigger?
        waitForStart();

        while (opModeIsActive()) {
            if(Math.abs(gamepad1.left_trigger) > 0.05){
                leftPower = gamepad1.left_trigger;
                rightPower = gamepad1.left_trigger;
            }
            else if(Math.abs(gamepad1.right_trigger) > 0.05){
                leftPower = gamepad1.right_trigger *= -1;
                rightPower = gamepad1.right_trigger *= -1;
            }else{
                rightPower = 0;
                leftPower = 0;
            }

            setMotorPowers(leftPower, rightPower);

    }}}