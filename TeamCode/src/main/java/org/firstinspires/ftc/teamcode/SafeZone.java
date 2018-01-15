package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

/**
 * Created by user on 10/12/2017.
 */

@Autonomous (name = "SafeZone")
public class SafeZone extends robot {

    @Override
    public void runOpMode() throws InterruptedException {
        initRobot();
        waitForStart();
        runWithEncoders(0.5, 0.5, -1895,-1895,7000);
    }//end method
}