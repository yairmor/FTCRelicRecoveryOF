package org.firstinspires.ftc.teamcode;
import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

import org.firstinspires.ftc.robotcore.external.ClassFactory;
import org.firstinspires.ftc.robotcore.external.matrices.OpenGLMatrix;
import org.firstinspires.ftc.robotcore.external.matrices.VectorF;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;
import org.firstinspires.ftc.robotcore.external.navigation.RelicRecoveryVuMark;
import org.firstinspires.ftc.robotcore.external.navigation.VuMarkInstanceId;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackable;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackableDefaultListener;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackables;

import java.sql.Time;


/**
 * Created by user on 10/12/2017.
 */

@Autonomous (name = "RedTeamRightAngle")
public class RedTeamRightAngle extends robot {


    @Override
    public void runOpMode() throws InterruptedException {
        initVuforia();
        initRobot();
        stopAndResetEncoders();
        glifs2.setDirection(DcMotor.Direction.FORWARD);
        glifs1.setDirection(DcMotor.Direction.REVERSE);
        motorLeftF.setDirection(DcMotorSimple.Direction.REVERSE);
        motorLeftB.setDirection(DcMotorSimple.Direction.REVERSE);
        telemetry.addLine("RED: " + String.valueOf(colorSensor.red()));
/*
        BNO055IMU.Parameters parameters1 = new BNO055IMU.Parameters();

        parameters1.mode = BNO055IMU.SensorMode.IMU;
        parameters1.angleUnit = BNO055IMU.AngleUnit.DEGREES;
        parameters1.accelUnit = BNO055IMU.AccelUnit.METERS_PERSEC_PERSEC;
        parameters1.loggingEnabled = false;

        // Retrieve and initialize the IMU. We expect the IMU to be attached to an I2C port
        // on a Core Device Interface Module, configured to be a sensor of type "AdaFruit IMU",
        // and named "imu".
        imu = hardwareMap.get(BNO055IMU.class, "imu");

        imu.initialize(parameters1);

        telemetry.addData("Mode", "calibrating...");
        telemetry.update();

        // make sure the imu gyro is calibrated before continuing.
        while (!isStopRequested() && !imu.isGyroCalibrated()) {
            sleep(50);
            idle();
        }

        telemetry.addLine("Press Play To Start");
        telemetry.addData("imu calib status", imu.getCalibrationStatus().toString());
        telemetry.update();
        */
        waitForStart();
        //initVuforia();
        yl.setPosition(0.53);


        ballX.setPosition(0.69);
        Thread.sleep(1000);
        ballY.setPosition(0.15);
        Thread.sleep(1000);

        if (colorSensor.red() > 47) {
            ballX.setPosition(0.85);
        } else {
            ballX.setPosition(0.23);
        }

        Thread.sleep(500);
        ballX.setPosition(0.69);
        ballY.setPosition(0.71);


        RelicRecoveryVuMark currentVu = vision();
        if (currentVu == RelicRecoveryVuMark.CENTER) {
            stopAndResetEncoders();
            yl.setPosition(0.53); //Magash Half Way UP
            runWithEncoders(1, 1, -2400, -2400, 3500); // Drive To Matritza
            Thread.sleep(300);
            runWithEncoders(0.57, 0.57, 1000, -1000, 1500); // Turning 90 Left was 1050
            Thread.sleep(300);
            runWithEncoders(0.8, 0.8, -1105, -1105, 3000); // Backing Up to Matritza
            Thread.sleep(300);

            yl.setPosition(0.20); // Magash All The Way UP
            Thread.sleep(1500);
            yl.setPosition(0.636);// Magash All The Way down
            Thread.sleep(150);


            glifs1.setPower(-0.7);
            glifs2.setPower(-1);
            Thread.sleep(100);
            runWithEncoders(1, 1, 3500, 3500, 4500);
            Thread.sleep(100);
            //glifs1.setPower(0);
            // glifs2.setPower(0);
            //runWithEncoders(1, 1, -95, 95, 2000);
            Thread.sleep(150);
            runWithEncoders(1, 1, -3250, -3250, 4000);
            Thread.sleep(550);
            yl.setPosition(0.20);
            Thread.sleep(1500);
            yl.setPosition(0.636);

        }

        else if (currentVu == RelicRecoveryVuMark.LEFT) { // Vision Target
            stopAndResetEncoders();
            yl.setPosition(0.53); // Magash Half Way UP
            runWithEncoders(1, 1, -3268, -3268, 3000); //Drive To Matritza

            Thread.sleep(100);
            //turning left//
            runWithEncoders(0.8, 0.8, 1190, -1190, 3000);
            Thread.sleep(100);
            // going 35cm forward//
            runWithEncoders(0.85, 0.85, -1237, -1237, 3000);
            Thread.sleep(1000);
            // MAGASH up down two times//
            yl.setPosition(0.20);

            Thread.sleep(1000);
            runWithEncoders(0.5, 0.5, 900, 900, 3000);
            Thread.sleep(150);
            //drive back
            runWithEncoders(0.5, 0.5, -1020, -1020, 3000);
            Thread.sleep(150);
            //Forward
            runWithEncoders(0.3, 0.3, 500, 500, 3000);
            yl.setPosition(0.63);
             }
        else if (currentVu == RelicRecoveryVuMark.RIGHT) { // Vision Target
            stopAndResetEncoders();
            yl.setPosition(0.53); //Magash Half Way UP
            runWithEncoders(0.7, 0.7, -1684, -1684, 3500); // Drive To Matritza
            Thread.sleep(300);
            runWithEncoders(0.5, 0.5, 1045, -1045, 2000); // Turning 90 Left was 1050
            Thread.sleep(300);
            runWithEncoders(0.73, 0.73, -1100, -1100, 3000); // Backing Up to Matritza
            Thread.sleep(300);

            yl.setPosition(0.20); // Magash All The Way UP
            Thread .sleep(1500);
            yl.setPosition(0.636);// Magash All The Way down
            Thread.sleep(150);

            glifs1.setPower(-0.7);
            glifs2.setPower(-1);
            Thread.sleep(100);
            runWithEncoders(1, 1, 3500, 3500, 4000);
           Thread.sleep(100);
           //glifs1.setPower(0);
           // glifs2.setPower(0);
            runWithEncoders(1, 1, -100, 100, 2000);
            Thread.sleep(150);
            runWithEncoders(1, 1, -3250, -3250, 4000);
            Thread.sleep(550);
            yl.setPosition(0.20);



            while (opModeIsActive()) {
                // Use gyro to drive in a straight line.
                correction = checkDirection();

                telemetry.addData("1 imu heading", lastAngles.firstAngle);
                telemetry.addData("2 global heading", globalAngle);
                telemetry.addData("3 correction", correction);
                telemetry.update();

                motorLeftF.setPower(power + correction);
                motorRightF.setPower(power);
                motorRightB.setPower(power);
                motorLeftB.setPower(power + correction);

                // We record the sensor values because we will test them in more than
                // one place with time passing between those places. See the lesson on
                // Timing Considerations to know why.



            }
            // turn the motors off.
            motorRightF.setPower(0);
            motorLeftF.setPower(0);
            motorRightB.setPower(0);
            motorLeftB.setPower(0);

            //runWithGyro(3000);
            Thread.sleep(1000);
            yl.setPosition(0.20);
            Thread.sleep(1000);
            runWithEncoders(1, 1, 500, 500, 1000);

        }




        }

