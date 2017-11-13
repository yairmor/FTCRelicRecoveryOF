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
    @Override
    public void init() {
        left = hardwareMap.dcMotor.get("MotorLeft");
        right = hardwareMap.dcMotor.get("MotorRight");
        //ser = hardwareMap.servo.get("Servo");
        //ser2 = hardwareMap.servo.get("Servo2");
        right.setDirection(DcMotorSimple.Direction.REVERSE);
    }

    @Override
    public void loop() {
        left.setPower(gamepad1.left_stick_y);
        right.setPower(gamepad1.right_stick_y);
        if(gamepad2.a){
           //ser.setPosition(-0.5);
           // ser2.setPosition(0.5);
        }
        else{
            //ser.setPosition(1);
            //ser2.setPosition(1);
        }
    }
}



