package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.sun.source.tree.ThrowTree;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;


/**
 * Created by user on 25/12/2017.
 */
@Autonomous (name = "blueREED")
public class blueREED extends robot{
    @Override
    public void runOpMode() throws InterruptedException {
        initRobot();
        waitForStart();
        while(true) {
            telemetry.addLine("BLUE: " + String.valueOf(colorSensor.green()));
            telemetry.update();
        }


    }



}
