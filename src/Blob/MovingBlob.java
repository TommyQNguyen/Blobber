package Blob;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import Cursor.CursorBonus;
import Game.Game;

public class MovingBlob extends ABlob {
	private int x, y, diameter;
	private final int deplacementBlob = 4;
	
	public MovingBlob(int ticksCounter, int damage, int hp, int score, int x, int y, int diameter, Game game) {
		super(ticksCounter, damage, hp, score, game);
		this.color = Color.CYAN;
		this.x = x;
		this.y = y;
		this.diameter = diameter;
		
		Ecouteur ec = new Ecouteur();
		Timer timer = new Timer(100, ec); 	// 0.1 secondes 
		timer.start(); 						// Timer starts counting at 0 second and adding 1 each second
	}

	@Override
	protected void drawBlob(Graphics g) {
		setBounds(x, y, diameter, diameter);
		g.setColor(color);
		g.fillOval(0, 0, diameter, diameter);
	}
	
	@Override
	public void pop() {
		super.pop();
	}
	
	private class Ecouteur implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			x = x + deplacementBlob;	// Pour que le nouveau blob s'enfuit a gauche

			repaint();
		}	
	}
}
