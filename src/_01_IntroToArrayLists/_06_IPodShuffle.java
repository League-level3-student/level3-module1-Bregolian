package _01_IntroToArrayLists;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


//Copyright The League of Amazing Programmers, 2015

public class _06_IPodShuffle implements ActionListener{
	JFrame jFrame = new JFrame();
	JPanel jPanel = new JPanel();
	JButton jButton = new JButton();
	ArrayList<Song> playlist = new ArrayList<Song>();
	int currentSong = 0;
	public _06_IPodShuffle() {
		
		// 1. Use the Song class the play the demo.mp3 file.
				Song s = new Song("demo.mp3");
				Song s2 = new Song("demo.mp3");
				Song s3 = new Song("demo.mp3");
				Song s4 = new Song("demo.mp3");
				
				playlist.add(s);
				playlist.add(s2);
				playlist.add(s3);
				playlist.add(s4);
				
				createUI();
				
		/**
		 * 2. Congratulations on completing the sound check! * Now we want to make an
		 * iPod Shuffle that plays random music. * Create an ArrayList of Songs and a
		 * "Surprise Me!" button that will play a random song when it is clicked. * If
		 * you're really cool, you can stop all the songs, before playing a new one on
		 * subsequent button clicks.
		 */
		
	}
	
	private void createUI() {
	
		jFrame.add(jPanel);
		jPanel.add(jButton);
		jButton.addActionListener(this);
		jButton.setText("Suprise Me");
		jFrame.setVisible(true);
	}

	public static void main(String[] args) {
		new _06_IPodShuffle();
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource().equals(jButton)) {
			playlist.get(currentSong).stop();
			currentSong = (int)(Math.random()*playlist.size());
			playlist.get(currentSong).play();
		}
		
	}
}