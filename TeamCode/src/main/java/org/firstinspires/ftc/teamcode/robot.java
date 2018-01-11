package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

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

//import static android.R.attr.color;


/**
 * Created by user on 02/10/2017.
 */

public abstract class robot extends LinearOpMode {
    public DcMotor motorLeftF;
    public DcMotor motorRightF;
    public DcMotor MotorLeftB;
    public DcMotor MotorRightB;
    public ColorSensor colorSensor;
    public Servo puz;
    public Servo nigger;
    public Servo yl;
    abstract public void runOpMode() throws InterruptedException;

    public static final String TAG = "Vuforia VuMark Sample";

    OpenGLMatrix lastLocation = null;

    VuforiaLocalizer vuforia;



    private final String VUFORIA_KEY_CODE = "AZEdxSX/////AAAAGRJHvDefqkuEg/u6gUdjR7lBp/9/VJUSfF+vyquynu2jWx3A1RFYpuNecs0reL12ivg/g8WUYgMopKOjRIxKoqWmjTUBlrIfDlZkFArLx5nTa7KQOAlbaNPIGr1x1wYx5ChhsB+c/NK3YdOJ4LvQ3lqyDus0FDa3W5kj7xifwGZWQupirVwjEpCxDBu7LCtc/1asHgf5OzjC0qUIajlgZYYn0QXB+rdrQPZ4oiBysidFNigDqyQOcFpmL0clUnEVCQ35UjZRmjqYjKzzLXGLzY/jbbsfuwEDuSykOMwS8i5dpHIQFs+CSWSjJHn+nD/TDPY70FDqBZMEOgiP+pUOLXd2SL7FJSaWcOxw7qspEHgQ\n";
    public void stopRobot(){//will stop the robot
       motorLeftF.setPower(0);
       motorRightF.setPower(0);
        MotorLeftB.setPower(0);
        MotorRightB.setPower(0);
    }
    public void resetEncoders(){//will reset encoders
        motorLeftF.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motorRightF.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        MotorLeftB.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        MotorRightB.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }
    public void stopAndResetEncoders(){//will do both
        stopRobot();
        resetEncoders();
    }
    public void runUsingEncoders(){
        //motorLeftF.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        //motorRightF.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }
    public void runWithoutEncoders(){
        //motorLeftF.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        //motorRightF.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    }


    public void runWithEncoders(
            double LEFT_MOTOR_POWER, double RIGHT_MOTOR_POWER, int LEFT_MOTOR_ENCODER, int RIGHT_MOTOR_ENCODER, int TIME) throws InterruptedException {
        double ticksForCM = 1;
        LEFT_MOTOR_ENCODER = (int)(LEFT_MOTOR_ENCODER*ticksForCM);
        RIGHT_MOTOR_ENCODER = (int)(RIGHT_MOTOR_ENCODER*ticksForCM);
        if (opModeIsActive()) {
            runUsingEncoders();
            resetEncoders();//resets the motors
            Thread.sleep(50);
           motorLeftF.setTargetPosition(LEFT_MOTOR_ENCODER);
            motorRightF.setTargetPosition(RIGHT_MOTOR_ENCODER);//set position for the motors
            MotorLeftB.setTargetPosition(LEFT_MOTOR_ENCODER);
            MotorRightB.setTargetPosition(RIGHT_MOTOR_ENCODER);


           motorLeftF.setMode(DcMotor.RunMode.RUN_TO_POSITION);
           motorRightF.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            MotorRightB.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            MotorLeftB.setMode(DcMotor.RunMode.RUN_TO_POSITION);

            Thread.sleep(50);
           motorLeftF.setPower(LEFT_MOTOR_POWER);//sets the speed
           motorRightF.setPower(RIGHT_MOTOR_POWER);
           MotorRightB.setPower(RIGHT_MOTOR_POWER);
            MotorLeftB.setPower(RIGHT_MOTOR_POWER);

            long start = System.currentTimeMillis();
            while (MotorLeftB.isBusy() || MotorRightB.isBusy()) {
                Thread.sleep(30);//while teleOP keep going
                telemetry.addLine("leftPos:" + MotorLeftB.getCurrentPosition() + " rightPos: " + MotorRightB.getCurrentPosition());
                telemetry.addLine("motorLeftF: " + MotorLeftB.isBusy() + " motorRightF :" + MotorRightB.isBusy());
                telemetry.update();
                if ((System.currentTimeMillis() - start) > TIME) {//if the time limit is reached then terminate the command
                   break;
                }

            }

        }
        stopAndResetEncoders();
        runWithoutEncoders();
    }

    public void initRobot(){
        //cnfig
        //the name of the configuration
        motorLeftF =hardwareMap.dcMotor.get("motorLeftF");
        motorRightF =hardwareMap.dcMotor.get("motorRightF");
        MotorLeftB = hardwareMap.dcMotor.get("MotorLeftB");
        MotorRightB = hardwareMap.dcMotor.get("MotorRightB");
        puz= hardwareMap.servo.get("puz");
        nigger= hardwareMap.servo.get("nigger");
        colorSensor = hardwareMap.colorSensor.get("color");
        yl = hardwareMap.servo.get("yl");
    }

    public RelicRecoveryVuMark vision() throws InterruptedException {
        int cameraMonitorViewId = hardwareMap.appContext.getResources().getIdentifier("cameraMonitorViewId", "id", hardwareMap.appContext.getPackageName());
        VuforiaLocalizer.Parameters parameters = new VuforiaLocalizer.Parameters(cameraMonitorViewId);

        parameters.vuforiaLicenseKey = "AZEdxSX/////AAAAGRJHvDefqkuEg/u6gUdjR7lBp/9/VJUSfF+vyquynu2jWx3A1RFYpuNecs0reL12ivg/g8WUYgMopKOjRIxKoqWmjTUBlrIfDlZkFArLx5nTa7KQOAlbaNPIGr1x1wYx5ChhsB+c/NK3YdOJ4LvQ3lqyDus0FDa3W5kj7xifwGZWQupirVwjEpCxDBu7LCtc/1asHgf5OzjC0qUIajlgZYYn0QXB+rdrQPZ4oiBysidFNigDqyQOcFpmL0clUnEVCQ35UjZRmjqYjKzzLXGLzY/jbbsfuwEDuSykOMwS8i5dpHIQFs+CSWSjJHn+nD/TDPY70FDqBZMEOgiP+pUOLXd2SL7FJSaWcOxw7qspEHgQ\n";
        parameters.cameraDirection = VuforiaLocalizer.CameraDirection.BACK;
        this.vuforia = ClassFactory.createVuforiaLocalizer(parameters);

        VuforiaTrackables relicTrackables = this.vuforia.loadTrackablesFromAsset("RelicVuMark");
        VuforiaTrackable relicTemplate = relicTrackables.get(0);
        relicTemplate.setName("relicVuMarkTemplate"); // can help in debugging; otherwise not necessary

        telemetry.addData(">", "Press Play to start");
        telemetry.update();

        relicTrackables.activate();
        Thread.sleep(2500);
        RelicRecoveryVuMark vuMark = RelicRecoveryVuMark.from(relicTemplate);

        if (vuMark != RelicRecoveryVuMark.UNKNOWN) {

            /* Found an instance of the template. In the actual game, you will probably
             * loop until this condition occurs, then move on to act accordingly depending
             * on which VuMark was visible. */
            telemetry.addData("VuMark", "%s visible", vuMark);

            /* For fun, we also exhibit the navigational pose. In the Relic Recovery game,
             * it is perhaps unlikely that you will actually need to act on this pose information, but
             * we illustrate it nevertheless, for completeness. */
            OpenGLMatrix pose = ((VuforiaTrackableDefaultListener)relicTemplate.getListener()).getPose();
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
        }
        else {
            telemetry.addData("VuMark", "not visible");
        }

        telemetry.update();
        return vuMark;

    }

    String format(OpenGLMatrix transformationMatrix) {
        return (transformationMatrix != null) ? transformationMatrix.formatAsTransform() : "null";
    }

}

