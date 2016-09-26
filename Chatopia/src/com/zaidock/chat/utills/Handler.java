package com.zaidock.chat.utills;

import java.awt.Graphics;
import java.util.LinkedList;

import com.zaidock.chat.BackGround;
import com.zaidock.chat.GameObject;

public class Handler {
	
	public LinkedList<GUI> gui = new LinkedList<GUI>();
	public LinkedList<GameItem> item = new LinkedList<GameItem>();
	public LinkedList<GameObject> object = new LinkedList<GameObject>();
	
	public void tick() {
		for (int i = 0; i < object.size(); i++) {
			GameObject tempObject = object.get(i);

			tempObject.tick();
		}
		for (int i = 0; i < item.size(); i++) {
			GameItem tempItem = item.get(i);
			tempItem.tick();
		}
		for (int i = 0; i < gui.size(); i++) {
			GUI tempGUI = gui.get(i);
			tempGUI.tick();
		}
	}

	public void render(Graphics g) {
		for (int i = 0; i < object.size(); i++) {
			GameObject tempObject = object.get(i);

			tempObject.render(g);
		}
		for (int i = 0; i < gui.size(); i++) {
			GUI tempGUI = gui.get(i);
			tempGUI.render(g);
		}
		for (int i = 0; i < item.size(); i++) {
			GameItem tempItem = item.get(i);
			tempItem.render(g);
		}
	}

	public void addObject(GameObject object) {
		this.object.add(object);
	}

	public void removeObject(GameObject object) {
		this.object.remove(object);
	}
	
	public void addItem(GameItem item) {
		this.item.add(item);
		System.out.println("added Item");
	}

	public void removeItem(GameItem item) {
		this.item.remove(item);
	}
	
	public void addGUI(GUI gui) {
		this.gui.add(gui);
	}

	public void removeGUI(GUI gui) {
		this.gui.remove(gui);
	}
}
