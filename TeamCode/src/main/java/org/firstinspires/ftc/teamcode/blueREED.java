package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;


/**
 * Created by user on 25/12/2017.
 */
@Disabled

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
