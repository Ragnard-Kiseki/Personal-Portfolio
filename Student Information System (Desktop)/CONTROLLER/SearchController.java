package controller;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;


import view.StudentInformationView;

public  class SearchController implements KeyListener{
	
	public SearchController(JTextField searchField) {
		super();
		searchField = StudentInformationView.searchField;
	}


	@Override
	public void keyPressed(KeyEvent arg0) {
		File file = new File(
				"C:\\Users\\AAA\\Desktop\\OOP\\CCS 201 - FinalsProject\\studentData\\studentinformation.txt");
		UIManager.put("OptionPane.background", new Color(53, 53, 53));
		UIManager.put("OptionPane.messageForeground", new Color(255, 255, 255));
		UIManager.put("Panel.background", new Color(53, 53, 53));
		UIManager.put("Button.background", new Color(94, 94, 94));
		UIManager.put("Button.foreground", new Color(249, 224, 72));
		try {
			if (arg0.getKeyCode() == KeyEvent.VK_ENTER) {
				if (file.exists() == true) {
					FileReader fileReader = new FileReader(file);
					BufferedReader bufferedReader = new BufferedReader(fileReader);
					String line = null;
					StringBuilder match_wholeLine = new StringBuilder();
					while ((line = bufferedReader.readLine()) != null) {		
						if (line.toLowerCase().contains(StudentInformationView.searchField.getText())) {
							 match_wholeLine.append(line+"\n");
						}
					}
					JOptionPane.showMessageDialog(null, match_wholeLine,
							"Student Information", JOptionPane.PLAIN_MESSAGE);
					bufferedReader.close();
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


}
