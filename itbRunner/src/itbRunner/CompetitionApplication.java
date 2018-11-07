package itbRunner;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JTextPane;
import javax.swing.JTextArea;

public class CompetitionApplication extends JFrame {

	private JPanel contentPane;

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
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		JPanel ShowAll = new JPanel();
		tabbedPane.addTab("Show All", null, ShowAll, null);
		ShowAll.setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 11, 399, 201);
		ShowAll.add(textArea);
		
		JPanel addPanel = new JPanel();
		tabbedPane.addTab("Add Runner", null, addPanel, null);
		
		JPanel removePanel = new JPanel();
		tabbedPane.addTab("Remove Runner", null, removePanel, null);
		
		JPanel updatePanel = new JPanel();
		tabbedPane.addTab("Update Runner", null, updatePanel, null);
	}
}
