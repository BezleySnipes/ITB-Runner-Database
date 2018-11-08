package itbRunner;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class CompetitionApplication extends JFrame {

	private JPanel contentPane;
	private JTextField rNameTextBox;
	private JTextField rAgeTextBox;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CompetitionApplication frame = new CompetitionApplication();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CompetitionApplication() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(5, 24, 424, 232);
		contentPane.add(tabbedPane);
		
		JPanel ShowAll = new JPanel();
		tabbedPane.addTab("Show All", null, ShowAll, null);
		ShowAll.setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 11, 399, 159);
		ShowAll.add(textArea);
		
		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText(t);
			}
		});
		btnRefresh.setBounds(160, 181, 89, 23);
		ShowAll.add(btnRefresh);
		
		JPanel addPanel = new JPanel();
		tabbedPane.addTab("Add Runner", null, addPanel, null);
		addPanel.setLayout(null);
		
		JLabel lblRunnerName = new JLabel("Runner Name:");
		lblRunnerName.setBounds(42, 46, 80, 14);
		addPanel.add(lblRunnerName);
		
		JLabel lblRunnerAge = new JLabel("Runner Age:");
		lblRunnerAge.setBounds(42, 89, 80, 14);
		addPanel.add(lblRunnerAge);
		
		JLabel lblRunningCategory = new JLabel("Running Category:");
		lblRunningCategory.setBounds(42, 135, 113, 14);
		addPanel.add(lblRunningCategory);
		
		rNameTextBox = new JTextField();
		rNameTextBox.setBounds(149, 43, 178, 20);
		addPanel.add(rNameTextBox);
		rNameTextBox.setColumns(10);
		
		rAgeTextBox = new JTextField();
		rAgeTextBox.setBounds(149, 86, 33, 20);
		addPanel.add(rAgeTextBox);
		rAgeTextBox.setColumns(10);
		
		JComboBox rCatBox = new JComboBox();
		rCatBox.setModel(new DefaultComboBoxModel(new String[] {"", "Sprinter", "long Distance", "Mini Marathon", "Fun runner"}));
		rCatBox.setBounds(149, 131, 178, 22);
		addPanel.add(rCatBox);
		
		JButton addRunnerButton = new JButton("Add Runner");
		addRunnerButton.setBounds(160, 181, 89, 23);
		addPanel.add(addRunnerButton);
		
		JPanel removePanel = new JPanel();
		tabbedPane.addTab("Remove Runner", null, removePanel, null);
		
		JPanel updatePanel = new JPanel();
		tabbedPane.addTab("Update Runner", null, updatePanel, null);
		updatePanel.setLayout(null);
		
		JLabel label = new JLabel("Runner Name:");
		label.setBounds(42, 46, 80, 14);
		updatePanel.add(label);
		
		JLabel label_1 = new JLabel("Runner Age:");
		label_1.setBounds(42, 89, 80, 14);
		updatePanel.add(label_1);
		
		JLabel label_2 = new JLabel("Running Category:");
		label_2.setBounds(42, 136, 113, 14);
		updatePanel.add(label_2);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(114, 122, 178, 20);
		updatePanel.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(114, 122, 33, 20);
		updatePanel.add(textField_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(114, 122, 178, 22);
		updatePanel.add(comboBox);
		
		JButton button = new JButton("Add Runner");
		button.setBounds(114, 122, 89, 23);
		updatePanel.add(button);
		
		JLabel lblNewLabel = new JLabel("ITB Runner Database");
		lblNewLabel.setBounds(5, 5, 424, 19);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Lucida Console", Font.BOLD | Font.ITALIC, 18));
	}
}