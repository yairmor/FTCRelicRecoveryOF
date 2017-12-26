package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;


/**
 * Created by user on 10/12/2017.
 */

@Autonomous (name = "REDteam")
public class RedTeam extends robot  {

    @Override
    public void runOpMode() throws InterruptedException {
        initRobot();

        motorLeftF.setDirection(DcMotor.Direction.REVERSE);
        motorRightF.setDirection(DcMotor.Direction.FORWARD);
        telemetry.addLine("RED: " + String.valueOf(colorSensor.red()));
        telemetry.update();

        waitForStart();
        nigger.setPosition(0.69);
        Thread.sleep(500);
        puz.setPosition(0.12);
        Thread.sleep(500);


        if (colorSensor.red() > 47){
            nigger.setPosition(0.85);
        }
        else{
            nigger.setPosition(0.23);
        }

        Thread.sleep(500);
        nigger.setPosition(0.69);
        puz.setPosition(0.66);
        Thread.sleep(30);

        runWithEncoders(-0.8, -0.8, -2300, -2300, 7000);
        Thread.sleep(500);
        runWithEncoders(0.8, -0.8, 1000, -1000, 2000);
        Thread.sleep(500);
        runWithEncoders(0.4, 0.4, 650, 650, 3000);
        Thread.sleep(500);
        yl.setPosition(0.33);
        Thread.sleep(500);
        runWithEncoders(-0.4, -0.4, -200, -200, 2000);
        Thread.sleep(500);
        yl.setPosition(0.77);






    }

}



