package controller;

import view.AddStudent;
import view.DeleteStudent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class btnDeleteController implements ActionListener {

	public btnDeleteController(JButton btnEditControl) {
		super();
		btnEditControl = DeleteStudent.btnDelete;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {

			int deleterow = DeleteStudent.table.getSelectedRow();
			File studentInformation = new File("src\\studentData\\studentinformation.txt");
			UIManager.put("OptionPane.background", new Color(53, 53, 53));
			UIManager.put("OptionPane.messageForeground", new Color(255, 255, 255));
			UIManager.put("Panel.background", new Color(53, 53, 53));
			UIManager.put("Button.background", new Color(94, 94, 94));
			UIManager.put("Button.foreground", new Color(249, 224, 72));
			if (studentInformation.exists() == true && studentInformation.length() != 0) {
				FileWriter fwriter = new FileWriter(studentInformation);
				BufferedWriter bwriter = new BufferedWriter(fwriter);
				if (deleterow >= 0) {
					DeleteStudent.modify_row.removeRow(deleterow);
				}
				for (int i1 = 0; i1 < DeleteStudent.modify_row.getRowCount(); i1++) {
					for (int j = 0; j < DeleteStudent.modify_row.getColumnCount(); j++) {
						bwriter.write(DeleteStudent.modify_row.getValueAt(i1, j).toString() + ",");
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
							Window window = SwingUtilities.windowForComponent(DeleteStudent.btnDelete);
							window.dispose();
						}
					} else {
					}
				} else {
				}
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}

	}

}
