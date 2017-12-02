package com.mb.units;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import com.mb.main.Game;
import com.mb.main.Mainwindow;

public class BasicEnemy extends Gameobjects {
	
	private Game game;
	

	public BasicEnemy(int xBound, int yBound, float x, float y, float velX, float velY, int width, int height, Game game) {
		super(xBound, yBound, x, y, velX, velY, width, height);
		
		this.game = game;
		
	}

	@Override
	public void update() {
		
		x += velX;
		y += velY;
		
		//fix out of bounds
		if (x > Mainwindow.WIDTH - 16) {
			velX *= -1;
			
		}
		
		if (x < 0) {
			velX *= -1;
		}
		
		if (y > Mainwindow.HEIGHT - 27) {
			velY *= -1;
	
		}
		
		if (y < 0 ) {
			velY *= -1;
		}
	}

	@Override
	public void Render(Graphics graphics) {
		
		Graphics2D graphics2d = (Graphics2D) graphics;
		
		
		graphics.setColor(Color.WHITE); 
		graphics.fillRect((int)x, (int)y, width, height);
		graphics2d.draw(getBounds());
		
	}
	
	public Rectangle getBounds() {
		return new Rectangle((int)x, (int)y, 16, 16);
		
	}


}
