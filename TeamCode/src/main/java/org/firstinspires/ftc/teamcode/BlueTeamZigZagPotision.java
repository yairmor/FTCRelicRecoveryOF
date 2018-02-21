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
        //initVuforia();
        initRobot();
        initVuforia();
        GlifServo("DOWN");

        telemetry.addLine("RED: " + String.valueOf(colorSensor.red()));
        telemetry.addData(">", "heifes KATAV!");
        telemetry.update();

        waitForStart();

        ballX.setPosition(0.72);
        Thread.sleep(650);
        ballY.setPosition(0.13);
        Thread.sleep(1000);



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
            runWithEncoders(1, 1, 2900, 2900,3000);
            Thread.sleep(200);
            //turning right
            runWithEncoders(0.7, 0.7, -1350, 1350,2000);
            Thread.sleep(200);
            runWithEncoders(0.7, 0.7, -820, -8200,3000);
            Thread.sleep(200);
            //turning right
            runWithEncoders(0.8, 0.8, -1200, 1200,2000);
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



