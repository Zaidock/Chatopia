package com.zaidock.chat;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public abstract class GameObject {

	protected float x, y;
	protected ID id;
	protected float velX, velY;

	public boolean showingHitBoxes = false;

	public GameObject(float x, float y, ID id) {
		this.x = x;
		this.y = y;
		this.id = id;
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

	public void setVelX(int velX) {
		this.velX = velX;
	}

	public void setVelY(int velY) {
		this.velY = velY;
	}

	public int getVelX() {
		return (int) velX;
	}

	public int getVelY() {
		return (int) velY;
	}

	public void jump(int height) {
		for (int i = 0; i > height; i++) {
			height++;
			setY(getY() + height);
		}

		for (int i = 0; i < height; i++) {
			height--;
			setY(getY() - height);
		}
	}

	public void showHitBox(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.draw(getBounds());
		showingHitBoxes = true;
	}
}
