/**
 * The KeyHandler class plays a crucial role in managing keyboard input, detecting key presses, and handling key events
 * within the game. It is designed to interact with the KeyListener interface, effectively facilitating key event handling.
 */

package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener{

	public boolean upPressed, downPressed, leftPressed, rightPressed;
	
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
		
		if ( code == KeyEvent.VK_W) {
			upPressed = true;
		}
		if ( code == KeyEvent.VK_A) {
			leftPressed = true;
		}
		if ( code == KeyEvent.VK_S) {
			downPressed = true;
		}
		if ( code == KeyEvent.VK_D) {
			rightPressed = true;
		}
		
		
	} //  end keyPressed()

	
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
