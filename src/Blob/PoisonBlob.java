package Blob;

import java.awt.Color;
import java.awt.Graphics;

import Cursor.CursorMalus;
import Game.Game;
import Game.GameLoop;

public class PoisonBlob extends ABlob {
	
	private int x, y, w, h;
	
	public PoisonBlob(int ticksCounter, int damage, int currentHP, int score, int x, int y, int w, int h, Game game) {
		super(ticksCounter, damage, currentHP, score, game);
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.color = Color.RED;
	}
	
	@Override
	public void pop() {
		game.removeBlobFromGame(this);						// Retire PoisonBlob du jeu
		GameLoop.getInstance().unregisterObserver(this);	
		game.decorateCursor(new CursorMalus());				// Retire 1 point de dommage/d'attaque au curseur
		game.getPlayer().removeHp(damage);					// Endommage le joueur 
	}

	@Override
	protected void drawBlob(Graphics g) {
		setBounds(x, y, w, h);
		g.setColor(color);
		g.fillOval(0, 0, w, h);	
	}

}
