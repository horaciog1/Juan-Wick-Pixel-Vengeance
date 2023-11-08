package main;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {

        // Create a new JFrame for the game window
		JFrame window = new JFrame();
		
        // Set the default close operation to exit the game when the "X" is clicked
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
        // Prevent the window from being resized
		window.setResizable(false);
		
        // Set the title of the game window
		window.setTitle("Juan Wick: Pixel Vengeance");
		
		// Create a GamePanel to handle game rendering and logic
		GamePanel gamePanel = new GamePanel();
		
        // Add the GamePanel to the window
		window.add(gamePanel);
		
        // Pack the window to the preferred size of its subcomponents
		window.pack();	
		
        // Center the window on the screen
		window.setLocationRelativeTo(null);
		
        // Make the window visible
		window.setVisible(true);
		
        // Setup the game and start the game thread
		gamePanel.setupGame();
		gamePanel.startGameThread();
		
	} // end main
} // end Class
