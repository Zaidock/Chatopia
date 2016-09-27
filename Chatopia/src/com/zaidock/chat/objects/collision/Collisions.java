package com.zaidock.chat.objects.collision;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import com.zaidock.chat.Chatopia;
import com.zaidock.chat.ID;
import com.zaidock.chat.utills.GameObject;
import com.zaidock.chat.utills.Handler;

public class Collisions extends GameObject {

	private Handler handler;

	private int width, height;

	private Chatopia game;

	public Collisions(float x, float y, int width, int height, ID id, Handler handler, Chatopia game) {
		super(x, y, id);
		this.handler = handler;
		this.width = width;
		this.height = height;
		this.game = game;
	}

	@Override
	public void tick() {
	}

	@Override
	public void render(Graphics g) {
		if (game.showCollisions == true) {
			Graphics2D g2d = (Graphics2D) g;
			g.setColor(Color.red);
			g2d.draw(getBounds());
		}
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle((int) x, (int) y, width, height);
	}

	public void removeCollisions() {
		handler.object.remove(this);
	}

}
