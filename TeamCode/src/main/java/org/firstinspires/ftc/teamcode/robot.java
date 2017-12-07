package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import org.firstinspires.ftc.robotcore.external.Telemetry;

//import static android.R.attr.color;
import static android.R.attr.left;
import static android.R.attr.right;

/**
 * Created by user on 02/10/2017.
 */

public abstract class robot extends LinearOpMode {
    public DcMotor motorLeft;
    public DcMotor motorRight;
    public ColorSensor colorSensor;
    abstract public void runOpMode() throws InterruptedException;
    public DcMotor left, right;
    private final String VUFORIA_KEY_CODE = "AZEdxSX/////AAAAGRJHvDefqkuEg/u6gUdjR7lBp/9/VJUSfF+vyquynu2jWx3A1RFYpuNecs0reL12ivg/g8WUYgMopKOjRIxKoqWmjTUBlrIfDlZkFArLx5nTa7KQOAlbaNPIGr1x1wYx5ChhsB+c/NK3YdOJ4LvQ3lqyDus0FDa3W5kj7xifwGZWQupirVwjEpCxDBu7LCtc/1asHgf5OzjC0qUIajlgZYYn0QXB+rdrQPZ4oiBysidFNigDqyQOcFpmL0clUnEVCQ35UjZRmjqYjKzzLXGLzY/jbbsfuwEDuSykOMwS8i5dpHIQFs+CSWSjJHn+nD/TDPY70FDqBZMEOgiP+pUOLXd2SL7FJSaWcOxw7qspEHgQ\n";
    public void stopRobot(){//will stop the robot
        left.setPower(0);
        right.setPower(0);
    }
    public void resetEncoders(){//will reset encoders
        left.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        right.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }
    public void stopAndResetEncoders(){//will do both
        stopRobot();
        resetEncoders();
    }
    public void runUsingEncoders(){
        left.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        right.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }
    public void runWithoutEncoders(){
        left.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        right.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    }



    public void runWithEncoders(
            double LEFT_MOTOR_POWER, double RIGHT_MOTOR_POWER, int LEFT_MOTOR_ENCODER, int RIGHT_MOTOR_ENCODER, int TIME) throws InterruptedException {
        if (opModeIsActive()) {
            runUsingEncoders();
            resetEncoders();//resets the motors

            Thread.sleep(50);
            left.setTargetPosition(LEFT_MOTOR_ENCODER);
            right.setTargetPosition(RIGHT_MOTOR_ENCODER);//set position for the motors

            left.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            right.setMode(DcMotor.RunMode.RUN_TO_POSITION);

            Thread.sleep(50);
            left.setPower(LEFT_MOTOR_POWER);//sets the speed
            right.setPower(RIGHT_MOTOR_POWER);
            long start = System.currentTimeMillis();
            while (left.isBusy() || right.isBusy()) {
                Thread.sleep(30);//while teleOP keep going
                telemetry.addLine("leftPos:" + left.getCurrentPosition() + " rightPos: " + right.getCurrentPosition());
                telemetry.addLine("motorLeft: " + left.isBusy() + " motorRight :" + right.isBusy());
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
        motorLeft = hardwareMap.dcMotor.get("MotorLeft");
        motorRight = hardwareMap.dcMotor.get("MotorRight");
        // ser = hardwareMap.servo.get("Ser1");
        // ser2 = hardwareMap.servo.get("Ser2");
        //glifs1 = hardwareMap.dcMotor.get("glifs1");
        //glifs2 = hardwareMap.dcMotor.get("glifs2");
        //flip1 = hardwareMap.servo.get("flip1");
        //flip2 = hardwareMap.servo.get("flip2");
        //Elev = hardwareMap.dcMotor.get("Elev");
        // Yl = hardwareMap.servo.get("yl");
        //motorRight.setDirection(DcMotor.Direction.REVERSE);
        motorLeft.setDirection(DcMotor.Direction.REVERSE);
        // Yl.setPosition(0.25);
    }

}

