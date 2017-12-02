package com.mb.main;

import java.awt.Color;
import java.awt.Graphics;

public class HUD {
	
	private Game game; 
	public static int healthPoints;
	public static int damage;
	private Color color;
	
	
	public HUD(Game game) {
		this.game = game;
		
		//initializing health and damage
		
		healthPoints = 5;
		damage = 1;
	
	}
	
	public void update() {
		
	}
	
	public void render(Graphics graphics) {
		//set color
		if(healthPoints >= 3 || healthPoints <= 5 ) {
			color = Color.GREEN;
		}
		else if(healthPoints == 2) {
			color = Color.YELLOW;
		}
		else {
			color = Color.RED;	
		}
		
		//draw bar
		graphics.setColor(color);
		graphics.fillRect(2, 2, healthPoints * 30, 15);
		
	}
	

}
