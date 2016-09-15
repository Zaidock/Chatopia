package com.zaidock.chat.keys;

import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import com.zaidock.chat.Chatopia;
import com.zaidock.chat.Chatopia.State;
import com.zaidock.chat.GameObject;
import com.zaidock.chat.ID;
import com.zaidock.chat.utills.Handler;

public class KeyInput extends KeyAdapter {

	private Handler handler;
	private Chatopia game;
	Graphics g;

	public KeyInput(Handler handler, Chatopia game) {
		this.handler = handler;
		this.game = game;
	}

	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		for (int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			if (tempObject.getID() == ID.Player) {
				if (game.gameState == State.Game) {
					if (key == KeyEvent.VK_W) {
						tempObject.setVelY(-2);
					}
					if (key == KeyEvent.VK_S) {
						tempObject.setVelY(2);
					}
					if (key == KeyEvent.VK_A) {
						tempObject.setVelX(-2);
					}
					if (key == KeyEvent.VK_D) {
						tempObject.setVelX(2);
					}

					if (key == KeyEvent.VK_P) {
						System.out.println(tempObject.getX() + "," + tempObject.getY());
					}
					if (key == KeyEvent.VK_F3) {
						if(game.showfps == false)
						game.showfps = true;
						else if(game.showfps == true){
							game.showfps = false;
						}
						
					}
				}
			}
		}

		if (key == KeyEvent.VK_ESCAPE){
			if(game.gameState == State.Game)
			game.gameState = State.paused;
			else if(game.gameState == State.paused){
				game.gameState = State.Game;
			}
		}
	}

	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		for (int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			if (tempObject.getID() == ID.Player) {
				if (key == KeyEvent.VK_W)
					tempObject.setVelY(0);
				if (key == KeyEvent.VK_S)
					tempObject.setVelY(0);
				if (key == KeyEvent.VK_A)
					tempObject.setVelX(0);
				if (key == KeyEvent.VK_D)
					tempObject.setVelX(0);
			}
		}
	}
}