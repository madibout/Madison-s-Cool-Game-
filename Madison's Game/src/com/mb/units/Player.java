package com.mb.units;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import com.mb.main.Game;
import com.mb.main.HUD;
import com.mb.main.Mainwindow;

public class Player extends Gameobjects {
	
	private Game game;
	private BasicEnemy basicEnemy;

	public Player(int xBound, int yBound, float x, float y, float velX, float velY, int width, int height, Game game, BasicEnemy basicEnemy) {
		super(xBound, yBound, x, y, velX, velY, width, height);
		
		this.game = game;
		this.basicEnemy = basicEnemy;
		
	}

	@Override
	public void update() {
		
		x += velX;
		y += velY;
		
		//fix out of bounds
		if (x > Mainwindow.WIDTH - 32) {
			x = Mainwindow.WIDTH - 32;
			
		}
		
		if (x < 0) {
			x = 0;
		}
		
		if (y > Mainwindow.HEIGHT - 54) {
			y = Mainwindow.HEIGHT - 54;
	
		}
		
		if (y < 0 ) {
			y = 0;
		}
		
		//collision detection
		if (this.getBounds().intersects(basicEnemy.getBounds())) {
			HUD.healthPoints -= HUD.damage;
			
		}
	}

	@Override
	public void Render(Graphics graphics) {
		Graphics2D graphics2d = (Graphics2D) graphics;
		graphics.setColor(Color.YELLOW); 
		graphics.fillRect((int)x, (int)y, width, height);
		graphics2d.draw(getBounds());

		
	}
	public Rectangle getBounds() {
		return new Rectangle((int)x, (int)y, 32, 32);
		
	}


}
