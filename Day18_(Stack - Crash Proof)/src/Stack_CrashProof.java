/*
 * Created by: Romy I. Chu III
 * Created on: 09-March-2020
 * Created for: ICS4U
 * Day #18 (Stack - Crash Proof)
 * This program ... Adding onto day 17. Program will not crash when an exception occurs.
*/

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;

public class Stack_CrashProof extends JFrame {
	// These are variables for the objects that will be created later.
	private JPanel contentPane;
	private JTextField txtInput;
	
	// Variables and stuff n' Things
	StackClass stackClass = new StackClass();
	static List<Integer> stack = new ArrayList<Integer>(); // This is the stack.
	
	// Automatically Created...
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Stack_CrashProof frame = new Stack_CrashProof();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	// Automatically Created...
	public Stack_CrashProof() {
		setTitle("Stack - Crash Proof");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 285, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAddInteger = new JLabel("Please Enter an Integer :");
		lblAddInteger.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
		lblAddInteger.setBounds(10, 11, 144, 14);
		contentPane.add(lblAddInteger);
		
		txtInput = new JTextField();
		txtInput.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
		txtInput.setBounds(164, 8, 96, 20);
		contentPane.add(txtInput);
		txtInput.setColumns(10);
		
		JTextPane lstDisplay = new JTextPane();
		lstDisplay.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
		lstDisplay.setEditable(false);
		lstDisplay.setBounds(10, 67, 250, 183);
		contentPane.add(lstDisplay);
		
		
		JButton btnStackPush = new JButton("Stack - Push");
		//This Block of code creates an action listener and attaches it to the button. 
		btnStackPush.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// This try-catch loop will catch any errors that occur during runtime.
				// The procedure will try to...
				try {
					int push = Integer.parseInt(txtInput.getText());									// Gets the integer that the user put in the text box.
					stack = stackClass.push(push);														// Adds an object to the stack.
					if (lstDisplay.getText().isEmpty())													// If the display is empty...
						lstDisplay.setText(Integer.toString(stack.get(0)));								// Just print the first value in the stack.
					else																				// Otherwise...
						lstDisplay.setText(lstDisplay.getText() + "\n" + stack.get(stack.size() - 1));	// Get the previous string and add the next value of the stack to the list.
					txtInput.setText("");
				  // If an exception occurs during runtime...
				} catch(Exception exc) {
					// Tell the user that they didn't enter the required information.
					JOptionPane.showMessageDialog(null, "You have inputted an invalid number!", "An Error Has Occurred", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnStackPush.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
		btnStackPush.setBounds(10, 36, 100, 20);
		contentPane.add(btnStackPush);
		
		
		JButton btnStackPop = new JButton("Stack - Pop");
		//This Block of code creates an action listener and attaches it to the button. 
		btnStackPop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// This try-catch loop will catch any errors that occur during runtime.
				// The procedure will try to...
				try {
					stack = stackClass.pop();										// Removes the last object in the stack.
					lstDisplay.setText("");											// Clears the list box.
					for(int i : stack) {											// Foreach integer in the stack...
						if (lstDisplay.getText().isEmpty())							// If the display is empty...
							lstDisplay.setText(Integer.toString(i));				// Add i to the list box.
						else														// Otherwise...
							lstDisplay.setText(lstDisplay.getText() + "\n" + i);	// Get the previous string and add the next value of the stack to the list.	
					}
				  // If an exception occurs during runtime...
				} catch(Exception exc) {
					// Tell the user that they reached the end of the stack.
					JOptionPane.showMessageDialog(null, "The stack is empty!", "An Error Has Occurred", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btnStackPop.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
		btnStackPop.setBounds(115, 36, 95, 20);
		contentPane.add(btnStackPop);
	}
}
