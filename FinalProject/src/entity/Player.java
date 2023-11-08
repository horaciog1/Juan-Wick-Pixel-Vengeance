/**
 * The Player class represents the in-game player character. It extends the Entity class and encapsulates the player's
 * attributes, actions, and interactions within the game world.
 */

package entity;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.KeyHandler;

public class Player extends Entity{

	GamePanel gp; // Reference to the game panel
    KeyHandler keyH; // Key handler for input handling
	
    // Fixed screen position for the player
   	public final int screenX;
   	public final int screenY;
   	
   	public int hasKey = 0; // Counter for collected keys
	
   	/**
     * Constructs a player character for the game.
     *
     * @param gp   The game panel.
     * @param keyH The key handler for input control.
     */
	public Player (GamePanel gp, KeyHandler keyH) {
		
		this.gp = gp;
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
			
			up0 = ImageIO.read(getClass().getResourceAsStream("/player/gray_up_0.png"));
			up1 = ImageIO.read(getClass().getResourceAsStream("/player/gray_up_1.png"));
			down0 = ImageIO.read(getClass().getResourceAsStream("/player/gray_down_0.png"));
			down1 = ImageIO.read(getClass().getResourceAsStream("/player/gray_down_1.png"));
			left0 = ImageIO.read(getClass().getResourceAsStream("/player/gray_left_0.png"));
			left1 = ImageIO.read(getClass().getResourceAsStream("/player/gray_left_1.png"));
			right0 = ImageIO.read(getClass().getResourceAsStream("/player/gray_right_0.png"));
			right1 = ImageIO.read(getClass().getResourceAsStream("/player/gray_right_1.png"));
			TitleScreen = ImageIO.read(getClass().getResourceAsStream("/objects/TitleScreen.png"));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
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
	} // end update()
	
	
	/**
     * Handles interactions when the player picks up objects.
     *
     * @param i The index of the object to pick up.
     */
	public void pickUpObject(int i) {
		
		if(i != 999) {
			
			String objectName = gp.obj[i].name;
			
			switch(objectName) {
			case "Key":
				hasKey++;
				gp.obj[i] = null;	// make obj disappear
				System.out.println("Key:" + hasKey);
				break;
			case "Door":
				if(hasKey > 0) {
					gp.obj[i] = null;	// Disappear door if player has key
					hasKey--;
				}
				System.out.println("Key:" + hasKey);
				break;
			}// end switch
		} // end if
	}// end pickUpObject
	
	
	/**
     * Draws the player character with the appropriate sprite image.
     *
     * @param g2 The graphics context.
     */
	
	public void draw(Graphics2D g2) {
			
		BufferedImage image = null;
		
		switch(direction) {
		
		case "up":
			if(spriteNum == 1) {
				image = up0;
			}
			if (spriteNum == 2) {
				image = up1;
			}
			break;
			
		case "down":
			if (spriteNum == 1) {
				image = down0;
			}
			if (spriteNum == 2) {
				image = down1;
			}
			break;
			
		case "left":
			if (spriteNum == 1) {
				image = left0;
			}
			if (spriteNum == 2) {
				image = left1;
			}
			break;
			
		case "right":
			if (spriteNum == 1) {
				image = right0;
			}
			if (spriteNum == 2) {
				image = right1;
			}
			break;
			
		} // end switch
		
		g2.drawImage(image, screenX, screenY, gp.tileSizeWidth, gp.tileSizeHeight, null);
		
		
	} // end draw()
	
} // end class
