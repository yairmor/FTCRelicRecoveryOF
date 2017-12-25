package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.sun.source.tree.ThrowTree;


/**
 * Created by user on 10/12/2017.
 */

@Autonomous (name = "REDball")
public class REDball extends robot  {

    @Override
    public void runOpMode() throws InterruptedException {
        initRobot();
        nigger.setPosition(0.69);
        puz.setPosition(0.12);
        left.setDirection(DcMotor.Direction.REVERSE);
        right.setDirection(DcMotor.Direction.FORWARD);
        telemetry.addLine("RED: " + String.valueOf(colorSensor.red()));
        telemetry.update();


        waitForStart();







        if (colorSensor.red()>=47 ){
            nigger.setPosition(0.85);


        }
        else{
            nigger.setPosition(0.23);
        }
        while(true){
            Thread.sleep(20);
            telemetry.addLine("RED: " + String.valueOf(colorSensor.red()));
            telemetry.update();
            //telemetry.addLine("RED: " + String.valueOf(colorSensor.red()));
            //telemetry.update();
        }
        //runWithEncoders(0.5, 0.5, 3000, 3000, 5000);
    }
}


