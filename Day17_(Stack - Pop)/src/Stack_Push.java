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
	
	// Variables and stuff n' Things
	StackClassPush stackClass = new StackClassPush();
	private JTextField txtInput;
	
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
		btnStackPush.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					List<Integer> stack = new ArrayList<Integer>();
					
					int push = Integer.parseInt(txtInput.getText());
					stack = stackClass.push(push);
					if (lstDisplay.getText().isEmpty())	
						lstDisplay.setText(Integer.toString(stack.get(0)));
					else
						lstDisplay.setText(lstDisplay.getText() + "\n" + stack.get(stack.size() - 1));
				} catch(Exception exc) {
					System.out.println("An Error Occured");
				}
			}
		});
		btnStackPush.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
		btnStackPush.setBounds(10, 36, 104, 20);
		contentPane.add(btnStackPush);
	}
}
