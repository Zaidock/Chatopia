package com.zaidock.chat.keys;

import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import com.zaidock.chat.GameObject;
import com.zaidock.chat.ID;
import com.zaidock.chat.utills.Handler;

public class KeyInput extends KeyAdapter {

	private Handler handler;
	
	Graphics g;

	public KeyInput(Handler handler) {
		this.handler = handler;
	}

	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		for (int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			if (tempObject.getID() == ID.Player) {
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
				
				if(key == KeyEvent.VK_P){
					System.out.println(tempObject.getX() + "," + tempObject.getY());
				}
				/*if(key == KeyEvent.VK_B)
					tempObject.showHitBox(g);*/
			}
		}
		
			
		if (key == KeyEvent.VK_ESCAPE)
			System.exit(1);

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