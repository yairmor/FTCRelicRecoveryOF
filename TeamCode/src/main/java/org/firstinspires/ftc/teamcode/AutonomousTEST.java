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


        if (colorSensor.red()>50){
            runWithEncoders(-0.5, 0.5, -1500, 1500, 2500);

        }
        else{
            runWithEncoders(0.5, -0.5, 1500, -1500, 2500);
        }
    }
}
