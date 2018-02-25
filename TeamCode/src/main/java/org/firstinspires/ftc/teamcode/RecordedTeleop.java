package org.firstinspires.ftc.teamcode;

import android.content.Context;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import java.io.FileOutputStream;

@TeleOp(name="RecordedTeleop")
@Disabled
public class RecordedTeleop extends teleOp {


    @Override
    public void init() {
        super.init();  // TankDrive teleop initialization.
        startTime = -1;

        try {
            // Open a file named "recordedTeleop" in the app's folder.
            outputStream = hardwareMap.appContext.openFileOutput("PlaybackAuto",
                    Context.MODE_PRIVATE);
            // Setup a hardware recorder.
            recorder = new BlackBox.Recorder(hardwareMap, outputStream);
        } catch (Exception e) {
            e.printStackTrace();
            requestOpModeStop();
        }

    }
    @Override
    public void loop() {
        super.loop();
        if (startTime == -1) {
            startTime = time;
        }
        double elapsed = time - startTime;
        telemetry.addLine("Recording File");
        telemetry.addData("Elapsed", elapsed);

        try {
            // Record the hardware state at the current time.
            recorder.record("motorLeftF", time);
            recorder.record("motorRightB", time);
            recorder.record("motorRightF", time);
            recorder.record("motorLeftB", time);
            recorder.record("Flip", time);
            recorder.record("Elev", time);
            recorder.record("glifsRight", time);
            recorder.record("glifsLeft", time);
            recorder.record("GservoR", time);
            recorder.record("GservoL", time);
        } catch (Exception e) {
            e.printStackTrace();
            requestOpModeStop();
        }
    }
    @Override
    public void stop() {
        super.stop();

        try {
            recorder = null;
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    // The output file stream.
        private FileOutputStream outputStream;
        // The hardware recorder.
        private BlackBox.Recorder recorder;
        private double startTime;

}