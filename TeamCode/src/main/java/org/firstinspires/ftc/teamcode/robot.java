package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.robotcore.external.navigation.Quaternion;


import org.firstinspires.ftc.robotcore.external.ClassFactory;
import org.firstinspires.ftc.robotcore.external.Func;
import org.firstinspires.ftc.robotcore.external.matrices.OpenGLMatrix;
import org.firstinspires.ftc.robotcore.external.matrices.VectorF;
import org.firstinspires.ftc.robotcore.external.navigation.Acceleration;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;
import org.firstinspires.ftc.robotcore.external.navigation.RelicRecoveryVuMark;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackable;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackableDefaultListener;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackables;


import java.sql.Time;
import java.util.Locale;

//import static android.R.attr.color;


/**
 * Created by user on 02/10/2017.
 */

public abstract class robot extends LinearOpMode {
    public DcMotor motorLeftF;
    public DcMotor motorRightF;
    public DcMotor motorLeftB;
    public DcMotor motorRightB;
    public ColorSensor colorSensor;
    public DistanceSensor Distance;

    public ColorSensor ColorDistance;


    //public DistanceSensor Distance;
    public Servo ballY;
    public Servo ballX;
    public Servo yl;
    public DcMotor glifs1;
    public DcMotor glifs2;
    public BNO055IMU imu;
    public String Column;
    public Orientation angles;
    public Acceleration gravity;
    public RelicRecoveryVuMark vuMark;
    public Orientation lastAngles = new Orientation();
    public double globalAngle, power = 0.6, correction;
    public VuforiaLocalizer vuforiaLocalizer;
    public VuforiaLocalizer.Parameters parameters;
    public VuforiaTrackables visionTargets;
    public VuforiaTrackable target;
    public VuforiaTrackableDefaultListener listener;
    public OpenGLMatrix lastKnownLocation;
    public OpenGLMatrix phoneLocation;
    public Boolean CheckColumn = false;


    static final String VUFORIA_KEY = ""; // Insert your own key here

    float robotX = 0;
    float robotY = 0;
    float robotAngle = 0;

    // abstract public void runOpMode() throws InterruptedException;

    public static final String TAG = "Vuforia VuMark Sample";

    OpenGLMatrix lastLocation = null;

    VuforiaLocalizer vuforia;
    VuforiaTrackables relicTrackables;
    VuforiaTrackable relicTemplate;

    String formatAngle(AngleUnit angleUnit, double angle) {
        return formatDegrees(AngleUnit.DEGREES.fromUnit(angleUnit, angle));
    }

    String formatDegrees(double degrees) {
        return String.format(Locale.getDefault(), "%.1f", AngleUnit.DEGREES.normalize(degrees));
    }

    public void RunUsingMyEncders(int enc, int pwr) {
        motorLeftF.setTargetPosition(enc);
        motorRightF.setTargetPosition(enc);
        motorRightB.setTargetPosition(enc);
        motorLeftB.setTargetPosition(enc);

        motorLeftF.setPower(pwr);
        motorRightF.setPower(pwr);
        motorRightB.setPower(pwr);
        motorLeftB.setPower(pwr);
        while (motorRightB.isBusy() || motorLeftF.isBusy()) {

            telemetry.addLine("leftPos:" + motorLeftB.getCurrentPosition() + " rightPos: " + motorRightB.getCurrentPosition());
            telemetry.addLine("motorLeftB: " + motorLeftB.isBusy() + " motorRightB :" + motorRightB.isBusy());
            telemetry.addLine("leftPos:" + motorLeftF.getCurrentPosition() + " rightPos: " + motorRightF.getCurrentPosition());
            telemetry.addLine("motorLeftF: " + motorLeftF.isBusy() + " motorRightF :" + motorRightF.isBusy());
            telemetry.update();
        }
    }

    private final String VUFORIA_KEY_CODE = "AZEdxSX/////AAAAGRJHvDefqkuEg/u6gUdjR7lBp/9/VJUSfF+vyquynu2jWx3A1RFYpuNecs0reL12ivg/g8WUYgMopKOjRIxKoqWmjTUBlrIfDlZkFArLx5nTa7KQOAlbaNPIGr1x1wYx5ChhsB+c/NK3YdOJ4LvQ3lqyDus0FDa3W5kj7xifwGZWQupirVwjEpCxDBu7LCtc/1asHgf5OzjC0qUIajlgZYYn0QXB+rdrQPZ4oiBysidFNigDqyQOcFpmL0clUnEVCQ35UjZRmjqYjKzzLXGLzY/jbbsfuwEDuSykOMwS8i5dpHIQFs+CSWSjJHn+nD/TDPY70FDqBZMEOgiP+pUOLXd2SL7FJSaWcOxw7qspEHgQ\n";

    public void stopRobot() {//will stop the robot
        motorLeftF.setPower(0);
        motorRightF.setPower(0);
        motorLeftB.setPower(0);
        motorRightB.setPower(0);
    }

    public void setImu() {
        while (!isStopRequested() && !imu.isGyroCalibrated()) {
            sleep(50);
            idle();
        }

        telemetry.addAction(new Runnable() {
            @Override
            public void run() {
                // Acquiring the angles is relatively expensive; we don't want
                // to do that in each of the three items that need that info, as that's
                // three times the necessary expense.
                angles = imu.getAngularOrientation(AxesReference.INTRINSIC, AxesOrder.ZYX, AngleUnit.DEGREES);
                gravity = imu.getGravity();
            }
        });

        telemetry.addLine()
                .addData("status", new Func<String>() {
                    @Override
                    public String value() {
                        return imu.getSystemStatus().toShortString();
                    }
                })
                .addData("calib", new Func<String>() {
                    @Override
                    public String value() {
                        return imu.getCalibrationStatus().toString();
                    }
                });

        telemetry.addLine()
                .addData("Z", new Func<String>() {
                    @Override
                    public String value() {
                        return formatAngle(angles.angleUnit, angles.firstAngle);
                    }
                })
                .addData("Y", new Func<String>() {
                    @Override
                    public String value() {
                        return formatAngle(angles.angleUnit, angles.secondAngle);
                    }
                })
                .addData("X", new Func<String>() {
                    @Override
                    public String value() {
                        return formatAngle(angles.angleUnit, angles.thirdAngle);
                    }
                });

        telemetry.addLine()
                .addData("grvty", new Func<String>() {
                    @Override
                    public String value() {
                        return gravity.toString();
                    }
                })
                .addData("mag", new Func<String>() {
                    @Override
                    public String value() {
                        return String.format(Locale.getDefault(), "%.3f",
                                Math.sqrt(gravity.xAccel * gravity.xAccel
                                        + gravity.yAccel * gravity.yAccel
                                        + gravity.zAccel * gravity.zAccel));
                    }
                });
        telemetry.update();

    }

    public void resetEncoders() {//will reset encoders
        motorLeftF.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motorRightF.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motorLeftB.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motorRightB.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }

    public void stopAndResetEncoders() {//will do both
        stopRobot();
        resetEncoders();
    }

    public void runUsingEncoders() {
        motorLeftF.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motorRightF.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motorLeftB.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motorRightB.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

    }

