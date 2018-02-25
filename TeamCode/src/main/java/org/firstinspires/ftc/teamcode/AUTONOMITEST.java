package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

import java.util.Locale;

/**
 * Created by user on 11/02/2018.
 */
@Disabled
@Autonomous public class AUTONOMITEST extends robot {

    @Override
    public void runOpMode() throws InterruptedException {
        initRobot();
        initgyro();
        Elev.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        Elev.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        waitForStart();
        telemetry.addLine("Elev: " +Elev.getCurrentPosition());
        telemetry.addData("Distance (cm)",String.format(Locale.US, "%.02f", Distance.getDistance(DistanceUnit.CM)));
        telemetry.update();
        //Isof glifs and put in place
        GlifServo("UP");
        ballX.setPosition(0.69);
        ballY.setPosition(0.71);
        Thread.sleep(100);
        resetAngle();
        Thread.sleep(100);
        glifsLeft.setPower(1);
        glifsRight.setPower(1);
        runWithGyro(600, 0.8, "FORWARD");
        Thread.sleep(100);
        runWithGyro(1700, 0.8, "FORWARD");
        glifonator(500);

        if (NumCube == 2) {

        } else {
            Thread.sleep(100);
            runWithGyro(400, .8, "REVERSE");
            Thread.sleep(100);
            runWithGyro(800, .8, "FORWARD");
            Thread.sleep(100);
            glifonator(700);

        }
        if (NumCube == 2) {

        } else {
            Thread.sleep(100);
            runWithGyro(400, .8, "REVERSE");
            Thread.sleep(100);
            runWithGyro(800, .8, "FORWARD");
            Thread.sleep(100);
            glifonator(700);
        }
            /*runWithEncoders(1, 1, 2000, 2000, 4000);
            Thread.sleep(150);
            runWithEncoders(0.76, 0.76, 2000, 2000, 3000);
            Thread.sleep(150);
            runWithEncoders(1, 1, -750, -750, 4000);
            Thread.sleep(150);
            runWithEncoders(0.8, 0.8, 1500, 1500, 1000);
            Thread.sleep(100);
            runWithEncoders(0.8, 0.8, -5000, -5000, 4000);
            */
        runWithGyro(2300, .8, "REVERSE");
        Thread.sleep(150);
        runWithEncoders(1, 1, 200, 200, 1000);
        Flip.setPosition(0.53);
        //runWithEncoders(0.8, 0.8, -3250, -3250, 4000);
        Elev.setTargetPosition(1100);
        Elev.setPower(1);
        Thread.sleep(100);
        runWithEncoders(1, 1, -100, -100, 600);
        Thread.sleep(550);
        Flip.setPosition(0.20);
        Thread.sleep(150);
        runWithEncoders(1, 1, -100, -100, 500);
        Thread.sleep(100);
        runWithEncoders(1, 1, 620, 620, 1000);
        Elev.setTargetPosition(-300);
        glifsLeft.setPower(0);
        glifsRight.setPower(0);
        Flip.setPosition(0.636);

    }
}



