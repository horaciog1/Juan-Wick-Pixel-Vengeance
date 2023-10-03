/*
 * This Class will store variables that will be used in player, enemies, and NPC classes
 */

package entity;

import java.awt.image.BufferedImage;

public class Entity {

	public int x, y;
	public int speed;
	
	// it describes an image with an accessible buffer of image data. (to store our image files)
	public BufferedImage up0, up1, down0, down1, left0, left1, right0, right1;	
	public String direction;
	
	public int spriteCounter = 0;
	public int spriteNum = 1;
	
	
	
	
	
	
} // end class
