package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;


/**
 * Created by user on 10/12/2017.
 */

@Autonomous (name = "BlueTeamZigZagPotision")
public class BlueTeamZigZagPotision extends robot  {

    @Override
    public void runOpMode() throws InterruptedException {
        //initVuforia();
        initRobot();


        telemetry.addLine("RED: " + String.valueOf(colorSensor.red()));
        telemetry.addData(">", "heifes KATAV!");
        telemetry.update();

        waitForStart();

        ballX.setPosition(0.72);
        Thread.sleep(650);
        ballY.setPosition(0.15);
        Thread.sleep(1000);



        if (colorSensor.red() < 48){
            ballX.setPosition(0.85);
        }
        else{
            ballX.setPosition(0.23);
        }

        Thread.sleep(500);
        ballX.setPosition(0.69);
        ballY.setPosition(0.71);
        Flip.setPosition(0.70);
        Thread.sleep(30);

        // going 60cm Backward//
        runWithEncoders( 0.7,  0.7,  2300,  2300,7000);
        Thread.sleep(750);
        //turning right//
        runWithEncoders( 0.85, -0.85,  1250, -1250,7000);
        Thread.sleep(750);
        // going 32cm Backward//
        runWithEncoders( 0.7,  0.7,  2050, 2050,7000);
        Thread.sleep(750);
        //turning Left//
        runWithEncoders( 0.75, -0.75,  1320, -1320,7000);
        Thread.sleep(750);

        //drive forward to the matrix 32cm//
        runWithEncoders( -0.6,  -0.6,  -1550,  -1550,7000);
        Thread.sleep(750);

        // MAGASH up down two times//
        Flip.setPosition(0.33);
        Thread.sleep(30);
        //revers stop//
        runWithEncoders(0.5,0.5, 160, 160,7000);
        Thread.sleep(30);
        Flip.setPosition(0.77);










        // go backward for 15 cm//
        //runWithEncoders(0.5, 0.5, 700, 700, 2000);
        //Thread.sleep(30);
        // going again forward to push the cube//
        //runWithEncoders(-0.5, -0.5, -700, -700, 2000);

        // finish with the MAGASH down//










    }

}



