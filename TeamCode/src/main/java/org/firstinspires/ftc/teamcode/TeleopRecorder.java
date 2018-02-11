package org.firstinspires.ftc.teamcode;

import android.content.Context;

import com.github.pmtischler.base.BlackBox;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import java.io.FileOutputStream;

@TeleOp (name="TeleopRecorder")
public class TeleopRecorder extends robot {

    // The output file stream.
    private FileOutputStream outputStream;
    // The hardware recorder.
    private BlackBox.Recorder recorder;


    public void initteleop() {
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

    @Override
    public void runOpMode() throws InterruptedException {

    }
}
