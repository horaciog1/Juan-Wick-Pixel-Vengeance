/**
 * The Entity class serves as a fundamental blueprint for various in-game characters, including players, enemies, and NPCs.
 * It encapsulates essential properties and behavior shared by these entities.
 */

package entity;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.UtilityTool;

public class Entity {

	GamePanel gp;
	public BufferedImage up0, up1, down0, down1, left0, left1, right0, right1, TitleScreen;	// Sprite images for different directions
	public Rectangle solidArea = new Rectangle(0, 0, 48, 48); 	// Hit-box for collision detection (you can overwrite the hit-box on the designated class;) )
	public int solidAreaDefaultX, solidAreaDefaultY;
	public BufferedImage image, image2, image3;
	public boolean collision = false;
	
	// STATE
	public int spriteNum = 1; // Total number of sprites
	public int worldX, worldY; // Current world position
	public String direction = "down";  // Current facing direction
	public boolean collisionOn = false;	// Flag to enable collision detection
	public boolean invincible = false;
	boolean attacking = false;
	public boolean alive = true;
	public boolean dying = false;
	boolean hpBarOn = false;
	
	
	
	// COUNTER
	public int spriteCounter = 0; // Counter for sprite animation
	public int actionLockCounter = 0;
	public int invincibleCounter = 0;
	int dyingCounter = 0;
	int hpBarCounter = 0;
	
	//CHARACTER ATTRIBUTES
	public int maxLife;
	public int life;
	public int type;	// 0 = player, 1 = NPC (if added), 2 = enemy
	public String name;
	public int speed; // Movement speed
	public int maxMana;		// delete
	public int mana;		// delete
	public Projectile projectile;
	public int useCost;				// delete


	
	public Entity (GamePanel gp) {
		this.gp = gp;
	} // end constructor
	
	
	// To be overwritten
	public void setAction() { } // end setAction
	public void damageReaction() { } // end damageReaction
	
