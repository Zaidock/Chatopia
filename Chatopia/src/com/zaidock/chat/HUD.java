package com.zaidock.chat;

import java.awt.Color;
import java.awt.Graphics;

public class HUD {	
	public int health = 100;
	
	public void tick(){
		
		if(health <= 0){
			System.exit(1);
		}
	}
	
	public void render(Graphics g){
		g.setColor(Color.gray);
		g.fillRect(Chatopia.WIDTH / 2 - 100, 15, 200, 32);
		g.setColor(Color.green);
		g.fillRect(Chatopia.WIDTH / 2 - 100, 15, health * 2, 32);
		g.setColor(Color.white);
		g.drawRect(Chatopia.WIDTH / 2 - 100, 15, 200, 32);
	}
	
	public int getHealth(){
		return health;
	}
	
	public void setHealth(int health){
		this.health = health;
	}
}
