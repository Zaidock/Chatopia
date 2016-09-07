package com.zaidock.chat;

public class Time {

	int seconds = 0;
	int minutes = 0;
	int hours = 0;

	public void tick() {
		seconds++;
		if (seconds == 60) {
			minutes++;
			seconds = 0;
			System.out.println(hours + ":" + minutes);
		}
		if(minutes == 60){
			hours++;
			minutes = 0;
		}
		if(hours == 24){
			hours = 0;
		}
	}

}
