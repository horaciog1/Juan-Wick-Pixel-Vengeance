/**
 * The Entity class serves as a fundamental blueprint for various in-game characters, including players, enemies, and NPCs.
 * It encapsulates essential properties and behavior shared by these entities.
 */

package entity;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.UtilityTool;

public class Entity {

	GamePanel gp;
	public int worldX, worldY; // Current world position
	public int speed; // Movement speed
	
    // Sprite images for different directions
	public BufferedImage up0, up1, down0, down1, left0, left1, right0, right1, TitleScreen;	
	public String direction = "down";  // Current facing direction
	
	public int spriteCounter = 0; // Counter for sprite animation
	public int spriteNum = 1; // Total number of sprites
	
    // Hit-box for collision detection (you can overwrite the hit-box on the designated class;) )
	public Rectangle solidArea = new Rectangle(0, 0, 48, 48);
	public int solidAreaDefaultX, solidAreaDefaultY;
	public boolean collisionOn = false;	// Flag to enable collision detection
	public int actionLockCounter = 0;
	public boolean invincible = false;
	public int invincibleCounter = 0;
	public BufferedImage image, image2, image3;
	public String name;
	public boolean collision = false;
	public int type;	// 0 = player, 1 = NPC (if added), 2 = enemy
	
	//CHARACTER STATUS
	public int maxLife;
	public int life;
	
	public Entity (GamePanel gp) {
		this.gp = gp;
	} // end constructor
	
	
	
	public void setAction() {
		
	} // end setAction
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
		   if(spriteNum == 1) {
		    image = up0;
		   }
		   if(spriteNum == 2) {
		    image = up1;
		   }
		   break;
		  case "down":
		   if(spriteNum == 1) {
		    image = down0;
		   }
		   if(spriteNum == 2) {
		    image = down1;
		   }
		   break;
		  case "left":
		   if(spriteNum == 1) {
		    image = left0;    
		   }   
		   if(spriteNum == 2) {
		    image = left1;
		   }
		   break;
		  case "right":
		   if(spriteNum == 1) {
		    image = right0;
		   }   
		   if(spriteNum == 2) {
		    image = right1;
		   }
		   break;
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
		
	} // end draw
	
	public BufferedImage setup(String imagePath) {
		
		UtilityTool uTool = new UtilityTool();
		BufferedImage image = null;
		
		try {
			image = ImageIO.read(getClass().getResourceAsStream(imagePath + ".png"));
			image = uTool.scaleImage(image, gp.tileSize, gp.tileSize);
			
		} catch(IOException e) {
			e.printStackTrace();
		}
		return image;
	} // end setup
	
	
	public BufferedImage setupPlayer(String imagePath) {
		
		UtilityTool uTool = new UtilityTool();
		BufferedImage image = null;
		
		try {
			image = ImageIO.read(getClass().getResourceAsStream(imagePath + ".png"));
			image = uTool.scaleImage(image, gp.tileSizeWidth-4, gp.tileSizeHeight);	
			// used to be only gp.tileSizeWidth, changed after size of window changed
		} catch(IOException e) {
			e.printStackTrace();
		}
		return image;
	} // end setup
	
} // end class
