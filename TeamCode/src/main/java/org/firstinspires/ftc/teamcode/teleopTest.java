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
    DcMotor motorLeftB;
    DcMotor motorRightB;
    Servo ser;
    Servo ser2;
    DcMotor glifs1;
    DcMotor glifs2;
    Servo flip1;
    Servo Yl;
    DcMotor Elev;
    Servo nigger;
    Servo puz;
    DcMotor motorLeftF;
    DcMotor motorRightF;
    private enum Direction {
        UP, DOWN, NO
    }
    private  boolean isLifting;
    private Direction dir = Direction.NO;


    private enum clowStatus {
        CLOSE, OPEN, NO
    }

    ;
    private clowStatus diRyyy = clowStatus.NO;


    public boolean flagForServo = false;

    @Override
    public void init() {
        //the name of the configuration

        //MOTORS BACK
        motorLeftB = hardwareMap.dcMotor.get("MotorLeftB");
        motorRightB = hardwareMap.dcMotor.get("MotorRightB");

        //MOTORS FORWARD
        motorLeftF = hardwareMap.dcMotor.get("motorLeftF");
        motorRightF = hardwareMap.dcMotor.get("motorRightF");

        // ser = hardwareMap.servo.get("Ser1");
       // ser2 = hardwareMap.servo.get("Ser2");
        glifs1 = hardwareMap.dcMotor.get("glifs1");
        glifs2 = hardwareMap.dcMotor.get("glifs2");
        //flip1 = hardwareMap.servo.get("flip1");
        //flip2 = hardwareMap.servo.get("flip2");
        Elev = hardwareMap.dcMotor.get("Elev");
        Yl = hardwareMap.servo.get("yl");
        nigger= hardwareMap.servo.get("nigger");
        puz= hardwareMap.servo.get("puz");
        //motorRightB.setDirection(DcMotor.Direction.REVERSE);
        motorLeftB.setDirection(DcMotor.Direction.REVERSE);
       // yl.setPosition(0.25);
        nigger.setPosition(0.7);
        puz.setPosition(0.26);
    }

    @Override
    public void loop() {
        //if (gamepad2.x){
            isLifting = !isLifting;
        //}
        //if(isLifting){
            //flip1.setPosition(0.70);
        //}
        //else{
            //flip1.setPosition(1);
        //}

        motorLeftB.setPower(gamepad1.left_stick_y);
        motorRightB.setPower(gamepad1.right_stick_y);

        motorLeftF.setPower(gamepad1.left_stick_y);
        motorRightF.setPower(gamepad1.right_stick_y);

        //collect glifs
        if (gamepad1.right_bumper) {
            glifs1.setPower(-1);
            glifs2.setPower(-1);

        } else if (gamepad1.left_bumper) {
            glifs1.setPower(1);
            glifs2.setPower(1);

        } else {
            glifs1.setPower(0);
            glifs2.setPower(0);
            //end


        }
        //take relic
        //if (gamepad2.y) {

          //  if (diRyyy == clowStatus.NO) {
            //    flagForServo = !flagForServo;
              //  diRyyy = clowStatus.CLOSE;
            //}

        //} else {
          //  diRyyy = clowStatus.NO;
        //}

        //if (flagForServo) {
          //  ser.setPosition(0.50);
        //} else {
          //  ser.setPosition(1);
        //}


        if (gamepad2.dpad_up) {
            //down= up    up=down
            if (dir != Direction.UP) {
                Yl.setPosition(Yl.getPosition() + 0.31);
                this.telemetry.addLine("" + Yl.getPosition());
                dir = Direction.UP;
            }
        } else if (gamepad2.dpad_down) {

            if (dir != Direction.DOWN) {
                Yl.setPosition(Yl.getPosition() - 0.31);
                this.telemetry.addLine("" + Yl.getPosition());
                dir = Direction.DOWN;
            }
        } else {
            dir = Direction.NO;
        }


       // if (gamepad2.a) {
          //  telemetry.addLine("Servo:" + flip1.getPosition());
          //  flip1.setPosition(0.38);

        //} else {
           // flip1.setPosition(0.70);



        //}

        //telemetry.addLine("" +Elev.getCurrentPosition());
        if(-gamepad2.left_stick_y > 0.5) {
            //  Elev.setTargetPosition();
            Elev.setPower(0.7);

        }else  if(-gamepad2.left_stick_y < -0.5){
          //  Elev.setTargetPosition();
            Elev.setPower(-0.6);

        }else {
            Elev.setPower(0);
        }






    } // end of method loop
}







