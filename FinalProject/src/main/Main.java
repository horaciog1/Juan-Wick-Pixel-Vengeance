package main;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {

		JFrame window = new JFrame();
		
		// This allows the user to close the game when the "X" is clicked
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Window cannon be resized
		window.setResizable(false);
		window.setTitle("Juan Wick: Pixel Vengeance");
		
		GamePanel gamePanel = new GamePanel();
		window.add(gamePanel);
		
		// Makes the size of the window to the preferred size of its subcomponents
		window.pack();	
		
		// Window will be displayed at the center
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		
		
		gamePanel.setupGame();
		gamePanel.startGameThread();
		
	} // end main

} // end Class
