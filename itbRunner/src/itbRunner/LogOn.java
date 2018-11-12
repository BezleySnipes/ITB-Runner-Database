package itbRunner;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class LogOn extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5849175268495076699L;
	private JPanel contentPane;
	public JTextField textField;
	public JTextField textField_1;
	public String user;
	public String pass;
	public static JFrame LogOnframe;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogOnframe = new LogOn();
					LogOnframe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LogOn() {
		RunnerQueries r1 = new RunnerQueries();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(202, 81, 131, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(202, 137, 131, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblUserName = new JLabel("User Name");
		lblUserName.setBounds(115, 84, 66, 14);
		contentPane.add(lblUserName);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(115, 140, 66, 14);
		contentPane.add(lblPassword);
		
		
		JButton btnLogIn = new JButton("Log In");
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(r1.getConnection(textField.getText(), textField_1.getText()).isValid(1)) {
						user = textField.getText();
						pass = textField_1.getText();
						System.out.println("correct");
						CompetitionApplication startApp = new CompetitionApplication("root","root");
						startApp.setVisible(true);
						LogOnframe.setVisible(false);
						
					}else{
						JOptionPane.showMessageDialog(null, "Unable to verify your creditials","ITB Runner Database",2);
					};
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "Unable to connect to server","ITB Runner Database",2);
				}catch (NullPointerException e2) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "Check your Username / Password and try again","ITB Runner Database",2);
				}
			}
		});
		btnLogIn.setBounds(175, 194, 89, 23);
		contentPane.add(btnLogIn);
		
		JLabel lblItbRunnerDatabase = new JLabel("ITB Runner Database System");
		lblItbRunnerDatabase.setFont(new Font("Stencil", Font.PLAIN, 18));
		lblItbRunnerDatabase.setBounds(74, 11, 337, 51);
		contentPane.add(lblItbRunnerDatabase);
	}
}

