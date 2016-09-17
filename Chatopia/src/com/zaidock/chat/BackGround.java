package com.zaidock.chat;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import com.zaidock.chat.Chatopia.Maps;

public class BackGround {
	private Chatopia game;

	private BufferedImage background;

	public BackGround(Chatopia game) {
		this.game = game;
	}

	public void tick() {
		try {
			if (game.currentMap == Maps.room) {
				background = ImageIO.read(getClass().getResourceAsStream("/maps/room.png"));
			}
			if(game.currentMap == Maps.house){
				background = ImageIO.read(getClass().getResourceAsStream("/maps/house.png"));
			}
			if(game.currentMap == Maps.castleWall){
				background = ImageIO.read(getClass().getResourceAsStream("/maps/castleWall.bmp"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void render(Graphics g) {
		g.drawImage(background, 0, 0, null);
	}
}
