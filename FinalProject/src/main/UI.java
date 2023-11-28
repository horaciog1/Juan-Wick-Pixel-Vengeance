package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import object.OBJ_Heart;
import object.OBJ_Key;
import entity.Entity;

public class UI {

		GamePanel gp;
		Graphics2D g2;
		Font arial_40, arial_80B;
		BufferedImage full_heart, half_heart, empty_heart;
		public boolean messageOn = false;
		public String message1 = "";
		int messageCounter1 = 0;
		ArrayList <String> message = new ArrayList<>();
		ArrayList<Integer> messageCounter = new ArrayList<>();
		public boolean gameFinished = false;
		public int commandNum = 0;
		public int titleScreenState = 0;	// 0: first screen, 1: second screen
		//For displaying key 
		BufferedImage keyImage;
		
		public UI(GamePanel gp) {
			this.gp = gp;
			
			//Creating new fonts
			arial_40 = new Font("Arial", Font.PLAIN, 40);
			arial_80B = new Font("Arial", Font.BOLD, 80);
			OBJ_Key key = new OBJ_Key(gp);
			keyImage = key.image;
			
			//Create Hud Object
			Entity heart = new OBJ_Heart(gp);
			full_heart = heart.image;
			half_heart = heart.image2;
			empty_heart = heart.image3;
			
		}
		
		public void addMessage(String text) {
			message.add(text);
			messageCounter.add(0);
		} //  end showMessage
		
		public void draw(Graphics2D g2) {
			
			this.g2 = g2;
			
			g2.setFont(arial_40);
			g2.setColor(Color.black);
			g2.drawImage(keyImage, gp.tileSize/2, gp.tileSize+5, gp.tileSize - 10, gp.tileSize - 10, null);
			g2.drawString("x " + gp.player.hasKey, 95, 115);
			
			
			// MESSAGE
			if(messageOn == true) {
				g2.setFont(g2.getFont().deriveFont(30F));
				g2.setColor(Color.black);
				g2.drawString(message1, gp.tileSize/2, gp.tileSize*5);
				
				messageCounter1++;
				
				if(messageCounter1 > 120) { // text disappears after 2 sec 
					messageCounter1 = 0;
					messageOn = false;
				}
			}
			
			//TITLE STATE
			if(gp.gameState == gp.titleState) {
				drawTitleScreen();
			}
			//PLAY STATE
			if(gp.gameState == gp.playState) {
				drawPlayerLife();
				drawMessage();
			}
			//PAUSE STATE
			if(gp.gameState == gp.pauseState) {
				drawPlayerLife();
				drawPauseScreen();
			}
		}
		
		//Method to draw player life
		public void drawPlayerLife() {
			
			//gp.player.life = 6;
			
			int x = gp.tileSize/4;
			int y = gp.tileSize/8;
			int i = 0;
			
			//Draw Blank Heart
			while(i < gp.player.maxLife/2) {
				g2.drawImage(empty_heart, x, y, null);
				i++;
				x += gp.tileSize;
			}
			//Reset
			x = gp.tileSize/4;
			y = gp.tileSize/8;
			i = 0;
			
			//Draw Current Life
			while(i < gp.player.life) {
				g2.drawImage(half_heart, x,  y,  null);
				i++;
				if(i < gp.player.life) {
					g2.drawImage(full_heart, x, y, null);
				}
				i++;
				x += gp.tileSize;
			}
			
		}
		
		
		public void drawMessage() {
			
			int messageX = gp.tileSize;
			int messageY = gp.tileSize*4;
			g2.setFont(g2.getFont().deriveFont(Font.BOLD, 32F));
			
			for (int i = 0; i < message.size(); i++) {
				
				if(message.get(i) != null) {
					g2.setColor(Color.white);
					g2.drawString(message.get(i), messageX+2, messageY+2);
					g2.setColor(Color.black);
					g2.drawString(message.get(i), messageX, messageY);
					
					int counter = messageCounter.get(i) + 1;	// messageCounter++
					messageCounter.set(i, counter);				// set the counter to the array
					messageY += 50;
					
					if(messageCounter.get(i) > 180) {
						message.remove(i);
						messageCounter.remove(i);
					}
				}
				
			} // end for
			
			
			
		}// end drawMessage
		
