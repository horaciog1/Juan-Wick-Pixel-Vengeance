/**
 * The AssetSetter class manages the placement and manipulation of objects in the game map.
 * It initializes and sets the initial positions of objects such as keys and doors.
 * Note: This class is separated to keep the GamePanel class clean and organized.
 */
package main;

import enemy.ENEM_Ninja;
//import object.OBJ_Door;
//import object.OBJ_Key;

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
//		gp.obj[0] = new OBJ_Door(gp);
//		gp.obj[0].worldX = gp.tileSize * 14;
//		gp.obj[0].worldY = gp.tileSize * 7;
//		
//		gp.obj[1] = new OBJ_Key(gp);
//		gp.obj[1].worldX = gp.tileSize * 10;
//		gp.obj[1].worldY = gp.tileSize * 3;
	}// end setObject()
	
	
	public void setEnemy() {
		
		gp.enemy[0] = new ENEM_Ninja(gp);
		gp.enemy[0].worldX = gp.tileSize * 24;
		gp.enemy[0].worldY = gp.tileSize * 5;
		
		gp.enemy[1] = new ENEM_Ninja(gp);
		gp.enemy[1].worldX = gp.tileSize * 22;
		gp.enemy[1].worldY = gp.tileSize * 8;
		
	
		
		
	} // end setEnemy
} // end class
