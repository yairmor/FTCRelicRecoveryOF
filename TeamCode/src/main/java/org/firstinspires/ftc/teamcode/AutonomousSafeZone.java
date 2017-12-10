package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.sun.source.tree.ThrowTree;
/**
 * Created by user on 10/12/2017.
 */



@Autonomous (name = "AutonomousSafeZone")
public class AutonomousSafeZone extends robot  {

    @Override
    public void runOpMode() throws InterruptedException {
        initRobot();
        waitForStart();
        runWithEncoders(0.8, -0.8, 2600, -3000, 6000);

    }
}
