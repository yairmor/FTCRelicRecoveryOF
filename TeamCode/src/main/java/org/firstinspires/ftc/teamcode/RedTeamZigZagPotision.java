package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.robotcore.external.navigation.RelicRecoveryVuMark;


/**
 * Created by user on 10/12/2017.
 */

@Autonomous (name = "RedTeamZigZagPotision")
public class RedTeamZigZagPotision extends robot  {

    @Override
    public void runOpMode() throws InterruptedException {
        initVuforia();
        initRobot();
        GlifServo("DOWN");
        stopAndResetEncoders();
        telemetry.addData("12363 ", "Good Luck Robot");
        telemetry.update();
        waitForStart();
        Kadorim("RED");

       /* if (colorSensor.red() > 47){
            Thread.sleep(500);
            ballX.setPosition(0.85);
        }
        else{
            ballX.setPosition(0.23);
        }*/

        Thread.sleep(500);
        ballX.setPosition(0.69);
        ballY.setPosition(0.71);
        Flip.setPosition(0.53);
        Thread.sleep(70);
        RelicRecoveryVuMark currentVu = vision();

        if (currentVu== RelicRecoveryVuMark.CENTER){
            stopAndResetEncoders();
            Flip.setPosition(0.53);
            Thread.sleep(200);
            //going backward 41 cm
            runWithEncoders(1, 1, -1950, -1950,3000);
            Thread.sleep(200);
            //turning right
            runWithEncoders(0.7, 0.7, -1150, 1150,2000);
            Thread.sleep(200);
            runWithEncoders(0.7, 0.7, -770, -770,3000);
            Thread.sleep(200);
            //turning right
            runWithEncoders(0.8, 0.8, 1140, -1140,2000);
            Thread.sleep(200);
            runWithEncoders(0.8, 0.8, -700, -700,2000);
            Thread.sleep(1000);

            Flip.setPosition(0.2);//MAGASH up
            Thread.sleep(1000);
            runWithEncoders(1, 1, 500, 500 ,1000);
            Flip.setPosition(0.63);
        }


        else if(currentVu== RelicRecoveryVuMark.RIGHT){
            stopAndResetEncoders();
            Flip.setPosition(0.53);
            Thread.sleep(200);
            //going backward 41 cm
            runWithEncoders(1, 1, -1950, -1950,3000);
            Thread.sleep(200);
            //turning right
            runWithEncoders(0.7, 0.7, -1150, 1150,2000);
            Thread.sleep(200);
            runWithEncoders(0.7, 0.7, -340, -340,3000);
            Thread.sleep(200);
            //turning right
            runWithEncoders(0.8, 0.8, 1100, -1100,2000);
            Thread.sleep(200);
            runWithEncoders(0.8, 0.8, -700, -700,2000);
            Thread.sleep(1000);

            Flip.setPosition(0.2);//MAGASH up
            Thread.sleep(1000);
            runWithEncoders(1, 1, 500, 500 ,1000);
            Flip.setPosition(0.63);
        }


        else if(currentVu== RelicRecoveryVuMark.LEFT){
            stopAndResetEncoders();
            Flip.setPosition(0.53);
            Thread.sleep(200);
            //going backward 41 cm
            runWithEncoders(1, 1, -2000, -2000,3000);
            Thread.sleep(200);
            //turning right
            runWithEncoders(0.7, 0.7, -1275, 1275,2000);
            Thread.sleep(200);
            runWithEncoders(0.7, 0.7, -1600, -1600,3000);
            Thread.sleep(200);
            //turning right
            runWithEncoders(0.8, 0.8, 1200, -1200,2000);
            Thread.sleep(200);
            runWithEncoders(0.8, 0.8, -700, -700,2000);
            Thread.sleep(1000);

            Flip.setPosition(0.2);//MAGASH up
            Thread.sleep(1000);
            runWithEncoders(1, 1, 500, 500 ,1000);
            Flip.setPosition(0.63);

        }
        else {
            stopAndResetEncoders();
            Flip.setPosition(0.70);
            Thread.sleep(200);
            //going backward 41 cm
            runWithEncoders(0.4, 0.4, -850, -850,7000);
            Thread.sleep(200);
            //turning right
            runWithEncoders(0.5, 0.5, -1210, 1210,7000);
            Thread.sleep(200);
            runWithEncoders(0.6, 0.6, 940, 940,7000);
            Thread.sleep(200);
            //drive to matriza 49 cm
            runWithEncoders(0.55, 0.55, -1730, -1730,7000);
            Thread.sleep(200);
            //turning right
            runWithEncoders(0.4, 0.4, 1140, -1140,7000);
            Thread.sleep(200);
            runWithEncoders(0.6, 0.6, -1010, -1010,7000);
            Thread.sleep(1000);

            Flip.setPosition(0.33);//MAGASH up
            Thread.sleep(1000);
            runWithEncoders(0.5,0.5, 900, 900,7000);
            Thread.sleep(200);
            //drive back
            runWithEncoders(0.5, 0.5, -960, -960,7000);
            Thread.sleep(200);
            //Forward
            runWithEncoders(0.3, 0.3, 400, 400,7000);
            Thread.sleep(200);
            Flip.setPosition(0.77);
        }
























        // going 65cm forward//
        //runWithEncoders(-0.7, -0.7, -2550, -2550, 7000);
        ///Thread.sleep(750);
        //turning Left//
       // runWithEncoders(-0.85, 0.85, -1250, 1250, 5000);
        //Thread.sleep(750);
        // going 15cm forward//
        //runWithEncoders(-0.7, -0.7, -500, -500, 7000);
        //Thread.sleep(750);
        //turning right //
        //runWithEncoders(0.85, -0.85, 1250, -1250, 5000);
        //Thread.sleep(750);

        //drive forward to the matrix 28cm//
        //runWithEncoders(-0.6, -0.6, -800, -800, 5000);
        //Thread.sleep(750);

        // MAGASH up down two times//
        //Flip.setPosition(0.33);
        //Thread.sleep(30);
        //Flip.setPosition(0.77);
        //Thread.sleep(30);
        //Flip.setPosition(0.33);
        //Thread.sleep(30);
        //revers stop//
        //runWithEncoders(0.5,0.5, 160, 160, 3000);

        // go backward for 15 cm//
        //runWithEncoders(0.5, 0.5, 700, 700, 2000);
        //Thread.sleep(30);
        // going again forward to push the cube//
       // runWithEncoders(-0.5, -0.5, -800, -800, 2000);
       // Thread.sleep(30);

        // finish with the MAGASH down//
        //Flip.setPosition(0.77);
        //Thread.sleep(15);



    }

}



