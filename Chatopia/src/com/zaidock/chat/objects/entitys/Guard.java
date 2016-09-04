package com.zaidock.chat.objects.entitys;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import com.zaidock.chat.GameObject;
import com.zaidock.chat.ID;

public class Guard extends GameObject {

	private BufferedImage Guard;
	
	public Guard(float x, float y, ID id) {
		super(x, y, id);
		try {
			Guard = ImageIO.read(getClass().getResourceAsStream("/characters/Guard.png"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void tick() {

	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Guard, (int) x, (int) y, 64, 64, null);
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle((int) x + 16, (int) y + 16, 32, 48);
	}

}
