package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable{

	// Screen Settings
	final int originalTileSize = 16;   // 16x16 tile
	final int scale = 3;
	
	final int tileSize = originalTileSize * scale;   // 48*48 tile
	final int maxScreenCol = 19;
	final int maxScreenRow = 15;
	final int screenWidth = tileSize * maxScreenCol;   // 912 pixels
	final int screenHeight = tileSize * maxScreenRow;   // 720 pixels
	
	// FPS
	int FPS = 60;

	KeyHandler keyH = new KeyHandler();
	Thread gameThread;
	
	
	
	// Set player's default position
	int playerX = 100;
	int playerY = 100;
	int playerSpeed = 4;
	
	
	public GamePanel() {
		
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setBackground(Color.black);
		
		// all the drawing from this component will be done in an off-screen painting buffer
		// it can basically improve rendering performance
		this.setDoubleBuffered(true);   
		this.addKeyListener(keyH);
		this.setFocusable(true);	// With this, this GamePanel can be "focused" to receive key input
		
	}// end constructor

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
	
	public void update() {
		if (keyH.upPressed == true) {
			playerY -= playerSpeed;
		}
		else if (keyH.downPressed == true) {
			playerY += playerSpeed;
		}
		else if (keyH.leftPressed == true) {
			playerX -= playerSpeed;
		}
		else if (keyH.rightPressed == true) {
			playerX += playerSpeed;
		}
	}// end update()
	
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.white);
		
		g2.fillRect(playerX, playerY, tileSize, tileSize);
		
		g2.dispose();	// dispose of this graphics context and release any system resources that it is using
		
		
	}// paintComponent()
} // end class