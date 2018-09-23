package _04_HangMan;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class HangMan implements KeyListener {
	JFrame jFrame = new JFrame();
	JPanel jPanel = new JPanel();
	JLabel jLabel = new JLabel();
	JLabel jLives = new JLabel();
	JLabel jLivesText = new JLabel();
	JLabel jWrong = new JLabel();
	String currentWord;
	String numOfWordsString;
	String currentText;
	String usefulString;
	int numOfWords;
	int numCharCorrect;
	int startLives = 10;
	boolean correct;
	Stack<String> words = new Stack<String>();
	Utilities u = new Utilities();

	public static void main(String[] args) {
		HangMan h = new HangMan();
		h.setUp();
	}

	private void setUp() {
		jFrame.add(jPanel);
		jPanel.add(jLabel);
		jPanel.add(jLives);
		jPanel.add(jLivesText);
		jPanel.add(jWrong);
		jWrong.setText("Incorrect Letters: ");
		jLives.setText(startLives+"");
		jLivesText.setText("Lives Left");;
		jFrame.setSize(500, 100);
		jFrame.setVisible(true);
		jFrame.addKeyListener(this);
		numOfWordsString = JOptionPane.showInputDialog("How many words would you like to do?");
		numOfWords = Integer.parseInt(numOfWordsString);
		for (int i = 0; i < numOfWords; i++) {
			words.push(u.readRandomLineFromFile("src/_04_HangMan/dictionary.txt"));
		}
		currentWord = words.pop();
		for (int i = 0; i < currentWord.length(); i++) {
			currentText = jLabel.getText();
			currentText += '_';
			currentText += ' ';
			jLabel.setText(currentText);
		}
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		if (currentWord.contains(arg0.getKeyChar() + "") && !jLabel.getText().contains(arg0.getKeyChar() + "")) {
			for (int i = 0; i < currentWord.length(); i++) {
				usefulString = jLabel.getText();
				if (currentWord.charAt(i) == arg0.getKeyChar()) {
					usefulString = usefulString.substring(0, 2 * i) + arg0.getKeyChar()
							+ usefulString.substring(2 * i + 1);
					jLabel.setText(usefulString);
					numCharCorrect++;
				}
			}

			if (numCharCorrect == currentWord.length()) {
				numCharCorrect = 0;
				if (words.isEmpty()) {
					JOptionPane.showMessageDialog(null, "You win! You completed " + numOfWords + " words.");
					jFrame.removeKeyListener(this);
				} else {
					currentWord = words.pop();
					currentText = "";
					for (int i = 0; i < currentWord.length(); i++) {
						currentText += '_';
						currentText += ' ';
					}
					jLabel.setText(currentText);
					jWrong.setText("Incorrect Letters: ");
					jLives.setText("10");
				}
			}
		} else {
			int newLives;
			String response;
			newLives = Integer.parseInt(jLives.getText());
			newLives--;
			jWrong.setText(jWrong.getText() + (" " + arg0.getKeyChar()));
			if (newLives == 0) {
				response = JOptionPane.showInputDialog("You just lost the game. The word was " + currentWord + " Would you like to play again?");
				if (response.equalsIgnoreCase("Yes")) {
					newLives=10;
					numOfWordsString = JOptionPane.showInputDialog("How many words would you like to do?");
					numOfWords = Integer.parseInt(numOfWordsString);
					for (int i = 0; i < numOfWords; i++) {
						words.push(u.readRandomLineFromFile("src/_04_HangMan/dictionary.txt"));
					}
					currentWord = words.pop();
					jLabel.setText("");
					for (int i = 0; i < currentWord.length(); i++) {
						currentText = jLabel.getText();
						currentText += '_';
						currentText += ' ';
						jLabel.setText(currentText);
					}
					jWrong.setText("Incorrect Letters: ");
				}
				else {
					jFrame.removeKeyListener(this);
				}
			}
			jLives.setText(newLives + "");
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

}
