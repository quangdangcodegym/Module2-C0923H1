package audio;

import javax.sound.sampled.*;
import java.io.File;

public class AudioRecorder {
    public static void main(String[] args) {
        try {
            // Mở micro và đặt các cấu hình
            AudioFormat audioFormat = new AudioFormat(16000.0f, 16, 1, true, true);
            DataLine.Info info = new DataLine.Info(TargetDataLine.class, audioFormat);

            if (!AudioSystem.isLineSupported(info)) {
                System.out.println("Line not supported");
                System.exit(0);
            }

            TargetDataLine targetDataLine = (TargetDataLine) AudioSystem.getLine(info);
            targetDataLine.open(audioFormat);
            targetDataLine.start();

            System.out.println("Bắt đầu ghi âm...");

            // Bắt đầu ghi âm và lưu vào tệp
            AudioInputStream audioInputStream = new AudioInputStream(targetDataLine);
            File audioFile = new File("recorded_audio.wav");
            AudioSystem.write(audioInputStream, AudioFileFormat.Type.WAVE, audioFile);

            System.out.println("Ghi âm thành công. Âm thanh đã được lưu vào recorded_audio.wav");

            // Dừng ghi âm và đóng micro
            targetDataLine.stop();
            targetDataLine.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
