package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by user on 30/11/2017.
 */
@TeleOp(name = "nigger")
public class servo1 extends OpMode {
    Servo ser;
    @Override
    public void init() {
      ser = hardwareMap.servo.get("nigger");
    }

    @Override
    public void loop() { 
        if(gamepad1.a){
            ser.setPosition(1);
        }
        else{
            ser.setPosition(ser.getPosition());
        }
    }
}
