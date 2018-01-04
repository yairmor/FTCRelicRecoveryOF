package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

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

        motorLeftF.setDirection(DcMotorSimple.Direction.REVERSE);
       // motorRightF.setDirection(DcMotor.Direction.FORWARD);
        MotorLeftB.setDirection(DcMotorSimple.Direction.REVERSE);
       // MotorRightB.setDirection(DcMotor.Direction.FORWARD);
        telemetry.addLine("RED: " + String.valueOf(colorSensor.red()));
        telemetry.update();

        waitForStart();

        nigger.setPosition(0.72);
        Thread.sleep(650);
        puz.setPosition(0.15);
        Thread.sleep(1000);

        if (vision() == RelicRecoveryVuMark.CENTER){
            runWithEncoders(0.3, 0.3, 500, 60, 10000);
        }
        else if (vision() == RelicRecoveryVuMark.LEFT) {
         runWithEncoders(0.5, 0.5, 1500, 1500, 3000);
        }




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
        Thread.sleep(30);

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







        // go backward for 15 cm//
        //runWithEncoders(0.5, 0.5, 500, 500, 2000);
        //Thread.sleep(30);
        // finish with the MAGASH down//
       // yl.setPosition(0.77);
        //Thread.sleep(15);








    }

}



