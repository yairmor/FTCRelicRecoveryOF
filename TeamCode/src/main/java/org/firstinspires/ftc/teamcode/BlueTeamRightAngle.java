package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.robotcore.external.navigation.RelicRecoveryVuMark;


/**
 * Created by user on 10/12/2017.
 */

@Autonomous (name = "BlueTeamRightAngle")
public class BlueTeamRightAngle extends robot {

    @Override
    public void runOpMode() throws InterruptedException {
        initRobot();
        GlifServo("DOWN");
        initVuforia();
        initgyro();
        Elev.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        Elev.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        telemetry.addData("12363 ", "Good Luck Robot");
        telemetry.update();

        waitForStart();
        Kadorim("BLUE");
        Rmotor.setTargetPosition(-2650);
        Rmotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        Rmotor.setPower(1);
        Thread.sleep(500);
        ballX.setPosition(0.69);
        ballY.setPosition(0.71);
        Flip.setPosition(0.53);
        Thread.sleep(30);
        RelicRecoveryVuMark currentVu = vision();

        if (currentVu == RelicRecoveryVuMark.CENTER) {
            stopAndResetEncoders();
            Flip.setPosition(0.53); //Magash Half Way UP
            runWithEncoders(1, 1, 3700, 3700, 2300); // Drive To Matritza
            Thread.sleep(100);
            runWithEncoders(0.7, 0.7, 1370,-1370, 2000); // Turning 90 Left was 1050
            Thread.sleep(100);
            runWithEncoders(0.9, 0.9, -900, -900, 1100); // Backing Up to Matritza
            Thread.sleep(300);
            GlifServo("UP");

            Flip.setPosition(0.20); // Magash All The Way UP
            Thread.sleep(1500);
            Flip.setPosition(0.636);// Magash All The Way down
            Thread.sleep(150);

        }


        else if (currentVu == RelicRecoveryVuMark.RIGHT) {
            stopAndResetEncoders();
            Flip.setPosition(0.53);//MAGASH half way

            runWithEncoders(1, 1, 4450, 4450,2000);//going 40cm forward//
            Thread.sleep(100);
            runWithEncoders(0.7, 0.7, 1250, -1250,1500);//turning LEFT//
            Thread.sleep(100);
            runWithEncoders(0.9, 0.9, -900, -900, 1000);//drive to matriza
            Thread.sleep(150);
            GlifServo("UP");
            // MAGASH up down //
            Flip.setPosition(0.2);
            Thread.sleep(1500);
            Flip.setPosition(0.636);//MAGASH up
            Thread.sleep(150);
        }




        else if (currentVu == RelicRecoveryVuMark.LEFT) {//LEVDOK!!!!!!!
            stopAndResetEncoders();
            Flip.setPosition(0.53);//MAGASH half way

            runWithEncoders(1 ,1, 2810, 2810,2000);//going 40cm forward//
            Thread.sleep(100);
            runWithEncoders(0.8, 0.8, 1350, -1350,2000);//turning LEFT//
            Thread.sleep(100);
            runWithEncoders(0.9, 0.9, -950, -950, 2000);//drive to matriza
            Thread.sleep(150);
            GlifServo("UP");
            // MAGASH up down //
            Flip.setPosition(0.2);
            Thread.sleep(1500);
            Flip.setPosition(0.636);//MAGASH up
            Thread.sleep(100);


        }
        else {
            stopAndResetEncoders();
            Flip.setPosition(0.68);//MAGASH half way

            runWithEncoders(0.6, 0.6, 2000, 2000,5000);//going 40cm forward//
            Thread.sleep(100);
            runWithEncoders(0.6, 0.6, 1260, -1260,4000);//turning LEFT//
            Thread.sleep(100);
            runWithEncoders(0.6, 0.6, -1020, -1020, 5000);//drive to matriza
            Thread.sleep(150);

            // MAGASH up down //
            Flip.setPosition(0.68);
            Thread.sleep(100);
            Flip.setPosition(0.33);//MAGASH up
            Thread.sleep(1500);
            runWithEncoders(0.7, 0.7, 900, 900,7000);
            Thread.sleep(100);
            //drive back
            runWithEncoders(0.6, 0.6, -1020, -1020,5000);
            Thread.sleep(100);
            //Forward
            runWithEncoders(0.3, 0.3, 500, 500, 5000);
            Flip.setPosition(0.77);
        }
        //Isof glifs and put in place

        Thread.sleep(100);
        resetAngle();
        Thread.sleep(100);
        glifsLeft.setPower(1);
        glifsRight.setPower(1);
        runWithGyro(700, 0.8, "FORWARD");
        Thread.sleep(100);
        runWithGyro(1600, 0.8, "FORWARD");
        glifonator(500);

        if (NumCube == 2) {

        } else {
            Thread.sleep(100);
            runWithGyro(400, .8, "REVERSE");
            Thread.sleep(100);
            runWithGyro(1000, .8, "FORWARD");
            Thread.sleep(100);
            glifonator(700);

        }
        if (NumCube == 2) {

        } else {
            Thread.sleep(100);
            runWithGyro(400, .8, "REVERSE");
            Thread.sleep(100);
            runWithGyro(900, .8, "FORWARD");
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
        GlifServo("DOWN");
        runWithGyro(2300, .8, "REVERSE");
        GlifServo("UP");
        Thread.sleep(150);
        runWithEncoders(1, 1, 200, 200, 1000);
        Flip.setPosition(0.53);
        //runWithEncoders(0.8, 0.8, -3250, -3250, 4000);
        Elev.setTargetPosition(1200);
        Elev.setPower(1);
        Thread.sleep(100);
        runWithEncoders(1, 1, -100, -100, 600);
        Thread.sleep(550);
        Flip.setPosition(0.20);
        Thread.sleep(150);
        runWithEncoders(1, 1, -100, -100, 500);
        Thread.sleep(100);
        runWithEncoders(1, 1, 620, 620, 1000);
        Elev.setTargetPosition(-320);
        glifsLeft.setPower(0);
        glifsRight.setPower(0);
        Flip.setPosition(0.636);

    }


}