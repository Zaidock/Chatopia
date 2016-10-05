package com.zaidock.chat.utills;

import java.awt.Graphics;

public abstract class Quests {
	
	protected String name;
	
	public abstract void tick();
	public abstract void render(Graphics g);
	public abstract boolean isComplete();
}
