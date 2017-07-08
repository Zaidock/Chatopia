package com.zaidock.chat.Menu;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.zaidock.chat.Game;
import com.zaidock.chat.Game.State;

public class Menu extends MouseAdapter{
	
	private Game game;
	
	
	public Menu(Game game) {
		this.game = game;
	}
	
	public void mousePressed(MouseEvent e) {
		int mx = e.getX();
		int my = e.getY();
		
		if(mouseOver(mx, my, 210, 150, 200, 64)){
			game.gameState = State.Game;
		}
	}
	
	public void mouseReleased(MouseEvent e) {
		
	}
	
	public boolean mouseOver(int mx, int my, int x, int y, int width, int height){
		if(mx > x && mx < x + width){
			if(my > y && my < y + height){
				return true;
			}
			return false;
		}
		return false;	
	}
	
	public void render(Graphics g){
		Font fnt = new Font("arial", 1, 50);
		Font bntFnt = new Font("arial", 1, 20);
		Font versionFnt = new Font("arial", 1, 15);
		
		g.setFont(fnt);
		
		g.setColor(Color.black);
		
		g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);
		
		g.setColor(Color.WHITE);
		g.drawString("Chatopia", 200, 50);
		
		g.setFont(bntFnt);
		g.drawString("Play", 285, 190);
		g.drawString("Options", 272, 190 + 100);
		g.drawString("Exit", 290, 390);
		g.setFont(versionFnt);
		g.drawString("Version: " + game.version, 15, Game.HEIGHT - 30);

		g.drawRect(210, 150, 200, 64);
		
		g.setColor(Color.WHITE);
		g.drawRect(210, 250, 200, 64);
		
		g.setColor(Color.WHITE);
		g.drawRect(210, 350, 200, 64);
	}
	
	public void tick(){
		
	}

}
