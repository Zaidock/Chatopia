package com.zaidock.chat;

import com.zaidock.chat.Game.State;

public class Time {

	private Game game;

	public Time(Game game) {
		this.game = game;
	}

	int seconds = 0;
	int minutes = 30;
	int hours = 10;

	String time;

	public void tick() {
		if (game.gameState == State.paused)
			return;
		seconds++;
		if (seconds == 60) {
			minutes++;
			seconds = 0;
		}
		if (minutes == 60) {
			hours++;
			minutes = 0;
		}
		if (hours == 24) {
			hours = 0;
		}
	}
}
