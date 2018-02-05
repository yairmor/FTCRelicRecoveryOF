package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotorSimple;


import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;
import org.firstinspires.ftc.robotcore.external.navigation.Position;
import org.firstinspires.ftc.robotcore.external.navigation.Velocity;

/**
 * Created by user on 27/01/2018.
 */
@Autonomous(name = "imuTest")
public class imuTest extends robot {


    private void loop2(){

        // Start the logging of measured acceleration
        Position p = new Position();
        Velocity v = new Velocity();
        imu.startAccelerationIntegration(p, v, 10);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long st = System.currentTimeMillis();
        while (System.currentTimeMillis() -st < 30000) {
            telemetry.addLine("in loop" + this.imu.getPosition().toString());
            telemetry.addLine("p=" + p);
            telemetry.addLine("v=" + v);
            Orientation angles = imu.getAngularOrientation(AxesReference.INTRINSIC, AxesOrder.XYZ, AngleUnit.DEGREES);
            telemetry.addLine(angles.toString());

            telemetry.update();

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    @Override
    public void runOpMode() throws InterruptedException {
        initRobot();
        while (!isStopRequested() && !imu.isGyroCalibrated())
        {
            sleep(50);
            idle();
        }
        stopAndResetEncoders();

       {

            motorLeftF.setDirection(DcMotorSimple.Direction.REVERSE);
            motorLeftB.setDirection(DcMotorSimple.Direction.REVERSE);
            waitForStart();
            //setImu();

            loop2();
        }
        }
    }

