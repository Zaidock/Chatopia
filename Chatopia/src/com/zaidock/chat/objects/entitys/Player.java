package com.zaidock.chat.objects.entitys;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import com.zaidock.chat.GameObject;
import com.zaidock.chat.ID;
import com.zaidock.chat.utills.Handler;

public class Player extends GameObject {

	private BufferedImage playerStill;
	public BufferedImage playerUp1;

	private Handler handler;
		
	private boolean castleDoor = false;
	public Player(float x, float y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
		try {
			playerStill = ImageIO.read(getClass().getResourceAsStream("/characters/soldier_altcolor-00-02.png"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void tick() {
		// TODO Change when making map changing
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
		// Castle
		if (getX() > 127 && getY() <= 82 && getX() < 227) {
			if(castleDoor == false){
				//handler.addObject(new Speech(256, 74, ID.speech));
				castleDoor = true;
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
		//g.setColor(Color.red);
		//g.fillRect((int)x,(int) y, 32, 32);
	}

	public Rectangle getBounds() {
		return new Rectangle((int) x + 16, (int) y + 16, 32, 48);
	}
}
