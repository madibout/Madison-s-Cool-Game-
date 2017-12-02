package com.mb.main;

import java.awt.Canvas;

import javax.swing.JFrame;

public class Mainwindow extends Canvas {

	public final static int WIDTH = 500;
	public final static int HEIGHT = 500;
	
	public Mainwindow(String title, Game game) {
		
		//Start Main Window 
		JFrame window = new JFrame("Madison's Cool Game!");
		window.setVisible(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(WIDTH, HEIGHT);
		window.setResizable(false);
		window.setLocationRelativeTo(null);
		window.add(game);
		game.start();
		
		
	}
	
	public static void main(String[] args){
		new Game();
		

		
		}
}
