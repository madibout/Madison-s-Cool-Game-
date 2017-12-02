package com.mb.units;

import java.awt.Graphics;
import java.awt.image.renderable.RenderableImage;

public abstract class Gameobjects {
	
	protected int xBound, yBound;
	protected float x, y; 
	protected float velX, velY; //how fast moving
	protected int width, height; 
	
	public Gameobjects(int xBound, int yBound, float x, float y, float velX, float velY, int width, int height) {
		this.xBound = xBound;
		this.yBound = yBound;
		this.x = x;
		this.y = y;
		this.velX = velX;
		this.velY = velY;
		this.width = width;
		this.height = height;
		
	}
	
	public abstract void update();
	public abstract void Render(Graphics graphics);
	public void setVelX (float velX) {
		this.velX = velX;
	}
	public void setVelY (float velY) {
		this.velY = velY;
	}
	
	

}
