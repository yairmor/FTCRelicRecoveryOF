package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;
import org.firstinspires.ftc.robotcore.external.navigation.RelicRecoveryVuMark;


/**
 * Created by user on 10/12/2017.
 */

@Autonomous (name = "RedTeamRightAngle")
public class RedTeamRightAngle extends robot {


    @Override
    public void runOpMode() throws InterruptedException {
        initRobot();
        GlifServo("DOWN");
        initVuforia();

        Elev.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        Elev.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        initgyro();

        stopAndResetEncoders();
        telemetry.addData("12363 ", "Good Luck Robot");
        telemetry.update();
        waitForStart();
        telemetry.addData("Elev", Elev.getCurrentPosition());
        telemetry.update();
        //initVuforia();
        Flip.setPosition(0.53);


        ballX.setPosition(0.69);
        Thread.sleep(1000);
        ballY.setPosition(0.13);
        Thread.sleep(1000);
        Kadorim("RED");
        /*if (colorSensor.red() > 47) {
            ballX.setPosition(0.85);
        } else {
            ballX.setPosition(0.35);
        }
*/
        ballX.setPosition(0.69);
        ballY.setPosition(0.71);
        Flip.setPosition(0.53); //Magash Half Way UP


        RelicRecoveryVuMark currentVu = vision();
        if (currentVu == RelicRecoveryVuMark.CENTER) {
            stopAndResetEncoders();
            Flip.setPosition(0.53); //Magash Half Way UP
            runWithEncoders(1, 1, -2500, -2500, 2000); // Drive To Matritza
            Thread.sleep(300);
            runWithEncoders(0.57, 0.57, 1150, -1150, 1000); // Turning 90 Left was 1050
            Thread.sleep(300);
            runWithEncoders(0.8, 0.8, -1200, -1200, 3000); // Backing Up to Matritza
            Thread.sleep(300);
            GlifServo("UP");
            Flip.setPosition(0.20); // Magash All The Way UP
            Thread.sleep(1500);
            Flip.setPosition(0.65);// Magash All The Way down
            Thread.sleep(150);
            //Isof glifs and put in place

            Thread.sleep(100);
            resetAngle();
            Thread.sleep(100);
            glifsLeft.setPower(1);
            glifsRight.setPower(1);
            runWithGyro(600, 0.8, "FORWARD");
            Thread.sleep(100);
            runWithGyro(2000, 0.8, "FORWARD");
            glifonator(500);

            if (NumCube == 2) {

            } else {
                Thread.sleep(100);
                runWithGyro(400, .8, "REVERSE");
                Thread.sleep(100);
                runWithGyro(900, .8, "FORWARD");
                Thread.sleep(100);
                glifonator(700);

            }
            if (NumCube == 2) {

            } else {
                Thread.sleep(100);
                runWithGyro(400, .8, "REVERSE");
                Thread.sleep(100);
                runWithGyro(900, .8, "FORWARD");
                Thread.sleep(100);
                glifonator(700);
            }
            /*runWithEncoders(1, 1, 2000, 2000, 4000);
            Thread.sleep(150);
            runWithEncoders(0.76, 0.76, 2000, 2000, 3000);
            Thread.sleep(150);
            runWithEncoders(1, 1, -750, -750, 4000);
            Thread.sleep(150);
            runWithEncoders(0.8, 0.8, 1500, 1500, 1000);
            Thread.sleep(100);
            runWithEncoders(0.8, 0.8, -5000, -5000, 4000);
            */
            runWithGyro(2300, .8, "REVERSE");
            Thread.sleep(150);
            runWithEncoders(1, 1, 200, 200, 1000);
            Flip.setPosition(0.53);
            //runWithEncoders(0.8, 0.8, -3250, -3250, 4000);
            Elev.setTargetPosition(1100);
            Elev.setPower(1);
            Thread.sleep(100);
            runWithEncoders(1, 1, -100, -100, 600);
            Thread.sleep(550);
            Flip.setPosition(0.20);
            Thread.sleep(150);
            runWithEncoders(1, 1, -100, -100, 500);
            Thread.sleep(100);
            runWithEncoders(1, 1, 620, 620, 1000);
            Elev.setTargetPosition(-300);
            glifsLeft.setPower(0);
            glifsRight.setPower(0);
            Flip.setPosition(0.636);


        } else if (currentVu == RelicRecoveryVuMark.LEFT) { // Vision Target
            stopAndResetEncoders();
            Flip.setPosition(0.53); //Magash Half Way UP
            runWithEncoders(1, 1, -3070, -3070, 2000); // Drive To Matritza
            Thread.sleep(300);
            runWithEncoders(0.57, 0.57, 1160, -1160, 1000); // Turning 90 Left was
            Thread.sleep(300);
            runWithEncoders(0.8, 0.8, -1200, -1200, 2000); // Backing Up to Matritza
            Thread.sleep(300);
            GlifServo("UP");
            Flip.setPosition(0.20); // Magash All The Way UP
            Thread.sleep(1500);
            Flip.setPosition(0.636);// Magash All The Way down
            //Isof glifs and put in place

            Thread.sleep(100);
            resetAngle();
            Thread.sleep(100);
            glifsLeft.setPower(1);
            glifsRight.setPower(1);
            runWithGyro(600, 0.8, "FORWARD");
            Thread.sleep(100);
            runWithGyro(2000, 0.8, "FORWARD");
            glifonator(500);

            if (NumCube == 2) {

            } else {
                Thread.sleep(100);
                runWithGyro(400, .8, "REVERSE");
                Thread.sleep(100);
                runWithGyro(1300, .8, "FORWARD");
                Thread.sleep(100);
                glifonator(700);

            }
            if (NumCube == 2) {

            } else {
                Thread.sleep(100);
                runWithGyro(400, .8, "REVERSE");
                Thread.sleep(100);
                runWithGyro(900, .8, "FORWARD");
                Thread.sleep(100);
                glifonator(700);
            }
            /*runWithEncoders(1, 1, 2000, 2000, 4000);
            Thread.sleep(150);
            runWithEncoders(0.76, 0.76, 2000, 2000, 3000);
            Thread.sleep(150);
            runWithEncoders(1, 1, -750, -750, 4000);
            Thread.sleep(150);
            runWithEncoders(0.8, 0.8, 1500, 1500, 1000);
            Thread.sleep(100);
            runWithEncoders(0.8, 0.8, -5000, -5000, 4000);
            */
            runWithGyro(2300, .8, "REVERSE");
            Thread.sleep(150);
            runWithEncoders(1, 1, 200, 200, 1000);
            Flip.setPosition(0.53);
            //runWithEncoders(0.8, 0.8, -3250, -3250, 4000);
            Elev.setTargetPosition(1100);
            Elev.setPower(1);
            Thread.sleep(100);
            runWithEncoders(1, 1, -100, -100, 600);
            Thread.sleep(550);
            Flip.setPosition(0.20);
            Thread.sleep(150);
            runWithEncoders(1, 1, -100, -100, 500);
            Thread.sleep(100);
            runWithEncoders(1, 1, 620, 620, 1000);
            Elev.setTargetPosition(-300);
            glifsLeft.setPower(0);
            glifsRight.setPower(0);
            Flip.setPosition(0.636);


        } else if (currentVu == RelicRecoveryVuMark.RIGHT) { // Vision Target
            stopAndResetEncoders();
            Flip.setPosition(0.53); //Magash Half Way UP
            runWithEncoders(1, 1, -2000, -2000, 3500); // Drive To Matritza
            Thread.sleep(300);
            runWithEncoders(0.57, 0.57, 1250, -1250, 2000); // Turning 90 Left was 1050
            Thread.sleep(300);
            runWithEncoders(0.9, 0.9, -1300, -1300, 3000); // Backing Up to Matritza
            Thread.sleep(300);
            GlifServo("UP");

            Flip.setPosition(0.20); // Magash All The Way UP
            Thread.sleep(1500);
            Flip.setPosition(0.636);// Magash All The Way down
            Thread.sleep(150);
            //Isof glifs and put in place

            Thread.sleep(100);
            resetAngle();
            Thread.sleep(100);
            glifsLeft.setPower(1);
            glifsRight.setPower(1);
            runWithGyro(600, 0.8, "FORWARD");
            Thread.sleep(100);
            runWithGyro(2000, 0.8, "FORWARD");
            glifonator(500);

            if (NumCube == 2) {

            } else {
                Thread.sleep(100);
                runWithGyro(400, .8, "REVERSE");
                Thread.sleep(100);
                runWithGyro(1300, .8, "FORWARD");
                Thread.sleep(100);
                glifonator(700);

            }
            if (NumCube == 2) {

            } else {
                Thread.sleep(100);
                runWithGyro(400, .8, "REVERSE");
                Thread.sleep(100);
                runWithGyro(900, .8, "FORWARD");
                Thread.sleep(100);
                glifonator(700);
            }
            //runWithEncoders(1, 1, 2000, 2000, 4000);
            //Thread.sleep(150);
            //runWithEncoders(0.76, 0.76, 2000, 2000, 3000);
            //Thread.sleep(150);
            //runWithEncoders(1, 1, -750, -750, 4000);
            //Thread.sleep(150);
            //runWithEncoders(0.8, 0.8, 1500, 1500, 1000);
            //Thread.sleep(100);
            //runWithEncoders(0.8, 0.8, -5000, -5000, 4000);

            runWithGyro(2300, .8, "REVERSE");
            Thread.sleep(150);
            runWithEncoders(1, 1, 200, 200, 1000);
            Flip.setPosition(0.53);
            //runWithEncoders(0.8, 0.8, -3250, -3250, 4000);
            Elev.setTargetPosition(1100);
            Elev.setPower(1);
            Thread.sleep(100);
            runWithEncoders(1, 1, -100, -100, 600);
            Thread.sleep(550);
            Flip.setPosition(0.20);
            Thread.sleep(150);
            runWithEncoders(1, 1, -100, -100, 500);
            Thread.sleep(100);
            runWithEncoders(1, 1, 620, 620, 1000);
            Elev.setTargetPosition(-300);
            glifsLeft.setPower(0);
            glifsRight.setPower(0);
            Flip.setPosition(0.636);


        } else {

            stopAndResetEncoders();
            Flip.setPosition(0.53); //Magash Half Way UP
            runWithEncoders(1, 1, -2500, -2500, 2000); // Drive To Matritza
            Thread.sleep(300);
            runWithEncoders(0.57, 0.57, 1150, -1150, 1000); // Turning 90 Left was 1050
            Thread.sleep(300);
            runWithEncoders(0.8, 0.8, -1200, -1200, 3000); // Backing Up to Matritza
            Thread.sleep(300);
            GlifServo("UP");
            Flip.setPosition(0.20); // Magash All The Way UP
            Thread.sleep(1500);
            Flip.setPosition(0.65);// Magash All The Way down
            Thread.sleep(150);
            //Isof glifs and put in place

            Thread.sleep(100);
            resetAngle();
            Thread.sleep(100);
            glifsLeft.setPower(1);
            glifsRight.setPower(1);
            runWithGyro(600, 0.8, "FORWARD");
            Thread.sleep(100);
            runWithGyro(2000, 0.8, "FORWARD");
            glifonator(500);

            if (NumCube == 2) {

            } else {
                Thread.sleep(100);
                runWithGyro(400, .8, "REVERSE");
                Thread.sleep(100);
                runWithGyro(1300, .8, "FORWARD");
                Thread.sleep(100);
                glifonator(700);

            }
            if (NumCube == 2) {

            } else {
                Thread.sleep(100);
                runWithGyro(400, .8, "REVERSE");
                Thread.sleep(100);
                runWithGyro(900, .8, "FORWARD");
                Thread.sleep(100);
                glifonator(700);
            }
            /*runWithEncoders(1, 1, 2000, 2000, 4000);
            Thread.sleep(150);
            runWithEncoders(0.76, 0.76, 2000, 2000, 3000);
            Thread.sleep(150);
            runWithEncoders(1, 1, -750, -750, 4000);
            Thread.sleep(150);
            runWithEncoders(0.8, 0.8, 1500, 1500, 1000);
            Thread.sleep(100);
            runWithEncoders(0.8, 0.8, -5000, -5000, 4000);
            */
            runWithGyro(2300, .8, "REVERSE");
            Thread.sleep(150);
            runWithEncoders(1, 1, 200, 200, 1000);
            Flip.setPosition(0.53);
            //runWithEncoders(0.8, 0.8, -3250, -3250, 4000);
            Elev.setTargetPosition(1100);
            Elev.setPower(1);
            Thread.sleep(100);
            runWithEncoders(1, 1, -100, -100, 600);
            Thread.sleep(550);
            Flip.setPosition(0.20);
            Thread.sleep(150);
            runWithEncoders(1, 1, -100, -100, 500);
            Thread.sleep(100);
            runWithEncoders(1, 1, 620, 620, 1000);
            Elev.setTargetPosition(-300);
            glifsLeft.setPower(0);
            glifsRight.setPower(0);
            Flip.setPosition(0.636);


        }
    }

