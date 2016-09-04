package com.zaidock.chat.objects.other;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;

import com.zaidock.chat.Chatopia;
import com.zaidock.chat.GameObject;
import com.zaidock.chat.ID;
import com.zaidock.chat.Chatopia.State;

public class Speech extends GameObject{

	private String text;

	private int time;
	
	private Chatopia game;

	private int timer = 0;

	public Speech(float x, float y, ID id, String text, int time, Chatopia game) {
		super(x, y, id);
		this.text = text;
		this.time = time;
	}

	public void tick() {
		timer++;
	}

	public void render(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(15, Chatopia.HEIGHT - 15, 15, Chatopia.HEIGHT - 15);

		Font font = new Font("arial", 1, 15);
		g.setFont(font);
		g.setColor(Color.black);
		g.drawString(text, 15, Chatopia.HEIGHT - 30);
		g.clearRect(15, Chatopia.HEIGHT - 15, 15, Chatopia.HEIGHT - 15);
		if (timer == time * 60 && !(game.gameState == State.paused)) {
			g.drawString(text, 15, Chatopia.HEIGHT - 30);
		}
	}

	public Rectangle getBounds() {
		return null;
	}

}
