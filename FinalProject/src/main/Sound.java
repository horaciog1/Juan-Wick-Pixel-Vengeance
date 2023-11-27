package main;

import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sound {

	Clip clip;	//We use this to open the audio files
	URL soundURL[] = new URL[30];
	
	public Sound() {
		soundURL[0] = getClass().getResource("/sound/mainMenu.wav");
		soundURL[1] = getClass().getResource("/sound/backgroundMusic1.wav");
		soundURL[2] = getClass().getResource("/sound/blocked.wav");
		soundURL[3] = getClass().getResource("/sound/unlock.wav");
		soundURL[4] = getClass().getResource("/sound/swordSlash.wav");
		soundURL[5] = getClass().getResource("/sound/dooropen.wav");
		soundURL[6] = getClass().getResource("/sound/coin.wav");
		soundURL[7] = getClass().getResource("/sound/gunshot.wav");
		soundURL[8] = getClass().getResource("/sound/hit.wav");
		soundURL[9] = getClass().getResource("/sound/enemy_dying.wav");
		soundURL[10] = getClass().getResource("/sound/player_damage.wav");

		
		
		
		

	} // end constructor
	
	
	public void setFile(int i) {
		
		try {
			AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[i]);
			clip = AudioSystem.getClip();
			clip.open(ais);
		} catch(Exception e) {
			
		} // end try-catch
		
	} // end setFile
	
	
	public void play() {
		clip.start();
	} // end play
	
	
	public void loop() {
		clip.loop(Clip.LOOP_CONTINUOUSLY);
	} // end loop
	
	
	public void stop() {
		clip.stop();
	} // end stop
	
	
	
	
	
	
	
	
	
	
} // end class
