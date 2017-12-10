package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

/**
 * Created by user on 10/12/2017.
 */

@Autonomous (name = "AutonomousGlifs")
public class AutonomousGlifs extends robot {

    @Override
    public void runOpMode() throws InterruptedException {
        initRobot();
        waitForStart();
        runWithEncoders(-0.7, 0.7, -5000, 5000, 8000);

        Thread.sleep(30);
        //runWithEncoders(-1, 1, -4000, 3000, 8000);
        //yl.setPosition(0.38);`
    }//end method
}