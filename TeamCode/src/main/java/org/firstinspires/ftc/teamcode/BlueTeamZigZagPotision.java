package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.robotcore.external.navigation.RelicRecoveryVuMark;


/**
 * Created by user on 10/12/2017.
 */

@Autonomous (name = "BlueTeamZigZagPotision")
public class BlueTeamZigZagPotision extends robot  {

    @Override
    public void runOpMode() throws InterruptedException {
        initRobot();
        GlifServo("DOWN");
        initVuforia();
        waitForStart();
        Kadorim("BLUE");
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
            runWithEncoders(1, 1, 2770, 2770,2000);
            Thread.sleep(200);
            //turning right
            runWithEncoders(0.7, 0.7, -1300, 1300,2000);
            Thread.sleep(200);
            runWithEncoders(0.7, 0.7, -1200, -1200,2000);
            Thread.sleep(200);
            //turning right
            runWithEncoders(0.8, 0.8, -1220, 1220,2000);
            Thread.sleep(200);
            runWithEncoders(0.8, 0.8, -900, -900,2000);
            Thread.sleep(1000);

            Flip.setPosition(0.2);//MAGASH up
            Thread.sleep(500);
            runWithEncoders(1, 1, 600, 600 ,1000);
            Thread.sleep(150);
            runWithEncoders(1, 1, -600, -600 ,1000);
            Thread.sleep(150);

            runWithEncoders(1, 1, 150, 150 ,1000);
            Flip.setPosition(0.63);
        }


        else if(currentVu== RelicRecoveryVuMark.RIGHT){
            stopAndResetEncoders();
            Flip.setPosition(0.53);
            Thread.sleep(200);
            //going backward 41 cm
            runWithEncoders(1, 1, 2770, 2770,2000);
            Thread.sleep(200);
            //turning right
            runWithEncoders(0.7, 0.7, -1150, 1150,2000);
            Thread.sleep(200);
            runWithEncoders(0.7, 0.7, -2000, -2000,2000);
            Thread.sleep(200);
            //turning right
            runWithEncoders(0.8, 0.8, -1250, 1250,2000);
            Thread.sleep(200);
            runWithEncoders(0.8, 0.8, -930, -930,2000);
            Thread.sleep(1000);

            Flip.setPosition(0.2);//MAGASH up
            Thread.sleep(500);
            runWithEncoders(1, 1, 700, 700 ,1000);
            Thread.sleep(150);
            runWithEncoders(1, 1, -670, -670 ,1000);
            Thread.sleep(150);

            runWithEncoders(1, 1, 150, 150 ,1000);
            Flip.setPosition(0.63);
        }


        else if(currentVu== RelicRecoveryVuMark.LEFT){
            stopAndResetEncoders();
            Flip.setPosition(0.53);
            Thread.sleep(200);
            //going backward 41 cm
            runWithEncoders(1, 1, 2770, 2770,2000);
            Thread.sleep(200);
            //turning right
            runWithEncoders(0.7, 0.7, -1150, 1150,2000);
            Thread.sleep(200);
            runWithEncoders(0.7, 0.7, -560, -560,2000);
            Thread.sleep(200);
            //turning right
            runWithEncoders(0.8, 0.8, -1250, 1250,2000);
            Thread.sleep(200);
            runWithEncoders(0.8, 0.8, -900, -900,2000);
            Thread.sleep(1000);

            Flip.setPosition(0.2);//MAGASH up
            Thread.sleep(500);

            runWithEncoders(1, 1, 600, 600 ,1000);
            Thread.sleep(150);
            runWithEncoders(1, 1, -600, -600 ,1000);
            Thread.sleep(150);

            runWithEncoders(1, 1, 150, 150 ,1000);
            Flip.setPosition(0.63);

        }
        else {
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











    }

}



