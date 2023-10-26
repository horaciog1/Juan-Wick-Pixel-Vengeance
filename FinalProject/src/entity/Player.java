package entity;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.KeyHandler;

public class Player extends Entity{

	GamePanel gp;
	KeyHandler keyH;
	
	// These wont change, player character's screen position
	public final int screenX;
	public final int screenY;
	int hasKey = 0;
	
	
	
	public Player (GamePanel gp, KeyHandler keyH) {
		
		this.gp = gp;
		this.keyH = keyH;
		
		screenX = gp.screenWidth / 2 - (gp.tileSize/2);
		screenY = gp.screenHeight / 2 - (gp.tileSize/2);
		
		// Player's hit-box
		solidArea = new Rectangle();
		solidArea.x = 25;
		solidArea.y = 15;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultX = solidArea.y;
		solidArea.width = 24;
		solidArea.height = 40;
		
		setDefaultValues();
		getPlayerImage();
		
		
	} // end Player()
	
	public void setDefaultValues() {
		
		worldX = gp.tileSize * 3;
		worldY = gp.tileSize * 6;
		speed = 4;
		direction = "down";
		
	} // end setDefaultValues()
	
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

		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}// end getPlayerImage()
	
	public void update() {
		
		// this is going to stop the changing of the sprite while is not moving
		if(keyH.upPressed == true || keyH.downPressed == true || 
				keyH.leftPressed == true || keyH.rightPressed == true ) {

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
			
			// CHECK TILE COLLISION
			collisionOn = false;
			gp.cChecker.checkTile(this);
			
			
			// CHECK OBJECT COLLISION
			int objIndex = gp.cChecker.checkObject(this, true);
			pickUpObject(objIndex);
			
			// IF COLLISION IS FALSE, PLAYER CAN MOVE
			if (collisionOn == false) {
				
				switch(direction) {
				case "up": worldY -= speed; 	break;
				case "down": worldY += speed; 	break;
				case "left": worldX -= speed; 	break;
				case "right": worldX += speed;	 break;
				}// end switch
			} // end if collisionOn
			
			
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
	
	public void pickUpObject(int i) {
		
		if (i != 999) {
			
			String objectName = gp.obj[i].name;
			
			switch(objectName) {
			case "Key":
				hasKey++;
				gp.obj[i] = null;	// make obj disappear
				System.out.println("Key:" + hasKey);
				break;
				
			case "Door":
				if(hasKey > 0) {
					gp.obj[i] = null; // Disappear door if player has key
					hasKey--;
				}
				System.out.println("Key:" + hasKey);
				break;
				
			}// end switch
			
		} // end if
		
		
	}// end pickUpObject
	
	public void draw(Graphics2D g2) {
		
//		g2.setColor(Color.white);
//		g2.fillRect(x, y, gp.tileSizeWidth, gp.tileSizeHeight);
		
		
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























