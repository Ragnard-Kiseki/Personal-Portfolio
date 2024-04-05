package controller;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import view.MainView;
import view.StudentInformationView;
import java.awt.Toolkit;

@SuppressWarnings("serial")
public class ProgressBar extends JFrame  implements Runnable{

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProgressBar frame = new ProgressBar();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	
	
	public ProgressBar() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\AAA\\Desktop\\OOP\\CCS 201 - FinalsProject\\tip logo.jpg"));
		setTitle("Loading");
		
		
		Thread thread = new Thread(this);
		thread.start();
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblcount = new JLabel("");
		lblcount.setForeground(Color.WHITE);
		lblcount.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblcount.setBounds(74, 91, 163, 16);
		contentPane.add(lblcount);
		
		JProgressBar Pbar = new JProgressBar();
		Pbar.setBackground(Color.YELLOW);
		Pbar.setForeground(Color.YELLOW);
		Pbar.setBounds(73, 120, 286, 31);
		contentPane.add(Pbar);
		
		JLabel lblPleaseWait = new JLabel("Logging in...");
		lblPleaseWait.setForeground(Color.WHITE);
		lblPleaseWait.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblPleaseWait.setBounds(74, 164, 163, 22);
		contentPane.add(lblPleaseWait);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBorder(new LineBorder(Color.WHITE));
		panel.setBounds(12, 13, 408, 227);
		contentPane.add(panel);
	}
	
	@Override
	public void run()  {
		
		JLabel lblcount = new JLabel("");
		lblcount.setForeground(Color.WHITE);
		lblcount.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblcount.setBounds(74, 91, 163, 16);
		contentPane.add(lblcount);
		
		JProgressBar Pbar = new JProgressBar();
		Pbar.setForeground(Color.YELLOW);
		Pbar.setBounds(73, 120, 286, 31);
		contentPane.add(Pbar);
		
		for (int i = 0; i <=100; i++) {
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			lblcount.setText(i+"%");
			Pbar.setValue(i);
			
			
		}
		
	
		      
				try {
					StudentInformationView view = new StudentInformationView();
				    view.setVisible(true);
					MainView.frmTipStudentInformation.dispose();
				} catch (IOException e) {
					e.printStackTrace();
				}
			
		
		 dispose();
	}
}
