package com.nosiphus.optifinder.init;

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
public class Window extends JDialog {
	
	private static final long serialVersionUID = 1L;

	static {
		System.setProperty("java.awt.headless", "false");
	}

	public Window(JFrame parent, String title, String message, String version) {
		
		super(parent, title, true);
		
		JPanel messagePane = new JPanel();
		messagePane.add(new JLabel(message));
		getContentPane().add(messagePane);
		
		JPanel buttonPane = new JPanel();
		
		JButton openDirectory = new JButton("Open Directory");
		openDirectory.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String location = (new File("mods")).getAbsolutePath();
				File file = new File(location);
				Desktop desktop = Desktop.getDesktop();
				
				try {
					
					desktop.open(file);
					System.exit(0);
					
				} catch (IOException f) {
					
					f.printStackTrace();
					
				}
				
			}
			
		});
		
		buttonPane.add(openDirectory);
		getContentPane().add(buttonPane, BorderLayout.SOUTH);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		pack();
		setLocation((Toolkit.getDefaultToolkit().getScreenSize().width)/2 - getWidth()/2, (Toolkit.getDefaultToolkit().getScreenSize().height)/2 - getHeight()/2);
		setVisible(true);
		
	}
	
	public static void main(String version) {

		new Window(new JFrame(), "Install OptiFine", "You do not have the present version of OptiFine. Read the instructions on the page for how to add it.", version);
		
	}
	
}