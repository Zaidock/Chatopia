package com.zaidock.chat;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import com.zaidock.chat.keys.KeyInput;
import com.zaidock.chat.objects.collision.Collisions;
import com.zaidock.chat.objects.entitys.Player;
import com.zaidock.chat.states.Menu;
import com.zaidock.chat.utills.Handler;

public class Chatopia extends Canvas implements Runnable {

	private static final long serialVersionUID = 6650874674830497312L;

	public static final int WIDTH = 640, HEIGHT = WIDTH / 12 * 9;

	private Thread thread;
	private boolean running = false;

	private Handler handler = new Handler();;
	private HUD hud;
	private Menu menu = new Menu(this);

	BufferedImage castleWall, CastleWallAccsesorys;

	public enum State {
		Menu, Game
	};

	public State gameState = State.Game;

	public Chatopia() {

		this.addKeyListener(new KeyInput(handler));
		this.addMouseListener(menu);

		new Window((int) WIDTH, (int) HEIGHT, "Chatopia Alpha", this);

		hud = new HUD();
		
		handler.addObject(new Player(100, HEIGHT / 2, ID.Player, handler));
		addCollisions();
	}

	public static void main(String[] args) {
		System.out.println("Opening");
		new Chatopia();
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
				frames = 0;
			}
		}
		stop();
	}

	private void tick() {
		handler.tick();
		hud.tick();
	}

	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			this.createBufferStrategy(3);
			return;
		}

		Graphics g = bs.getDrawGraphics();
		
		
		
		try {
			castleWall = ImageIO.read(getClass().getResourceAsStream("/maps/CastleWall.png"));
			CastleWallAccsesorys = ImageIO.read(getClass().getResourceAsStream("/maps/CastleWallTrees.png"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		hud.render(g);
		
		g.drawImage(castleWall, 0, 0, null);
		handler.render(g);
		g.drawImage(CastleWallAccsesorys, 0, 0, null);

		g.dispose();
		bs.show();
	}

	public void addCollisions() {
		handler.addObject(new Collisions(0, 384, ID.CollisionBox));
		handler.addObject(new Collisions(0, 384 - 32, ID.CollisionBox));
		handler.addObject(new Collisions(96, 384, ID.CollisionBox));
		handler.addObject(new Collisions(96, 384 - 32, ID.CollisionBox));
		handler.addObject(new Collisions(256, 384, ID.CollisionBox));
		handler.addObject(new Collisions(256, 384 - 32, ID.CollisionBox));
		handler.addObject(new Collisions(352, 384, ID.CollisionBox));
		handler.addObject(new Collisions(352, 384 - 32, ID.CollisionBox));
		handler.addObject(new Collisions(450, 384, ID.CollisionBox));
		handler.addObject(new Collisions(450, 384 - 32, ID.CollisionBox));
		handler.addObject(new Collisions(544, 384, ID.CollisionBox));
		handler.addObject(new Collisions(544, 384 - 32, ID.CollisionBox));
	}
}
