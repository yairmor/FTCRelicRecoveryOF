package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by user on 02/10/2017.
 */
@TeleOp(name = "TeleOP")
public class teleopTest extends OpMode {
    DcMotor left;
    DcMotor right;
    Servo ser;
    Servo ser2;
    DcMotor glifs1;
    DcMotor glifs2;
    Servo xl;
    Servo Yl;
    public  boolean flagForServo = false;
    @Override
    public void init() {
        //the name of the configuration
        left = hardwareMap.dcMotor.get("MotorLeft");
        right = hardwareMap.dcMotor.get("MotorRight");
        ser = hardwareMap.servo.get("Ser1");
        //ser2 = hardwareMap.servo.get("Ser2");
        //glifs1 = hardwareMap.dcMotor.get("glifs1");
        //glifs2 = hardwareMap.dcMotor.get("glifs2");
        xl = hardwareMap.servo.get("xl");
        Yl = hardwareMap.servo.get("yl");
        //right.setDirection(DcMotorSimple.Direction.REVERSE);
        //left.setDirection(DcMotorSimple.Direction.REVERSE);
    }

    @Override
    public void loop() {
        left.setPower(gamepad1.left_stick_y);
        right.setPower(gamepad1.right_stick_y);
        //collect glifs
        if(gamepad2.a){
           //glifs1.setPower(1);
           //glifs2.setPower(1);
        }
        else{
           //glifs1.setPower(0);
           //glifs2.setPower(0);
            //end
        }
        //take relic
        if(gamepad2.y) {
            flagForServo = !flagForServo;
        }
        if(flagForServo){
            ser.setPosition(0.50);
        }
        else {
           ser.setPosition(1);
        }

        xl.setPosition(gamepad2.left_stick_x);
        Yl.setPosition(gamepad2.right_stick_y);


    }
}