	public void update() {
		setAction();
		
		collisionOn = false;
		gp.cChecker.checkTile(this);
		gp.cChecker.checkObject(this, false);
		gp.cChecker.checkEntity(this, gp.enemy);
		boolean contactPlayer = gp.cChecker.checkPlayer(this);
		
		// If enemy is having contact with player
		if(this.type == 2 && contactPlayer == true) {
			if(gp.player.invincible == false) {
				// Player can receive damage
				gp.playSE(10);
				gp.player.life -= 1;
				gp.player.invincible = true;
			}
		}
		
		
		// If no collision, update the player's position
		if (collisionOn == false) {
						
			switch(direction) {
				case "up": worldY -= speed; 	break;
				case "down": worldY += speed; 	break;
				case "left": worldX -= speed; 	break;
				case "right": worldX += speed;	 break;
			}// end switch
		} // end if collisionOn
					
					
		// Manage sprite animation
		spriteCounter++;
		if (spriteCounter > 12 ) {
			if (spriteNum == 1) {
				spriteNum = 2;
			}
			else if (spriteNum ==2) {
				spriteNum = 1;
			}
			spriteCounter = 0;
		} // end if spriteCounter > 12		
		
		if( invincible == true) {
			invincibleCounter++;
			if(invincibleCounter > 40) {
				invincible = false;
				invincibleCounter = 0;
			}
		} // end if
		
	} // end update
	
	
	public void draw(Graphics2D g2) {
		
		  BufferedImage image = null;
		  int screenX = worldX - gp.player.worldX + gp.player.screenX;
		  int screenY = worldY - gp.player.worldY + gp.player.screenY;
		  
		  // STOP MOVING CAMERA
		  if(gp.player.worldX < gp.player.screenX) {
		   screenX = worldX;
		  }
		  if(gp.player.worldY < gp.player.screenY) {
		   screenY = worldY;
		  }   
		  int rightOffset = gp.screenWidth - gp.player.screenX;      
		  if(rightOffset > gp.worldWidth - gp.player.worldX) {
		   screenX = gp.screenWidth - (gp.worldWidth - worldX);
		  } 
		  int bottomOffset = gp.screenHeight - gp.player.screenY;
		  if(bottomOffset > gp.worldHeight - gp.player.worldY) {
		   screenY = gp.screenHeight - (gp.worldHeight - worldY);
		  }
		  ///////////////////
		  
		  switch(direction) {
		  case "up":
		   if(spriteNum == 1) { image = up0; }
		   if(spriteNum == 2) { image = up1; }
		   break;
		  case "down":
		   if(spriteNum == 1) { image = down0; }
		   if(spriteNum == 2) { image = down1; }
		   break;
		  case "left":
		   if(spriteNum == 1) { image = left0; }   
		   if(spriteNum == 2) { image = left1; }
		   break;
		  case "right":
		   if(spriteNum == 1) { image = right0; }   
		   if(spriteNum == 2) { image = right1; }
		   break;
		  }
		  
		  
		  // Enemy HP bar
		  if(type == 2 && hpBarOn == true) {
			  
			  double oneScale = (double)gp.tileSize / maxLife;
			  double hpBarValue = oneScale*life;
			  
			  g2.setColor(new Color(35, 35, 35));
			  g2.fillRect(screenX - 1, screenY - 16, gp.tileSize + 2, 12);
			  
			  g2.setColor(new Color(255,0,30));
			  g2.fillRect(screenX, screenY - 15, (int)hpBarValue, 10);  
			  
			  hpBarCounter++;
			  
			  if(hpBarCounter > 600) {		// after 10 sec, the bar disappears
				  hpBarCounter = 0;
				  hpBarOn = false;
			  }
		  } // end if
		  
		  
		  
		  if (invincible == true) {
			  hpBarOn = true;
			  hpBarCounter = 0;
			  changeAlpha(g2, 0.4f);	// make enemy transparent when invincible, he received damage
		  }
		  
		  if(dying == true) {
			  dyingAnimation(g2);
		  }
		  
		  if(worldX + gp.tileSize > gp.player.worldX - gp.player.screenX &&
		     worldX - gp.tileSize < gp.player.worldX + gp.player.screenX &&
		     worldY + gp.tileSize > gp.player.worldY - gp.player.screenY &&
		     worldY - gp.tileSize < gp.player.worldY + gp.player.screenY) {      
		   g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
		  }
		  // If player is around the edge, draw everything
		  else if(gp.player.worldX < gp.player.screenX ||
		    gp.player.worldY < gp.player.screenY ||
		    rightOffset > gp.worldWidth - gp.player.worldX ||
		    bottomOffset > gp.worldHeight - gp.player.worldY) {
		   g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null); 
		  }
		  changeAlpha(g2, 1f);
	} // end draw
	
	
	public void dyingAnimation(Graphics2D g2) {
		
		dyingCounter++;
		
		int i = 5;
		
		if(dyingCounter <= i ) { changeAlpha(g2, 0f); }
		if(dyingCounter > i && dyingCounter <= i*2 ) { changeAlpha(g2, 1f); }
		if(dyingCounter > i*2 && dyingCounter <= i*3 ) { changeAlpha(g2, 0f); }
		if(dyingCounter > i*3 && dyingCounter <= i*4 ) { changeAlpha(g2, 1f); }
		if(dyingCounter > i*4 && dyingCounter <= i*5 ) { changeAlpha(g2, 0f); }
		if(dyingCounter > i*5 && dyingCounter <= i*6 ) { changeAlpha(g2, 1f); }
		if(dyingCounter > i*6 && dyingCounter <= i*7 ) { changeAlpha(g2, 0f); }
		if(dyingCounter > i*7 && dyingCounter <= i*8 ) { changeAlpha(g2, 1f); }
		if(dyingCounter > i*8) {
			alive = false;
		}
		
	} // end dyingAnimation
	
	
	public void changeAlpha(Graphics2D g2, float alphaValue) {
		
		g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alphaValue));
		
	} // end changeAlpha
	
	
	public BufferedImage setup(String imagePath, int width, int height) {
		
		UtilityTool uTool = new UtilityTool();
		BufferedImage image = null;
		
		try {
			image = ImageIO.read(getClass().getResourceAsStream(imagePath + ".png"));
			image = uTool.scaleImage(image, width, height);
			
		} catch(IOException e) {
			e.printStackTrace();
		}
		return image;
	} // end setup
	
	
//	public BufferedImage setupPlayer(String imagePath) {
//		
//		UtilityTool uTool = new UtilityTool();
//		BufferedImage image = null;
//		
//		try {
//			image = ImageIO.read(getClass().getResourceAsStream(imagePath + ".png"));
//			image = uTool.scaleImage(image, gp.tileSizeWidth-4, gp.tileSizeHeight);	
//			// used to be only gp.tileSizeWidth, changed after size of window changed
//		} catch(IOException e) {
//			e.printStackTrace();
//		}
//		return image;
//	} // end setup
	
} // end class
