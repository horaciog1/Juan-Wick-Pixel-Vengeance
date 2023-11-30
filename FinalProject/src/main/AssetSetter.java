/**
 * The AssetSetter class manages the placement and manipulation of objects in the game map.
 * It initializes and sets the initial positions of objects such as keys and doors.
 * Note: This class is separated to keep the GamePanel class clean and organized.
 */
package main;

import enemy.ENEM_BlueNinja;
import enemy.ENEM_Ninja;
import enemy.ENEM_NinjaDropper;
import enemy.ENEM_RedNinja;
import object.OBJ_Chest;
import object.OBJ_Door;

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
		int i = 0;
		gp.obj[i] = new OBJ_Door(gp);
		gp.obj[i].worldX = gp.tileSize * 16;
		gp.obj[i].worldY = gp.tileSize * 7;
		i++;	
		
		gp.obj[i] = new OBJ_Door(gp);
		gp.obj[i].worldX = gp.tileSize * 31;
		gp.obj[i].worldY = gp.tileSize * 6;
		i++;
		
		gp.obj[i] = new OBJ_Door(gp);
		gp.obj[i].worldX = gp.tileSize * 31;
		gp.obj[i].worldY = gp.tileSize * 15;
		i++;
		
		gp.obj[i] = new OBJ_Door(gp);
		gp.obj[i].worldX = gp.tileSize * 16;
		gp.obj[i].worldY = gp.tileSize * 16;
		i++;
		
		gp.obj[i] = new OBJ_Door(gp);
		gp.obj[i].worldX = gp.tileSize * 3;
		gp.obj[i].worldY = gp.tileSize * 20;
		i++;
		
		gp.obj[i] = new OBJ_Door(gp);
		gp.obj[i].worldX = gp.tileSize * 16;
		gp.obj[i].worldY = gp.tileSize * 29;
		i++;
		
		gp.obj[i] = new OBJ_Door(gp);
		gp.obj[i].worldX = gp.tileSize * 31;
		gp.obj[i].worldY = gp.tileSize * 28;
		i++;
		
		gp.obj[i] = new OBJ_Door(gp);
		gp.obj[i].worldX = gp.tileSize * 34;
		gp.obj[i].worldY = gp.tileSize * 31;
		i++;
		
		gp.obj[i] = new OBJ_Door(gp);
		gp.obj[i].worldX = gp.tileSize * 13;
		gp.obj[i].worldY = gp.tileSize * 38;
		i++;
		
		gp.obj[i] = new OBJ_Door(gp);
		gp.obj[i].worldX = gp.tileSize * 2;
		gp.obj[i].worldY = gp.tileSize * 41;
		i++;
		
		gp.obj[i] = new OBJ_Door(gp);
		gp.obj[i].worldX = gp.tileSize * 13;
		gp.obj[i].worldY = gp.tileSize * 45;
		i++;
		
		gp.obj[i] = new OBJ_Door(gp);
		gp.obj[i].worldX = gp.tileSize * 27;
		gp.obj[i].worldY = gp.tileSize * 45;
		i++;
		
		gp.obj[i] = new OBJ_Door(gp);
		gp.obj[i].worldX = gp.tileSize * 38;
		gp.obj[i].worldY = gp.tileSize * 41;
		i++;
		
		gp.obj[i] = new OBJ_Chest(gp);
		gp.obj[i].worldX = gp.tileSize * 46;
		gp.obj[i].worldY = gp.tileSize * 48;
		i++;
		
		gp.obj[i] = new OBJ_Chest(gp);
		gp.obj[i].worldX = gp.tileSize * 7;
		gp.obj[i].worldY = gp.tileSize * 6;
		i++;
		
		
	}// end setObject()
	
	
	public void setEnemy() {
		
		int i = 0;
		
		// ROOM 1
		gp.enemy[i] = new ENEM_Ninja(gp);
		gp.enemy[i].worldX = gp.tileSize * 14;
		gp.enemy[i].worldY = gp.tileSize * 10;
		i++;
		gp.enemy[i] = new ENEM_Ninja(gp);
		gp.enemy[i].worldX = gp.tileSize * 14;
		gp.enemy[i].worldY = gp.tileSize * 2;
		i++;
		gp.enemy[i] = new ENEM_Ninja(gp);
		gp.enemy[i].worldX = gp.tileSize * 1;
		gp.enemy[i].worldY = gp.tileSize * 10;
		i++;
		gp.enemy[i] = new ENEM_NinjaDropper(gp);
		gp.enemy[i].worldX = gp.tileSize * 3;
		gp.enemy[i].worldY = gp.tileSize * 1;
		i++;
		
		// ROOM 2
		gp.enemy[i] = new ENEM_Ninja(gp);
		gp.enemy[i].worldX = gp.tileSize * 18;
		gp.enemy[i].worldY = gp.tileSize * 9;
		i++;
		gp.enemy[i] = new ENEM_Ninja(gp);
		gp.enemy[i].worldX = gp.tileSize * 22;
		gp.enemy[i].worldY = gp.tileSize * 9;
		i++;
		gp.enemy[i] = new ENEM_Ninja(gp);
		gp.enemy[i].worldX = gp.tileSize * 18;
		gp.enemy[i].worldY = gp.tileSize * 2;
		i++;
		gp.enemy[i] = new ENEM_NinjaDropper(gp);
		gp.enemy[i].worldX = gp.tileSize * 30;
		gp.enemy[i].worldY = gp.tileSize * 3;
		i++;
		gp.enemy[i] = new ENEM_RedNinja(gp);
		gp.enemy[i].worldX = gp.tileSize * 28;
		gp.enemy[i].worldY = gp.tileSize * 9;
		i++;
		
		// ROOM 3
		gp.enemy[i] = new ENEM_NinjaDropper(gp);
		gp.enemy[i].worldX = gp.tileSize * 38;
		gp.enemy[i].worldY = gp.tileSize * 1;
		i++;
		gp.enemy[i] = new ENEM_RedNinja(gp);
		gp.enemy[i].worldX = gp.tileSize * 34;
		gp.enemy[i].worldY = gp.tileSize * 6;
		i++;
		gp.enemy[i] = new ENEM_RedNinja(gp);
		gp.enemy[i].worldX = gp.tileSize * 45;
		gp.enemy[i].worldY = gp.tileSize * 2;
		i++;
		gp.enemy[i] = new ENEM_RedNinja(gp);
		gp.enemy[i].worldX = gp.tileSize * 34;
		gp.enemy[i].worldY = gp.tileSize * 4;
		i++;
		
		// ROOM 4
		gp.enemy[i] = new ENEM_Ninja(gp);
		gp.enemy[i].worldX = gp.tileSize * 33;
		gp.enemy[i].worldY = gp.tileSize * 10;
		i++;
		gp.enemy[i] = new ENEM_Ninja(gp);
		gp.enemy[i].worldX = gp.tileSize * 33;
		gp.enemy[i].worldY = gp.tileSize * 12;
		i++;
		gp.enemy[i] = new ENEM_NinjaDropper(gp);
		gp.enemy[i].worldX = gp.tileSize * 34;
		gp.enemy[i].worldY = gp.tileSize * 15;
		i++;
		gp.enemy[i] = new ENEM_RedNinja(gp);
		gp.enemy[i].worldX = gp.tileSize * 43;
		gp.enemy[i].worldY = gp.tileSize * 11;
		i++;
		
		// ROOM 5
		gp.enemy[i] = new ENEM_NinjaDropper(gp);
		gp.enemy[i].worldX = gp.tileSize * 18;
		gp.enemy[i].worldY = gp.tileSize * 13;
		i++;
		gp.enemy[i] = new ENEM_BlueNinja(gp);
		gp.enemy[i].worldX = gp.tileSize * 19;
		gp.enemy[i].worldY = gp.tileSize * 14;
		i++;
		gp.enemy[i] = new ENEM_BlueNinja(gp);
		gp.enemy[i].worldX = gp.tileSize * 29;
		gp.enemy[i].worldY = gp.tileSize * 19;
		i++;
		
		
		// ROOM 6
		gp.enemy[i] = new ENEM_BlueNinja(gp);
		gp.enemy[i].worldX = gp.tileSize * 14;
		gp.enemy[i].worldY = gp.tileSize * 18;
		i++;
		gp.enemy[i] = new ENEM_RedNinja(gp);
		gp.enemy[i].worldX = gp.tileSize * 7;
		gp.enemy[i].worldY = gp.tileSize * 14;
		i++;
		gp.enemy[i] = new ENEM_NinjaDropper(gp);
		gp.enemy[i].worldX = gp.tileSize * 2;
		gp.enemy[i].worldY = gp.tileSize * 13;
		i++;
		
		
		// ROOM 7
		gp.enemy[i] = new ENEM_BlueNinja(gp);
		gp.enemy[i].worldX = gp.tileSize * 2;
		gp.enemy[i].worldY = gp.tileSize * 28;
		i++;
		gp.enemy[i] = new ENEM_NinjaDropper(gp);
		gp.enemy[i].worldX = gp.tileSize * 8;
		gp.enemy[i].worldY = gp.tileSize * 30;
		i++;
		
		// ROOM 8
		gp.enemy[i] = new ENEM_BlueNinja(gp);
		gp.enemy[i].worldX = gp.tileSize * 29;
		gp.enemy[i].worldY = gp.tileSize * 27;
		i++;
		gp.enemy[i] = new ENEM_NinjaDropper(gp);
		gp.enemy[i].worldX = gp.tileSize * 19;
		gp.enemy[i].worldY = gp.tileSize * 24;
		i++;


		
		
		
	} //end setEnemy
} // end class
