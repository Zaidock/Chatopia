package com.zaidock.chat.utills;

public class Timer {
	
	public int time;
	
	public int timer = 0;
	
	public Timer(int time) {
		this.time = time;
	}
	
	public void tick(){
		timer++;
	}
}
