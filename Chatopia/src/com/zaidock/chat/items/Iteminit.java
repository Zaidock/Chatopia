package com.zaidock.chat.items;

import java.io.File;

import com.zaidock.chat.Game;
import com.zaidock.chat.Game.Slot;
import com.zaidock.chat.ID;
import com.zaidock.chat.JSONTools;

public class Iteminit {

	@SuppressWarnings("unused")
	private Item item;
	private String itemname;
	private Game game;
	private Slot slot;
	
	private String id;
	
	public void init(){
		String[] files = new File("src/com/zaidock/chat/items/").list();
		
		for (int i = 0; i <= files.length; i++){
			itemname = files[i].substring(0, files[i].lastIndexOf("."));
			
			if (files[i].substring(files[i].lastIndexOf(".") + 1) == "json"){
				id = JSONTools.get(itemname, "idtype");
				
				item = new Item(ID.valueOf(id), game, slot, itemname);
			}
		}
	}
}
