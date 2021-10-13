package application;

import java.io.*;
import javax.sound.sampled.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class ButtonListeners {
	@FXML
	Button DavisFaceButton;
	@FXML
	Label DavisQuote;

	int index = 0;
	File[] audioFiles = {new File("C:\\Users\\scott\\Downloads\\DavisAudio.wav"), 
			new File("C:\\Users\\scott\\Downloads\\DavisNein.wav"),
			new File("C:\\Users\\scott\\Downloads\\DavisAnything.wav"),
			new File("C:\\Users\\scott\\Downloads\\DavisVomit.wav")};
	
	String[] audioFileMessages = {"HELLO!", "NINE x INFINITY", "ANYTHINGGGG", "VOMIT"};
	
	public void DavisFaceButtonListener() throws UnsupportedAudioFileException, IOException, LineUnavailableException{
		System.out.println("Button Pressed - " + index + " - " + audioFileMessages[index]);
		
		File audioFile = audioFiles[index];

		String message = "Quote " + (index + 1) + ": " + audioFileMessages[index];
		
		DavisQuote.setText(message);
		
		if(index == (audioFiles.length - 1))
			index = 0;
		else
			index++;
		
		AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
		Clip clip = AudioSystem.getClip();
		clip.open(audioStream);
		
		clip.start();
	}
}
