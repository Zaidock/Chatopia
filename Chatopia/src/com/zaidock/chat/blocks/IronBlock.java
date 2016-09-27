package com.zaidock.chat.blocks;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import com.zaidock.chat.ID;
import com.zaidock.chat.utills.Block;

public class IronBlock extends Block {

	BufferedImage iron_block;
	
	public IronBlock(float x, float y, ID id) {
		super(x, y, id);
		try {
			iron_block = ImageIO.read(getClass().getResourceAsStream("/blocks/iron_block.png"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void tick() {
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(iron_block, (int)x,(int) y, null);
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle((int) x + 16, (int) y + 16, 32, 32);
	}

}
