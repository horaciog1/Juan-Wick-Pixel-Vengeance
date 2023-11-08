
/**
 * The AssetSetter class manages the placement and manipulation of objects in the game map.
 * It initializes and sets the initial positions of objects such as keys and doors.
 * Note: This class is separated to keep the GamePanel class clean and organized.
 */
package main;

import object.OBJ_Door;
import object.OBJ_Key;

public class AssetSetter {

	GamePanel gp;
	
	
	/**
     * Constructs an AssetSetter object.
     *
     * @param gp The GamePanel instance to which this AssetSetter is associated.
     */
	public AssetSetter(GamePanel gp) {
		this.gp = gp;
		
	} // end constructor
	
	/**
     * Initializes and sets the initial positions of objects in the game map.
     */	
	public void setObject() {
		
        // Creating Key objects and setting their positions
		gp.obj[0] = new OBJ_Key();
		gp.obj[0].worldX = 10 * gp.tileSize;
		gp.obj[0].worldY = 2 * gp.tileSize;

		gp.obj[1] = new OBJ_Key();
		gp.obj[1].worldX = 26 * gp.tileSize;
		gp.obj[1].worldY = 10 * gp.tileSize;
		
		gp.obj[2] = new OBJ_Key();
		gp.obj[2].worldX = 47 * gp.tileSize;
		gp.obj[2].worldY = 12 * gp.tileSize;
		
		gp.obj[3] = new OBJ_Key();
		gp.obj[3].worldX = 19 * gp.tileSize;
		gp.obj[3].worldY = 18 * gp.tileSize;
		
		gp.obj[4] = new OBJ_Key();
		gp.obj[4].worldX = 7 * gp.tileSize;
		gp.obj[4].worldY = 16 * gp.tileSize;
		
		
		// Creating Door objects and setting their positions
		gp.obj[5] = new OBJ_Door();
		gp.obj[5].worldX = 14 * gp.tileSize;
		gp.obj[5].worldY = 7 * gp.tileSize;
		
		gp.obj[6] = new OBJ_Door();
		gp.obj[6].worldX = 29 * gp.tileSize;
		gp.obj[6].worldY = 7 * gp.tileSize;
		
		gp.obj[7] = new OBJ_Door();
		gp.obj[7].worldX = 35 * gp.tileSize;
		gp.obj[7].worldY = 13 * gp.tileSize;
		
		gp.obj[8] = new OBJ_Door();
		gp.obj[8].worldX = 14 * gp.tileSize;
		gp.obj[8].worldY = 24 * gp.tileSize;
		
		gp.obj[9] = new OBJ_Door();
		gp.obj[9].worldX = 7 * gp.tileSize;
		gp.obj[9].worldY = 27 * gp.tileSize;
		

	}// end setObject()
	
} // end class
