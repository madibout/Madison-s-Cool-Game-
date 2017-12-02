package com.mb.units;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import com.mb.main.Game;
import com.mb.main.Mainwindow;

public class RandomEnemy extends Gameobjects {
	
	private Game game;
	private Random random;
	private long timeNow;
	

	public RandomEnemy(int xBound, int yBound, float x, float y, float velX, float velY, int width, int height, Game game) {
		super(xBound, yBound, x, y, velX, velY, width, height);
		
		this.game = game;
		random = new Random();
		timeNow = System.currentTimeMillis();
		
		
	}

	@Override
	public void update() {
	
		// Lets create a timer
		
		
		//fix out of bounds
		if (x > Mainwindow.WIDTH - 16) {
			
			velX = -1 * (random.nextInt(5) + 5);	
		}
		
		if (x < 0) {
			velX *= -1; 
			velX *= (random.nextInt(5) + 5);
		}
		
		if (y > Mainwindow.HEIGHT - 27) {
			velY = -1 * (random.nextInt(5) + 5);
	
		}
		
		if (y < 0 ) {
			velY *= -1;
			velY *= (random.nextInt(5) + 5);
		}
		
		x += velX;
		y += velY;
		
		//long timeElapsed = System.currentTimeMillis();
		//if (timeNow - timeElapsed > 1000) {
			System.out.println(y);
		//	timeNow = timeElapsed;
		//}
		
	}

	@Override
	public void Render(Graphics graphics) {
		graphics.setColor(Color.ORANGE); 
		graphics.fillRect((int)x, (int)y, width, height);
		
	}


}
