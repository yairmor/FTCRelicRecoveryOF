package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.sun.source.tree.ThrowTree;




/**
 * Created by user on 13/11/2017.
 */
@Autonomous (name = "TEST")
public class AutonomousTEST extends robot  {
    public DcMotor left;
    public DcMotor right;


    @Override
    public void runOpMode() throws InterruptedException {
        initRobot();
        waitForStart();
        runWithEncoders(1, 1, 1000, 1000, 1000);
        Thread.sleep(30);
        runWithEncoders(0.5, -0.5, 1000, 2500, 2500);
        runWithEncoders(1, -0.9, 5002, 1000, 2000);
        Thread.sleep(40);
        runWithEncoders(1, 1, 10000, 10000, 3000);
        stopRobot();
    }
}
