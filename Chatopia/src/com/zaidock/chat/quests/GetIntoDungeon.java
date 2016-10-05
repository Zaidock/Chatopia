package com.zaidock.chat.quests;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import com.zaidock.chat.Game;
import com.zaidock.chat.Game.Maps;
import com.zaidock.chat.utills.Handler;
import com.zaidock.chat.utills.Quests;

public class GetIntoDungeon extends Quests {

	Handler handler;
	Game game;
	BufferedImage notificationBox;
	
	public GetIntoDungeon(Game game, Handler handler) {
		name = "get into the dungeon";
		this.handler = handler;
		this.game = game;
		try {
			notificationBox = ImageIO.read(getClass().getResourceAsStream("/misc/notficationbox.png"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void tick() {
	}

	public boolean isComplete() {
		if(game.currentMap == Maps.dengeon){
			handler.removeQuest(this);
			game.getConfig().set("quest", "none");
			return true;
		}
		return false;
	}

	public void render(Graphics g) {
		if(game.inventoryOpened){
			g.drawImage(notificationBox, 390, 15, null);
			g.drawString("Find a bribe for the guard", 415, 70);
		}
	}

}
