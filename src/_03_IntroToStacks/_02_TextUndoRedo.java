package _03_IntroToStacks;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class _02_TextUndoRedo implements KeyListener {
	/*
	 * Create a JFrame with a JPanel and a JLabel.
	 * 
	 * Every time a key is pressed, add that character to the JLabel. It should look
	 * like a basic text editor.
	 * 
	 * Make it so that every time the BACKSPACE key is pressed, the last character
	 * is erased from the JLabel. Save that deleted character onto a Stack of
	 * Characters.
	 * 
	 * Choose a key to be the Undo key. Make it so that when that key is pressed,
	 * the top Character is popped off the Stack and added back to the JLabel.
	 * 
	 */
	JFrame jFrame = new JFrame();
	JPanel jPanel = new JPanel();
	JLabel jLabel = new JLabel();
	char removed;
	Stack<Character> removedList = new Stack<Character>();

	public static void main(String[] args) {
		_02_TextUndoRedo instance = new _02_TextUndoRedo();
		instance.setUp();
	}

	void setUp() {
		jFrame.add(jPanel);
		jPanel.add(jLabel);
		jFrame.setSize(100, 100);
		jFrame.setVisible(true);
		jFrame.addKeyListener(this);
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		if (arg0.getKeyCode() == KeyEvent.VK_BACK_SPACE && jLabel.getText().length() - 1 != -1) {
			removed = jLabel.getText().charAt(jLabel.getText().length() - 1);
			jLabel.setText(jLabel.getText().substring(0, jLabel.getText().length() - 1));
			removedList.push(removed);
		}
		else if (arg0.getKeyCode() == KeyEvent.VK_COMMA && removedList.size()>0) {
			removed = removedList.pop();
			jLabel.setText(jLabel.getText()+removed);
		}
		else if (arg0.getKeyCode() == KeyEvent.VK_SHIFT) {
		}
		else if (jLabel.getText().length() - 1 != -1 || arg0.getKeyCode() != KeyEvent.VK_BACK_SPACE) {
			jLabel.setText(jLabel.getText() + arg0.getKeyChar());
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
