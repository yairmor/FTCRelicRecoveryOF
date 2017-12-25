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
@Autonomous (name = "redREED")
public class redREED extends robot{
    @Override
    public void runOpMode() throws InterruptedException {
        initRobot();
        waitForStart();
        while(true){
            telemetry.addLine("RED: " + String.valueOf(colorSensor.red()));
            telemetry.update();

        }

    }

}
