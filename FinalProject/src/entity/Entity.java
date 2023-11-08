/**
 * The Entity class serves as a fundamental blueprint for various in-game characters, including players, enemies, and NPCs.
 * It encapsulates essential properties and behavior shared by these entities.
 */

package entity;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Entity {

    public int worldX, worldY; // Current world position
    public int speed; // Movement speed
	
    // Sprite images for different directions
	public BufferedImage up0, up1, down0, down1, left0, left1, right0, right1;	
	public String direction; // Current facing direction
	
    public int spriteCounter = 0; // Counter for sprite animation
    public int spriteNum = 1; // Total number of sprites
	
    // Hit-box for collision detection (player)
	public Rectangle solidArea;
	public int solidAreaDefaultX, solidAreaDefaultY;
	public boolean collisionOn = false; // Flag to enable collision detection
	
	//ADDED ADDED ADDED
	//CHARACTER STATUS
	//public int maxLife;
	//public int life;
	
} // end class
