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
	Tile[] tile;			//Single tile or texture
	int mapTileNum[][];		//Two-Dimentional Array for column and row
	
	public TileManager(GamePanel gp) {
		this.gp = gp;
		
//**********The number in the array "Tile" in the next line, limits the amount of tiles aka textures**********
		tile = new Tile[10];	
		mapTileNum = new int[gp.maxScreenCol][gp.maxScreenRow];
		
		getTileImage();
		loadMap("/maps/map01.txt");
	}//End TileManager
	
	//Declaration and import of the textures or tiles.
	//**********MUST BE .PNG AND STORED IN RESOUCES UNDER TILES**********
	public void getTileImage() {
		
		try { 
			
			tile[0] = new Tile();
			tile[0].image = ImageIO.read(getClass().getResourceAsStream("/tiles/RedWoodTile.png"));		//Red Wood tile
			
			tile[1] = new Tile();
			tile[1].image = ImageIO.read(getClass().getResourceAsStream("/tiles/WallTile.png"));		// Wall Tile
			
			tile[2] = new Tile();
			tile[2].image = ImageIO.read(getClass().getResourceAsStream("/tiles/WindowTile.png"));		// Window Tile
			
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
			while(col < gp.maxScreenCol && row < gp.maxScreenRow) {
				String line = br.readLine();
				
				while(col < gp.maxScreenCol) {
					String numbers[] = line.split(" ");	//Space must be placed in 2D array to recognize and properly Skip.
					
					int num = Integer.parseInt(numbers[col]);
					
					mapTileNum[col][row] = num;
					col++;
				}//End While
				if(col == gp.maxScreenCol) {
					col = 0;
					row++;
				}//End if
			}//End While
			
		}catch(Exception e) {
			e.printStackTrace();
			}//End try
	}//End loadMap
	public void draw(Graphics2D g2) {		//**********SEPARATION BETWEEN TILES IS 66 PIXELS**********
		
		int col = 0;
		int row = 0;
		int x = 0;
		int y = 0;
		
		while(col < gp.maxScreenCol && row < gp.maxScreenRow ) {
			
			int tileNum = mapTileNum[col][row];
			
			g2.drawImage(tile[tileNum].image, x, y, gp.tileSize, gp.tileSize, null);
			col++;
			x += gp.tileSize;
			
			if(col == gp.maxScreenCol) {
				col = 0;
				x = 0;
				row++;
				y += gp.tileSize;
				
			}//End if
		}//End While	
	}//End Draw
}
