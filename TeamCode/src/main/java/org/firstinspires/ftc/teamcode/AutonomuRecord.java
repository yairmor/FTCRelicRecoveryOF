package org.firstinspires.ftc.teamcode;

import com.github.pmtischler.base.BlackBox;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import java.io.FileInputStream;

@Autonomous(name="PlaybackAuto", group="PlaybackAuto")
public class AutonomuRecord extends OpMode {
    // The input file stream.
    private FileInputStream inputStream;
    // The hardware player.
    private BlackBox.Player player;

    @Override
    public void init() {
        try {
            // Open previously written file full of hardware data.
            inputStream = hardwareMap.appContext.openFileInput("recordedTeleop");
            // Create a player to playback the hardware log.
            player = new BlackBox.Player(inputStream, hardwareMap);
        } catch (Exception e) {
            e.printStackTrace();
            requestOpModeStop();
        }
    }

    @Override
    public void loop() {
        try {
            // Update the hardware to mimic human during recorded Teleop.
            player.playback(time);
        } catch (Exception e) {
            e.printStackTrace();
            requestOpModeStop();
        }
    }
}