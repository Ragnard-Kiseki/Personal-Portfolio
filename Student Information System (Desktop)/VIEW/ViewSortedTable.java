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
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import model.StudentInformationModel;

@SuppressWarnings("serial")
public class ViewSortedTable extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewSortedTable frame = new ViewSortedTable();
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

	public ViewSortedTable() throws IOException {

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

		JLabel lblNewLabel = new JLabel("View Student Information");
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
		gbl_sortedtablepanel.rowHeights = new int[] { 0, 0 };
		gbl_sortedtablepanel.columnWeights = new double[] { 0.0, Double.MIN_VALUE };
		gbl_sortedtablepanel.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		sortedtablepanel.setLayout(gbl_sortedtablepanel);

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
		gbc_btnDone.gridy = 0;
		sortedtablepanel.add(btnDone, gbc_btnDone);

		JScrollPane scrollTablePane = new JScrollPane();
		tablepanel.add(scrollTablePane);
		scrollTablePane.setBackground(new Color(53, 53, 53));

		StudentInformationModel modelinfo = new model.StudentInformationModel();
		table = new JTable();
		table.setAutoCreateRowSorter(true);
		table.setCellSelectionEnabled(true);
		table.setPreferredScrollableViewportSize(new Dimension(800, 300));
		scrollTablePane.setViewportView(table);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setColumnSelectionAllowed(true);
		table.setModel(modelinfo);
		DefaultTableModel add_row = (DefaultTableModel) table.getModel();
		File studentInformation = new File("studentData//studentinformation.txt");
		BufferedReader read = new BufferedReader(new FileReader(studentInformation));
		Object[] rows = read.lines().toArray();
		for (int i = 0; i < rows.length; i++) {
			String line = rows[i].toString().trim();
			String[] dataRow = line.split(",");
			add_row.addRow(dataRow);
		}
		read.close();
	}
}