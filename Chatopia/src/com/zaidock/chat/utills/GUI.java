package com.zaidock.chat.utills;

import java.awt.Graphics;

import com.zaidock.chat.ID;

public abstract class GUI {
	
	protected ID id;

	public GUI(ID id) {
		this.id = id;
	}
	
	public abstract void tick();
	public abstract void render(Graphics g);
	
	
	public ID getID(){
		return id;
	}
}
