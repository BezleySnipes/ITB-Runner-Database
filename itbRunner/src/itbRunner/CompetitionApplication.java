package itbRunner;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
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
import javax.swing.JScrollPane;

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
					CompetitionApplication frame = new CompetitionApplication("root","root");
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
	public CompetitionApplication(String par1,String par2) {
		// creates an object from the runner class
		RunnerQueries run1 = new RunnerQueries(par1,par2);
		
		//Set the Jpanel dimensions
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Create tabbed panel
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(5, 24, 424, 232);
		contentPane.add(tabbedPane);
		
		//Create show all tab
		JPanel ShowAll = new JPanel();
		tabbedPane.addTab("Show All", null, ShowAll, null);
		ShowAll.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 24, 400, 146);
		ShowAll.add(scrollPane);
		
		JTextArea displayAllTA = new JTextArea();
		scrollPane.setViewportView(displayAllTA);
		displayAllTA.setEditable(false);
		displayAllTA.setFont(new Font("Courier New", Font.PLAIN, 13));
		displayAllTA.setAutoscrolls(true);
						
		JLabel lblRunnerName_1 = new JLabel("Runner Name");
		lblRunnerName_1.setBounds(10, 8, 80, 14);
		ShowAll.add(lblRunnerName_1);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setBounds(184, 8, 46, 14);
		ShowAll.add(lblAge);
		
		JLabel lblRunningCategory_1 = new JLabel("Running Category");
		lblRunningCategory_1.setBounds(269, 8, 129, 14);
		ShowAll.add(lblRunningCategory_1);
		
		//Event logic and button
		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//process the ResultSet
				ResultSet rs = run1.showAll();
				String displayText = "";
				try {
					while (rs.next()) {
					//	First method to populate the text area, this one calls on the whitespace method to format the text area
						String Name = rs.getString("runnerName");
						String Age = Integer.toString(rs.getInt("runnerAge"));
						String Cat = rs.getString("runningCategory");
						displayText += Name+","+ whiteSpace(20-(Name.length()))+Age+","+ whiteSpace(8-(Age.length()))+Cat+".\n";
						
//					//  Second method to populate text area, this one creates objects from the runner class	
//						int Age = rs.getInt("runnerAge");
//						runner nR1 = new runner(Name,Age,Cat);
//						displayAllTA.append(nR1.toString()+"\n");
						
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
		
		//Create the add runner tab
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
		rCatAddCB.setModel(new DefaultComboBoxModel(new String[] {"Sprinter", "long Distance", "Mini Marathon", "Fun runner"}));
		rCatAddCB.setBounds(149, 131, 178, 22);
		rCatAddCB.setSelectedIndex(-1);
		addPanel.add(rCatAddCB);
		
		JButton addRunnerButton = new JButton("Add");
		addRunnerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if ( rNameAddTB.getText().isEmpty() == false && Integer.parseInt(rAgeAddTB.getText())>0 && Integer.parseInt(rAgeAddTB.getText())<100) {
					run1.insert(rNameAddTB.getText(), Integer.parseInt(rAgeAddTB.getText()), rCatAddCB.getSelectedItem().toString());
					}else {
						JOptionPane.showMessageDialog(null, "Please fill in all fields with correctly formatted information.","ITB Runner Database",2);
					}
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, "Please only enter numbers in the age field","ITB Runner Database",2);
					rAgeAddTB.setText("");
				}catch (NullPointerException e2) {
					JOptionPane.showMessageDialog(null, "Please make sure you select a running category","ITB Runner Database",2);
				}
				rNameAddTB.setText("");
				rAgeAddTB.setText("");
				rCatAddCB.setSelectedIndex(-1);
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
				int success = 0;
				if(rNameRemoveTB.getText().isEmpty() == false) {
					success = run1.remove(rNameRemoveTB.getText());
					rNameRemoveTB.setText("");
					}else {
						JOptionPane.showMessageDialog(null, "Please make sure you enter a runners name","ITB Runner Database",2);
					}
				if(success >0 ) {
					JOptionPane.showMessageDialog(null, "Success!!!", "ITB Runner Database",1);
				}else {
					JOptionPane.showMessageDialog(null, "No runner by that name was found in the database", "ITB Runner Database",2);
				}
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
		rCatUpdateCB.setModel(new DefaultComboBoxModel(new String[] {"Sprinter", "long Distance", "Mini Marathon", "Fun runner"}));
		rCatUpdateCB.setBounds(149, 84, 178, 22);
		rCatUpdateCB.setSelectedIndex(-1);
		updatePanel.add(rCatUpdateCB);
		
		JButton rUpdateButton = new JButton("Update");
		rUpdateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				int success = run1.update(rNameUpdateTB.getText(), rCatUpdateCB.getSelectedItem().toString());
				rNameUpdateTB.setText("");
				rCatUpdateCB.setSelectedIndex(-1);
						
				if(success >0 ) {
					JOptionPane.showMessageDialog(null, "Success!!!", "ITB Runner Database",1);
				}else {
					JOptionPane.showMessageDialog(null, "No runner by that name was found in the database", "ITB Runner Database",2);
				}}catch (NullPointerException e2) {
					JOptionPane.showMessageDialog(null, "Please make sure to provide all required information", "ITB Runner Database",2);
				}
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
	
	public String whiteSpace(int par1) {
		String ws = "";
		for(int i = 0;i<=par1;i++) {
			ws += " ";
		}
		return ws;
	}
}
