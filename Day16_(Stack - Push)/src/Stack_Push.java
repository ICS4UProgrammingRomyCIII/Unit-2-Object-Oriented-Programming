/*
 * Created by: Romy I. Chu III
 * Created on: 09-March-2020
 * Created for: ICS4U
 * Day #16 (Stack - Push)
 * This program ... Creates a generic stack that has the same .push() method as java.util.stack.
*/

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.*;
import java.awt.event.ActionEvent;
import javax.swing.*;
import javax.swing.border.*;

public class Stack_Push extends JFrame {
	// These are variables for the objects that will be created later.
	private JPanel contentPane;
	private JTextField txtInput;
	
	// Variables and stuff n' Things
	StackClassPush stackClass = new StackClassPush();
	static List<Integer> stack = new ArrayList<Integer>(); // This is the stack.
	
	// Automatically Created...
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Stack_Push frame = new Stack_Push();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	// Automatically Created...
	public Stack_Push() {
		setTitle("Stack - Push");
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
					stack = stackClass.push(push);														//  Adds an object to the stack.
					if (lstDisplay.getText().isEmpty())													// If the display is empty...
						lstDisplay.setText(Integer.toString(stack.get(0)));								// Just print the first value in the stack.
					else																				// Otherwise...
						lstDisplay.setText(lstDisplay.getText() + "\n" + stack.get(stack.size() - 1));	// Get the previous string and add the next value of the stack to the list.
				  // If an exception occurs during runtime...
				} catch(Exception exc) {
					// Tell the user that they didn't enter the required information.
					JOptionPane.showMessageDialog(null, "You have inputted an invalid number!", "An Error Has Occurred", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnStackPush.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
		btnStackPush.setBounds(10, 36, 104, 20);
		contentPane.add(btnStackPush);
	}
}
