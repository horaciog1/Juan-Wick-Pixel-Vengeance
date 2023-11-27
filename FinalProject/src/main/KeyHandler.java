/**
 * The KeyHandler class plays a crucial role in managing keyboard input, detecting key presses, and handling key events
 * within the game. It is designed to interact with the KeyListener interface, effectively facilitating key event handling.
 */

package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener{

	GamePanel gp;
	public boolean upPressed, downPressed, leftPressed, rightPressed;
	
	public KeyHandler(GamePanel gp) {
		this.gp = gp;
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// Not used, but necessary for the class to run without errors.
	}

	 /**
     * Handles key presses and responds to various key events based on the game's state.
     *
     * @param e The KeyEvent representing the key press.
     */
	@Override
	public void keyPressed(KeyEvent e) {
		
		int code = e.getKeyCode();
		
		//TITLE STATE
		if(gp.gameState == gp.titleState) {
			titleState(code);
		} 
		
		
		//PLAY STATE
		else if (gp.gameState == gp.playState) {
			playState(code);
		}
		
		// PAUSE STATE
		else if (gp.gameState == gp.pauseState) {
			pauseState(code);
		}
	} //  end keyPressed()
	
	
	
	public void titleState(int code) {

		//TITLE STATE
		if(gp.gameState == gp.titleState) {

			if(gp.ui.titleScreenState == 0) {
				if ( code == KeyEvent.VK_W) {
					gp.ui.commandNum--;
					if(gp.ui.commandNum < 0) {
						gp.ui.commandNum = 2;
					}
				}
				if ( code == KeyEvent.VK_S) {
					gp.ui.commandNum++;
					if(gp.ui.commandNum > 2) {
						gp.ui.commandNum = 0;
					}
				}
				if(code == KeyEvent.VK_ENTER) {
					if(gp.ui.commandNum == 0) {
						gp.ui.titleScreenState = 1;
					}
					if(gp.ui.commandNum == 1) {
						//add later
					}
					if(gp.ui.commandNum == 2) 
						System.exit(0);
				}
			} // end main if

			else if(gp.ui.titleScreenState == 1) {
				if ( code == KeyEvent.VK_W) {
					gp.ui.commandNum--;
					if(gp.ui.commandNum < 0) {
						gp.ui.commandNum = 2;
					}
				}
				if ( code == KeyEvent.VK_S) {
					gp.ui.commandNum++;
					if(gp.ui.commandNum > 3) {
						gp.ui.commandNum = 0;
					}
				}
				if(code == KeyEvent.VK_ENTER) {
					if(gp.ui.commandNum == 0) {
						System.out.println("Gray suit!");
						gp.gameState = gp.playState;
						gp.playMusic(1);
					}
					if(gp.ui.commandNum == 1) {
						System.out.println("Blue suit!");
						gp.gameState = gp.playState;
						gp.playMusic(1);
					}
					if(gp.ui.commandNum == 2) { 
						System.out.println("Black suit!");
						gp.gameState = gp.playState;
						gp.playMusic(1);
					}	
					if(gp.ui.commandNum == 3) { 
						gp.ui.titleScreenState = 0;
					}	
				}
			}

		} // end title if	
	} // end titleState
	
	public void playState(int code) {
		if ( code == KeyEvent.VK_W) { upPressed = true; }
		if ( code == KeyEvent.VK_A) { leftPressed = true; }
		if ( code == KeyEvent.VK_S) { downPressed = true; }
		if ( code == KeyEvent.VK_D) { rightPressed = true; }
		if ( code == KeyEvent.VK_P) { gp.gameState = gp.pauseState; }
	} // end playState
	
	public void pauseState(int code) {
		if (code == KeyEvent.VK_P) { gp.gameState = gp.playState; }
	} // end pauseState
	

	
	/**
     * Handles key releases and updates key event states accordingly.
     *
     * @param e The KeyEvent representing the key release.
     */
	@Override
	public void keyReleased(KeyEvent e) {
		
		int code = e.getKeyCode();
		
		if ( code == KeyEvent.VK_W) {
			upPressed = false;
		}
		if ( code == KeyEvent.VK_A) {
			leftPressed = false;
		}
		if ( code == KeyEvent.VK_S) {
			downPressed = false;
		}
		if ( code == KeyEvent.VK_D) {
			rightPressed = false;
		}
		
		
	} //  end keyReleased()

} // end class
