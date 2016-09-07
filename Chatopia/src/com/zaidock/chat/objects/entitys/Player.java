package com.zaidock.chat.objects.entitys;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import com.zaidock.chat.Chatopia;
import com.zaidock.chat.Chatopia.Maps;
import com.zaidock.chat.GameObject;
import com.zaidock.chat.ID;
import com.zaidock.chat.objects.other.Speech;
import com.zaidock.chat.utills.Handler;

public class Player extends GameObject {

	private BufferedImage playerStill;
	public BufferedImage playerUp1;

	private Handler handler;
	private Chatopia game;

	public Player(float x, float y, ID id, Handler handler, Chatopia game) {
		super(x, y, id);
		this.handler = handler;
		this.game = game;
		try {
			playerStill = ImageIO.read(getClass().getResourceAsStream("/characters/soldier_altcolor-00-02.png"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void tick() {
		x += velX;
		y += velY;
		if (getX() >= 609 - 16)
			setX(609 - 17);
		if (getX() <= 0 - 16)
			setX(0 - 15);
		if (getY() >= 426 - 32)
			setY(426 - 33);
		if (getY() < 55)
			setY(55 - 1);

		if (game.currentMap == Maps.room) {
			if (getX() > 463 && getX() < 493 && getY() <= 54) {
				game.currentMap = Maps.house;
				handler.removeObject(this);
				handler.addObject(new Player(241, 54, ID.Player, handler, game));
			}
		}

		if (game.currentMap == Maps.castleWall) {
			if (getX() > 139 && getX() < 217 && getY() == 81) {
				handler.addObject(new Speech(15, Chatopia.HEIGHT, ID.speech,
						"I can't let you in unless *cough* *cough* you have somthing for me?", 10, handler, game));
			}
		}
		
		if(game.currentMap == Maps.house){
			if(getY() > 146 && getY() < 218 && getX() == 592){
				game.currentMap = Maps.castleWall;
				handler.removeObject(this);
				handler.addObject(new Player(1, 233, ID.Player, handler, game));
			}
		}

		collision();
	}

	public void collision() {
		for (int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			if (tempObject.getID() == ID.CollisionBox || tempObject.getID() == ID.Guard) {
				if (getBounds().intersects(tempObject.getBounds())) {
					if (tempObject.getID() == ID.CollisionBox || tempObject.getID() == ID.Guard) {
						setVelX(0);
						setVelY(0);
					}
				}
			}
		}
	}

	public void render(Graphics g) {
		g.drawImage(playerStill, (int) x, (int) y, 64, 64, null);
		// g.setColor(Color.red);
		// g.fillRect((int) x, (int) y, 32, 32);
	}

	public Rectangle getBounds() {
		return new Rectangle((int) x + 16, (int) y + 16, 32, 48);
	}

	public void removePlayer() {
		handler.removeObject(this);
	}
}
