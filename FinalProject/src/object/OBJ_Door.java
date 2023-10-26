package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_Door extends SuperObject{

	// constructor
		public OBJ_Door() {
			
			name = "Door";
			try {
				image = ImageIO.read(getClass().getResourceAsStream("/objects/door.png"));
			}// end try
			catch (IOException e) {
				e.printStackTrace();
			}// end catch
			
			collision = true;
			
		} // end OBJ_Door()
	
}// end class
