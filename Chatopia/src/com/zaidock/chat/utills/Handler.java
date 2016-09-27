package com.zaidock.chat.utills;

import java.awt.Graphics;
import java.util.LinkedList;

public class Handler {

	public LinkedList<GUI> gui = new LinkedList<GUI>();
	public LinkedList<Item> item = new LinkedList<Item>();
	public LinkedList<Block> block = new LinkedList<Block>();
	public LinkedList<GameObject> object = new LinkedList<GameObject>();

	public void tick() {
		for (int i = 0; i < object.size(); i++) {
			GameObject tempObject = object.get(i);

			tempObject.tick();
		}
		for (int i = 0; i < block.size(); i++) {
			Block tempBlock = block.get(i);
			tempBlock.tick();
		}
		for (int i = 0; i < item.size(); i++) {
			Item tempItem = item.get(i);
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
		for (int i = 0; i < block.size(); i++) {
			Block tempBlock = block.get(i);
			tempBlock.render(g);
		}
		for (int i = 0; i < item.size(); i++) {
			Item tempItem = item.get(i);
			tempItem.render(g);
		}
	}

	public void addObject(GameObject object) {
		this.object.add(object);
	}

	public void removeObject(GameObject object) {
		this.object.remove(object);
	}

	public void addItem(Item item) {
		this.item.add(item);
	}

	public void removeItem(Item item) {
		this.item.remove(item);
	}

	public void addGUI(GUI gui) {
		this.gui.add(gui);
	}

	public void removeGUI(GUI gui) {
		this.gui.remove(gui);
	}

	public void addBlock(Block block) {
		this.block.add(block);
	}

	public void removeBlock() {
		this.block.remove(block);
	}
}
