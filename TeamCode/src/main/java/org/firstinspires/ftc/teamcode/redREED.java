package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;


/**
 * Created by user on 25/12/2017.
 */
@Disabled
@Autonomous (name = "redREED")
public class redREED extends robot{
    @Override
    public void runOpMode() throws InterruptedException {
        initRobot();
        waitForStart();
        while(true){
            telemetry.addLine("RED: " + String.valueOf(colorSensor.red()));
            telemetry.update();
            colorSensor.enableLed(false);

        }

    }

}
