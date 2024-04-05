package view;

import java.awt.EventQueue;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Toolkit;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class MainView extends JFrame {

	public static JFrame frmTipStudentInformation ;
	public static JPasswordField txtPassword;
	public static JTextField txtUssername;
	public static JButton btnlogIn;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@SuppressWarnings("static-access")
			public void run() {
				try {
					MainView window = new MainView();
					window.frmTipStudentInformation.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * 
	 * @throws IOException
	 */
	
	
	
	public MainView() throws IOException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws IOException
	 */
	private void initialize() throws IOException {
		UIManager.put("OptionPane.background", new Color(53, 53, 53));
		UIManager.put("OptionPane.messageForeground", new Color(255, 255, 255));
		UIManager.put("Panel.background", new Color(53, 53, 53));
		UIManager.put("Button.background", new Color(94, 94, 94));
		UIManager.put("Button.foreground", new Color(249, 224, 72));
		frmTipStudentInformation = new JFrame();
		frmTipStudentInformation.setIconImage(Toolkit.getDefaultToolkit()
				.getImage("C:\\Users\\AAA\\Desktop\\OOP\\CCS 201 - FinalsProject\\tip logo.jpg"));
		frmTipStudentInformation.getContentPane().setBackground(new Color(53, 53, 53));
		BufferedImage TIPimage = ImageIO
				.read(new File("C:\\Users\\AAA\\Desktop\\OOP\\CCS 201 - FinalsProject\\TIPSIS1.png"));

		JPanel imagepanel = new JPanel();
		imagepanel.setBackground(new Color(53, 53, 53));
		frmTipStudentInformation.getContentPane().add(imagepanel, BorderLayout.NORTH);
		JLabel lblImage = new JLabel(new ImageIcon(TIPimage));
		imagepanel.add(lblImage);

		JPanel securitypanel = new JPanel();
		securitypanel.setBackground(new Color(53, 53, 53));
		frmTipStudentInformation.getContentPane().add(securitypanel, BorderLayout.CENTER);
		GridBagLayout gbl_securitypanel = new GridBagLayout();
		gbl_securitypanel.columnWidths = new int[] { 0, 89 };
		gbl_securitypanel.columnWeights = new double[] { 0.0, 0.0 };
		gbl_securitypanel.rowWeights = new double[] { 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0 };
		gbl_securitypanel.rowHeights = new int[] { 0, 34, 45, 0, 0, 0, 0, 59, 0 };
		securitypanel.setLayout(gbl_securitypanel);

		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblUsername.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblUsername = new GridBagConstraints();
		gbc_lblUsername.weighty = 1.0;
		gbc_lblUsername.insets = new Insets(0, 0, 5, 5);
		gbc_lblUsername.gridx = 0;
		gbc_lblUsername.gridy = 0;
		gbc_lblUsername.anchor = GridBagConstraints.NORTHEAST;
		securitypanel.add(lblUsername, gbc_lblUsername);

		txtUssername = new JTextField();
		txtUssername.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtUssername.setForeground(Color.WHITE);
		txtUssername.setBackground(new Color(94, 94, 94));
		GridBagConstraints gbc_txtUssername = new GridBagConstraints();
		gbc_txtUssername.anchor = GridBagConstraints.ABOVE_BASELINE;
		gbc_txtUssername.insets = new Insets(0, 0, 5, 0);
		gbc_txtUssername.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtUssername.gridx = 1;
		gbc_txtUssername.gridy = 0;
		securitypanel.add(txtUssername, gbc_txtUssername);
		txtUssername.setColumns(10);

		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblPassword.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblPassword = new GridBagConstraints();
		gbc_lblPassword.weighty = 4.0;
		gbc_lblPassword.gridx = 0;
		gbc_lblPassword.gridy = 1;
		gbc_lblPassword.insets = new Insets(1, 0, 10, 5);
		gbc_lblPassword.anchor = GridBagConstraints.NORTH;
		securitypanel.add(lblPassword, gbc_lblPassword);

		txtPassword = new JPasswordField();
		txtPassword.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtPassword.setForeground(Color.WHITE);
		txtPassword.setBackground(new Color(94, 94, 94));
		GridBagConstraints gbc_txtPassword = new GridBagConstraints();
		gbc_txtPassword.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPassword.anchor = GridBagConstraints.NORTH;
		gbc_txtPassword.insets = new Insets(0, 0, 5, 0);
		gbc_txtPassword.gridx = 1;
		gbc_txtPassword.gridy = 1;
		securitypanel.add(txtPassword, gbc_txtPassword);
		
				JButton btnlogin = new JButton("Log in");
				btnlogin.setFont(new Font("SansSerif", Font.BOLD, 16));
				btnlogin.setMnemonic('I');
				btnlogin.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						
						 try {
							 controller.btnLogInController log = new controller.btnLogInController();
							log.login();
						} catch (IOException e1) {
						
							e1.printStackTrace();
						}
					}
				});
				btnlogin.setForeground(new Color(249, 224, 72));
				btnlogin.setBackground(new Color(94, 94, 94));
				GridBagConstraints gbc_btnlogin = new GridBagConstraints();
				gbc_btnlogin.fill = GridBagConstraints.HORIZONTAL;
				gbc_btnlogin.weighty = 25.0;
				gbc_btnlogin.anchor = GridBagConstraints.NORTH;
				gbc_btnlogin.insets = new Insets(0, 0, 5, 5);
				gbc_btnlogin.gridx = 0;
				gbc_btnlogin.gridy = 2;
				securitypanel.add(btnlogin, gbc_btnlogin);
				
				JButton btnExit = new JButton("Exit");
				btnExit.setMnemonic('E');
				btnExit.setFont(new Font("SansSerif", Font.BOLD, 16));
				btnExit.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if (JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "Student Information",
								JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE) == JOptionPane.YES_OPTION) {
							System.exit(0);
						}
					}
				});
				btnExit.setForeground(new Color(249, 224, 72));
				btnExit.setBackground(new Color(94, 94, 94));
				GridBagConstraints gbc_btnExit = new GridBagConstraints();
				gbc_btnExit.fill = GridBagConstraints.HORIZONTAL;
				gbc_btnExit.anchor = GridBagConstraints.NORTH;
				gbc_btnExit.insets = new Insets(0, 0, 5, 0);
				gbc_btnExit.gridx = 1;
				gbc_btnExit.gridy = 2;
				securitypanel.add(btnExit, gbc_btnExit);
		frmTipStudentInformation.setBackground(new Color(53, 53, 53));
		frmTipStudentInformation.setTitle("T.I.P Student Information");
		frmTipStudentInformation.setBounds(100, 100, 440, 573);
		frmTipStudentInformation.setLocationRelativeTo(null);
		frmTipStudentInformation.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}

}
