/**
 * The KeyHandler class plays a crucial role in managing keyboard input, detecting key presses, and handling key events
 * within the game. It is designed to interact with the KeyListener interface, effectively facilitating key event handling.
 */

package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener{

	GamePanel gp;
	public boolean upPressed, downPressed, leftPressed, rightPressed, shotKeyPressed, enterPressed;
	
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
		
		// OPTIONS STATE
		else if (gp.gameState == gp.optionsState) {
			optionsState(code);
		}
		// GAME OVER STATE
		else if (gp.gameState == gp.gameOverState) {
			gameOverState(code);
		}
		else if(gp.gameState == gp.endGameState) {
			endGameState(code);
		}
	} //  end keyPressed()
	
	
	
	public void titleState(int code) {

		//TITLE STATE
		if(gp.gameState == gp.titleState) {
			
			if(gp.ui.titleScreenState == 0) {
				if ( code == KeyEvent.VK_W) {
					gp.ui.commandNum--;
					gp.playSE(11);
					if(gp.ui.commandNum < 0) {
						gp.ui.commandNum = 2;
					}
				}
				if ( code == KeyEvent.VK_S) {
					gp.ui.commandNum++;
					gp.playSE(11);
					if(gp.ui.commandNum > 2) {
						gp.ui.commandNum = 0;
					}
				}
				if(code == KeyEvent.VK_ENTER) {
					gp.stopMusic();
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
					gp.playSE(11);
					gp.ui.commandNum--;
					if(gp.ui.commandNum < 0) {
						gp.ui.commandNum = 3;
					}
				}
				if ( code == KeyEvent.VK_S) {
					gp.playSE(11);
					gp.ui.commandNum++;
					if(gp.ui.commandNum > 3) {
						gp.ui.commandNum = 0;
					}
				}
				if(code == KeyEvent.VK_ENTER) {
					if(gp.ui.commandNum == 0) {
						gp.player.changeSkin(0);
						System.out.println("Gray suit!");
						gp.gameState = gp.playState;
						gp.playMusic(1);
						
					}
					if(gp.ui.commandNum == 1) {
						gp.player.changeSkin(1);
						System.out.println("Blue suit!");
						gp.gameState = gp.playState;
						gp.playMusic(1);
					}
					if(gp.ui.commandNum == 2) { 
						gp.player.changeSkin(3);
						System.out.println("Black suit!");
						gp.gameState = gp.playState;
						gp.playMusic(1);
					}	
					if(gp.ui.commandNum == 3) { 
						gp.ui.titleScreenState = 0;
						gp.playMusic(0);
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
		if (code == KeyEvent.VK_ENTER) { shotKeyPressed = true; }
		if (code == KeyEvent.VK_ESCAPE) { gp.gameState = gp.optionsState; }
	} // end playState
	
	public void pauseState(int code) {
		if (code == KeyEvent.VK_P) { gp.gameState = gp.playState; }
	} // end pauseState
	

	
	public void optionsState(int code) {
		
		if(code == KeyEvent.VK_ESCAPE) {
			gp.gameState = gp.playState;
		}
		if(code == KeyEvent.VK_ENTER) {
			enterPressed = true;
		}
		
		int maxCommandNum = 0;
		switch(gp.ui.subState) {
		case 0:	maxCommandNum = 4; break;
		case 2:	maxCommandNum = 1; 	break;
		}
		
		
		if(code == KeyEvent.VK_W) {
			gp.ui.commandNum--;
			gp.playSE(11);
			if(gp.ui.commandNum < 0) {
				gp.ui.commandNum = maxCommandNum;
			}
		}
		if(code == KeyEvent.VK_S) {
			gp.ui.commandNum++;
			gp.playSE(11);
			if(gp.ui.commandNum > maxCommandNum) {
				gp.ui.commandNum = 0;
			}
		}
		if (code == KeyEvent.VK_A) {
			if(gp.ui.subState == 0) {
				if(gp.ui.commandNum == 0 && gp.music.volumeScale > 0) {
					gp.music.volumeScale--;
					gp.music.checkVolume();
					gp.playSE(11);
				}
				if(gp.ui.commandNum == 1 && gp.se.volumeScale > 0) {
					gp.se.volumeScale--;
					gp.playSE(11);
				}
			}
		}
		if (code == KeyEvent.VK_D) {
			if(gp.ui.subState == 0) {
				if(gp.ui.commandNum == 0 && gp.music.volumeScale < 5) {
					gp.music.volumeScale++;
					gp.music.checkVolume();
					gp.playSE(11);
				}
				if(gp.ui.commandNum == 1 && gp.se.volumeScale < 5) {
					gp.se.volumeScale++;
					gp.playSE(11);
				}
			}
		}
		
		
		
	} //  end optionsState
	
	public void gameOverState(int code) {
		if (code == KeyEvent.VK_W) {
			gp.ui.commandNum--;
			if(gp.ui.commandNum < 0) {
				gp.ui.commandNum = 1;
			}
			gp.playSE(11);
		}
		if (code == KeyEvent.VK_S) {
			gp.ui.commandNum++;
			if(gp.ui.commandNum > 1) {
				gp.ui.commandNum = 0;
			}
			gp.playSE(11);
		}
		if (code == KeyEvent.VK_ENTER) {
			if(gp.ui.commandNum == 0) {
				gp.gameState = gp.playState;
				gp.retry();
				gp.playMusic(1);
			}
			else if ( gp.ui.commandNum ==1 ) {
				gp.gameState = gp.titleState;
				gp.ui.titleScreenState = 0;
				gp.restart();
			}
		}
		
	} // end gameOverState
	
	public void endGameState(int code){
		
		if (code == KeyEvent.VK_W) {
			gp.ui.commandNum--;
			if(gp.ui.commandNum < 0) {
				gp.ui.commandNum = 1;
			}
			gp.playSE(11);
		}
		if (code == KeyEvent.VK_S) {
			gp.ui.commandNum++;
			if(gp.ui.commandNum > 1) {
				gp.ui.commandNum = 0;
			}
			gp.playSE(11);
		}
		if (code == KeyEvent.VK_ENTER) {
			if(gp.ui.commandNum == 0 ) {
				gp.gameState = gp.titleState;
				gp.ui.titleScreenState = 0;
				gp.restart();
				gp.playMusic(0);
			}
			else if ( gp.ui.commandNum  == 1 ) {
				System.exit(0);
			}
		}
		
	}
	
	
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
		if (code == KeyEvent.VK_ENTER) { 
			shotKeyPressed = false; 
		}
		
		
		
	} //  end keyReleased()

} // end class
