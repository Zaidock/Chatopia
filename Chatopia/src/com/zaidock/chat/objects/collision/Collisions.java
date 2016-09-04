package com.zaidock.chat.objects.collision;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import com.zaidock.chat.GameObject;
import com.zaidock.chat.ID;

public class Collisions extends GameObject {

	public Collisions(float x, float y, ID id) {
		super(x, y, id);
	}

	@Override
	public void tick() {
	}

	@Override
	public void render(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g.setColor(Color.red);
		g2d.draw(getBounds());
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle((int)x,(int) y, 32, 32);
	}

}
