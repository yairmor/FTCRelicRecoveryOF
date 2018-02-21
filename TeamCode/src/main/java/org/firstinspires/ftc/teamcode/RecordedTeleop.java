package org.firstinspires.ftc.teamcode;

import android.content.Context;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import java.io.FileOutputStream;

@TeleOp(name="RecordedTeleop")
public class RecordedTeleop extends teleOp {
    // The output file stream.
    private FileOutputStream outputStream;
    // The hardware recorder.
    private BlackBox.Recorder recorder;

    public void init() {
        super.init();  // TankDrive teleop initialization.

        try {
            // Open a file named "recordedTeleop" in the app's folder.
            outputStream = hardwareMap.appContext.openFileOutput("recordedTeleop",
                    Context.MODE_PRIVATE);
            // Setup a hardware recorder.
            recorder = new BlackBox.Recorder(hardwareMap, outputStream);
        } catch (Exception e) {
            e.printStackTrace();
            requestOpModeStop();
        }
    }
    public void loop() {
        super.loop();  // TankDrive teleop control code.

        try {
            // Record the hardware state at the current time.
            recorder.record("leftFront", time);
            recorder.record("rightFront", time);
            recorder.record("leftBack", time);
            recorder.record("rightBack", time);
        } catch (Exception e) {
            e.printStackTrace();
            requestOpModeStop();
        }
    }
    public void stop() {
        super.stop();  // TankDrive stop code.

        try {
            // Close the file to write recorded data.
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }}