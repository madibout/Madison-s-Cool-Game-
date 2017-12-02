package com.mb.main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import javax.naming.InitialContext;
import javax.swing.plaf.basic.BasicArrowButton;
import javax.xml.stream.events.StartDocument;

import com.mb.handler.Keyboardinput;
import com.mb.units.BasicEnemy;
import com.mb.units.Player;
import com.mb.units.RandomEnemy;

public class Game extends Canvas implements Runnable {

	private Thread thread;
	private Boolean running = false;
	private Player player;
	private BasicEnemy basicEnemy;
	private RandomEnemy randomEnemy;
	private HUD hud;
	
	
	
	

	public Game() {
		super();

		// Start Canvas
		setFocusable(true); // you can use a keyboard
		requestFocus(); // use it
		setPreferredSize(new Dimension(Mainwindow.WIDTH, Mainwindow.HEIGHT)); // keep same size as main window

		// Start Main Window Panel
		new Mainwindow("Madison's Cool Game!", this);

		// Load All Game Elements
		init();
		
		addKeyListener(new Keyboardinput(player));
		requestFocus();
	}

	// Load Game Elements
	public void init() {
		
		basicEnemy = new BasicEnemy(0, 0, 50, 50, 15, 15, 16, 16, this);
		player = new Player(150, 150, 150, 150, 0, 0, 32, 32, this, basicEnemy);
		randomEnemy = new RandomEnemy(0, 0, 250, 250, 5, 5, 16, 16, this);
		hud= new HUD(this);
		
		
		

		

	}

	// Thread Stuff
	public synchronized void start() {
		thread = new Thread(this);
		thread.start();
		running = true;

	}

	public synchronized void stop() {
		try {
			thread.join();
			running = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		// Variables to keep track of time
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;

		// Main Loop
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;

			// Updates
			while (delta >= 1) {
				update();
				delta--;
			}

			// Optimize Game Loop
			try {
				Thread.sleep(5);
			} catch (Exception e) {
				e.printStackTrace();
			}
			// Draw all objects to the screen
			render();

			// Update FPS + Print FPS
			frames++;
			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				//System.out.println("FPS: " + frames);
				frames = 0;
			}

		}

		// Engine Stop
		stop();

	}

	// Game Logic + Drawing
	public void update() { // thinking
		player.update();
		basicEnemy.update();
		randomEnemy.update();
		hud.update();
	}

	public void render() { // acting
		// Start Graphics
		BufferStrategy bStrategy = this.getBufferStrategy();
		if (bStrategy == null) {
			this.createBufferStrategy(3); // draw 3 frames for the screen
			return;
		}
		Graphics graphics = bStrategy.getDrawGraphics();

		// Set Background
		graphics.setColor(Color.PINK);
		graphics.fillRect(0, 0, Mainwindow.WIDTH, Mainwindow.HEIGHT);
		
		//Draw Player 
		player.Render(graphics);
		basicEnemy.Render(graphics);
		randomEnemy.Render(graphics);
		hud.render(graphics);
	
		
		//Show Graphics
		graphics.dispose();
		bStrategy.show();
		

	}

}
