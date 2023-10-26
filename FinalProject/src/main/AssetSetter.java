package main;

import Object.OBJ_Door;
import Object.OBJ_Key;

public class AssetSetter {

	GamePanel gp;
	
	public AssetSetter(GamePanel gp) {
		this.gp = gp;
	}
	
	public void setObject() {
		
		//Creating First Key
		gp.obj[0] = new OBJ_Key();
		gp.obj[0].worldX = 7 * gp.tileSize;
		gp.obj[0].worldY = 4 * gp.tileSize;
		
		//Creating Second Key
		gp.obj[1] = new OBJ_Key();
		gp.obj[1].worldX = 7 * gp.tileSize;
		gp.obj[1].worldY = 17 * gp.tileSize;
		
		//Creating First Door
		gp.obj[2] = new OBJ_Door();
		gp.obj[2].worldX = 7 * gp.tileSize;
		gp.obj[2].worldY = 12 * gp.tileSize;
		
		//Creating Second Door
		gp.obj[3] = new OBJ_Door();
		gp.obj[3].worldX = 12 * gp.tileSize;
		gp.obj[3].worldY = 6 * gp.tileSize;
	}
}
