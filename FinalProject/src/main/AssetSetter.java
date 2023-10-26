/*
 * This class will take care of placing the manipulating the objects in the map
 * 
 * *Note: This class can be implemented in GamePanel, but it will be a mess
 */

package main;

import object.OBJ_Door;
import object.OBJ_Key;

public class AssetSetter {

	GamePanel gp;
	
	public AssetSetter(GamePanel gp) {
		this.gp = gp;
		
	} // end constructor
	
	
	public void setObject() {
		
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
