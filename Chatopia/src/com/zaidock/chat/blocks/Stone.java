package com.zaidock.chat.blocks;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import com.zaidock.chat.ID;
import com.zaidock.chat.utills.Block;

public class Stone extends Block {

	BufferedImage stone;

	public Stone(float x, float y, ID id) {
		super(x, y, id);
		try {
			stone = ImageIO.read(getClass().getResourceAsStream("/blocks/stone.png"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub

	}

	@Override
	public void render(Graphics g) {
		g.drawImage(stone, (int) x, (int) y, null);
	}

	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return null;
	}

}
