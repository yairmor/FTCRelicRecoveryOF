package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

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

}

