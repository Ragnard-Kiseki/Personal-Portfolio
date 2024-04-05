package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import view.AddStudent;

public class btnAddController implements ActionListener {

	public btnAddController(JButton btnAddControl) {
		super();
		btnAddControl = AddStudent.btnAdd;
	}

	public void AddingInformation(){
		try {
			model.StudentInformationModel model = new model.StudentInformationModel();
			DefaultTableModel add_rows = (DefaultTableModel) AddStudent.table.getModel();
			
			if (AddStudent.studnoField.getText().equals("") || AddStudent.firstnameField.getText().equals("")
					|| AddStudent.lastnameField.getText().equals("")
					|| AddStudent.sexualityField.getText().equals("") || AddStudent.ageField.getText().equals("")
					|| AddStudent.comboBoxProgram.getSelectedItem().equals("--")) {
				UIManager.put("OptionPane.background", new Color(53, 53, 53));
				UIManager.put("OptionPane.messageForeground", new Color(255, 255, 255));
				UIManager.put("Panel.background", new Color(53, 53, 53));
				UIManager.put("Button.background", new Color(94, 94, 94));
				UIManager.put("Button.foreground", new Color(249, 224, 72));
				JOptionPane.showMessageDialog(null, "Error!\nMust fill all the required information.",
						"System Information", JOptionPane.ERROR_MESSAGE);

			} else {
			String firstname = String.valueOf(AddStudent.firstnameField.getText());
			String lastname = String.valueOf(AddStudent.lastnameField.getText());
			String sex = String.valueOf(AddStudent.comboBoxSex.getSelectedItem());
			String sexuality = String.valueOf(AddStudent.sexualityField.getText());
			Integer studNo = Integer.parseInt(AddStudent.studnoField.getText());
			Integer age = Integer.parseInt(AddStudent.ageField.getText());
			Integer yearlvl = Integer.parseInt((String) AddStudent.comboBoxYearLevel.getSelectedItem());
			String program = String.valueOf(AddStudent.comboBoxProgram.getSelectedItem());

			model.setStudNo(studNo);
			model.setFirstname(firstname);
			model.setLastname(lastname);
			model.setSex(sex);
			model.setSexuality(sexuality);
			model.setAge(age);
			model.setYearlvl(yearlvl);
			model.setProgram(program);
			AddStudent.rows[0] = model.getStudNo();
			AddStudent.rows[1] = model.getFirstname();
			AddStudent.rows[2] = model.getLastname();
			AddStudent.rows[3] = model.getSex();
			AddStudent.rows[4] = model.getSexuality();
			AddStudent.rows[5] = model.getAge();
			AddStudent.rows[6] = model.getYearlvl();
			AddStudent.rows[7] = model.getProgram();
			add_rows.addRow(AddStudent.rows);
			BufferedWriter studentInformationText = new BufferedWriter(
					new FileWriter("studentData//studentinformation.txt", true));
			studentInformationText.write(AddStudent.rows[0] + ", " + AddStudent.rows[1] + ", " + AddStudent.rows[2] + ", "
					+ AddStudent.rows[3] + ", " + AddStudent.rows[4] + ", " + AddStudent.rows[5] + ", " + AddStudent.rows[6]
					+ ", " + AddStudent.rows[7]);
			studentInformationText.flush();
			studentInformationText.newLine();
			studentInformationText.close();
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public void actionPerformed(ActionEvent args) {
		try {
			File studentInformation = new File("studentData//studentinformation.txt");
			UIManager.put("OptionPane.background", new Color(53, 53, 53));
			UIManager.put("OptionPane.messageForeground", new Color(255, 255, 255));
			UIManager.put("Panel.background", new Color(53, 53, 53));
			UIManager.put("Button.background", new Color(94, 94, 94));
			UIManager.put("Button.foreground", new Color(249, 224, 72));
			if (studentInformation.exists() == false) {
				if (JOptionPane.showConfirmDialog(null, "Error:\nNo file detected!", "System Information",
						JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE) == JOptionPane.OK_OPTION) {
					if (JOptionPane.showConfirmDialog(null, "Prompt Creation:\nDo you want to create a file?",
							"System Information", JOptionPane.YES_NO_OPTION,
							JOptionPane.PLAIN_MESSAGE) == JOptionPane.YES_OPTION) {
						if (studentInformation.createNewFile()) {
							JOptionPane.showMessageDialog(null, "Creating file...\nFile has been created!", "System",
									JOptionPane.PLAIN_MESSAGE);
						}
					} else {
					}
				} else {
				}
			} else {
				
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
