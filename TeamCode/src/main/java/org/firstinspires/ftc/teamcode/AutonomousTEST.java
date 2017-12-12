package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.sun.source.tree.ThrowTree;




/**
 * Created by user on 13/11/2017.
 */
@Autonomous (name = "blueball")
public class AutonomousTEST extends robot  {

    @Override
    public void runOpMode() throws InterruptedException {
        initRobot();
        waitForStart();
        //telemetry.addLine(String.valueOf(colorSensor));
        //telemetry.update();
        Thread.sleep(30);


        if (colorSensor.red()>250){
            runWithEncoders(-0.8, 0.8, -2800, 2800,7000);

        }
        else{
            runWithEncoders(0.8, -0.5, 2800, -2800, 7000);
        }
    }
}
