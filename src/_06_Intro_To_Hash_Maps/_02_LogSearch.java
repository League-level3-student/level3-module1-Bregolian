package _06_Intro_To_Hash_Maps;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class _02_LogSearch implements ActionListener {
	JFrame jFrame = new JFrame();
	JPanel jPanel = new JPanel();
	JButton addEntry = new JButton();
	JButton searchByID = new JButton();
	JButton viewList = new JButton();
	JButton removeEntry = new JButton();
	/*
	 * Crate a HashMap of Integers for the keys and Strings for the values. Create a
	 * GUI with three buttons. Button 1: Add Entry When this button is clicked, use
	 * an input dialog to ask the user to enter an ID number. After an ID is
	 * entered, use another input dialog to ask the user to enter a name. Add this
	 * information as a new entry to your HashMap.
	 * 
	 * Button 2: Search by ID When this button is clicked, use an input dialog to
	 * ask the user to enter an ID number. If that ID exists, display that name to
	 * the user. Otherwise, tell the user that that entry does not exist.
	 * 
	 * Button 3: View List When this button is clicked, display the entire list in a
	 * message dialog in the following format: ID: 123 Name: Harry Howard ID: 245
	 * Name: Polly Powers ID: 433 Name: Oliver Ortega etc...
	 * 
	 * When this is complete, add a fourth button to your window. Button 4: Remove
	 * Entry When this button is clicked, prompt the user to enter an ID using an
	 * input dialog. If this ID exists in the HashMap, remove it. Otherwise, notify
	 * the user that the ID is not in the list.
	 *
	 */
	HashMap<Integer, String> id = new HashMap<Integer, String>();

	public static void main(String[] args) {
		_02_LogSearch lS = new _02_LogSearch();
		lS.setUp();
	}

	private void setUp() {
		jFrame.add(jPanel);
		jPanel.add(addEntry);
		jPanel.add(searchByID);
		jPanel.add(viewList);
		jPanel.add(removeEntry);
		jFrame.setSize(300, 150);
		jFrame.setVisible(true);
		addEntry.setText("Add Entry");
		searchByID.setText("Search by ID");
		viewList.setText("View List");
		removeEntry.setText("Remove Entry");
		addEntry.addActionListener(this);
		searchByID.addActionListener(this);
		viewList.addActionListener(this);
		removeEntry.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == addEntry) {
			String input;
			int parsedInputID;
			input = JOptionPane.showInputDialog("ID Number Please");
			parsedInputID = Integer.parseInt(input);
			input = JOptionPane.showInputDialog("Name Please");
			id.put(parsedInputID, input);
		}
		if (arg0.getSource() == searchByID) {
			String input;
			int parsedInputID;
			input = JOptionPane.showInputDialog("ID Number Please");
			parsedInputID = Integer.parseInt(input);
			if (id.containsKey(parsedInputID)) {
				JOptionPane.showMessageDialog(null, id.get(parsedInputID));
			}
			else {
				JOptionPane.showMessageDialog(null, "That ID number does not exist");
			}
		}
		if (arg0.getSource() == viewList) {
			Object[] keySet;
			keySet = id.keySet().toArray();
			for (int i = 0; i < id.size(); i++) {
				System.out.print("ID "+keySet[i]+" is: ");
				System.out.println(id.get(keySet[i]));
			}
		}
		if (arg0.getSource() == removeEntry) {
			String input;
			int parsedInputID;
			input = JOptionPane.showInputDialog("ID Number Please");
			parsedInputID = Integer.parseInt(input);
			if (id.containsKey(parsedInputID)) {
				id.remove(parsedInputID);
			}
			else {
				JOptionPane.showMessageDialog(null, "That ID does not exist");
			}
		}
	}
}
