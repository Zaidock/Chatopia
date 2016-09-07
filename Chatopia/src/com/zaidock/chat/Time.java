package com.zaidock.chat;

import java.awt.Font;
import java.awt.Graphics;

import com.zaidock.chat.Chatopia.State;

public class Time {

	private Chatopia game;

	public Time(Chatopia game) {
		this.game = game;
	}

	int seconds = 0;
	int minutes = 0;
	int hours = 0;

	String time;

	public void tick() {
		if (game.gameState == State.paused)
			return;
		seconds++;
		if (seconds == 60) {
			minutes++;
			seconds = 0;
			System.out.println(hours + ":" + minutes);
		}
		if (minutes == 60) {
			hours++;
			minutes = 0;
		}
		if (hours == 24) {
			hours = 0;
		}
	}

	public void render(Graphics g) {
		Font font = new Font("arial", 1, 15);
		g.setFont(font);
		g.drawString("hi", 15, Chatopia.HEIGHT - 15);
	}

}
