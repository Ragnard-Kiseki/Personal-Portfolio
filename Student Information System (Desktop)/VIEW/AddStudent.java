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
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
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
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class AddStudent extends JFrame {

	public static JPanel contentPane;
	public static JTable table;
	public static JTextField studnoField;
	public static JTextField firstnameField;
	public static JTextField lastnameField;
	public static JTextField ageField;
	public static JComboBox<Object> comboBoxYearLevel = new JComboBox<Object>();
	public static JComboBox<Object> comboBoxProgram = new JComboBox<Object>();
	public static JComboBox<Object> comboBoxSex = new JComboBox<Object>();
	public static JTextField sexualityField;
	public static JButton btnAdd;
	public static Object[] rows = new Object[8];

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddStudent frame = new AddStudent();
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
	public AddStudent() throws IOException {
		
		controller.IntegerOnlyTextField int_only = new controller.IntegerOnlyTextField();
		UIManager.put("PopupMenu.border", new LineBorder(new Color(94, 94, 94)));
		UIManager.put("PopupMenu.border", BorderFactory.createLineBorder(new Color(94, 94, 94), 1));
		UIManager.put("PopupMenu.border", new LineBorder(new Color(53, 53, 53)));
		UIManager.put("OptionPane.background", new Color(53, 53, 53));
		UIManager.put("OptionPane.messageForeground", new Color(255, 255, 255));
		UIManager.put("Panel.background", new Color(53, 53, 53));
		UIManager.put("Button.background", new Color(94, 94, 94));
		UIManager.put("Button.foreground", new Color(249, 224, 72));
		setBackground(new Color(53, 53, 53));
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage("C:\\Users\\AAA\\Desktop\\OOP\\CCS 201 - FinalsProject\\tip logo.jpg"));
		setTitle("T.I.P Student Information");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		FlowLayout flowLayout_2 = (FlowLayout) panelMenuBar.getLayout();
		flowLayout_2.setAlignment(FlowLayout.LEFT);
		contentPane.add(panelMenuBar, BorderLayout.NORTH);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setForeground(new Color(249, 224, 72));
		menuBar.setBackground(new Color(53, 53, 53));
		panelMenuBar.add(menuBar);

		JMenu mnGotoMenu = new JMenu("Goto Menu");
		mnGotoMenu.setMnemonic('G');
		mnGotoMenu.setForeground(new Color(249, 224, 72));
		mnGotoMenu.setBackground(new Color(53, 53, 53));
		mnGotoMenu.setFont(new Font("SansSerif", Font.PLAIN, 18));
		menuBar.add(mnGotoMenu);

		JMenuItem mntmMainMenu = new JMenuItem("Main Menu");
		mntmMainMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new StudentInformationView().setVisible(true);
					dispose();
				} catch (IOException e1) {
					e1.printStackTrace();
				}

			}
		});
		mntmMainMenu.setIcon(new ImageIcon(
				AddStudent.class.getResource("/com/sun/java/swing/plaf/windows/icons/image-delayed.png")));
		mntmMainMenu.setHorizontalAlignment(SwingConstants.LEFT);
		mntmMainMenu.setForeground(new Color(249, 224, 72));
		mntmMainMenu.setBackground(new Color(53, 53, 53));
		mntmMainMenu.setPreferredSize(new Dimension(160, 25));
		mntmMainMenu.setFont(new Font("SansSerif", Font.PLAIN, 12));
		mnGotoMenu.add(mntmMainMenu);

		JSeparator separator = new JSeparator();
		separator.setPreferredSize(new Dimension(20, 1));
		separator.setForeground(SystemColor.controlShadow);
		separator.setBackground(SystemColor.windowBorder);
		mnGotoMenu.add(separator);

		JMenuItem mntmEditOption = new JMenuItem("Edit Information");
		mntmEditOption.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new EditStudent().setVisible(true);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				dispose();
			}
		});
		mntmEditOption.setIcon(new ImageIcon(
				AddStudent.class.getResource("/com/sun/java/swing/plaf/windows/icons/image-delayed.png")));
		mntmEditOption.setPreferredSize(new Dimension(160, 25));
		mntmEditOption.setHorizontalAlignment(SwingConstants.LEFT);
		mntmEditOption.setForeground(new Color(249, 224, 72));
		mntmEditOption.setFont(new Font("SansSerif", Font.PLAIN, 12));
		mntmEditOption.setBackground(new Color(53, 53, 53));
		mnGotoMenu.add(mntmEditOption);

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
		mntmDeleteOption.setIcon(new ImageIcon(
				AddStudent.class.getResource("/com/sun/java/swing/plaf/windows/icons/image-delayed.png")));
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
		mntmViewOption.setIcon(new ImageIcon(
				AddStudent.class.getResource("/com/sun/java/swing/plaf/windows/icons/image-delayed.png")));
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

		JLabel lblTitleLabel = new JLabel("Add Student Information");
		lblTitleLabel.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblTitleLabel.setForeground(new Color(249, 224, 72));
		GridBagConstraints gbc_lblTitleLabel = new GridBagConstraints();
		gbc_lblTitleLabel.anchor = GridBagConstraints.NORTH;
		gbc_lblTitleLabel.gridx = 0;
		gbc_lblTitleLabel.gridy = 1;
		panelImage.add(lblTitleLabel, gbc_lblTitleLabel);

		JPanel panelBody = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panelBody.getLayout();
		flowLayout_1.setAlignOnBaseline(true);

		contentPane.add(panelBody, BorderLayout.SOUTH);
		panelBody.setBackground(new Color(53, 53, 53));

		JPanel panelTable = new JPanel();
		panelTable.setBackground(new Color(53, 53, 53));
		panelBody.add(panelTable);
		GridBagLayout gbl_panelTable = new GridBagLayout();
		gbl_panelTable.columnWidths = new int[] { 0, 158, 0 };
		gbl_panelTable.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panelTable.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gbl_panelTable.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		panelTable.setLayout(gbl_panelTable);

		JButton btnNewButton = new JButton("Student Number");
		btnNewButton.setEnabled(false);
		btnNewButton.setBackground(new Color(94, 94, 94));
		btnNewButton.setForeground(new Color(249, 224, 72));
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 0;
		panelTable.add(btnNewButton, gbc_btnNewButton);

		studnoField = new JTextField();
		studnoField.addKeyListener(int_only);
		GridBagConstraints gbc_studnoField = new GridBagConstraints();
		gbc_studnoField.insets = new Insets(0, 0, 5, 0);
		gbc_studnoField.fill = GridBagConstraints.HORIZONTAL;
		gbc_studnoField.gridx = 1;
		gbc_studnoField.gridy = 0;
		panelTable.add(studnoField, gbc_studnoField);
		studnoField.setColumns(1);

		JButton btnAddFirstname = new JButton("Firstname");
		btnAddFirstname.setEnabled(false);
		btnAddFirstname.setForeground(new Color(249, 224, 72));
		btnAddFirstname.setBackground(new Color(94, 94, 94));
		GridBagConstraints gbc_btnAddFirstname = new GridBagConstraints();
		gbc_btnAddFirstname.fill = GridBagConstraints.BOTH;
		gbc_btnAddFirstname.insets = new Insets(0, 0, 5, 5);
		gbc_btnAddFirstname.gridx = 0;
		gbc_btnAddFirstname.gridy = 1;
		panelTable.add(btnAddFirstname, gbc_btnAddFirstname);

		firstnameField = new JTextField();
		firstnameField.setColumns(1);
		GridBagConstraints gbc_firstnameField = new GridBagConstraints();
		gbc_firstnameField.insets = new Insets(0, 0, 5, 0);
		gbc_firstnameField.fill = GridBagConstraints.HORIZONTAL;
		gbc_firstnameField.gridx = 1;
		gbc_firstnameField.gridy = 1;
		panelTable.add(firstnameField, gbc_firstnameField);

		JButton btnAddLastname = new JButton("Lastname");
		btnAddLastname.setEnabled(false);
		btnAddLastname.setForeground(new Color(249, 224, 72));
		btnAddLastname.setBackground(new Color(94, 94, 94));
		GridBagConstraints gbc_btnAddLastname = new GridBagConstraints();
		gbc_btnAddLastname.fill = GridBagConstraints.BOTH;
		gbc_btnAddLastname.insets = new Insets(0, 0, 5, 5);
		gbc_btnAddLastname.gridx = 0;
		gbc_btnAddLastname.gridy = 2;
		panelTable.add(btnAddLastname, gbc_btnAddLastname);

		lastnameField = new JTextField();
		lastnameField.setColumns(1);
		GridBagConstraints gbc_lastnameField = new GridBagConstraints();
		gbc_lastnameField.insets = new Insets(0, 0, 5, 0);
		gbc_lastnameField.fill = GridBagConstraints.HORIZONTAL;
		gbc_lastnameField.gridx = 1;
		gbc_lastnameField.gridy = 2;
		panelTable.add(lastnameField, gbc_lastnameField);

		JButton btnYearLevel = new JButton("Year Level");
		btnYearLevel.setEnabled(false);
		btnYearLevel.setForeground(new Color(249, 224, 72));
		btnYearLevel.setBackground(new Color(94, 94, 94));
		GridBagConstraints gbc_btnYearLevel = new GridBagConstraints();
		gbc_btnYearLevel.fill = GridBagConstraints.BOTH;
		gbc_btnYearLevel.insets = new Insets(0, 0, 5, 5);
		gbc_btnYearLevel.gridx = 0;
		gbc_btnYearLevel.gridy = 3;
		panelTable.add(btnYearLevel, gbc_btnYearLevel);
		comboBoxYearLevel.setMaximumRowCount(4);

		comboBoxYearLevel.setModel(new DefaultComboBoxModel(new String[] { "1", "2", "3", "4" }));
		GridBagConstraints gbc_comboBoxYearLevel = new GridBagConstraints();
		gbc_comboBoxYearLevel.insets = new Insets(0, 0, 5, 0);
		gbc_comboBoxYearLevel.fill = GridBagConstraints.BOTH;
		gbc_comboBoxYearLevel.gridx = 1;
		gbc_comboBoxYearLevel.gridy = 3;
		panelTable.add(comboBoxYearLevel, gbc_comboBoxYearLevel);

		JButton btnAge = new JButton("Age");
		btnAge.setEnabled(false);
		btnAge.setForeground(new Color(249, 224, 72));
		btnAge.setBackground(new Color(94, 94, 94));
		GridBagConstraints gbc_btnAge = new GridBagConstraints();
		gbc_btnAge.fill = GridBagConstraints.BOTH;
		gbc_btnAge.insets = new Insets(0, 0, 5, 5);
		gbc_btnAge.gridx = 0;
		gbc_btnAge.gridy = 4;
		panelTable.add(btnAge, gbc_btnAge);

		ageField = new JTextField();
		ageField.addKeyListener(int_only);
		ageField.setColumns(1);
		GridBagConstraints gbc_ageField = new GridBagConstraints();
		gbc_ageField.insets = new Insets(0, 0, 5, 0);
		gbc_ageField.fill = GridBagConstraints.HORIZONTAL;
		gbc_ageField.gridx = 1;
		gbc_ageField.gridy = 4;
		panelTable.add(ageField, gbc_ageField);

		JButton btnSex = new JButton("Sex");
		btnSex.setEnabled(false);
		btnSex.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSex.setForeground(new Color(249, 224, 72));
		btnSex.setBackground(new Color(94, 94, 94));
		GridBagConstraints gbc_btnSex = new GridBagConstraints();
		gbc_btnSex.fill = GridBagConstraints.BOTH;
		gbc_btnSex.insets = new Insets(0, 0, 5, 5);
		gbc_btnSex.gridx = 0;
		gbc_btnSex.gridy = 5;
		panelTable.add(btnSex, gbc_btnSex);

		JButton btnProgram = new JButton("Program");
		btnProgram.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		comboBoxSex.setMaximumRowCount(2);

		comboBoxSex.setModel(new DefaultComboBoxModel(new String[] { "M", "F" }));
		comboBoxSex.setToolTipText("");
		GridBagConstraints gbc_comboBoxSex = new GridBagConstraints();
		gbc_comboBoxSex.insets = new Insets(0, 0, 5, 0);
		gbc_comboBoxSex.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxSex.gridx = 1;
		gbc_comboBoxSex.gridy = 5;
		panelTable.add(comboBoxSex, gbc_comboBoxSex);

		JButton btnSexuality = new JButton("Sexuality");
		btnSexuality.setForeground(new Color(249, 224, 72));
		btnSexuality.setEnabled(false);
		btnSexuality.setBackground(new Color(94, 94, 94));
		GridBagConstraints gbc_btnSexuality = new GridBagConstraints();
		gbc_btnSexuality.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnSexuality.insets = new Insets(0, 0, 5, 5);
		gbc_btnSexuality.gridx = 0;
		gbc_btnSexuality.gridy = 6;
		panelTable.add(btnSexuality, gbc_btnSexuality);

		sexualityField = new JTextField();
		sexualityField.setColumns(1);
		GridBagConstraints gbc_sexualityField = new GridBagConstraints();
		gbc_sexualityField.insets = new Insets(0, 0, 5, 0);
		gbc_sexualityField.fill = GridBagConstraints.HORIZONTAL;
		gbc_sexualityField.gridx = 1;
		gbc_sexualityField.gridy = 6;
		panelTable.add(sexualityField, gbc_sexualityField);
		btnProgram.setEnabled(false);
		btnProgram.setForeground(new Color(249, 224, 72));
		btnProgram.setBackground(new Color(94, 94, 94));
		GridBagConstraints gbc_btnProgram = new GridBagConstraints();
		gbc_btnProgram.fill = GridBagConstraints.BOTH;
		gbc_btnProgram.insets = new Insets(0, 0, 5, 5);
		gbc_btnProgram.gridx = 0;
		gbc_btnProgram.gridy = 7;
		panelTable.add(btnProgram, gbc_btnProgram);
		comboBoxProgram.setMaximumRowCount(6);

		comboBoxProgram
				.setModel(new DefaultComboBoxModel(new String[] { "--", "BSCS", "BSIT", "BSIS", "BSCE", "BSEMCE" }));
		comboBoxProgram.setToolTipText("");
		GridBagConstraints gbc_comboBoxProgram = new GridBagConstraints();
		gbc_comboBoxProgram.insets = new Insets(0, 0, 5, 0);
		gbc_comboBoxProgram.fill = GridBagConstraints.BOTH;
		gbc_comboBoxProgram.gridx = 1;
		gbc_comboBoxProgram.gridy = 7;
		panelTable.add(comboBoxProgram, gbc_comboBoxProgram);

		JButton btnDone = new JButton("Done");
		btnDone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new StudentInformationView().setVisible(true);
					Window window = SwingUtilities.windowForComponent(btnDone);
					window.dispose();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnDone.setForeground(new Color(249, 224, 72));
		btnDone.setBackground(new Color(94, 94, 94));
		GridBagConstraints gbc_btnDone = new GridBagConstraints();
		gbc_btnDone.fill = GridBagConstraints.BOTH;
		gbc_btnDone.insets = new Insets(0, 0, 0, 5);
		gbc_btnDone.gridx = 0;
		gbc_btnDone.gridy = 8;
		panelTable.add(btnDone, gbc_btnDone);

		JScrollPane scrollTablePane = new JScrollPane();
		panelBody.add(scrollTablePane);
		scrollTablePane.setBackground(new Color(53, 53, 53));

		table = new JTable();
		table.setAutoCreateRowSorter(true);
		table.setPreferredScrollableViewportSize(new Dimension(800, 300));
		table.setCellSelectionEnabled(true);
		scrollTablePane.setViewportView(table);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setColumnSelectionAllowed(true);
		model.StudentInformationModel modelinfo = new model.StudentInformationModel();
		table.setModel(modelinfo);
		DefaultTableModel add_row = (DefaultTableModel) table.getModel();
		File studentInformation = new File("studentData//studentinformation.txt");
		if (studentInformation.exists() == true) {
			BufferedReader read = new BufferedReader(new FileReader(studentInformation));
			Object[] rows = read.lines().toArray();
			for (int i = 0; i < rows.length; i++) {
				String line = rows[i].toString().trim();
				String[] dataRow = line.split(",");
				add_row.addRow(dataRow);
			}
			read.close();
		} else {
		}

		btnAdd = new JButton("Add Information");
		GridBagConstraints gbc_btnAdd = new GridBagConstraints();
		gbc_btnAdd.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnAdd.gridx = 1;
		gbc_btnAdd.gridy = 8;
		panelTable.add(btnAdd, gbc_btnAdd);
		controller.btnAddController fileCreationCheck = new controller.btnAddController(btnAdd);
		btnAdd.addActionListener(fileCreationCheck);
		btnAdd.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				controller.btnAddController addInformation = new controller.btnAddController(btnAdd);
				addInformation.AddingInformation();

			}

		});
		btnAdd.setForeground(new Color(249, 224, 72));
		btnAdd.setBackground(new Color(94, 94, 94));
	}
}
