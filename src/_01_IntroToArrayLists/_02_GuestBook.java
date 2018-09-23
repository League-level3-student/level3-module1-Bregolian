package _01_IntroToArrayLists;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class _02_GuestBook implements ActionListener {
	// Create a GUI with two buttons. One button reads "Add Name" and the other button reads "View Names". 
	// When the add name button is clicked, display an input dialog that asks the user to enter a name. Add
	// that name to an ArrayList. When the "View Names" button is clicked, display a message dialog that displays
	// all the names added to the list. Format the list as follows:
	// Guest #1: Bob Banders
	// Guest #2: Sandy Summers
	// Guest #3: Greg Ganders
	// Guest #4: Donny Doners
	JFrame jFrame = new JFrame();
	JPanel jPanel = new JPanel();
	JButton addName = new JButton();
	JButton viewNames = new JButton();
	String message = new String("");
	ArrayList<String> nameList=new ArrayList<String>();
	public static void main(String[] args) {
		_02_GuestBook guestBook =new _02_GuestBook();
		guestBook.createUI();
	}
	public void createUI() {
		jFrame.add(jPanel);
		jFrame.setSize(400, 200);
		jPanel.add(addName);
		jPanel.add(viewNames);
		addName.addActionListener(this);
		addName.setText("Add Name");
		viewNames.addActionListener(this);
		viewNames.setText("View Names");
		jFrame.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if (arg0.getSource()==(addName)) {
			nameList.add(JOptionPane.showInputDialog("What name would you like to add?"));
		}
		if (arg0.getSource()==(viewNames)) {
			for (int i = 0; i < nameList.size(); i++) {
					message+="Guest #"+i+": ";
					message+=nameList.get(i);
					message+="\n";
			}
			JOptionPane.showMessageDialog(null, message);
			message="";
		}
	}
			
	
	
}
