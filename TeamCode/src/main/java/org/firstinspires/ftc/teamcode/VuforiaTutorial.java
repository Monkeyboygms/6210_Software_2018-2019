package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.robotcore.external.ClassFactory;
import org.firstinspires.ftc.robotcore.external.matrices.OpenGLMatrix;
import org.firstinspires.ftc.robotcore.external.matrices.VectorF;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackable;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackableDefaultListener;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackables;

import static org.firstinspires.ftc.robotcore.external.navigation.AngleUnit.DEGREES;
import static org.firstinspires.ftc.robotcore.external.navigation.AxesOrder.XYZ;
import static org.firstinspires.ftc.robotcore.external.navigation.AxesReference.EXTRINSIC;

@Autonomous (name = "VufTut", group = "sensor")
public class VuforiaTutorial extends AutoLinearOpMode{

    @Override
    public void runOpMode() throws InterruptedException {

            VuforiaLocalizer.Parameters params = new VuforiaLocalizer.Parameters(R.id.cameraMonitorViewId);
            params.cameraDirection = VuforiaLocalizer.CameraDirection.BACK;
            params.vuforiaLicenseKey = "AQt2xVL/////AAABmXIVKUnTcEJbqvVBjp/Sw/9SqarohYyKotzRjT/Xl1/S8KDwsFHv/zYw6rXqXTjKrnjk92GfBA4hbZaQP17d1N6BiBuXO2W/hFNoMGxiF+fWlnvtDmUM1H/MF9faMOjZcPNjnQ7X8DVwdDDha3A3aqaoegefkKxb4A5EjP8Xcb0EPJ1JA4RwhUOutLbCDJNKUq6nCi+cvPqShvlYTvXoROcOGWSIrPxMEiOHemCyuny7tJHUyEg2FTd2upiQygKAeD+LN3P3cT02aK6AJbQ0DlQccxAtoo1+b//H6/eGro2s0fjxA2dH3AaoHB7qkb2K0Vl7ReFEwX7wmqJleamNUG+OZu7K3Zm68mPudzNuhAWQ";
            params.cameraMonitorFeedback = VuforiaLocalizer.Parameters.CameraMonitorFeedback.AXES;

            VuforiaLocalizer vuforia = ClassFactory.createVuforiaLocalizer(params);

            VuforiaTrackables cube = vuforia.loadTrackablesFromAsset("RoverRuckusGold");
            cube.get(0).setName("Front");
            cube.get(1).setName("Side");

            VuforiaTrackableDefaultListener front = (VuforiaTrackableDefaultListener) cube.get(0).getListener();

           /* telemetry.addData(">", "Press Play to start tracking");
            telemetry.update();
            boolean targetVisible = false;
            waitForStart();*/

            cube.activate();
            while (opModeIsActive() && front.getRawPose() == null){
                idle();
                telemetry.addData("looking", " for gold");
                telemetry.update();
            }

            telemetry.addData("found", "front");
            telemetry.update();

    }
}

