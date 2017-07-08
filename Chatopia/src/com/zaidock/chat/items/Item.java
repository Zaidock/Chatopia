package com.zaidock.chat.items;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import org.json.JSONObject;

import com.zaidock.chat.Game;
import com.zaidock.chat.Game.Slot;
import com.zaidock.chat.ID;
import com.zaidock.chat.utills.Itemref;

public class Item  extends Itemref{
	
	static JSONObject reader;

	public static String get(String filepath, String type){
		reader = new JSONObject(filepath);
		
		String out = reader.getString(type);
		return out;
	}
	
	public static String getFromObject(String filepath, String object, String type){
		reader = new JSONObject(filepath);
		
		String out = reader.getJSONObject(object).getString(type);
		return out;
	}
	
	String itemname;
	BufferedImage itemimage;
	
	private Game game;
	private Slot slot;

	public Item(ID id, Game game, Slot slot, String name) {
		super(id, slot);
		itemname = name;
		try {
			itemimage = ImageIO.read(getClass().getResourceAsStream(get(itemname, "iconImage")));
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
				g.drawImage(itemimage, 15 / 2, game.slot0, null);
			if (slot == Slot.slot1)
				g.drawImage(itemimage, 15 / 2, game.slot1, null);
			if (slot == Slot.slot2)
				g.drawImage(itemimage, 15 / 2, game.slot2, null);
			if (slot == Slot.slot3)
				g.drawImage(itemimage, 15 / 2, game.slot3, null);
			if (slot == Slot.slot4)
				g.drawImage(itemimage, 15 / 2, game.slot4, null);
			if (slot == Slot.slot5)
				g.drawImage(itemimage, 15 / 2, game.slot5, null);
			if (slot == Slot.slot6)
				g.drawImage(itemimage, 15 / 2, game.slot6, null);
			if (slot == Slot.slot7)
				g.drawImage(itemimage, 15 / 2, game.slot7, null);
			if (slot == Slot.slot8)
				g.drawImage(itemimage, 15 / 2, game.slot8, null);
		}
	}

}

