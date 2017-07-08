package com.zaidock.chat;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import com.zaidock.chat.Menu.Menu;
import com.zaidock.chat.blocks.Stone;
import com.zaidock.chat.gui.Inventory;
import com.zaidock.chat.keys.KeyInput;
import com.zaidock.chat.objects.collision.Collisions;
import com.zaidock.chat.objects.entitys.Player;
import com.zaidock.chat.objects.other.Speech;
import com.zaidock.chat.utills.Config;
import com.zaidock.chat.utills.GUI;
import com.zaidock.chat.utills.GameObject;
import com.zaidock.chat.utills.Handler;
import com.zaidock.chat.utills.Settings;

public class Game extends Canvas implements Runnable {

	private static final long serialVersionUID = 6650874674830497312L;

	public static final int WIDTH = 640, HEIGHT = WIDTH / 12 * 9;

	private Thread thread;
	private boolean running = false;

	public String version = "0.0.0.1";

	private Handler handler = new Handler();
	private HUD hud;
	private Menu menu = new Menu(this);
	private Time time = new Time(this);

	public boolean showfps = false;
	public boolean addedCollisions = false;
	public boolean showCollisions = false;
	public boolean inventoryOpened = false;

	public boolean walkingUp = false;
	public boolean walkingDown = false;
	public boolean walkingLeft = false;
	public boolean walkingRight = false;

	public String checkpoint;

	public int slot0 = 22;
	public int slot1 = 22 + 48;
	public int slot2 = 22 + 48 * 2;
	public int slot3 = 22 + 48 * 3;
	public int slot4 = 22 + 48 * 4;
	public int slot5 = 22 + 48 * 5;
	public int slot6 = 22 + 48 * 6;
	public int slot7 = 22 + 48 * 7;
	public int slot8 = 22 + 48 * 8;

	BufferedImage room, castleWall, CastleWallAccsesorys, house, richsHouse;

	public enum State {
		Menu, Game, paused
	};

	public enum Maps {
		room, kichen, house, castleWall, dengeon, richsHouse
	};

	public enum Slot {
		slot0, slot1, slot2, slot3, slot4, slot5, slot6, slot7, slot8
	};

	public State gameState = State.Menu;
	public Maps currentMap = Maps.room;

	public Inventory getInventory() {
		return new Inventory(ID.Inventory, handler);
	}
	public Game() {

		this.addKeyListener(new KeyInput(handler, this));
		this.addMouseListener(menu);

		new Window((int) WIDTH, (int) HEIGHT, "Chatopia Alpha 0.0.0.1", this);

		hud = new HUD();

		try {
			castleWall = ImageIO.read(getClass().getResourceAsStream("/maps/CastleWall.bmp"));
			CastleWallAccsesorys = ImageIO.read(getClass().getResourceAsStream("/maps/CastleWallTrees.png"));
			room = ImageIO.read(getClass().getResourceAsStream("/maps/room.png"));
			house = ImageIO.read(getClass().getResourceAsStream("/maps/house.png"));
			richsHouse = ImageIO.read(getClass().getResourceAsStream("/maps/Rich's House.png"));
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("TODO: Add Collisions to room");
		checkpoint = getConfig().get("checkpoint");
		if (checkpoint.equals("1")) {
			currentMap = Maps.castleWall;
			handler.addObject(new Player(1, 233, ID.Player, handler, this));
		} else if (checkpoint.equals("0")) {
			handler.addObject(new Player(367, 108, ID.Player, handler, this));
		}
		removeCollisions();
		addCollisions();
	}

	public synchronized void start() {
		thread = new Thread(this);
		thread.start();
		running = true;
		System.out.println("Started");
	}

	public synchronized void stop() {
		try {
			thread.join();
			running = false;
			System.out.println("Stoping");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void run() {
		this.requestFocus();
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while (delta >= 1) {
				tick();
				delta--;
			}
			if (running)
				render();
			frames++;

			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				 System.out.println("FPS: " + frames);
				if (showfps && !(gameState == State.paused))
					handler.addObject(new Speech(15, 15, ID.speech, "FPS: " + frames, 1, handler, this));
				frames = 0;
			}
		}
		stop();
	}

	private void tick() {
		handler.tick();
		if (gameState == State.Game) {
			hud.tick();
			time.tick();
		} else if (gameState == State.Menu) {
			menu.tick();
		}
		if (addedCollisions == false)
			addCollisions();
	}

	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			this.createBufferStrategy(3);
			return;
		}

