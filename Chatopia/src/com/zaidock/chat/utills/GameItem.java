package com.zaidock.chat.utills;

import java.awt.Graphics;

import com.zaidock.chat.ItemIDs;

public abstract class GameItem {

	protected ItemIDs id;
	
	public GameItem(ItemIDs id) {
		this.id = id;
	}
	
	public abstract void tick();
	public abstract void render(Graphics g);
	
	public ItemIDs getID(){
		return id;
	}
	
}
