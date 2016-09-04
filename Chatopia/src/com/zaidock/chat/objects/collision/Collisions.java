package com.zaidock.chat.objects.collision;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.zaidock.chat.GameObject;
import com.zaidock.chat.ID;
import com.zaidock.chat.utills.Handler;

public class Collisions extends GameObject {
	
	private Handler handler;

	public Collisions(float x, float y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
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
		return new Rectangle((int)x,(int) y, 32, 32);
	}

	public void removeCollisions(){
		handler.object.remove(this);
	}
	
}
