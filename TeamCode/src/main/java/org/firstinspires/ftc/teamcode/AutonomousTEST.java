package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

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
        runWithEncoders(0.5, -0.5, 1000, 2500, 2500);
        stopRobot();
    }
}
