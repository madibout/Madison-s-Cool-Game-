package com.mb.handler;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


import com.mb.units.Player;

public class Keyboardinput implements KeyListener{
	
	private Player Player;
	private boolean[] keys;
	
	
	public Keyboardinput(Player player) {
		this.Player = player; 
		
		keys = new boolean[4];
		for (int i= 0; i<keys.length; i++) {
			keys[i] = false;
		}
		
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		int key = arg0.getKeyCode();
		
		if (key == KeyEvent.VK_ESCAPE) {
			System.exit(0);
		}
		
		if (key == KeyEvent.VK_UP && !keys[0]) {
			Player.setVelY(-10);
			keys[0] = true;
		}
		
		if (key == KeyEvent.VK_DOWN && !keys[1]) {
			Player.setVelY(10);
			keys[1] = true;
			
		}	
		
		if (key == KeyEvent.VK_RIGHT && !keys[2]) {
			Player.setVelX(10);
			keys[2] = true;
			
		}	
		
		if (key == KeyEvent.VK_LEFT && !keys[3]) {
			Player.setVelX(-10);
			keys[3] = true;
			
		}
		
		
		
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		int key = arg0.getKeyCode();

		if (key == KeyEvent.VK_UP && keys[0]) {
			Player.setVelY(0);
			keys[0] = false;
		}
		
		if (key == KeyEvent.VK_DOWN && keys[1]) {
			Player.setVelY(-0);
			keys[1] = false;
			
		}	
		
		if (key == KeyEvent.VK_RIGHT && keys[2]) {
			Player.setVelX(0);
			keys[2] = false;
			
		}	
		
		if (key == KeyEvent.VK_LEFT && keys[3]) {
			Player.setVelX(-0);
			keys[3] = false;
			
		}
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		//DO NOT USE 
	}

}
