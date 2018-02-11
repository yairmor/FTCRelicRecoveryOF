package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.TouchSensor;
/**
 * Created by ori on 12/21/2016.
 */
@TeleOp(name = "TeleOP16")
public class driveTest extends OpMode{

    DcMotor left;//parts var
    DcMotor right;
    DcMotor collector;
    DcMotor lifterMotor;
    DcMotor shooter;
    DcMotor masua;
    TouchSensor microswitch;
    Servo railServo;

    boolean isRTpressed = false;
    DcMotor elevtor1;
    DcMotor elevtor2;
    float speedCon = 1;

    public boolean switchDirection = true;
    @Override
    public void init() {
        left = hardwareMap.dcMotor.get("left");
        right = hardwareMap.dcMotor.get("right");
        right.setDirection(DcMotorSimple.Direction.FORWARD);
        left.setDirection(DcMotorSimple.Direction.REVERSE);
        collector =  hardwareMap.dcMotor.get("coll");
        lifterMotor = hardwareMap.dcMotor.get("noker");
        shooter = hardwareMap.dcMotor.get("shooter");
        masua = hardwareMap.dcMotor.get("masua");
        collector.setDirection(DcMotorSimple.Direction.REVERSE);
        railServo = hardwareMap.servo.get("rs");
        elevtor1 = hardwareMap.dcMotor.get("elv1");
        elevtor2 = hardwareMap.dcMotor.get("elv2");
        microswitch = hardwareMap.touchSensor.get("ms");
    }

    @Override
    public void loop() {
        telemetry.addLine("galgelet"+gamepad1.y);

        telemetry.addLine("MS:"+microswitch.isPressed());//micro switch
        telemetry.addLine("forward:" + switchDirection);
        if (gamepad2.dpad_up) {
            elevtor1.setPower(-1);
            elevtor2.setPower(-1);
        }
        else if (gamepad2.dpad_down) {
            elevtor1.setPower(0.10);
            elevtor2.setPower(0.10);
        }
        else{
            elevtor1.setPower(0);
            elevtor2.setPower(0);
        }

        masua.setPower(gamepad2.right_stick_y);

        if(gamepad1.y){
            switchDirection = true;
        }
        else if(gamepad1.x){
            switchDirection = false;
        }
        if(switchDirection) {
            left.setPower(-gamepad1.left_stick_y*speedCon);
            right.setPower(-gamepad1.right_stick_y*speedCon);
        }
        else{
            left.setPower(gamepad1.right_stick_y*speedCon);
            right.setPower(gamepad1.left_stick_y*speedCon);
        }
        if(gamepad2.b){//fix lifter
            lifterMotor.setPower(0.1);
        }
        else if(gamepad2.right_bumper){//active flag
            isRTpressed = true;
        }
        else{
            lifterMotor.setPower(0);
        }


        if(isRTpressed) {//if lifter is active and microswitch = false
            if (microswitch.isPressed()) {
                lifterMotor.setPower(0);
                isRTpressed = false;
            }
            else{
                lifterMotor.setPower(-1);
            }
        }
        if(gamepad2.a){//ballsAutonomous op
            shooter.setPower(-1);
        }
        else{
            shooter.setPower(0);
        }
        if (gamepad1.left_bumper) {//collector op
            collector.setPower(-1);
        }
        else if (gamepad1.right_bumper) {
            collector.setPower(1);
        }
        else if(gamepad1.a){
            collector.setPower(0.25);
        }

        else {
            collector.setPower(0);
        }
        if(gamepad1.dpad_left){
            railServo.setDirection(Servo.Direction.REVERSE);
            railServo.setPosition(1);
        }//reverse is left
        else if(gamepad1.dpad_right){
            railServo.setDirection(Servo.Direction.FORWARD);
            railServo.setPosition(1);
        }//forward is right
        else{
            railServo.setPosition(0);
        }
        if(gamepad2.y){
            if(speedCon == 1){
                speedCon = 0.1f;
            }
            else{
                speedCon = 1;
            }
        }
    }
}
