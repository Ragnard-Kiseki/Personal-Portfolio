package view;

import controller.btnDeleteController;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

@SuppressWarnings("serial")
public class DeleteStudent extends JFrame {
	public static JButton btnDelete = new JButton("Delete Student in Row");
	public static JTable table;
	public static DefaultTableModel modify_row;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteStudent frame = new DeleteStudent();
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

	public DeleteStudent() throws IOException {
		model.StudentInformationModel model = new model.StudentInformationModel();
		UIManager.put("PopupMenu.border", new LineBorder(new Color(53, 53, 53)));
		UIManager.put("PopupMenu.border", new LineBorder(new Color(53, 53, 53)));
		UIManager.put("OptionPane.background", new Color(53, 53, 53));
		UIManager.put("OptionPane.messageForeground", new Color(255, 255, 255));
		UIManager.put("Panel.background", new Color(53, 53, 53));
		UIManager.put("Button.background", new Color(94, 94, 94));
		UIManager.put("Button.foreground", new Color(249, 224, 72));
		setBackground(new Color(53, 53, 53));
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage("src\\images\\tip logo.jpg"));
		setTitle("T.I.P Student Information");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(25, 25, 1366, 768);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(53, 53, 53));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		BufferedImage TIPimage = ImageIO
				.read(new File("src\\images\\TIPSIS1.png"));

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
		mntmEditOption.setPreferredSize(new Dimension(160, 25));
		mntmEditOption.setHorizontalAlignment(SwingConstants.LEFT);
		mntmEditOption.setForeground(new Color(249, 224, 72));
		mntmEditOption.setFont(new Font("SansSerif", Font.PLAIN, 12));
		mntmEditOption.setBackground(new Color(53, 53, 53));
		mnGotoMenu.add(mntmEditOption);

		JSeparator separator_2 = new JSeparator();
		separator_2.setPreferredSize(new Dimension(20, 1));
		separator_2.setForeground(SystemColor.controlShadow);
		separator_2.setBackground(SystemColor.windowBorder);
		mnGotoMenu.add(separator_2);

		JMenuItem mntmViewOption = new JMenuItem("View Information");
		mntmViewOption.addActionListener(new ActionListener() {
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

		JLabel lblNewLabel = new JLabel("Delete Student Information");
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
		gbl_sortedtablepanel.columnWidths = new int[] { 0, 0 };
		gbl_sortedtablepanel.rowHeights = new int[] { 0, 0, 0 };
		gbl_sortedtablepanel.columnWeights = new double[] { 0.0, Double.MIN_VALUE };
		gbl_sortedtablepanel.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		sortedtablepanel.setLayout(gbl_sortedtablepanel);

		btnDelete.setBackground(new Color(94, 94, 94));
		btnDelete.setForeground(new Color(249, 224, 72));
		btnDeleteController delete = new btnDeleteController(btnDelete);
		btnDelete.addActionListener(delete);
		GridBagConstraints gbc_btnDelete = new GridBagConstraints();
		gbc_btnDelete.fill = GridBagConstraints.BOTH;
		gbc_btnDelete.insets = new Insets(0, 0, 5, 0);
		gbc_btnDelete.gridx = 0;
		gbc_btnDelete.gridy = 0;
		sortedtablepanel.add(btnDelete, gbc_btnDelete);

		JButton btnDone = new JButton("Done");
		btnDone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new StudentInformationView().setVisible(true);
					dispose();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnDone.setForeground(new Color(249, 224, 72));
		btnDone.setBackground(new Color(94, 94, 94));
		GridBagConstraints gbc_btnDone = new GridBagConstraints();
		gbc_btnDone.fill = GridBagConstraints.BOTH;
		gbc_btnDone.gridx = 0;
		gbc_btnDone.gridy = 1;
		sortedtablepanel.add(btnDone, gbc_btnDone);

		JScrollPane scrollTablePane = new JScrollPane();
		tablepanel.add(scrollTablePane);
		scrollTablePane.setBackground(new Color(53, 53, 53));

		table = new JTable();
		table.setAutoCreateRowSorter(true);
		table.setPreferredScrollableViewportSize(new Dimension(800, 300));
		table.setCellSelectionEnabled(true);
		scrollTablePane.setViewportView(table);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setColumnSelectionAllowed(true);
		table.setModel(model);
		modify_row = (DefaultTableModel) table.getModel();
		File studentInformation = new File("studentData//studentinformation.txt");
		if (studentInformation.exists() == true) {
			BufferedReader read = new BufferedReader(new FileReader(studentInformation));
			Object[] rows = read.lines().toArray();
			for (int i = 0; i < rows.length; i++) {
				String line = rows[i].toString().trim();
				String[] dataRow = line.split(",");
				modify_row.addRow(dataRow);

			}
			read.close();
		}

	}

}