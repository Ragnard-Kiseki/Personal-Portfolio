package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import controller.EditFileController;
import model.StudentInformationModel;

@SuppressWarnings("serial")
public class EditStudent extends JFrame {

	public static JPanel contentPane;
	public static JTable table;
	public static JTextField StudentNumber;
	public static JTextField FirstName;
	public static JTextField LastName;
	public static JTextField Age;
	public static JTextField Sexuality;
	public static JComboBox<Object> Sex = new JComboBox<Object>();
	public static JComboBox<Object> YearLevel = new JComboBox<Object>();
	public static JComboBox<Object> Program = new JComboBox<Object>();
	public static JButton btnEdit = new JButton("Update list");

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditStudent frame = new EditStudent();
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

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public EditStudent() throws IOException {

		UIManager.put("PopupMenu.border", new LineBorder(new Color(53, 53, 53)));
		setBackground(new Color(53, 53, 53));
		UIManager.put("PopupMenu.border", new LineBorder(new Color(53, 53, 53)));
		UIManager.put("OptionPane.background", new Color(53, 53, 53));
		UIManager.put("OptionPane.messageForeground", new Color(255, 255, 255));
		UIManager.put("Panel.background", new Color(53, 53, 53));
		UIManager.put("Button.background", new Color(94, 94, 94));
		UIManager.put("Button.foreground", new Color(249, 224, 72));
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage("C:\\Users\\AAA\\Desktop\\OOP\\CCS 201 - FinalsProject\\tip logo.jpg"));
		setTitle("T.I.P Student Information");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(25, 25, 1366, 768);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(53, 53, 53));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		BufferedImage TIPimage = ImageIO
				.read(new File("C:\\Users\\AAA\\Desktop\\OOP\\CCS 201 - FinalsProject\\TIPSIS1.png"));

		JPanel panelMenuBar = new JPanel();
		panelMenuBar.setForeground(new Color(249, 224, 72));
		panelMenuBar.setBackground(new Color(94, 94, 94));
		contentPane.add(panelMenuBar, BorderLayout.NORTH);
		panelMenuBar.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

		JMenuBar menuBar = new JMenuBar();
		menuBar.setForeground(new Color(249, 224, 72));
		menuBar.setBackground(new Color(53, 53, 53));
		panelMenuBar.add(menuBar);

		JMenu mnGotoMenu = new JMenu("Goto Menu");
		mnGotoMenu.setMnemonic('G');
		mnGotoMenu.setForeground(new Color(249, 224, 72));
		mnGotoMenu.setFont(new Font("SansSerif", Font.PLAIN, 18));
		mnGotoMenu.setBackground(new Color(53, 53, 53));
		menuBar.add(mnGotoMenu);

		JMenuItem mntmMainMenu = new JMenuItem("Main Menu");
		mntmMainMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new StudentInformationView().setVisible(true);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				dispose();
			}
		});
		mntmMainMenu.setPreferredSize(new Dimension(160, 25));
		mntmMainMenu.setHorizontalAlignment(SwingConstants.LEFT);
		mntmMainMenu.setForeground(new Color(249, 224, 72));
		mntmMainMenu.setFont(new Font("SansSerif", Font.PLAIN, 12));
		mntmMainMenu.setBackground(new Color(53, 53, 53));
		mnGotoMenu.add(mntmMainMenu);

		JSeparator separator = new JSeparator();
		separator.setPreferredSize(new Dimension(20, 1));
		separator.setForeground(SystemColor.controlShadow);
		separator.setBackground(SystemColor.windowBorder);
		mnGotoMenu.add(separator);

		JMenuItem mntmAddOption = new JMenuItem("Add Information");
		mntmAddOption.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new AddStudent().setVisible(true);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				dispose();
			}
		});
		mntmAddOption.setPreferredSize(new Dimension(160, 25));
		mntmAddOption.setHorizontalAlignment(SwingConstants.LEFT);
		mntmAddOption.setForeground(new Color(249, 224, 72));
		mntmAddOption.setFont(new Font("SansSerif", Font.PLAIN, 12));
		mntmAddOption.setBackground(new Color(53, 53, 53));
		mnGotoMenu.add(mntmAddOption);

		JSeparator separator_1 = new JSeparator();
		separator_1.setPreferredSize(new Dimension(20, 1));
		separator_1.setForeground(SystemColor.controlShadow);
		separator_1.setBackground(SystemColor.windowBorder);
		mnGotoMenu.add(separator_1);

		JMenuItem mntmDeleteOption = new JMenuItem("Delete Information");
		mntmDeleteOption.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new DeleteStudent().setVisible(true);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				dispose();
			}
		});
		mntmDeleteOption.setPreferredSize(new Dimension(160, 25));
		mntmDeleteOption.setHorizontalAlignment(SwingConstants.LEFT);
		mntmDeleteOption.setForeground(new Color(249, 224, 72));
		mntmDeleteOption.setFont(new Font("SansSerif", Font.PLAIN, 12));
		mntmDeleteOption.setBackground(new Color(53, 53, 53));
		mnGotoMenu.add(mntmDeleteOption);

		JSeparator separator_2 = new JSeparator();
		separator_2.setPreferredSize(new Dimension(20, 1));
		separator_2.setForeground(SystemColor.controlShadow);
		separator_2.setBackground(SystemColor.windowBorder);
		mnGotoMenu.add(separator_2);

		JMenuItem mntmViewOption = new JMenuItem("View Information");
		mntmViewOption.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					File studentInformation = new File("studentData//studentinformation.txt");
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
		mntmViewOption.setPreferredSize(new Dimension(160, 25));
		mntmViewOption.setHorizontalAlignment(SwingConstants.LEFT);
		mntmViewOption.setForeground(new Color(249, 224, 72));
		mntmViewOption.setFont(new Font("SansSerif", Font.PLAIN, 12));
		mntmViewOption.setBackground(new Color(53, 53, 53));
		mnGotoMenu.add(mntmViewOption);

		JPanel panelHeader = new JPanel();
		panelHeader.setBackground(new Color(53, 53, 53));
		contentPane.add(panelHeader, BorderLayout.CENTER);
		panelHeader.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 100));

		JPanel panelImage = new JPanel();
		panelHeader.add(panelImage);
		panelImage.setBackground(new Color(53, 53, 53));
		GridBagLayout gbl_panelImage = new GridBagLayout();
		gbl_panelImage.columnWidths = new int[] { 205, 0 };
		gbl_panelImage.rowHeights = new int[] { 146, 0, 0 };
		gbl_panelImage.columnWeights = new double[] { 0.0, Double.MIN_VALUE };
		gbl_panelImage.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		panelImage.setLayout(gbl_panelImage);
		JLabel lblImage = new JLabel(new ImageIcon(TIPimage));
		GridBagConstraints gbc_lblImage = new GridBagConstraints();
		gbc_lblImage.insets = new Insets(0, 0, 5, 0);
		gbc_lblImage.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblImage.gridx = 0;
		gbc_lblImage.gridy = 0;
		panelImage.add(lblImage, gbc_lblImage);

		JLabel lblNewLabel = new JLabel("Edit Student Information");
		lblNewLabel.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblNewLabel.setForeground(new Color(249, 224, 72));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.NORTH;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 1;
		panelImage.add(lblNewLabel, gbc_lblNewLabel);

		JPanel tablepanel = new JPanel();
		contentPane.add(tablepanel, BorderLayout.SOUTH);
		tablepanel.setBackground(new Color(53, 53, 53));

		JPanel sortedtablepanel = new JPanel();
		sortedtablepanel.setBackground(new Color(53, 53, 53));
		tablepanel.add(sortedtablepanel);
		GridBagLayout gbl_sortedtablepanel = new GridBagLayout();
		gbl_sortedtablepanel.columnWidths = new int[] { 0, 158, 0 };
		gbl_sortedtablepanel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_sortedtablepanel.columnWeights = new double[] { 1.0, 1.0, Double.MIN_VALUE };
		gbl_sortedtablepanel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		sortedtablepanel.setLayout(gbl_sortedtablepanel);

		JButton btnEditStudent = new JButton("Edit Student Number");
		btnEditStudent.setEnabled(false);
		btnEditStudent.setBackground(new Color(94, 94, 94));
		btnEditStudent.setForeground(new Color(249, 224, 72));
		GridBagConstraints gbc_btnEditStudent = new GridBagConstraints();
		gbc_btnEditStudent.fill = GridBagConstraints.VERTICAL;
		gbc_btnEditStudent.insets = new Insets(0, 0, 5, 5);
		gbc_btnEditStudent.gridx = 0;
		gbc_btnEditStudent.gridy = 0;
		sortedtablepanel.add(btnEditStudent, gbc_btnEditStudent);

		StudentNumber = new JTextField();
		GridBagConstraints gbc_StudentNumber = new GridBagConstraints();
		gbc_StudentNumber.insets = new Insets(0, 0, 5, 0);
		gbc_StudentNumber.fill = GridBagConstraints.HORIZONTAL;
		gbc_StudentNumber.gridx = 1;
		gbc_StudentNumber.gridy = 0;
		sortedtablepanel.add(StudentNumber, gbc_StudentNumber);
		StudentNumber.setColumns(10);

		JButton btnAddFirstname = new JButton("Edit Firstname");
		btnAddFirstname.setEnabled(false);
		btnAddFirstname.setForeground(new Color(249, 224, 72));
		btnAddFirstname.setBackground(new Color(94, 94, 94));
		GridBagConstraints gbc_btnAddFirstname = new GridBagConstraints();
		gbc_btnAddFirstname.fill = GridBagConstraints.BOTH;
		gbc_btnAddFirstname.insets = new Insets(0, 0, 5, 5);
		gbc_btnAddFirstname.gridx = 0;
		gbc_btnAddFirstname.gridy = 1;
		sortedtablepanel.add(btnAddFirstname, gbc_btnAddFirstname);

		FirstName = new JTextField();
		FirstName.setColumns(10);
		GridBagConstraints gbc_FirstName = new GridBagConstraints();
		gbc_FirstName.insets = new Insets(0, 0, 5, 0);
		gbc_FirstName.fill = GridBagConstraints.HORIZONTAL;
		gbc_FirstName.gridx = 1;
		gbc_FirstName.gridy = 1;
		sortedtablepanel.add(FirstName, gbc_FirstName);

		JButton btnAddLastname = new JButton("Edit Lastname");
		btnAddLastname.setEnabled(false);
		btnAddLastname.setForeground(new Color(249, 224, 72));
		btnAddLastname.setBackground(new Color(94, 94, 94));
		GridBagConstraints gbc_btnAddLastname = new GridBagConstraints();
		gbc_btnAddLastname.fill = GridBagConstraints.BOTH;
		gbc_btnAddLastname.insets = new Insets(0, 0, 5, 5);
		gbc_btnAddLastname.gridx = 0;
		gbc_btnAddLastname.gridy = 2;
		sortedtablepanel.add(btnAddLastname, gbc_btnAddLastname);

		LastName = new JTextField();
		LastName.setColumns(10);
		GridBagConstraints gbc_LastName = new GridBagConstraints();
		gbc_LastName.insets = new Insets(0, 0, 5, 0);
		gbc_LastName.fill = GridBagConstraints.HORIZONTAL;
		gbc_LastName.gridx = 1;
		gbc_LastName.gridy = 2;
		sortedtablepanel.add(LastName, gbc_LastName);

		JButton btnEditYearLevel = new JButton("Edit Year Level");
		btnEditYearLevel.setEnabled(false);
		btnEditYearLevel.setForeground(new Color(249, 224, 72));
		btnEditYearLevel.setBackground(new Color(94, 94, 94));
		GridBagConstraints gbc_btnEditYearLevel = new GridBagConstraints();
		gbc_btnEditYearLevel.fill = GridBagConstraints.BOTH;
		gbc_btnEditYearLevel.insets = new Insets(0, 0, 5, 5);
		gbc_btnEditYearLevel.gridx = 0;
		gbc_btnEditYearLevel.gridy = 3;
		sortedtablepanel.add(btnEditYearLevel, gbc_btnEditYearLevel);

		YearLevel.setModel(new DefaultComboBoxModel(new String[] { "1", "2", "3", "4" }));
		GridBagConstraints gbc_YearLevel = new GridBagConstraints();
		gbc_YearLevel.insets = new Insets(0, 0, 5, 0);
		gbc_YearLevel.fill = GridBagConstraints.BOTH;
		gbc_YearLevel.gridx = 1;
		gbc_YearLevel.gridy = 3;
		sortedtablepanel.add(YearLevel, gbc_YearLevel);

		JButton btnEditAge = new JButton("Edit Age");
		btnEditAge.setEnabled(false);
		btnEditAge.setForeground(new Color(249, 224, 72));
		btnEditAge.setBackground(new Color(94, 94, 94));
		GridBagConstraints gbc_btnEditAge = new GridBagConstraints();
		gbc_btnEditAge.fill = GridBagConstraints.BOTH;
		gbc_btnEditAge.insets = new Insets(0, 0, 5, 5);
		gbc_btnEditAge.gridx = 0;
		gbc_btnEditAge.gridy = 4;
		sortedtablepanel.add(btnEditAge, gbc_btnEditAge);

		Age = new JTextField();
		Age.setColumns(10);
		GridBagConstraints gbc_Age = new GridBagConstraints();
		gbc_Age.insets = new Insets(0, 0, 5, 0);
		gbc_Age.fill = GridBagConstraints.HORIZONTAL;
		gbc_Age.gridx = 1;
		gbc_Age.gridy = 4;
		sortedtablepanel.add(Age, gbc_Age);

		JButton btnEditSex = new JButton("Edit Sex");
		btnEditSex.setForeground(new Color(249, 224, 72));
		btnEditSex.setEnabled(false);
		btnEditSex.setBackground(new Color(94, 94, 94));
		GridBagConstraints gbc_btnEditSex = new GridBagConstraints();
		gbc_btnEditSex.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnEditSex.insets = new Insets(0, 0, 5, 5);
		gbc_btnEditSex.gridx = 0;
		gbc_btnEditSex.gridy = 5;
		sortedtablepanel.add(btnEditSex, gbc_btnEditSex);

		JButton btnEditSexuality = new JButton("Edit Sexuality");
		btnEditSexuality.setEnabled(false);
		btnEditSexuality.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		Sex.setModel(new DefaultComboBoxModel(new String[] { "M", "F" }));
		GridBagConstraints gbc_Sex = new GridBagConstraints();
		gbc_Sex.insets = new Insets(0, 0, 5, 0);
		gbc_Sex.fill = GridBagConstraints.HORIZONTAL;
		gbc_Sex.gridx = 1;
		gbc_Sex.gridy = 5;
		sortedtablepanel.add(Sex, gbc_Sex);
		btnEditSexuality.setForeground(new Color(249, 224, 72));
		btnEditSexuality.setBackground(new Color(94, 94, 94));
		GridBagConstraints gbc_btnEditSexuality = new GridBagConstraints();
		gbc_btnEditSexuality.fill = GridBagConstraints.BOTH;
		gbc_btnEditSexuality.insets = new Insets(0, 0, 5, 5);
		gbc_btnEditSexuality.gridx = 0;
		gbc_btnEditSexuality.gridy = 6;
		sortedtablepanel.add(btnEditSexuality, gbc_btnEditSexuality);

		Sexuality = new JTextField();
		Sexuality.setColumns(10);
		GridBagConstraints gbc_Sexuality = new GridBagConstraints();
		gbc_Sexuality.insets = new Insets(0, 0, 5, 0);
		gbc_Sexuality.fill = GridBagConstraints.HORIZONTAL;
		gbc_Sexuality.gridx = 1;
		gbc_Sexuality.gridy = 6;
		sortedtablepanel.add(Sexuality, gbc_Sexuality);

		JButton btnEditProgram = new JButton("Edit Program");
		btnEditProgram.setEnabled(false);
		btnEditProgram.setForeground(new Color(249, 224, 72));
		btnEditProgram.setBackground(new Color(94, 94, 94));
		GridBagConstraints gbc_btnEditProgram = new GridBagConstraints();
		gbc_btnEditProgram.fill = GridBagConstraints.BOTH;
		gbc_btnEditProgram.insets = new Insets(0, 0, 5, 5);
		gbc_btnEditProgram.gridx = 0;
		gbc_btnEditProgram.gridy = 7;
		sortedtablepanel.add(btnEditProgram, gbc_btnEditProgram);

		JScrollPane scrollTablePane = new JScrollPane();
		tablepanel.add(scrollTablePane);
		scrollTablePane.setBackground(new Color(53, 53, 53));
		table = new JTable();
		table.setCellSelectionEnabled(true);
		scrollTablePane.setViewportView(table);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setColumnSelectionAllowed(true);
		table = new JTable();
		table.setPreferredScrollableViewportSize(new Dimension(800, 300));
		table.setCellSelectionEnabled(true);
		scrollTablePane.setViewportView(table);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setColumnSelectionAllowed(true);
		StudentInformationModel modelinfo = new StudentInformationModel();
		table.setModel(modelinfo);

		// LANCE ADDED CODE FOR EDIT CLASS CRUD PROGRAM.

		DefaultTableModel add_row = (DefaultTableModel) table.getModel();

		// Use the automatic Source file.
		File studentInformation = new File("studentData//studentinformation.txt");

		// To show the table like in the add table.
		if (studentInformation.exists() == true) {
			BufferedReader read = new BufferedReader(new FileReader(studentInformation));
			Object[] rows = read.lines().toArray();
			for (int i = 0; i < rows.length; i++) {
				String line = rows[i].toString().trim();
				String[] dataRow = line.split(",");
				add_row.addRow(dataRow);

			}
			table.addMouseListener(new MouseAdapter() {

				@Override
				public void mouseClicked(MouseEvent e) {

					// i = the index of the selected row
					int i = table.getSelectedRow();

					StudentNumber.setText(add_row.getValueAt(i, 0).toString());
					FirstName.setText(add_row.getValueAt(i, 1).toString());
					LastName.setText(add_row.getValueAt(i, 2).toString());
					Sex.setSelectedItem(add_row.getValueAt(i, 3).toString());
					Sexuality.setText(add_row.getValueAt(i, 4).toString());
					Age.setText(add_row.getValueAt(i, 5).toString());
					YearLevel.setSelectedItem(add_row.getValueAt(i, 6).toString());
					Program.setSelectedItem(add_row.getValueAt(i, 7).toString());
				}
			});
			read.close();
		} else {
		}

		Program.setModel(new DefaultComboBoxModel(new String[] { "BSCS", "BSIT", "BSCE", "BSEMCE", "BSIS" }));
		Program.setToolTipText("");
		GridBagConstraints gbc_Program = new GridBagConstraints();
		gbc_Program.insets = new Insets(0, 0, 5, 0);
		gbc_Program.fill = GridBagConstraints.BOTH;
		gbc_Program.gridx = 1;
		gbc_Program.gridy = 7;
		sortedtablepanel.add(Program, gbc_Program);

		JButton btnDone = new JButton("Done");
		btnDone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new StudentInformationView().setVisible(true);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnDone.setForeground(new Color(249, 224, 72));
		btnDone.setBackground(new Color(94, 94, 94));
		GridBagConstraints gbc_btnDone = new GridBagConstraints();
		gbc_btnDone.insets = new Insets(0, 0, 0, 5);
		gbc_btnDone.fill = GridBagConstraints.BOTH;
		gbc_btnDone.gridx = 0;
		gbc_btnDone.gridy = 8;
		sortedtablepanel.add(btnDone, gbc_btnDone);

		EditFileController EditFileController = new EditFileController(btnEdit);
		btnEdit.addActionListener(EditFileController);
		btnEdit.setForeground(new Color(249, 224, 72));
		btnEdit.setBackground(new Color(94, 94, 94));
		GridBagConstraints gbc_btnEdit = new GridBagConstraints();
		gbc_btnEdit.fill = GridBagConstraints.BOTH;
		gbc_btnEdit.gridx = 1;
		gbc_btnEdit.gridy = 8;
		sortedtablepanel.add(btnEdit, gbc_btnEdit);

	}

}