		public void drawTitleScreen() {
			
			if(titleScreenState == 0) {
				g2.setColor(new Color(153,0,0));
				g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);
				//TITLE NAME
				g2.setFont(g2.getFont().deriveFont(Font.BOLD,96F));
				String text = "JUAN WICK";
				int x = getXforCenteredText(text);
				int y = gp.tileSize*2;
				
				//SHADOW
				g2.setColor(Color.black);
				g2.drawString(text, x+5, y+5);
				
				//MAIN COLOR
				g2.setColor(Color.white);
				g2.drawString(text, x, y);
				
				//JUAN WICK IMAGE
				x = gp.screenWidth/2 - (gp.tileSize*2)/2;
				y += gp.tileSize;
				g2.drawImage(gp.player.TitleScreen, -10, -260, 1000, 1000, null);	// x-coordinate, y-coordinate, width, height
				
				
				
				//MENU
				g2.setFont(g2.getFont().deriveFont(Font.BOLD,48F));
				
				text = "NEW GAME";
				x = getXforCenteredText(text);
				y += gp.tileSize * 4;
				g2.drawString(text, x, y);
				if(commandNum == 0 ) {
					g2.drawString(">", x-gp.tileSize, y);  //draw image to use image
				}
				
				text = "LOAD GAME";
				x = getXforCenteredText(text);
				y += gp.tileSize;
				g2.drawString(text, x, y);
				if(commandNum == 1 ) {
					g2.drawString(">", x-gp.tileSize, y);  //draw image to use image
				}
				
				text = "QUIT";
				x = getXforCenteredText(text);
				y += gp.tileSize;
				g2.drawString(text, x, y);
				if(commandNum == 2 ) {
					g2.drawString(">", x-gp.tileSize, y);  //draw image to use image
				} // end if
			} // end bigger if
			
			else if (titleScreenState == 1) {
				
				// SKIN SELECTION SCREEN
				g2.setColor(Color.white);
				g2.setFont(g2.getFont().deriveFont(42F));
				
				String text = "Select the suit for Juan Wick!";
				int x = getXforCenteredText(text);
				int y = gp.tileSize * 3;
				g2.drawString(text, x, y);
				
				text = "Gray Suit";
				x = getXforCenteredText(text);
				y += gp.tileSize; 
				g2.drawString(text, x, y);
				if(commandNum == 0) {
					g2.drawString(">", x-gp.tileSize, y);
				}
				
				text = "Blue Suit";
				x = getXforCenteredText(text);
				y += gp.tileSize; 
				g2.drawString(text, x, y);
				if(commandNum == 1) {
					g2.drawString(">", x-gp.tileSize, y);
				}
				
				text = "Black Suit";
				x = getXforCenteredText(text);
				y += gp.tileSize; 
				g2.drawString(text, x, y);
				if(commandNum == 2) {
					g2.drawString(">", x-gp.tileSize, y);
				}
				
				text = "Back";
				x = getXforCenteredText(text);
				y += gp.tileSize * 2; 
				g2.drawString(text, x, y);
				if(commandNum == 3) {
					g2.drawString(">", x-gp.tileSize, y);
				}

			} // end else if
			
			
		} // end drawTitleScreen
		
		public void drawPauseScreen() {
			
			g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 80F));
			String text = "PAUSED";
			int x = getXforCenteredText(text);
			int y = gp.screenHeight/2;
			g2.drawString(text, x, y);
		}
		
		public int getXforCenteredText(String text) {
			
			int length = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
			int x = gp.screenWidth/2 - length/2;
			return x;
			
		}
		
}









