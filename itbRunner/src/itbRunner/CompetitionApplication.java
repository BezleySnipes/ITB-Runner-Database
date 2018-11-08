package itbRunner;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class CompetitionApplication extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5780532187214899420L;

	private JPanel contentPane;
	private JTextField rNameAddTB;
	private JTextField rAgeAddTB;
	private JTextField rNameUpdateTB;
	private JTextField rNameRemoveTB;

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
		
		RunnerQueries run1 = new RunnerQueries();
		
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
		
		JTextArea displayAllTA = new JTextArea();
		displayAllTA.setBounds(10, 11, 399, 159);
		ShowAll.add(displayAllTA);
		
		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ResultSet rs = run1.showAll();
				String displayText = "";
				try {
					while (rs.next()) {
						String Name = rs.getString("runnerName");
						String Age = Integer.toString(rs.getInt("runnerAge"));
						String Cat = rs.getString("runningCategory");
	
						displayText += Name+",\t"+Age+",\t"+Cat+".\n";		
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				displayAllTA.setText(displayText);
			}
		});
		run1.showAll();
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
		
		rNameAddTB = new JTextField();
		rNameAddTB.setBounds(149, 43, 178, 20);
		addPanel.add(rNameAddTB);
		rNameAddTB.setColumns(10);
		
		rAgeAddTB = new JTextField();
		rAgeAddTB.setBounds(149, 86, 33, 20);
		addPanel.add(rAgeAddTB);
		rAgeAddTB.setColumns(10);
		
		JComboBox rCatAddCB = new JComboBox();
		rCatAddCB.setModel(new DefaultComboBoxModel(new String[] {"", "Sprinter", "long Distance", "Mini Marathon", "Fun runner"}));
		rCatAddCB.setBounds(149, 131, 178, 22);
		addPanel.add(rCatAddCB);
		
		JButton addRunnerButton = new JButton("Add Runner");
		addRunnerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					run1.insert(rNameAddTB.getText(), Integer.parseInt(rAgeAddTB.getText()), rCatAddCB.getSelectedItem().toString());
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "Please only enter numbers in the age field","ITB Runner Database",2);
					rAgeAddTB.setText("");
				}
				rNameAddTB.setText("");
				rAgeAddTB.setText("");
				rCatAddCB.setSelectedIndex(0);
			}
		});
		addRunnerButton.setBounds(160, 181, 89, 23);
		addPanel.add(addRunnerButton);
		
		JPanel removePanel = new JPanel();
		tabbedPane.addTab("Remove Runner", null, removePanel, null);
		removePanel.setLayout(null);
		
		JLabel rNameRemovelb = new JLabel("Runner Name:");
		rNameRemovelb.setBounds(59, 58, 90, 14);
		removePanel.add(rNameRemovelb);
		
		rNameRemoveTB = new JTextField();
		rNameRemoveTB.setBounds(150, 55, 153, 20);
		removePanel.add(rNameRemoveTB);
		rNameRemoveTB.setColumns(10);
		
		JButton btnRemoveRunner = new JButton("Remove");
		btnRemoveRunner.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				run1.remove(rNameRemoveTB.getText());
				rNameRemoveTB.setText("");
			}
		});
		btnRemoveRunner.setBounds(160, 181, 89, 23);
		removePanel.add(btnRemoveRunner);
		
		JPanel updatePanel = new JPanel();
		tabbedPane.addTab("Update Runner", null, updatePanel, null);
		updatePanel.setLayout(null);
		
		JLabel label = new JLabel("Runner Name:");
		label.setBounds(42, 46, 80, 14);
		updatePanel.add(label);
		
		JLabel label_2 = new JLabel("Running Category:");
		label_2.setBounds(42, 88, 113, 14);
		updatePanel.add(label_2);
		
		rNameUpdateTB = new JTextField();
		rNameUpdateTB.setColumns(10);
		rNameUpdateTB.setBounds(149, 43, 178, 20);
		updatePanel.add(rNameUpdateTB);
		
		JComboBox rCatUpdateCB = new JComboBox();
		rCatUpdateCB.setModel(new DefaultComboBoxModel(new String[] {"", "Sprinter", "long Distance", "Mini Marathon", "Fun runner"}));
		rCatUpdateCB.setBounds(149, 84, 178, 22);
		updatePanel.add(rCatUpdateCB);
		
		JButton rUpdateButton = new JButton("Update");
		rUpdateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				run1.update(rNameUpdateTB.getText(), rCatUpdateCB.getSelectedItem().toString());
				rNameUpdateTB.setText("");
				rCatUpdateCB.setSelectedIndex(0);
			}
		});
		rUpdateButton.setBounds(160, 181, 89, 23);
		updatePanel.add(rUpdateButton);
		
		JLabel lblNewLabel = new JLabel("ITB Runner Database");
		lblNewLabel.setBounds(5, 5, 424, 19);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Lucida Console", Font.BOLD | Font.ITALIC, 18));
	}
}
