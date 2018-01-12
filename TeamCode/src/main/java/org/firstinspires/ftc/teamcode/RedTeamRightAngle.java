package org.firstinspires.ftc.teamcode;
import com.google.gson.annotations.Until;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.sun.source.tree.WhileLoopTree;
import com.sun.tools.javac.util.ForwardingDiagnosticFormatter;

import org.firstinspires.ftc.robotcore.external.matrices.OpenGLMatrix;
import org.firstinspires.ftc.robotcore.external.navigation.RelicRecoveryVuMark;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;

/**
 * Created by user on 10/12/2017.
 */

@Autonomous (name = "RedTeamRightAngle")
public class RedTeamRightAngle extends robot  {


    @Override
    public void runOpMode() throws InterruptedException {
        initRobot();
        stopAndResetEncoders();
        motorLeftF.setDirection(DcMotorSimple.Direction.REVERSE);
        MotorLeftB.setDirection(DcMotorSimple.Direction.REVERSE);
        telemetry.addLine("RED: " + String.valueOf(colorSensor.red()));
        telemetry.update();
        waitForStart();
        nigger.setPosition(0.73);
        Thread.sleep(650);
        puz.setPosition(0.15);
        Thread.sleep(800);


        if (colorSensor.red() > 47){
            nigger.setPosition(0.85);
        }
        else{
            nigger.setPosition(0.23);
        }

        Thread.sleep(500);
        nigger.setPosition(0.69);
        puz.setPosition(0.71);
        yl.setPosition(0.70);
        runWithEncoders(0.5, 0.5, -1092, -1092, 4000);
        RelicRecoveryVuMark currentVu = vision();

        if (currentVu == RelicRecoveryVuMark.CENTER){
            yl.setPosition(0.70);
            //going 40cm forward//
            runWithEncoders(0.8, 0.8, -1410, -1410, 5000);
            Thread.sleep(100);
            //turning left//
            runWithEncoders(0.85, 0.85, 1250, -1250, 5000);
            Thread.sleep(100);
            // going 35cm forward//
            runWithEncoders(0.85, 0.85, -1237, -1237, 6000);
            // MAGASH up down two times//
            yl.setPosition(0.77);
            Thread.sleep(1000);
            yl.setPosition(0.33);
            Thread.sleep(100);
            runWithEncoders(0.5,0.5, 900, 900, 3000);
            //drive back
            runWithEncoders(0.5, 0.5, -1020, -1020, 5000);
            //Forward
            runWithEncoders(0.3, 0.3, 500, 500, 3000);
            yl.setPosition(0.33);

        }
        else if (currentVu==RelicRecoveryVuMark.LEFT){
            yl.setPosition(0.70);
            runWithEncoders(0.8, 0.8, -2208, -2208, 5000);

            Thread.sleep(100);
            //turning left//
            runWithEncoders(0.85, 0.85, 1250, -1250, 5000);
            Thread.sleep(100);
            // going 35cm forward//
            runWithEncoders(0.85, 0.85, -1237, -1237, 6000);
            // MAGASH up down two times//
            yl.setPosition(0.77);
            //Thread.sleep(1000);
            yl.setPosition(0.33);
            Thread.sleep(50);
            runWithEncoders(0.5,0.5, 900, 900, 3000);
            //drive back
            runWithEncoders(0.5, 0.5, -1020, -1020, 5000);
            //Forward
            runWithEncoders(0.3, 0.3, 500, 500, 3000);
            yl.setPosition(0.33);
        }
        else if (currentVu==RelicRecoveryVuMark.RIGHT){
            yl.setPosition(0.70);
            runWithEncoders(0.8, 0.8, -748, -745, 5000);

            Thread.sleep(100);
            //turning left//
            runWithEncoders(0.85, 0.85, 1250, -1250, 5000);
            Thread.sleep(100);
            // going 35cm forward//
            runWithEncoders(0.85, 0.85, -1237, -1237, 6000);
            // MAGASH up down two times//
            yl.setPosition(0.77);
            Thread.sleep(500);
            yl.setPosition(0.33);
            Thread.sleep(50);
            runWithEncoders(0.5,0.5, 900, 900, 3000);
            //drive back
            runWithEncoders(0.5, 0.5, -1020, -1020, 5000);
            //Forward
            runWithEncoders(0.3, 0.3, 500, 500, 3000);
            yl.setPosition(0.33);



        }


            else{
            // going 65cm forward//
            runWithEncoders(-0.7, -0.7, -2550, -2550, 7000);
            Thread.sleep(750);
            //turning right//
            runWithEncoders(0.85, -0.85, 1250, -1250, 5000);
            Thread.sleep(750);
            //drive forward to the matrix//
            runWithEncoders(-0.6, -0.6, -1500, -1500, 5000);
            Thread.sleep(750);

            // MAGASH up down two times//
            yl.setPosition(0.33);
            Thread.sleep(30);
            yl.setPosition(0.77);
            Thread.sleep(30);
            yl.setPosition(0.33);
            Thread.sleep(30);
            //revers stop//
            runWithEncoders(0.5,0.5, 160, 160, 3000);

        }











         }

    }














        // go backward for 15 cm//
        //runWithEncoders(0.5, 0.5, 500, 500, 2000);
        //Thread.sleep(30);
        // finish with the MAGASH down//
       // yl.setPosition(0.77);
        //Thread.sleep(15);














