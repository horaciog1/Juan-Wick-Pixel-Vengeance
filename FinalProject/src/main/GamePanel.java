/**
 * The `GamePanel` class serves as the core component for game rendering and logic control.
 * It provides the main canvas for rendering graphics, manages game parameters like tile size, screen dimensions, and frame rate,
 * and contains the game loop, which updates the game state and renders graphics. 
 */
package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import entity.Player;
import object.SuperObject;
import tile.TileManager;

@SuppressWarnings("serial")
public class GamePanel extends JPanel implements Runnable{

	// Screen Settings
	final int originalTileSizeWidth = 15;   // 15x22 tile
	final int originalTileSizeHeight = 22;
	final int scale = 3; // Scaling factor
	
	public final int tileSizeWidth = originalTileSizeWidth * scale;   // depends on scale
	public final int tileSizeHeight = originalTileSizeHeight * scale;
	public final int tileSize = tileSizeHeight;

	public final int maxScreenCol = 18;
	public final int maxScreenRow = 14;
	public final int screenWidth = tileSize * maxScreenCol;   // 912 pixels
	public final int screenHeight = tileSize * maxScreenRow;   // 720 pixels
	
	// WORLD SETTINGS
	public final int maxWorldCol = 50;
	public final int maxWorldRow = 50;
	public final int worldWidth = tileSize * maxWorldCol;
	public final int worldHeight = tileSize * maxWorldRow;

	
	// Frames per second
	int FPS = 60;

	//SYSTEM
	TileManager tileM = new TileManager(this);
	KeyHandler keyH = new KeyHandler();
	Thread gameThread;
	public CollisionChecker cChecker = new CollisionChecker(this);
	public AssetSetter aSetter = new AssetSetter(this);
	public Player player = new Player(this, keyH);
	
	// objects that can be displayed at the same time, it can be change any time to display more objects
	public SuperObject obj[] = new SuperObject [12];
	
	
	
	public GamePanel() {
		
        // Set the preferred size of the game panel
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setBackground(Color.black);
		
		// all the drawing from this component will be done in an off-screen painting buffer
		// it can basically improve rendering performance
		this.setDoubleBuffered(true);   
		
        // Add key listener to the game panel for receiving user input
		this.addKeyListener(keyH);
		this.setFocusable(true);	// With this, this GamePanel can be "focused" to receive key input
		
	}// end constructor
	
	
	// This places the objects into the map before the game loads
	public void setupGame() {
		
		
		// We create this method so we can add other stuff in the future
		aSetter.setObject(); // Place objects into the map
		
	} //  end setupGame

	// clock that gives life to the game
	public void startGameThread() {
		gameThread = new Thread(this);
		gameThread.start();
	} // end startGameThread()
	
//	@Override
//	public void run() {
//		
//		double drawInterval = 1000000000/FPS; // 0.01666 seconds
//		double nextDrawTime = System.nanoTime() + drawInterval;		
//		
//		while (gameThread != null) {
//			
//						
//			// 1. Update: update information such as character positions
//			update();
//			
//			// 2. Draw: draw the screen with the updated information
//			repaint();
//			
//			
//			try {
//				double remainingTime = nextDrawTime - System.nanoTime();	
//				remainingTime = remainingTime/1000000;
//				
//				if (remainingTime < 0) {
//					remainingTime = 0;
//				}
//				
//				Thread.sleep( (long) remainingTime);
//				
//				nextDrawTime += drawInterval;
//				
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//			
//		} // end while
//		
//	} // end run()
//
	
	public void run() {
		double drawInterval = 1000000000 / FPS;
		double delta = 0;
		long lastTime = System.nanoTime();		
		long currentTime;
		long timer = 0;
		int drawCount = 0;
		
		
		while (gameThread != null) {
			
			currentTime = System.nanoTime();
			
			delta += (currentTime - lastTime) / drawInterval;
			timer += (currentTime - lastTime);
			lastTime = currentTime;
			
			if (delta >= 1) {
				// 1. Update: update information such as character positions
				update();
				// 2. Draw: draw the screen with the updated information
				repaint();
				delta--;
				drawCount++;
			}
			
			if(timer >= 1000000000) {
				System.out.println("FPS: " + drawCount);
				drawCount = 0;
				timer = 0;
			}
			
		} // end while
	} // end run()
	
	// Update game elements
	public void update() {
		
		player.update();
		
	}// end update()
	
	
	// Paint component to render the game
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D) g;
		
		// TILE
		tileM.draw(g2);
		
		// OBJECT
		for(int i = 0; i < obj.length; i++) {
			
			if (obj[i] !=  null) {
				obj[i].draw(g2, this);
			}//end  if
			
			
		}// end for
		
		// PLAYER
		player.draw(g2);
		
		g2.dispose();	// dispose of this graphics context and release any system resources that it is using
		
		
	}// paintComponent()
} // end class
