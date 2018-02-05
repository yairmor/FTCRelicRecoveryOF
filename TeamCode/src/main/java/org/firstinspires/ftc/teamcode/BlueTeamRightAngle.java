package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

import org.firstinspires.ftc.robotcore.external.navigation.RelicRecoveryVuMark;


/**
 * Created by user on 10/12/2017.
 */

@Autonomous (name = "BlueTeamRightAngle")
public class BlueTeamRightAngle extends robot {

    @Override
    public void runOpMode() throws InterruptedException {

        initRobot();

        motorLeftF.setDirection(DcMotorSimple.Direction.REVERSE);
        // motorRightF.setDirection(DcMotor.Direction.FORWARD);
        motorLeftB.setDirection(DcMotorSimple.Direction.REVERSE);
        // motorRightB.setDirection(DcMotor.Direction.FORWARD);
        telemetry.addLine("RED: " + String.valueOf(colorSensor.red()));
        telemetry.addData(">", "Hello Drivers" );
        telemetry.addLine("Press Play To Start >");
        telemetry.update();

        waitForStart();
        yl.setPosition(0.68);
        Thread.sleep(500);
        ballX.setPosition(0.72);
        Thread.sleep(650);
        ballY.setPosition(0.15);
        Thread.sleep(1000);


        if (colorSensor.red() < 48) {
            Thread.sleep(500);
            ballX.setPosition(0.85);
        } else {
            Thread.sleep(500);
            ballX.setPosition(0.23);

        }

        Thread.sleep(500);
        ballX.setPosition(0.69);
        ballY.setPosition(0.71);
        yl.setPosition(0.70);
        Thread.sleep(30);
        runWithEncoders(0.3, 0.3, -50, -50,3000);
        RelicRecoveryVuMark currentVu = vision();

        if (currentVu == RelicRecoveryVuMark.CENTER) {
            stopAndResetEncoders();
            yl.setPosition(0.68);//MAGASH half way

            runWithEncoders(0.6, 0.6, 3750, 3500,5000);//going 40cm forward//
            Thread.sleep(100);
            runWithEncoders(0.6, 0.6, 1260, -1260,4000);//turning LEFT//
            Thread.sleep(100);
            runWithEncoders(0.6, 0.6, -1020, -1020, 5000);//drive to matriza
            Thread.sleep(150);

            // MAGASH up down //
            yl.setPosition(0.68);
            Thread.sleep(100);
            yl.setPosition(0.33);//MAGASH up
            Thread.sleep(1500);
            runWithEncoders(0.7, 0.7, 900, 900,7000);
            Thread.sleep(100);
            //drive back
            runWithEncoders(0.6, 0.6, -1020, -1020,5000);
            Thread.sleep(100);
            //Forward
            runWithEncoders(0.3, 0.3, 500, 500, 5000);
            yl.setPosition(0.77);
        }


        else if (currentVu == RelicRecoveryVuMark.RIGHT) {
            stopAndResetEncoders();
            yl.setPosition(0.68);//MAGASH half way

            runWithEncoders(0.6, 0.6, 4450, 4200,5000);//going 40cm forward//
            Thread.sleep(100);
            runWithEncoders(0.6, 0.6, 1260, -1260,4000);//turning LEFT//
            Thread.sleep(100);
            runWithEncoders(0.6, 0.6, -1020, -1020, 5000);//drive to matriza
            Thread.sleep(150);

            // MAGASH up down //
            yl.setPosition(0.68);
            Thread.sleep(100);
            yl.setPosition(0.33);//MAGASH up
            Thread.sleep(1500);
            runWithEncoders(0.7, 0.7, 900, 900,7000);
            Thread.sleep(100);
            //drive back
            runWithEncoders(0.6, 0.6, -1020, -1020,5000);
            Thread.sleep(100);
            //Forward
            runWithEncoders(0.3, 0.3, 500, 500, 5000);
            yl.setPosition(0.77);
        }




        else if (currentVu == RelicRecoveryVuMark.LEFT) {//LEVDOK!!!!!!!
            stopAndResetEncoders();
            yl.setPosition(0.68);//MAGASH half way

            runWithEncoders(0.6, 0.6, 3050, 2800,5000);//going 40cm forward//
            Thread.sleep(100);
            runWithEncoders(0.6, 0.6, 1260, -1260,4000);//turning LEFT//
            Thread.sleep(100);
            runWithEncoders(0.6, 0.6, -1020, -1020, 5000);//drive to matriza
            Thread.sleep(150);

            // MAGASH up down //
            yl.setPosition(0.68);
            Thread.sleep(100);
            yl.setPosition(0.33);//MAGASH up
            Thread.sleep(1500);
            runWithEncoders(0.7, 0.7, 900, 900,7000);
            Thread.sleep(100);
            //drive back
            runWithEncoders(0.6, 0.6, -1020, -1020,5000);
            Thread.sleep(100);
            //Forward
            runWithEncoders(0.3, 0.3, 500, 500, 5000);
            yl.setPosition(0.77);


        }
        else {
            stopAndResetEncoders();
            yl.setPosition(0.68);//MAGASH half way

            runWithEncoders(0.6, 0.6, 2000, 2000,5000);//going 40cm forward//
            Thread.sleep(100);
            runWithEncoders(0.6, 0.6, 1260, -1260,4000);//turning LEFT//
            Thread.sleep(100);
            runWithEncoders(0.6, 0.6, -1020, -1020, 5000);//drive to matriza
            Thread.sleep(150);

            // MAGASH up down //
            yl.setPosition(0.68);
            Thread.sleep(100);
            yl.setPosition(0.33);//MAGASH up
            Thread.sleep(1500);
            runWithEncoders(0.7, 0.7, 900, 900,7000);
            Thread.sleep(100);
            //drive back
            runWithEncoders(0.6, 0.6, -1020, -1020,5000);
            Thread.sleep(100);
            //Forward
            runWithEncoders(0.3, 0.3, 500, 500, 5000);
            yl.setPosition(0.77);
        }


    }


}