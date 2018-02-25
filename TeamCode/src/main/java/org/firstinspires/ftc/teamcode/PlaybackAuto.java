package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.Servo;

import java.io.FileInputStream;

/**
 * Playback autonomous mode.
 * This mode playbacks the recorded values previously recorded by teleop.
 */
@Disabled
@Autonomous(name="pmt.Playback", group="pmtischler")
public class PlaybackAuto extends OpMode {
    DcMotor motorLeftB;
    DcMotor motorRightB;
    Servo Rservo;
    Servo ser2;
    public DigitalChannel Rtouch;
    // public CRServo GservoL;
    public Servo GservoR;
    public Servo GservoL;
    DcMotor glifsLeft;
    DcMotor glifsRight;
    Servo Flip;
    DcMotor Elev;
    Servo ballX;
    Servo ballY;
    DcMotor motorLeftF;
    DcMotor motorRightF;
    DcMotor Rmotor;
    /**
     * Creates the playback.
     */
    @Override
    public void init() {

        Rtouch = hardwareMap.digitalChannel.get("Rtouch");
        //MOTORS BACK
        motorLeftB = hardwareMap.dcMotor.get("motorLeftB");
        motorRightB = hardwareMap.dcMotor.get("motorRightB");

        //MOTORS FRONT
        motorLeftF = hardwareMap.dcMotor.get("motorLeftF");
        motorRightF = hardwareMap.dcMotor.get("motorRightF");

        Rservo = hardwareMap.servo.get("Rservo");
        // GservoL = (CRServo) hardwareMap.crservo.get("GservoL");
        GservoR = hardwareMap.servo.get("GservoR");
        GservoL = hardwareMap.servo.get("GservoL");
        // ser2 = hardwareMap.servo.get("Ser2");
        glifsLeft = hardwareMap.dcMotor.get("glifsLeft");
        glifsRight = hardwareMap.dcMotor.get("glifsRight");
        Elev = hardwareMap.dcMotor.get("Elev");
        Flip = hardwareMap.servo.get("Flip");
        ballX = hardwareMap.servo.get("ballX");
        ballY = hardwareMap.servo.get("ballY");
        Rmotor =hardwareMap.dcMotor.get("Rmotor");
        Rmotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        Elev.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        motorRightF.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motorRightB.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motorLeftF.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motorLeftB.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        Rmotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        motorLeftB.setDirection(DcMotor.Direction.REVERSE);
        motorLeftF.setDirection(DcMotor.Direction.REVERSE);

        motorRightB.setDirection(DcMotor.Direction.FORWARD);
        motorRightF.setDirection(DcMotor.Direction.FORWARD);

        glifsRight.setDirection(DcMotor.Direction.FORWARD);
        glifsLeft.setDirection(DcMotor.Direction.REVERSE );
        Rmotor.setDirection(DcMotor.Direction.REVERSE);
        //telemetry.update();
        ballX.setPosition(0.69);
        ballY.setPosition(0.69);
        Flip.setPosition(0.63);
        Rtouch.setMode(DigitalChannel.Mode.INPUT);

        motorLeftB.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motorLeftF.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motorRightF.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motorRightB.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        Rmotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        Rmotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motorLeftF.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);//sets the speed
        motorRightF.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motorRightB.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motorLeftB.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        try {
            inputStream = hardwareMap.appContext.openFileInput("PlaybackAuto");
            player = new BlackBox.Player(inputStream, hardwareMap);
        } catch (Exception e) {
            e.printStackTrace();
            requestOpModeStop();
        }
        telemetry.addLine("Ready to go");
    }

    /**
     * Plays back the recorded hardware at the current time.
     */
    @Override
    public void loop() {
        try {
            player.playback(time);
        } catch (Exception e) {
            e.printStackTrace();
            requestOpModeStop();
        }
    }

    /**
     * Closes the file.
     */
    @Override
    public void stop() {
        try {
            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // The input file stream.
    private FileInputStream inputStream;
    // The hardware player.
    private BlackBox.Player player;
}
