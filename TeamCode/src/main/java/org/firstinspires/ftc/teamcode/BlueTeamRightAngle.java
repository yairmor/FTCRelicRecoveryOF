package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.robotcore.external.navigation.RelicRecoveryVuMark;


/**
 * Created by user on 10/12/2017.
 */

@Autonomous (name = "BlueTeamRightAngle")
public class BlueTeamRightAngle extends robot {

    @Override
    public void runOpMode() throws InterruptedException {
        initVuforia();
        initRobot();
        initgyro();

        telemetry.addLine("RED: " + String.valueOf(colorSensor.red()));

        telemetry.addData(">", "Hello Drivers" );
        telemetry.addLine("Press Play To Start");
        telemetry.update();

        waitForStart();
        Flip.setPosition(0.53);
        ballX.setPosition(0.69);
        Thread.sleep(1000);
        ballY.setPosition(0.15);
        Thread.sleep(850);


        if (colorSensor.red() < 48) {
            Thread.sleep(500);
            ballX.setPosition(0.85);
        } else {
            Thread.sleep(500);
            ballX.setPosition(0.35);

        }

        Thread.sleep(500);
        ballX.setPosition(0.69);
        ballY.setPosition(0.71);
        Flip.setPosition(0.53);
        Thread.sleep(30);
        RelicRecoveryVuMark currentVu = vision();

        if (currentVu == RelicRecoveryVuMark.CENTER) {
            stopAndResetEncoders();
            Flip.setPosition(0.53); //Magash Half Way UP
            runWithEncoders(1, 1, 2400, 2400, 3500); // Drive To Matritza
            Thread.sleep(300);
            runWithEncoders(0.57, 0.57, -1000,1000, 1500); // Turning 90 Left was 1050
            Thread.sleep(300);
            runWithEncoders(0.8, 0.8, 1105, 1105, 3000); // Backing Up to Matritza
            Thread.sleep(300);

            Flip.setPosition(0.20); // Magash All The Way UP
            Thread.sleep(1500);
            Flip.setPosition(0.636);// Magash All The Way down
            Thread.sleep(150);

        }


        else if (currentVu == RelicRecoveryVuMark.RIGHT) {
            stopAndResetEncoders();
            Flip.setPosition(0.53);//MAGASH half way

            runWithEncoders(0.6, 0.6, 4450, 4200,5000);//going 40cm forward//
            Thread.sleep(100);
            runWithEncoders(0.6, 0.6, 1260, -1260,4000);//turning LEFT//
            Thread.sleep(100);
            runWithEncoders(0.6, 0.6, -1020, -1020, 5000);//drive to matriza
            Thread.sleep(150);

            // MAGASH up down //
            Flip.setPosition(0.2);
            Thread.sleep(100);
            Flip.setPosition(0.636);//MAGASH up
            Thread.sleep(1500);
        }




        else if (currentVu == RelicRecoveryVuMark.LEFT) {//LEVDOK!!!!!!!
            stopAndResetEncoders();
            Flip.setPosition(0.53);//MAGASH half way

            runWithEncoders(1 ,1, 3050, 3050,2000);//going 40cm forward//
            Thread.sleep(100);
            runWithEncoders(0.8, 0.8, 1260, -1260,2000);//turning LEFT//
            Thread.sleep(100);
            runWithEncoders(0.6, 0.6, -1020, -1020, 2000);//drive to matriza
            Thread.sleep(150);

            // MAGASH up down //
            Flip.setPosition(0.2);
            Thread.sleep(1500);
            Flip.setPosition(0.53);//MAGASH up
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


    }


}