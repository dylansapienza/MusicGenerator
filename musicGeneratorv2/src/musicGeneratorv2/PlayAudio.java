package musicGeneratorv2;

import java.io.File;
import java.util.concurrent.TimeUnit;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class PlayAudio {

	
	int song = 0;
	int stopvar = 0;
	static int seconds = 1;
	static int milliseconds = 500;
	
    public static void play(int playChord) {
    	
    	File file = new File(playChord+".wav");
    	Clip clip;
    	
      	try {
      		   clip = AudioSystem.getClip();
      	 	   clip.open(AudioSystem.getAudioInputStream(file));
      	 	   clip.start();
      	 	   System.out.println(playChord);
      	 	   TimeUnit.SECONDS.sleep(seconds);
      	 	   TimeUnit.MILLISECONDS.sleep(milliseconds);
      	 	   clip.stop();
      	 	   
    	  } 
      	catch (Exception e) {
    		  System.err.println(e.getMessage());
      		}
      	
    }
    
    public void stop() {
  			
    	//clip.stop();

    }

}