		Graphics g = bs.getDrawGraphics();
		if (gameState == State.Game) {
			if (currentMap == Maps.castleWall) {
				hud.render(g);

				g.drawImage(castleWall, 0, 0, null);
				handler.render(g);
				g.drawImage(CastleWallAccsesorys, 0, 0, null);
			} else {
				if (!(currentMap == Maps.castleWall)) {
				}
				if (currentMap == Maps.room) {
					hud.render(g);
					g.drawImage(room, 0, 0, null);
					handler.render(g);
				}
				if (currentMap == Maps.house) {
					hud.render(g);
					g.drawImage(house, 0, 0, null);
					handler.render(g);
				}
				if (currentMap == Maps.richsHouse) {
					hud.render(g);
					g.drawImage(richsHouse, 0, 0, null);
					handler.render(g);
				}
			}
		} else if (gameState == State.Menu) {
			menu.render(g);
		}
		g.dispose();
		bs.show();
	}

	public void addCollisions() {
		removeCollisions();
		removeCollisions();
		removeCollisions();

		if (addedCollisions == false) {
			if (currentMap == Maps.castleWall) {
				removeCollisions();
				handler.addObject(new Collisions(0, 384, 32, 32, ID.CollisionBox, handler, this));
				handler.addObject(new Collisions(0, 384 - 32, 32, 32, ID.CollisionBox, handler, this));
				handler.addObject(new Collisions(96, 384, 32, 32, ID.CollisionBox, handler, this));
				handler.addObject(new Collisions(96, 384 - 32, 32, 32, ID.CollisionBox, handler, this));
				handler.addObject(new Collisions(256, 384, 32, 32, ID.CollisionBox, handler, this));
				handler.addObject(new Collisions(256, 384 - 32, 32, 32, ID.CollisionBox, handler, this));
				handler.addObject(new Collisions(352, 384, 32, 32, ID.CollisionBox, handler, this));
				handler.addObject(new Collisions(352, 384 - 32, 32, 32, ID.CollisionBox, handler, this));
				handler.addObject(new Collisions(450, 384, 32, 32, ID.CollisionBox, handler, this));
				handler.addObject(new Collisions(450, 384 - 32, 32, 32, ID.CollisionBox, handler, this));
				handler.addObject(new Collisions(544, 384, 32, 32, ID.CollisionBox, handler, this));
				handler.addObject(new Collisions(544, 384 - 32, 32, 32, ID.CollisionBox, handler, this));
				handler.addObject(new Collisions(248, 75, 16, 48, ID.CollisionBox, handler, this));
				addedCollisions = true;
			}
			if (currentMap == Maps.house) {
				removeCollisions();
				addedCollisions = true;
			}
			if (currentMap == Maps.room) {
				removeCollisions();
				handler.addObject(new Collisions(-15, 54, 32, 32, ID.CollisionBox, handler, this));
				addedCollisions = true;
			}
			if (currentMap == Maps.richsHouse) {
				removeCollisions();
				handler.addObject(new Collisions(353, 321, 32, 32, ID.CollisionBox, handler, this));
				handler.addObject(new Collisions(513, 351, 32, 32, ID.CollisionBox, handler, this));
				handler.addObject(new Collisions(65, 381, 32, 32, ID.CollisionBox, handler, this));
				handler.addObject(new Collisions(541, 225, 32, 96, ID.CollisionBox, handler, this));
				handler.addObject(new Collisions(541, 225, 32, 96, ID.CollisionBox, handler, this));
				handler.addObject(new Collisions(575, 285, 64, 32, ID.CollisionBox, handler, this));
				handler.addObject(new Collisions(574, 225, 64, 32, ID.CollisionBox, handler, this));
				handler.addBlock(new Stone(80, 325, ID.Stone));
				addedCollisions = true;
			}
		}
	}

	public void removeCollisions() {
		for (int i = 0; i < handler.object.size(); i++) {
			GameObject object = handler.object.get(i);
			if (object.getID() == ID.CollisionBox) {
				System.out.println("REMOVE");
				handler.object.remove(object);
			}
		}
	}

	public void closeInventory() {
		for (int i = 0; i < handler.gui.size(); i++) {
			GUI gui = handler.gui.get(i);
			if (gui.getID() == ID.Inventory) {
				handler.removeGUI(gui);
				inventoryOpened = false;
			}
		}
	}



	public Config getConfig() {
		return new Config();
	}
	
	public Settings getSettings(){
		return new Settings();
	}
}