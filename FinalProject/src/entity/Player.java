/**
 * The Player class represents the in-game player character. It extends the Entity class and encapsulates the player's
 * attributes, actions, and interactions within the game world.
 */

package entity;

import java.awt.AlphaComposite;
//import java.awt.Color;
//import java.awt.Font;
//import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.KeyHandler;
//import main.UtilityTool;

public class Player extends Entity{

    KeyHandler keyH; // Key handler for input handling
	
    // Fixed screen position for the player
   	public final int screenX;
   	public final int screenY;
   	
   	public int hasKey = 0; // Counter for collected keys			may be deleted
	
   	/**
     * Constructs a player character for the game.
     *
     * @param gp   The game panel.
     * @param keyH The key handler for input control.
     */
	public Player (GamePanel gp, KeyHandler keyH) {
		
		super(gp);
		
		this.keyH = keyH;
		
		screenX = gp.screenWidth / 2 - (gp.tileSize/2);
		screenY = gp.screenHeight / 2 - (gp.tileSize/2);
		
        // Initialize the player's hit-box
		solidArea = new Rectangle();
		solidArea.x = 7;
		solidArea.y = 16;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		solidArea.width = 32;
		solidArea.height = 32;
		
		setDefaultValues();
		getPlayerImage();
		
		
	} // end Player()
	
	/**
	* Initializes default values for the player character.
	*/	
	public void setDefaultValues() {
		
		worldX = gp.tileSize * 3;
		worldY = gp.tileSize * 6;
		speed = 4;
		direction = "down";
		 
		//PLAYER STATUS
		maxLife = 6;
		life = maxLife;
		
	} // end setDefaultValues()
	
	/**
	 * Loads player character images from resources.
	 */	
	public void getPlayerImage() {
		try {
			
			TitleScreen = ImageIO.read(getClass().getResourceAsStream("/objects/TitleScreen.png"));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		up0 = setup("/player/gray_up_0", gp.tileSizeWidth-4, gp.tileSizeHeight);
		up1 = setup("/player/gray_up_1", gp.tileSizeWidth-4, gp.tileSizeHeight);
		down0 = setup("/player/gray_down_0", gp.tileSizeWidth-4, gp.tileSizeHeight);
		down1 = setup("/player/gray_down_1", gp.tileSizeWidth-4, gp.tileSizeHeight);
		left0 = setup("/player/gray_left_0", gp.tileSizeWidth-4, gp.tileSizeHeight);
		left1 = setup("/player/gray_left_1", gp.tileSizeWidth-4, gp.tileSizeHeight);
		right0 = setup("/player/gray_right_0", gp.tileSizeWidth-4, gp.tileSizeHeight);
		right1 = setup("/player/gray_right_1", gp.tileSizeWidth-4, gp.tileSizeHeight);
		
	}// end getPlayerImage()
	
	
	/**
	* Updates the player character's position, animation, and interactions.
	*/
	public void update() {
		
        // Check if movement keys are pressed
		if(keyH.upPressed == true || keyH.downPressed == true || 
				keyH.leftPressed == true || keyH.rightPressed == true ) {

            // Determine the player's current direction based on key input
			if (keyH.upPressed == true) {
				direction = "up";		
			}
			else if (keyH.downPressed == true) {
				direction = "down";			
			}
			else if (keyH.leftPressed == true) {
				direction = "left";				
			}
			else if (keyH.rightPressed == true) {
				direction = "right";				
			}
			
			 // Check for collisions with tiles and objects
			collisionOn = false;
			gp.cChecker.checkTile(this);
			int objIndex = gp.cChecker.checkObject(this, true);
			pickUpObject(objIndex);
			
			// CHECK ENEMY COLLISION
			int enemyIndex = gp.cChecker.checkEntity(this, gp.enemy);
			contactEnemy(enemyIndex);
			
			
			
			// Check event
			gp.eHandler.checkEvent();
			
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
			
		} // end if to stop moving
		
		
		// This needs to be outside of key if statement!!!
		if( invincible == true) {
			invincibleCounter++;
			if(invincibleCounter > 60) {
				invincible = false;
				invincibleCounter = 0;
			}
		} // end if
		
	} // end update()
	
	
	/**
     * Handles interactions when the player picks up objects.
     *
     * @param i The index of the object to pick up.
     */
	public void pickUpObject(int i) {
		
		if(i != 999) {
			
			
		} // end if
	}// end pickUpObject
	
	
	public void contactEnemy( int i) {
		
		if(i != 999) {
			
			if( invincible == false) {
				gp.playSE(10);
				life -= 1;
				invincible = true;
			} // end if
			
			
		} // end if 
	} // end  contactEnemy
	
	
	public void damageEnemy(int i)  {
		
		if(i != 999) {
			
			if(gp.enemy[i].invincible == false) {
				
				gp.playSE(8);
				gp.enemy[i].life -= 1;
				gp.ui.addMessage("1 damage!");
				gp.enemy[i].invincible = true;
				gp.enemy[i].damageReaction();	
				
				if(gp.enemy[i].life <= 0) {
					gp.playSE(9);
					gp.enemy[i].dying = true;
					gp.ui.addMessage("killed a" + gp.enemy[i].name + "!");
				}
			}
		} // end if
	} // end damageEnemy
	
	
	
	/**
     * Draws the player character with the appropriate sprite image.
     *
     * @param g2 The graphics context.
     */
	
	public void draw(Graphics2D g2) {
			
		BufferedImage image = null;
		
		switch(direction) {
		
		case "up":
			if(spriteNum == 1) { image = up0; }
			if (spriteNum == 2) { image = up1; }
			break;
			
		case "down":
			if (spriteNum == 1) { image = down0; }
			if (spriteNum == 2) { image = down1; }
			break;
			
		case "left":
			if (spriteNum == 1) { image = left0; }
			if (spriteNum == 2) { image = left1; }
			break;
			
		case "right":
			if (spriteNum == 1) { image = right0; }
			if (spriteNum == 2) { image = right1; }
			break;
			
		} // end switch
		
		int x = screenX;
		int y = screenY;
		
		if(screenX > worldX) {
			x = worldX;
		}
		
		if(screenY > worldY) {
			y = worldY;
		}
		int rightOffset = gp.screenWidth - screenX;
		if(rightOffset > gp.worldWidth - worldX) {
			x = gp.screenWidth - (gp.worldWidth - worldX);
		}
		int bottomOffset = gp.screenHeight - screenY;
		if(bottomOffset > gp.worldHeight - worldY) {
			y = gp.screenHeight - (gp.worldHeight - worldY);
		}
		
		
		if (invincible == true) {
			g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.4f));		// make player transparent when invincible, he received damage
		}
		
		g2.drawImage(image, x, y, null);
		
		// Reset alpha
		g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));		// make player transparent when invincible, he received damage

		
		// DEBUG
//		g2.setFont(new Font("Arial", Font.PLAIN, 26));
//		g2.setColor(Color.black);
//		g2.drawString("Invincible: " + invincibleCounter , 10, 400);
		
		
	} // end draw()
	
} // end class
