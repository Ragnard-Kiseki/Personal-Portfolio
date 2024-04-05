package controller;

import java.awt.Color;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import view.AddStudent;
import view.EditStudent;

public class EditFileController implements ActionListener {
	@SuppressWarnings("unused")
	private JButton btnEdit = new JButton();

	public EditFileController(JButton btnEdit) {
		super();
		EditStudent.btnEdit = btnEdit;
	}

	public void actionPerformed(ActionEvent args) {

		try {
			DefaultTableModel add_rows = (DefaultTableModel) EditStudent.table.getModel();
			File studentInformation = new File("studentData//studentinformation.txt");
			UIManager.put("OptionPane.background", new Color(53, 53, 53));
			UIManager.put("OptionPane.messageForeground", new Color(255, 255, 255));
			UIManager.put("Panel.background", new Color(53, 53, 53));
			UIManager.put("Button.background", new Color(94, 94, 94));
			UIManager.put("Button.foreground", new Color(249, 224, 72));

			int i = EditStudent.table.getSelectedRow();
			if (i >= 0) {
				add_rows.setValueAt(EditStudent.StudentNumber.getText(), i, 0);
				add_rows.setValueAt(EditStudent.FirstName.getText(), i, 1);
				add_rows.setValueAt(EditStudent.LastName.getText(), i, 2);
				add_rows.setValueAt(EditStudent.Sex.getSelectedItem(), i, 3);
				add_rows.setValueAt(EditStudent.Sexuality.getText(), i, 4);
				add_rows.setValueAt(EditStudent.Age.getText(), i, 5);
				add_rows.setValueAt(EditStudent.YearLevel.getSelectedItem(), i, 6);
				add_rows.setValueAt(EditStudent.Program.getSelectedItem(), i, 7);
			}
			if (studentInformation.exists() == true  && studentInformation.length() != 0) {
				FileWriter fwriter = new FileWriter(studentInformation);
				BufferedWriter bwriter = new BufferedWriter(fwriter);
				for (int i1 = 0; i1 < add_rows.getRowCount(); i1++) {
					for (int j = 0; j < add_rows.getColumnCount(); j++) {
						bwriter.write(add_rows.getValueAt(i1, j).toString() + ",");
					}
					bwriter.newLine();
				}
				bwriter.close();
				fwriter.close();
			} else {
				if (JOptionPane.showConfirmDialog(null, "Error:\nYou have not added an information!",
						"System Information", JOptionPane.CLOSED_OPTION,
						JOptionPane.ERROR_MESSAGE) == JOptionPane.OK_OPTION) {
					if (JOptionPane.showConfirmDialog(null, "Prompt adding:\nDo you want to add an information?",
							"System Information", JOptionPane.YES_NO_OPTION,
							JOptionPane.PLAIN_MESSAGE) == JOptionPane.YES_OPTION) {
						if (JOptionPane.showConfirmDialog(null, "Going back to Add student option!",
								"System Information", JOptionPane.CLOSED_OPTION,
								JOptionPane.PLAIN_MESSAGE) == JOptionPane.OK_OPTION) {
							new AddStudent().setVisible(true);
							Window window = SwingUtilities.windowForComponent(EditStudent.btnEdit);
							window.dispose();
						}
					} else {
					}
				} else {
				}
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "No file Found!!");
		}

	}
}
