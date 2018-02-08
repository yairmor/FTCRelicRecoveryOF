package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by user on 02/10/2017.
 */
@TeleOp(name = "TeleOP")
public class teleOp extends OpMode {
    DcMotor motorLeftB;
    DcMotor motorRightB;
    Servo ser;
    Servo ser2;
    DcMotor glifs1;
    DcMotor glifs2;
    Servo Yl;
    DcMotor Elev;
    Servo ballX;
    Servo ballY;
    DcMotor motorLeftF;
    DcMotor motorRightF;
    float   leftPower, rightPower, xValue, yValue;
    boolean lastUpperVaLue;
    boolean lastLowerValue;
    int liftState = 0;


    private enum Direction {
        UP, DOWN, NO
    }
    private  boolean isLifting;
    private Direction dir = Direction.NO;


    private enum clowStatus {
        CLOSE, OPEN, NO
}


    private clowStatus diRyyy = clowStatus.NO;


    public boolean flagForServo = false;

    public boolean switchDirection = true;

    @Override
    public void init() {
        //the name of the configuration
        telemetry.addData("Mode", "running");
        telemetry.addData("stick", "  y=" + yValue + "  x=" + xValue);
        telemetry.addData("power", "  left=" + leftPower + "  right=" + rightPower);



        //MOTORS BACK
        motorLeftB = hardwareMap.dcMotor.get("motorLeftB");
        motorRightB = hardwareMap.dcMotor.get("motorRightB");

        //MOTORS FRONT
        motorLeftF = hardwareMap.dcMotor.get("motorLeftF");
        motorRightF = hardwareMap.dcMotor.get("motorRightF");

        // ser = hardwareMap.servo.get("Ser1");
       // ser2 = hardwareMap.servo.get("Ser2");
        glifs1 = hardwareMap.dcMotor.get("glifs1");
        glifs2 = hardwareMap.dcMotor.get("glifs2");
        Elev = hardwareMap.dcMotor.get("Elev");
        Yl = hardwareMap.servo.get("yl");
        ballX = hardwareMap.servo.get("ballX");
        ballY = hardwareMap.servo.get("ballY");



        motorLeftB.setDirection(DcMotor.Direction.REVERSE);
        motorLeftF.setDirection(DcMotor.Direction.REVERSE);

        motorRightB.setDirection(DcMotor.Direction.REVERSE);
        motorRightF.setDirection(DcMotor.Direction.REVERSE);

        glifs2.setDirection(DcMotor.Direction.REVERSE);
        glifs1.setDirection(DcMotor.Direction.FORWARD);
        //telemetry.update();
        ballX.setPosition(0.69);
        ballY.setPosition(0.69);
        Yl.setPosition(0.63);


        motorLeftB.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motorLeftF.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motorRightF.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motorRightB.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motorLeftF.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);//sets the speed
        motorRightF.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motorRightB.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motorLeftB.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    @Override
    public void loop() {

        //if (gamepad2.y){
            //isLifting = !isLifting;
        //}
        //if(isLifting){
            //flip1.setPosition(0.43);
        //}
        //else{
            //flip1.setPosition(1);
        //}
        //yValue = gamepad1.right_stick_x;
        //xValue = gamepad1.left_stick_y;

        //leftPower =  yValue - xValue;
        //rightPower = yValue + xValue;

        //motorLeftB.setPower(Range.clip(leftPower, -1.0, 1.0));
        //motorLeftF.setPower(Range.clip(leftPower, -1.0, 1.0));

        //motorRightF.setPower(Range.clip(rightPower, -1.0, 1.0));
        //motorRightB.setPower(Range.clip(rightPower, -1.0, 1.0));
        motorLeftB.setPower(-gamepad1.left_stick_y);
        motorRightB.setPower(gamepad1.right_stick_y);

        motorLeftF.setPower(-gamepad1.left_stick_y);
        motorRightF.setPower(gamepad1.right_stick_y);



        telemetry.addLine("MLB:" + motorLeftB.getCurrentPosition() + " MRB: " + motorRightB.getCurrentPosition());
        telemetry.addLine("MLF:" + motorLeftF.getCurrentPosition() + " MRF: " + motorRightF.getCurrentPosition());

        //collect glifs
        if (gamepad1.right_bumper) {
            glifs1.setPower(-1);
            glifs2.setPower(1);

        } else if (gamepad1.left_bumper) {
            glifs1.setPower(1);
            glifs2.setPower(-1);

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


       /* if (gamepad2.dpad_down) {
            //down= up    up=down
            if (dir != Direction.UP) {
                Yl.setPosition(Yl.getPosition() + 0.50);
                this.telemetry.addLine("" + Yl.getPosition());
                dir = Direction.UP;
            }
        } else if (gamepad2.dpad_up) {

            if (dir != Direction.DOWN) {
                Yl.setPosition(Yl.getPosition() - 0.45);
                this.telemetry.addLine("" + Yl.getPosition());
                dir = Direction.DOWN;
            }
        } else {
            dir = Direction.NO;
        }
*/


        //telemetry.addLine("" +Elev.getCurrentPosition());
        if(gamepad2.left_stick_y > 0.5) {
            //  Elev.setTargetPosition();
            Elev.setPower(1);

        }else  if(gamepad2.left_stick_y < -0.5){
          //  Elev.setTargetPosition();
            Elev.setPower(-0.6);

        }else {
            Elev.setPower(0);
        }
        glifs1.setPower(gamepad1.right_trigger);
        glifs2.setPower(gamepad1.right_trigger);

        glifs1.setPower(-gamepad1.left_trigger);
        glifs2.setPower(-gamepad1.left_trigger);

        if(!lastUpperVaLue && gamepad2.dpad_up){
            liftState++;
        }

        if(!lastLowerValue && gamepad2.dpad_down){
            liftState--;
        }
        if(liftState == 0){
            Yl.setPosition(0.65);
        }
        else if(liftState == 1){
            Yl.setPosition(0.53);
        }
        else{
            Yl.setPosition(0.17);
        }
        if(liftState < 0){
            liftState = 0;
        }
        else if(liftState > 2){
            liftState = 2;
        }
        lastUpperVaLue = gamepad2.dpad_up;
        lastLowerValue = gamepad2.dpad_down;



        if (gamepad1.y) {
            ballX.setPosition(0.69);
            ballY.setPosition(0.69);
        }

    }// end of method loop


}