        /*
         * Resets the cumulative angle tracking to zero.
         */

    public void resetAngle() {
        lastAngles = imu.getAngularOrientation(AxesReference.INTRINSIC, AxesOrder.ZYX, AngleUnit.DEGREES);

        globalAngle = 0;
    }

            /**
             * Get current cumulative angle rotation from last reset.
             *
             * @return Angle in degrees. + = left, - = right.
             */
            public double getAngle() {
            // We experimentally determined the Z axis is the axis we want to use for heading angle.
            // We have to process the angle because the imu works in euler angles so the Z axis is
            // returned as 0 to +180 or 0 to -180 rolling back to -179 or +179 when rotation passes
            // 180 degrees. We detect this transition and track the total cumulative angle of rotation.

            Orientation angles = imu.getAngularOrientation(AxesReference.INTRINSIC, AxesOrder.ZYX, AngleUnit.DEGREES);

            double deltaAngle = angles.firstAngle - lastAngles.firstAngle;

            if (deltaAngle < -180)
            deltaAngle += 360;
            else if (deltaAngle > 180)
            deltaAngle -= 360;

            globalAngle += deltaAngle;

            lastAngles = angles;

            return globalAngle;
            }

            /*
             * See if we are moving in a straight line and if not return a power correction value.
             *
             * @return Power adjustment, + is adjust left - is adjust right.
             */
            public double checkDirection() {
            // The gain value determines how sensitive the correction is to direction changes.
            // You will have to experiment with your robot to get small smooth direction changes
            // to stay on a straight line.
            double correction, angle, gain = .10;

            angle = getAngle();

            if (angle == 0)
            correction = 0;             // no adjustment.
            else
            correction = -angle;        // reverse sign of angle for correction.

            correction = correction * gain;

            return correction;
            }

