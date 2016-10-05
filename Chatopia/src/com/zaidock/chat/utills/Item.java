package com.zaidock.chat.utills;

import java.awt.Graphics;

import com.zaidock.chat.Game.Slot;
import com.zaidock.chat.ID;

public abstract class Item {

	protected ID id;
	protected Slot slot;
	
	public Item(ID id, Slot slot) {
		this.id = id;
		this.slot = slot;
	}
	
	public abstract void tick();
	public abstract void render(Graphics g);
	
	public ID getID(){
		return id;
	}
	
}
