package clients.shopDisplay;



import java.io.*;
import java.net.URL;
import javax.sound.sampled.*;
import javax.swing.*;

// To play sound using Clip, the process need to be alive.
// Hence, we use a Swing application.
public class Sound extends JFrame {

   public Sound() {
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      this.setTitle("Sound");
      this.setSize(300, 200);
      this.setVisible(true);

      try {
         // Opened an audio input stream.
         URL url = this.getClass().getClassLoader().getResource("music.wav");
         AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
         // a sound clip resource.
         Clip clip = AudioSystem.getClip();
         // Opened audio clip and loaded samples from the audio input stream.
         clip.open(audioIn);
         FloatControl gainControl = 
        (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        gainControl.setValue(-20.0f); // Reduced volume by 20 decibels.
         clip.start();


      } catch (UnsupportedAudioFileException e) {
         e.printStackTrace();
      } catch (IOException e) {
         e.printStackTrace();
      } catch (LineUnavailableException e) {
         e.printStackTrace();
      }
   }

   public static void main(String[] args) {
      new Sound();
   }
}

