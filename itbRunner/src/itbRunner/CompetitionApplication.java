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
		
		runner r1 = new runner();
		
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
				r1.showAll();
				
				
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
				r1.add(rNameAddTB.getText(), Integer.parseInt(rAgeAddTB.getText()), rCatAddCB.getSelectedItem().toString());
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
				r1.remove(rNameRemoveTB.getText());
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
				r1.update(rNameUpdateTB.getText(), rCatUpdateCB.getSelectedItem().toString());
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
