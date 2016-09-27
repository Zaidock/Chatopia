package com.zaidock.chat.utills;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.zaidock.chat.ID;

public abstract class Block {
	
	protected float x, y;
	protected ID id;
	
	public Block(float x, float y, ID id) {
		this.id = id;
		this.x = x;
		this.y = y;
	}
	
	public abstract void tick();

	public abstract void render(Graphics g);

	public abstract Rectangle getBounds();

	public void setX(float x) {
		this.x = x;
	}

	public void setY(float y) {
		this.y = y;
	}

	public int getX() {
		return (int) x;
	}

	public int getY() {
		return (int) y;
	}

	public void setID(ID id) {
		this.id = id;
	}

	public ID getID() {
		return id;
	}
}
