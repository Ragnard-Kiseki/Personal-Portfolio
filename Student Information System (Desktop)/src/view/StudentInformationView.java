package view;

import net.miginfocom.swing.MigLayout;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

@SuppressWarnings("serial")
public class StudentInformationView extends JFrame {

	private JPanel contentPane;
	public static JTextField searchField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					StudentInformationView frame = new StudentInformationView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @throws IOException
	 */

	public StudentInformationView() throws IOException {
		UIManager.put("OptionPane.background", new Color(53, 53, 53));
		UIManager.put("OptionPane.messageForeground", new Color(255, 255, 255));
		UIManager.put("Panel.background", new Color(53, 53, 53));
		UIManager.put("Button.background", new Color(94, 94, 94));
		UIManager.put("Button.foreground", new Color(249, 224, 72));
		UIManager.put("PopupMenu.border", new LineBorder(new Color(53, 53, 53)));
		setBackground(new Color(53, 53, 53));
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage("src\\images\\tip logo.jpg"));
		setTitle("T.I.P Student Information");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 100, 538, 500);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(53, 53, 53));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		BufferedImage TIPimage = ImageIO
				.read(new File("src\\images\\TIPSIS1.png"));
		JPanel imagepanel = new JPanel();
		imagepanel.setBackground(new Color(53, 53, 53));
		contentPane.add(imagepanel, BorderLayout.NORTH);
		JLabel lblImage = new JLabel(new ImageIcon(TIPimage));
		imagepanel.add(lblImage);

		JPanel optionpanel = new JPanel();
		optionpanel.setBackground(new Color(53, 53, 53));
		contentPane.add(optionpanel, BorderLayout.CENTER);
		optionpanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JPanel tablepanel = new JPanel();
		optionpanel.add(tablepanel);
		tablepanel.setBackground(new Color(53, 53, 53));
		tablepanel.setLayout(new MigLayout("", "[80.00px][65.00][grow][89.00]", "[25.00px][][][]"));

		JButton btnAddStudent = new JButton("Add Student");
		btnAddStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new AddStudent().setVisible(true);
					dispose();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnAddStudent.setForeground(new Color(249, 224, 72));
		btnAddStudent.setBackground(new Color(94, 94, 94));
		btnAddStudent.setVisible(false);
		tablepanel.add(btnAddStudent, "cell 0 1,grow");

		JButton btnEditStudent = new JButton("Edit Student");
		btnEditStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new EditStudent().setVisible(true);
					dispose();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnEditStudent.setForeground(new Color(249, 224, 72));
		btnEditStudent.setBackground(new Color(94, 94, 94));
		btnEditStudent.setVisible(false);
		tablepanel.add(btnEditStudent, "cell 0 2,growx");

		JButton btnDeleteStudent = new JButton("Delete Student");
		btnDeleteStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new DeleteStudent().setVisible(true);
					dispose();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnDeleteStudent.setForeground(new Color(249, 224, 72));
		btnDeleteStudent.setBackground(new Color(94, 94, 94));
		btnDeleteStudent.setVisible(false);
		tablepanel.add(btnDeleteStudent, "cell 0 3,growx");

		JToggleButton btnMenuOption = new JToggleButton("Menu Option");
		btnMenuOption.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				if (btnMenuOption.isSelected()) {
					btnAddStudent.setVisible(true);
					btnEditStudent.setVisible(true);
					btnDeleteStudent.setVisible(true);
				} else {
					btnAddStudent.setVisible(false);
					btnEditStudent.setVisible(false);
					btnDeleteStudent.setVisible(false);
				}
			}
		});

		btnMenuOption.setForeground(new Color(249, 224, 72));
		btnMenuOption.setBackground(new Color(94, 94, 94));
		tablepanel.add(btnMenuOption, "flowx,cell 0 0,growx");

		JButton btnViewTable = new JButton("View Table");
		btnViewTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					File studentInformation = new File("src\\studentData\\studentinformation.txt");
					if (studentInformation.exists() == true) {
						new ViewSortedTable().setVisible(true);
						dispose();
					} else {
						if (JOptionPane.showConfirmDialog(null, "Error:\nYou have not added an information!",
								"System Information", JOptionPane.CLOSED_OPTION,
								JOptionPane.ERROR_MESSAGE) == JOptionPane.OK_OPTION) {
							if (JOptionPane.showConfirmDialog(null,
									"Prompt adding:\nDo you want to add an information?", "System Information",
									JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE) == JOptionPane.YES_OPTION) {
								if (JOptionPane.showConfirmDialog(null, "Going back to Add student option!",
										"System Information", JOptionPane.CLOSED_OPTION,
										JOptionPane.PLAIN_MESSAGE) == JOptionPane.OK_OPTION) {
									new AddStudent().setVisible(true);
									dispose();
								}
							} else {
							}
						} else {
						}
					}
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnViewTable.setForeground(new Color(249, 224, 72));
		btnViewTable.setBackground(new Color(94, 94, 94));
		btnViewTable.setVisible(false);
		tablepanel.add(btnViewTable, "cell 1 1");

		JToggleButton btnViewMenu = new JToggleButton("View Menu");
		btnViewMenu.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if (btnViewMenu.isSelected()) {
					btnViewTable.setVisible(true);
				} else {
					btnViewTable.setVisible(false);
				}
			}
		});
		btnViewMenu.setBackground(new Color(94, 94, 94));
		btnViewMenu.setForeground(new Color(249, 224, 72));
		tablepanel.add(btnViewMenu, "cell 1 0,grow");

		searchField = new JTextField();
		controller.SearchController search = new controller.SearchController(searchField);
		searchField.addKeyListener(search);
		tablepanel.add(searchField, "cell 2 1,growx");
		searchField.setVisible(false);
		searchField.setColumns(10);

		JToggleButton btnSearch = new JToggleButton("Search");
		btnSearch.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if (btnSearch.isSelected()) {
					searchField.setVisible(true);
				} else {
					searchField.setVisible(false);
				}
			}
		});
		btnSearch.setBackground(new Color(94, 94, 94));
		btnSearch.setForeground(new Color(249, 224, 72));
		tablepanel.add(btnSearch, "cell 2 0,grow");

		JButton btnlLogOut = new JButton("Log Out");
		btnlLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame frame = new JFrame();
				if (JOptionPane.showConfirmDialog(frame, "Are you sure you want to log out?", "Student Information",
						JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE) == JOptionPane.YES_NO_OPTION) {
					MainView.frmTipStudentInformation.setVisible(true);
					dispose();
				}

			}
		});
		btnlLogOut.setBackground(new Color(94, 94, 94));
		btnlLogOut.setForeground(new Color(249, 224, 72));
		tablepanel.add(btnlLogOut, "cell 3 0,grow");

	}

}
