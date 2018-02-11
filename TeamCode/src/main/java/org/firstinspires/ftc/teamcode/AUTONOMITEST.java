package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by user on 11/02/2018.
 */

@Autonomous public class AUTONOMITEST extends robot {


    @Override
    public void runOpMode() throws InterruptedException {
        initRobot();
        Elev.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        Elev.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        telemetry.addLine("press play");
        waitForStart();
        yl.setPosition(0.53);
        Elev.setTargetPosition(600);
        Elev.setPower(1);

    }
}
