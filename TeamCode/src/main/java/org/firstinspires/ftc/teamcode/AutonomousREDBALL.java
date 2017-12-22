package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.sun.source.tree.ThrowTree;


/**
 * Created by user on 10/12/2017.
 */

@Autonomous (name = "REDball")
public class AutonomousREDBALL extends robot  {

    @Override
    public void runOpMode() throws InterruptedException {
        initRobot();
        nigger.setPosition(0.7);
        puz.setPosition(0.26);
        waitForStart();

        telemetry.addLine(String.valueOf(colorSensor.argb()));




        Thread.sleep(30);


        if (colorSensor.blue()>250){
            nigger.setPosition(1);
            puz.setPosition(1);

        }
        else{
            puz.setPosition(1);
        }
    }
}

