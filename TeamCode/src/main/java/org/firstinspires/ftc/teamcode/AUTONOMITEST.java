package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

/**
 * Created by user on 11/02/2018.
 */

@Autonomous public class AUTONOMITEST extends robot {


    @Override
    public void runOpMode() throws InterruptedException {
        initRobot();
        waitForStart();
        GservoL.setPosition(1);

    }
}



