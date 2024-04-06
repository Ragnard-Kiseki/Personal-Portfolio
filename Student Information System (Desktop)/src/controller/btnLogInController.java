package controller;

import view.MainView;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class btnLogInController {
	public static File file_check = new File("src\\studentData\\loginData\\login.txt");

	public void search(String un, String pw) {
		try {
			UIManager.put("OptionPane.background", new Color(53, 53, 53));
			UIManager.put("OptionPane.messageForeground", new Color(255, 255, 255));
			UIManager.put("Panel.background", new Color(53, 53, 53));
			UIManager.put("Button.background", new Color(94, 94, 94));
			UIManager.put("Button.foreground", new Color(249, 224, 72));
			if (file_check.exists() == false) {
			} else {
				FileWriter fw = new FileWriter("src\\studentData\\loginData\\login.txt",true);
				PrintWriter pw1 = new PrintWriter(fw);

				int num2 = 0;
				BufferedReader br = null;

				br = new BufferedReader(new FileReader("src\\studentData\\loginData\\login.txt"));
				if (br != null) {
					String st;
					while ((st = br.readLine()) != null) {
						String[] splitted = st.split(",");
						if (un.equals(splitted[0]) && pw.equals(splitted[1])) {
							num2++;

						} else {

						}
					}
				}
				if (num2 > 0) {
					JOptionPane.showConfirmDialog(null, "Username and Password is Already Used \n     Please try again",
							"System Information", JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE);
				} else {
					pw1.println(un + "," + pw);
					JOptionPane.showMessageDialog(null, "Account Succesfully Created", "System Information",
							JOptionPane.INFORMATION_MESSAGE);
					pw1.close();

				}
				br.close();
			}
		} catch (Exception e) {

		}
	}

	@SuppressWarnings("unused")
	public void login() throws IOException {

		try {
			UIManager.put("OptionPane.background", new Color(53, 53, 53));
			UIManager.put("OptionPane.messageForeground", new Color(255, 255, 255));
			UIManager.put("Panel.background", new Color(53, 53, 53));
			UIManager.put("Button.background", new Color(94, 94, 94));
			UIManager.put("Button.foreground", new Color(249, 224, 72));
			if (file_check.exists() == false) {
				if (JOptionPane.showConfirmDialog(null, "Error:\nNo file detected!", "System Information",
						JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE) == JOptionPane.OK_OPTION) {
					if (file_check.createNewFile()) {
						JOptionPane.showMessageDialog(null, "Creating file...\nFile has been created!", "System",
								JOptionPane.PLAIN_MESSAGE);
					} else {
					}
				} else {
				}
			} else {
				String password = new String(MainView.txtPassword.getPassword());
				String ussername = String.valueOf(MainView.txtUssername.getText());
				int num = 0;
				BufferedReader br = null;
				BufferedReader br2 = null;
				br = new BufferedReader(new FileReader(
						"src\\studentData\\loginData\\login.txt"));
				if (br != null) {
					String st;
					while ((st = br.readLine()) != null) {
						String[] splitted = st.split(",");
						if (ussername.equals(splitted[0]) && password.equals(splitted[1])) {
							num++;

						} else {

						}

					}

				}

				if (num > 0) {
					JOptionPane.showMessageDialog(null, "Username and Password is Correct", "System",
							JOptionPane.PLAIN_MESSAGE);
					ProgressBar bar = new ProgressBar();
					bar.setVisible(true);
					MainView.frmTipStudentInformation.dispose();
					MainView.txtUssername.setText("");
					MainView.txtPassword.setText("");
				} else {
					MainView.txtUssername.setText("");
					MainView.txtPassword.setText("");
					JOptionPane.showConfirmDialog(null, "No Account Found!", "System Information",
							JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE);
					int userchoice = JOptionPane.showConfirmDialog(null, "Create Account?", "System Information",
							JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
					if (userchoice == JOptionPane.YES_OPTION) {
						String resUser = JOptionPane.showInputDialog(null, "Enter Your username", "System Information",
								JOptionPane.INFORMATION_MESSAGE);
						String respass = JOptionPane.showInputDialog(null, "Enter Your password", "System Information",
								JOptionPane.INFORMATION_MESSAGE);

						search(resUser, respass);

					} else {
						JOptionPane.showMessageDialog(null, "Account Creation Cancel", "System Information",
								JOptionPane.CLOSED_OPTION);

					}
				}
				br.close();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

}
