package com.zaidock.chat.gui;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import com.zaidock.chat.ID;
import com.zaidock.chat.utills.GUI;
import com.zaidock.chat.utills.Itemref;
import com.zaidock.chat.utills.Handler;

public class Inventory extends GUI {

	public Itemref slot0;
	public Itemref slot1;
	public Itemref slot2;
	public Itemref slot3;
	public Itemref slot4;
	public Itemref slot5;
	public Itemref slot6;
	public Itemref slot7;
	public Itemref slot8;

	BufferedImage slot;

	private Handler handler;

	public Inventory(ID id, Handler handler) {
		super(id);
		try {
			slot = ImageIO.read(getClass().getResourceAsStream("/items/Inventoryslot.jpg"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void tick() {
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(slot, 0, 15, null);
		g.drawImage(slot, 0, 15 + 48, null);
		g.drawImage(slot, 0, 15 + 48 * 2, null);
		g.drawImage(slot, 0, 15 + 48 * 3, null);
		g.drawImage(slot, 0, 15 + 48 * 4, null);
		g.drawImage(slot, 0, 15 + 48 * 5, null);
		g.drawImage(slot, 0, 15 + 48 * 6, null);
		g.drawImage(slot, 0, 15 + 48 * 7, null);
		g.drawImage(slot, 0, 15 + 48 * 8, null);
	}

	public boolean isFull() {
		if (handler.item.size() > 8) {
			return true;
		}
		return false;
	}
}
