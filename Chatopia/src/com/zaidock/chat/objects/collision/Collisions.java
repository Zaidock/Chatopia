package com.zaidock.chat.objects.collision;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.zaidock.chat.GameObject;
import com.zaidock.chat.ID;
import com.zaidock.chat.utills.Handler;

public class Collisions extends GameObject {
	
	private Handler handler;
	
	private int width, height;

	public Collisions(float x, float y, int width, int height, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
		this.width = width;
		this.height = height;
	}

	@Override
	public void tick() {
	}

	@Override
	public void render(Graphics g) {
		/*Graphics2D g2d = (Graphics2D) g;
		g.setColor(Color.red);
		g2d.draw(getBounds());*/
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle((int)x,(int) y, width, height);
	}

	public void removeCollisions(){
		handler.object.remove(this);
	}
	
}