    public void runWithoutEncoders() {
        //motorLeftF.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        //motorRightF.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    }

    public void runWithEncoders(
            double LEFT_MOTOR_POWER, double RIGHT_MOTOR_POWER, int LEFT_MOTOR_ENCODER, int RIGHT_MOTOR_ENCODER, int TIME) throws InterruptedException {
        double ticksForCM = 1;
        LEFT_MOTOR_ENCODER = (int) (LEFT_MOTOR_ENCODER * ticksForCM);
        RIGHT_MOTOR_ENCODER = (int) (RIGHT_MOTOR_ENCODER * ticksForCM);
        if (opModeIsActive()) {
            runUsingEncoders();
            resetEncoders();//resets the motors
            Thread.sleep(50);
            motorLeftF.setTargetPosition(LEFT_MOTOR_ENCODER);
            motorRightF.setTargetPosition(RIGHT_MOTOR_ENCODER);//set position for the motors
            motorLeftB.setTargetPosition(LEFT_MOTOR_ENCODER);
            motorRightB.setTargetPosition(RIGHT_MOTOR_ENCODER);


            motorLeftF.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            motorRightF.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            motorRightB.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            motorLeftB.setMode(DcMotor.RunMode.RUN_TO_POSITION);

            Thread.sleep(50);
            motorLeftF.setPower(LEFT_MOTOR_POWER);//sets the speed
            motorRightF.setPower(RIGHT_MOTOR_POWER);
            motorRightB.setPower(RIGHT_MOTOR_POWER);
            motorLeftB.setPower(RIGHT_MOTOR_POWER);

            long start = System.currentTimeMillis();
            while (motorLeftB.isBusy() || motorRightB.isBusy()) {
                Thread.sleep(30);//while teleOP keep going
                telemetry.addLine("leftPos:" + motorLeftB.getCurrentPosition() + " rightPos: " + motorRightB.getCurrentPosition());
                telemetry.addLine("motorLeftB: " + motorLeftB.isBusy() + " motorRightB :" + motorRightB.isBusy());
                telemetry.addLine("leftPos:" + motorLeftF.getCurrentPosition() + " rightPos: " + motorRightF.getCurrentPosition());
                telemetry.addLine("motorLeftF: " + motorLeftF.isBusy() + " motorRightF :" + motorRightF.isBusy());
                telemetry.update();
                if ((System.currentTimeMillis() - start) > TIME) {//if the time limit is reached then terminate the command
                    break;
                }
            }

        }
        stopAndResetEncoders();
        runWithoutEncoders();

    }
    //public void runMotorForTime(DcMotor motor, int milisec, double power) throws InterruptedException{
    //activates the motors for set amount of mili seconds
    //will run a motor for per amount of seconds
    //motor.setPower(power);
    //Thread.sleep(milisec);
    // motor.setPower(0);}

    public void initRobot() {
        //cnfig
        //the name of the configuration
        motorLeftF = hardwareMap.dcMotor.get("motorLeftF");
        motorRightF = hardwareMap.dcMotor.get("motorRightF");
        motorLeftB = hardwareMap.dcMotor.get("motorLeftB");
        motorRightB = hardwareMap.dcMotor.get("motorRightB");
        ballY = hardwareMap.servo.get("ballY");
        ballX = hardwareMap.servo.get("ballX");
        colorSensor = hardwareMap.colorSensor.get("color");
        Distance = hardwareMap.get(DistanceSensor.class, "range");
        ColorDistance = hardwareMap.get(ColorSensor.class, "range");
        yl = hardwareMap.servo.get("yl");
        glifs1 = hardwareMap.dcMotor.get("glifs1");
        glifs2 = hardwareMap.dcMotor.get("glifs2");
        glifs2.setDirection(DcMotor.Direction.REVERSE);
        glifs1.setDirection(DcMotor.Direction.FORWARD);
        motorLeftF.setDirection(DcMotorSimple.Direction.REVERSE);
        motorLeftB.setDirection(DcMotorSimple.Direction.REVERSE);


    }

    void initVuforia() {
        int cameraMonitorViewId = hardwareMap.appContext.getResources().getIdentifier("cameraMonitorViewId", "id", hardwareMap.appContext.getPackageName());
        VuforiaLocalizer.Parameters parameters = new VuforiaLocalizer.Parameters(cameraMonitorViewId);

        parameters.vuforiaLicenseKey = "AZEdxSX/////AAAAGRJHvDefqkuEg/u6gUdjR7lBp/9/VJUSfF+vyquynu2jWx3A1RFYpuNecs0reL12ivg/g8WUYgMopKOjRIxKoqWmjTUBlrIfDlZkFArLx5nTa7KQOAlbaNPIGr1x1wYx5ChhsB+c/NK3YdOJ4LvQ3lqyDus0FDa3W5kj7xifwGZWQupirVwjEpCxDBu7LCtc/1asHgf5OzjC0qUIajlgZYYn0QXB+rdrQPZ4oiBysidFNigDqyQOcFpmL0clUnEVCQ35UjZRmjqYjKzzLXGLzY/jbbsfuwEDuSykOMwS8i5dpHIQFs+CSWSjJHn+nD/TDPY70FDqBZMEOgiP+pUOLXd2SL7FJSaWcOxw7qspEHgQ\n";
        parameters.cameraDirection = VuforiaLocalizer.CameraDirection.BACK;
        this.vuforia = ClassFactory.createVuforiaLocalizer(parameters);

        relicTrackables = this.vuforia.loadTrackablesFromAsset("RelicVuMark");
        relicTemplate = relicTrackables.get(0);
        relicTemplate.setName("relicVuMarkTemplate"); // can help in debugging; otherwise not necessary

        telemetry.addData("12363 ", "Good Luck Robot");
        telemetry.update();

    }

    public RelicRecoveryVuMark vision() throws InterruptedException {

        relicTrackables.activate();
        Thread.sleep(1500);
        RelicRecoveryVuMark vuMark = RelicRecoveryVuMark.from(relicTemplate);

        if (vuMark != RelicRecoveryVuMark.UNKNOWN) {

            /* Found an instance of the template. In the actual game, you will probably
             * loop until this condition occurs, then move on to act accordingly depending
             * on which VuMark was visible. */
            telemetry.addData("VuMark", "%s visible", vuMark);

            /* For fun, we also exhibit the navigational pose. In the Relic Recovery game,
             * it is perhaps unlikely that you will actually need to act on this pose information, but
             * we illustrate it nevertheless, for completeness. */
            OpenGLMatrix pose = ((VuforiaTrackableDefaultListener) relicTemplate.getListener()).getPose();
            telemetry.addData("Pose", format(pose));

            if (pose != null) {
                VectorF trans = pose.getTranslation();
                Orientation rot = Orientation.getOrientation(pose, AxesReference.EXTRINSIC, AxesOrder.XYZ, AngleUnit.DEGREES);

                double tX = trans.get(0);
                double tY = trans.get(1);
                double tZ = trans.get(1);

                double rX = rot.firstAngle;
                double rY = rot.secondAngle;
                double rZ = rot.thirdAngle;
            }
        } else {
            telemetry.addData("VuMark", "not visible");
        }

        telemetry.update();
        return vuMark;
    }

    String format(OpenGLMatrix transformationMatrix) {
        return (transformationMatrix != null) ? transformationMatrix.formatAsTransform() : "null";
    }


    public void runWithGyro(int Time) {
        if(opModeIsActive()){
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
            while (motorLeftB.isBusy() || motorRightB.isBusy()) {
                telemetry.addLine("leftPos:" + motorLeftB.getCurrentPosition() + " rightPos: " + motorRightB.getCurrentPosition());
                telemetry.addLine("motorLeftB: " + motorLeftB.isBusy() + " motorRightB :" + motorRightB.isBusy());
                telemetry.addLine("leftPos:" + motorLeftF.getCurrentPosition() + " rightPos: " + motorRightF.getCurrentPosition());
                telemetry.addLine("motorLeftF: " + motorLeftF.isBusy() + " motorRightF :" + motorRightF.isBusy());
                telemetry.update();
                if ((System.currentTimeMillis() - start) > Time) {//if the time limit is reached then terminate the command
                    break;
                }

                // turn the motors off.
                motorRightF.setPower(0);
                motorLeftF.setPower(0);
                motorRightB.setPower(0);
                motorLeftB.setPower(0);
            }
        }
    }

    /**
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

    /**
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

    /**
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


    /**
     * Resets the cumulative angle tracking to zero.
     */


    public void glifonator(int Time) throws InterruptedException {
        long start = System.currentTimeMillis();
        runWithEncoders(1,1,1000,1000,2000);
        while (opModeIsActive()) {
        telemetry.addData("Distance (cm)",
                String.format(Locale.US, "%.02f", Distance.getDistance(DistanceUnit.CM)));
        telemetry.update();
        if (Distance.getDistance(DistanceUnit.CM) > 1)
        {
            glifs1.setPower(0);
            glifs2.setPower(0);

        }else {
            glifs2.setPower(-1);
            glifs1.setPower(-1);

        }
        if ((System.currentTimeMillis() - start) > Time) {//if the time limit is reached then terminate the command
                    glifs1.setPower(0);
                    glifs2.setPower(0);
                    break;
                }
            }
        }
    }
