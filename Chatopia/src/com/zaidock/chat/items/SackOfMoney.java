package com.zaidock.chat.items;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import com.zaidock.chat.Chatopia;
import com.zaidock.chat.Chatopia.Slot;
import com.zaidock.chat.ID;
import com.zaidock.chat.utills.Item;

public class SackOfMoney extends Item {

	BufferedImage sackofcoins;

	private Chatopia game;
	private Slot slot;

	public SackOfMoney(ID id, Chatopia game, Slot slot) {
		super(id, slot);
		try {
			sackofcoins = ImageIO.read(getClass().getResourceAsStream("/items/SackOfMoney.jpeg"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.game = game;
		this.slot = slot;
	}

	@Override
	public void tick() {
	}

	@Override
	public void render(Graphics g) {
		if (game.inventoryOpened) {
			if (slot == Slot.slot0)
				g.drawImage(sackofcoins, 15 / 2, game.slot0, null);
			if (slot == Slot.slot1)
				g.drawImage(sackofcoins, 15 / 2, game.slot1, null);
			if (slot == Slot.slot2)
				g.drawImage(sackofcoins, 15 / 2, game.slot2, null);
			if (slot == Slot.slot3)
				g.drawImage(sackofcoins, 15 / 2, game.slot3, null);
			if (slot == Slot.slot4)
				g.drawImage(sackofcoins, 15 / 2, game.slot4, null);
			if (slot == Slot.slot5)
				g.drawImage(sackofcoins, 15 / 2, game.slot5, null);
			if (slot == Slot.slot6)
				g.drawImage(sackofcoins, 15 / 2, game.slot6, null);
			if (slot == Slot.slot7)
				g.drawImage(sackofcoins, 15 / 2, game.slot7, null);
			if (slot == Slot.slot8)
				g.drawImage(sackofcoins, 15 / 2, game.slot8, null);
		}
	}

}