            /*
             * Rotate left or right the number of degrees. Does not support turning more than 180 degrees.
             *
             * @param degrees Degrees to turn, + is left - is right
             */
            public void rotate(int degrees, double power) {
            double leftPower, rightPower;

            // restart imu movement tracking.
            resetAngle();

            // getAngle() returns + when rotating counter clockwise (left) and - when rotating
            // clockwise (right).

            if (degrees < 0) {   // turn right.
            leftPower = -power;
            rightPower = power;
            } else if (degrees > 0) {   // turn left.
            leftPower = power;
            rightPower = -power;
            } else return;

            // set power to rotate.
            motorLeftF.setPower(leftPower);
            motorRightF.setPower(rightPower);
            motorLeftB.setPower(leftPower);
            motorRightB.setPower(rightPower);

            // rotate until turn is completed.
            if (degrees < 0) {
            // On right turn we have to get off zero first.
            while (opModeIsActive() && getAngle() == 0) {
            }

            while (opModeIsActive() && getAngle() > degrees) {
            }
            } else    // left turn.
            while (opModeIsActive() && getAngle() < degrees) {
            }

            // turn the motors off.
            motorRightF.setPower(0);
            motorLeftF.setPower(0);
            motorLeftB.setPower(0);
            motorRightB.setPower(0);
            // wait for rotation to stop.
            sleep(1000);

            // reset angle tracking on new heading.
            resetAngle();
            }


/*
             * Resets the cumulative angle tracking to zero.
             */


        }


//telemetry.addData("Mode", "running");
        //telemetry.update();


        // drive until end of period.

            /*while (opModeIsActive()) {
                // Use gyro to drive in a straight line.
                correction = checkDirection();

                telemetry.addData("1 imu heading", lastAngles.firstAngle);
                telemetry.addData("2 global heading", globalAngle);
                telemetry.addData("3 correction", correction);
                telemetry.update();

                motorLeftF.setPower(-power + correction);
                motorRightF.setPower(-power);
                motorRightB.setPower(-power);
                motorLeftB.setPower(-power + correction);

                // We record the sensor values because we will test them in more than
                // one place with time passing between those places. See the lesson on
                // Timing Considerations to know why.
                long start = System.currentTimeMillis();
                    if ((System.currentTimeMillis() - start) > 4000) {//if the time limit is reached then terminate the command
                        motorRightF.setPower(0);
                        motorLeftF.setPower(0);
                        motorRightB.setPower(0);
                        motorLeftB.setPower(0);
                        glifs2.setPower(0);
                        glifs1.setPower(0);
                        break;
                    }

                    // turn the motors off.
                    //

                }*/





            /*runWithEncoders(0.6, 0.6, -1655, -1655, 3000);

            Thread.sleep(500);
            runWithEncoders(0.55, 0.55, 1190, -1190, 2000); //turning left//
            stopRobot();
            Thread.sleep(500);
            runWithEncoders(0.45, 0.45, -1137, -1137, 3000);// going 35cm forward//
            // MAGASH up down two times//
            Thread.sleep(100);
            yl.setPosition(0.20);
            Thread.sleep(1000);
            runWithEncoders(0.77, 0.77, 900, 900, 3000);
            //drive back
            runWithEncoders(0.6, 0.6, -1020, -1020, 3000);
            //Forward
            runWithEncoders(0.5, 0.5, 500, 500, 3000);
            yl.setPosition(0.63);


        } else {

            stopAndResetEncoders();
            yl.setPosition(0.53);
            runWithEncoders(0.6, 0.6, -2205, -2205, 7000);

            Thread.sleep(500);
            //turning left//
            runWithEncoders(0.55, 0.55, 1250, -1250, 7000);
            Thread.sleep(500);
            // going 35cm forward//
            runWithEncoders(0.6, 0.6, -1237, -1237, 7000);
            // MAGASH up down two times//
            Thread.sleep(100);
            yl.setPosition(0.53);
            Thread.sleep(100);
            yl.setPosition(0.20);
            Thread.sleep(1000);
            runWithEncoders(0.5, 0.5, 900, 900, 7000);
            //drive back
            runWithEncoders(0.5, 0.5, -1020, -1020, 7000);
            //Forward
            runWithEncoders(0.3, 0.3, 500, 500, 7000);
            yl.setPosition(0.63);
                */


        // go backward for 15 cm//
        //runWithEncoders(0.5, 0.5, 500, 500, 2000);
        //Thread.sleep(30);
        // finish with the MAGASH down//
        // yl.setPosition(0.77);
        //Thread.sleep(15);


