package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;


/**
 * Created by user on 10/12/2017.
 */

@Autonomous (name = "BlueTeam")
public class BlueTeam extends robot {

    @Override
    public void runOpMode() throws InterruptedException {
        initRobot();

        motorLeftF.setDirection(DcMotor.Direction.REVERSE);
        motorRightF.setDirection(DcMotor.Direction.FORWARD);
        telemetry.addLine("RED: " + String.valueOf(colorSensor.red()));
        telemetry.update();

        waitForStart();

        nigger.setPosition(0.69);
        Thread.sleep(400);
        puz.setPosition(0.12);
        Thread.sleep(200);


        if (colorSensor.red() < 48) {
            nigger.setPosition(0.85);
        } else {
            nigger.setPosition(0.23);
        }

        Thread.sleep(500);
        nigger.setPosition(0.69);
        puz.setPosition(0.66);
        Thread.sleep(30);
        runWithEncoders(0.1, 0.1, 500, 500, 2500);
        runWithEncoders(-0.8, 0.1, -500, 500, 2000);


    }
}