package tile;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;
import main.GamePanel;

public class TileManager {

	GamePanel gp;
	public Tile[] tile;			//Single tile or texture
	public int mapTileNum[][];		//Two-Dimentional Array for column and row
	
	public TileManager(GamePanel gp) {
		this.gp = gp;
		
//**********The number in the array "Tile" in the next line, limits the amount of tiles aka textures**********
		tile = new Tile[10];	
		mapTileNum = new int[gp.maxWorldCol][gp.maxWorldRow];
		
		getTileImage();
		loadMap("/maps/world01.txt");
	}//End TileManager
	
	//Declaration and import of the textures or tiles.
	//**********MUST BE .PNG AND STORED IN RESOUCES UNDER TILES**********
	public void getTileImage() {
		
		try { 
			
			tile[0] = new Tile();
			tile[0].image = ImageIO.read(getClass().getResourceAsStream("/tiles/RedWoodTile.png"));		//Red Wood tile
			
			tile[1] = new Tile();
			tile[1].image = ImageIO.read(getClass().getResourceAsStream("/tiles/WallTile.png"));		// Wall Tile
			tile[1].collision = true;
			
			tile[2] = new Tile();
			tile[2].image = ImageIO.read(getClass().getResourceAsStream("/tiles/WindowTile.png"));		// Window Tile
			
//			tile[3] = new Tile();
//			tile[3].image = ImageIO.read(getClass().getResourceAsStream("/tiles/WindowTile.png"));
//			
//			tile[4] = new Tile();
//			tile[4].image = ImageIO.read(getClass().getResourceAsStream("/tiles/WindowTile.png"));
//			
//			tile[5] = new Tile();
//			tile[5].image = ImageIO.read(getClass().getResourceAsStream("/tiles/WindowTile.png"));
//			
//			tile[6] = new Tile();
//			tile[6].image = ImageIO.read(getClass().getResourceAsStream("/tiles/WindowTile.png"));
//			
//			tile[7] = new Tile();
//			tile[7].image = ImageIO.read(getClass().getResourceAsStream("/tiles/WindowTile.png"));
//			
//			tile[8] = new Tile();
//			tile[8].image = ImageIO.read(getClass().getResourceAsStream("/tiles/WindowTile.png"));
//			
//			tile[9] = new Tile();
//			tile[9].image = ImageIO.read(getClass().getResourceAsStream("/tiles/WindowTile.png"));
			
		}catch(IOException e) {
			e.printStackTrace();
		}//End Catch
		
	}//End getTileImage
	
	//Loading of Maps
	public void loadMap(String filePath) {				//filePath String automation for multiple maps
		
		try {
			InputStream is = getClass().getResourceAsStream(filePath);
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			
			int col = 0;
			int row = 0;
			
			//**********"maxScreenCol" and "maxScreenRow" are declared in GamePanel**********
			while(col < gp.maxWorldCol && row < gp.maxWorldRow) {
				String line = br.readLine();
				
				while(col < gp.maxWorldCol) {
					String numbers[] = line.split(" ");	//Space must be placed in 2D array to recognize and properly Skip.
					
					int num = Integer.parseInt(numbers[col]);
					
					mapTileNum[col][row] = num;
					col++;
				}//End While
				if(col == gp.maxWorldCol) {
					col = 0;
					row++;
				}//End if
			}//End While
			
		}catch(Exception e) {
			e.printStackTrace();
			}//End try
	}//End loadMap
	public void draw(Graphics2D g2) {		//**********SEPARATION BETWEEN TILES IS 66 PIXELS**********
		
		int worldCol = 0;
		int worldRow = 0;
		
		
		while(worldCol < gp.maxWorldCol && worldRow < gp.maxWorldRow ) {
			
			int tileNum = mapTileNum[worldCol][worldRow];
			
			int worldX = worldCol * gp.tileSize;							// Position on the map
			int worldY = worldRow * gp.tileSize;							// Position on the map
			int screenX = worldX - gp.player.worldX + gp.player.screenX;	// Position on screen
			int screenY = worldY - gp.player.worldY + gp.player.screenY;	// Position on screen
			
			if(worldX + gp.tileSize > gp.player.worldX - gp.player.screenX &&
			   worldX - gp.tileSize < gp.player.worldX + gp.player.screenX &&
			   worldY + gp.tileSize > gp.player.worldY - gp.player.screenY &&
			   worldY - gp.tileSize < gp.player.worldY + gp.player.screenY)	{
				
				g2.drawImage(tile[tileNum].image, screenX, screenY, gp.tileSize, gp.tileSize, null);

			} //end if
					
			worldCol++;
			
			if(worldCol == gp.maxWorldCol) {
				worldCol = 0;
				worldRow++;
			}//End if
		}//End While	
	}//End Draw
} // end class
