package com.zaidock.chat.objects.blocks;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import com.zaidock.chat.Game;
import com.zaidock.chat.Game.Slot;
import com.zaidock.chat.ID;
import com.zaidock.chat.JSONTools;
import com.zaidock.chat.utills.Objectref;

public class Block extends Objectref {

	String itemname;
	BufferedImage itemimage;
	BufferedImage itemicon;
	boolean canBePickedUp;
	
	private Game game;
	private Slot slot;

	public Block(ID id, Game game, Slot slot, String name) {
		super(id, slot);
		itemname = name;
		
		canBePickedUp = JSONTools.get(itemname, "canBePickedUp") == "true";
		
		try {
			itemimage = ImageIO.read(getClass().getResourceAsStream(JSONTools.get(itemname, "objectImage")));
			if (canBePickedUp){
				itemicon = ImageIO.read(getClass().getResourceAsStream(JSONTools.get(itemname, "inventoryIcon")));
			}
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
	}
}
