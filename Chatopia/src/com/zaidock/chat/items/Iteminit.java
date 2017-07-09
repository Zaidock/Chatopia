package com.zaidock.chat.items;

import java.io.File;

import com.zaidock.chat.Game;
import com.zaidock.chat.Game.Slot;
import com.zaidock.chat.ID;

public class Iteminit {

	private Item item;
	private String itemname;
	private Game game;
	private Slot slot;
	
	public void init(){
		String[] files = new File("src/com/zaidock/chat/items/").list();
		
		for (int i = 0; i <= files.length; i++){
			itemname = files[i].substring(0, files[i].lastIndexOf("."));
			
			if (files[i].substring(files[i].lastIndexOf(".") + 1) == "json"){
				item = new Item(ID.valueOf(itemname), game, slot, itemname);
			}
		}
	}
}
