package controller;

import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class IntegerOnlyTextField extends KeyAdapter {
	public void keyTyped(KeyEvent e) {
		UIManager.put("OptionPane.background", new Color(53, 53, 53));
		UIManager.put("OptionPane.messageForeground", new Color(255, 255, 255));
		UIManager.put("Panel.background", new Color(53, 53, 53));
		UIManager.put("Button.background", new Color(94, 94, 94));
		UIManager.put("Button.foreground", new Color(249, 224, 72));
		char c = e.getKeyChar();
		if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
			JOptionPane.showMessageDialog(null, "Error:\nNot a digit!", "System Information",
					JOptionPane.ERROR_MESSAGE);
			e.consume();
		} else {
		}
	}
}
