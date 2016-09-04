package com.zaidock.chat.objects.other;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import com.zaidock.chat.GameObject;
import com.zaidock.chat.ID;

public class Speech extends GameObject {

	private BufferedImage speechBubble;

	public Speech(float x, float y, ID id) {
		super(x, y, id);
		try {
			speechBubble = ImageIO.read(getClass().getResourceAsStream("/misc/speachBubble.png"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void tick() {
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(speechBubble, (int) x, (int) y, null);
	}

	@Override
	public Rectangle getBounds() {
		return null;
	}

}
