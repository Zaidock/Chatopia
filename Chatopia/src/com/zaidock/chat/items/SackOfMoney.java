package com.zaidock.chat.items;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import com.zaidock.chat.ItemIDs;
import com.zaidock.chat.utills.GameItem;

public class SackOfMoney extends GameItem{

	BufferedImage sackofcoins;
	
	public SackOfMoney(ItemIDs id) {
		super(id);
		try {
			sackofcoins = ImageIO.read(getClass().getResourceAsStream("/characters/soldier_altcolor-00-02.png"));
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
		g.drawImage(sackofcoins, 15, 30, 64, 64, null);
	}

}
