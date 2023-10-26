package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class UI {

		GamePanel gp;
		Graphics2D g2;
		Font arial_40, arial_80B;
		public boolean messageOn = false;
		public String message = "";
		int messageCounter = 0;
		public boolean gameFinished = false;
		public int commandNum = 0;
		
		public UI(GamePanel gp) {
			this.gp = gp;
			arial_40 = new Font("Arial", Font.PLAIN, 40);
			arial_80B = new Font("Arial", Font.BOLD, 80);
			
		}
		
		public void draw(Graphics2D g2) {
			
			this.g2 = g2;
			
			g2.setFont(arial_40);
			g2.setColor(Color.white);
			
			//TITLE STATE
			if(gp.gameState == gp.titleState) {
				drawTitleScreen();
			}
			//PLAY STATE
			if(gp.gameState == gp.playState) {
				//Do play State stuff later
			}
			//PAUSE STATE
			if(gp.gameState == gp.pauseState) {
				drawPauseScreen();
			}
		}
		
		public void drawTitleScreen() {
			
			g2.setColor(new Color(100,10,2));
			g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);
			//TITLE NAME
			g2.setFont(g2.getFont().deriveFont(Font.BOLD,96F));
			String text = "JUAN WICK";
			int x = getXforCenteredText(text);
			int y = gp.tileSize*3;
			
			//SHADOW
			g2.setColor(Color.black);
			g2.drawString(text, x+5, y+5);
			
			//MAIN COLOR
			g2.setColor(Color.white);
			g2.drawString(text, x, y);
			
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
			}
		}
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









