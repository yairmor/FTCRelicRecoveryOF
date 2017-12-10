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
        waitForStart();
        //telemetry.addLine(String.valueOf(colorSensor));
        //telemetry.update();
        Thread.sleep(30);
         serball.setPosition(1);
        //if (colorSensor.blue()>250){
            runWithEncoders(0.5, -0.5, 2500, -2500, 5000);

        }
        //else{
            //runWithEncoders(-0.5, 0.5, 2500, -2500, 5000);
        }
   // }
//}