           /* while (opModeIsActive()) {
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
*/
        //runWithGyro(3000);



        /*

        glifsLeft.setPower(-0.7);
        glifsRight.setPower(-1);
        Thread.sleep(100);
        runWithEncoders(0.8, 0.8, 3700, 3700, 3000);
        Thread.sleep(500);
        //glifsLeft.setPower(0);
        // glifsRight.setPower(0);
        //runWithEncoders(1, 1, -95, 95, 2000);
        Thread.sleep(150);
        runWithEncoders(0.8, 0.8, -3250, -3250, 4000);
        Thread.sleep(550);
        Flip.setPosition(0.20);
        Thread.sleep(1500);
        Flip.setPosition(0.636);



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
                        glifsRight.setPower(0);
                        glifsLeft.setPower(0);
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
            Flip.setPosition(0.20);
            Thread.sleep(1000);
            runWithEncoders(0.77, 0.77, 900, 900, 3000);
            //drive back
            runWithEncoders(0.6, 0.6, -1020, -1020, 3000);
            //Forward
            runWithEncoders(0.5, 0.5, 500, 500, 3000);
            Flip.setPosition(0.63);


        } else {

            stopAndResetEncoders();
            Flip.setPosition(0.53);
            runWithEncoders(0.6, 0.6, -2205, -2205, 7000);

            Thread.sleep(500);
            //turning left//
            runWithEncoders(0.55, 0.55, 1250, -1250, 7000);
            Thread.sleep(500);
            // going 35cm forward//
            runWithEncoders(0.6, 0.6, -1237, -1237, 7000);
            // MAGASH up down two times//
            Thread.sleep(100);
            Flip.setPosition(0.53);
            Thread.sleep(100);
            Flip.setPosition(0.20);
            Thread.sleep(1000);
            runWithEncoders(0.5, 0.5, 900, 900, 7000);
            //drive back
            runWithEncoders(0.5, 0.5, -1020, -1020, 7000);
            //Forward
            runWithEncoders(0.3, 0.3, 500, 500, 7000);
            Flip.setPosition(0.63);
                */


        // go backward for 15 cm//
        //runWithEncoders(0.5, 0.5, 500, 500, 2000);
        //Thread.sleep(30);
        // finish with the MAGASH down//
        // Flip.setPosition(0.77);
        //Thread.sleep(15);


