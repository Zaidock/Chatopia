package com.zaidock.chat.objects.entitys;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import com.zaidock.chat.Game;
import com.zaidock.chat.Game.Maps;
import com.zaidock.chat.ID;
import com.zaidock.chat.objects.other.Speech;
import com.zaidock.chat.quests.GetIntoDungeon;
import com.zaidock.chat.utills.GameObject;
import com.zaidock.chat.utills.Handler;
import com.zaidock.chat.utills.Item;

public class Player extends GameObject {

	private BufferedImage player;
	private BufferedImage helmet;
	private BufferedImage chest;
	private BufferedImage leggings;

	private Handler handler;
	private Game game;

	int time = 0;

	public Player(float x, float y, ID id, Handler handler, Game game) {
		super(x, y, id);
		this.handler = handler;
		this.game = game;
		try {
			player = ImageIO.read(getClass().getResourceAsStream("/characters/soldier_altcolor-00-02.png"));
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
		walk();

		if (game.currentMap == Maps.house) {
			if (getY() > 146 && getY() < 218 && getX() == 592) {
				game.currentMap = Maps.castleWall;
				handler.removeObject(this);
				handler.addObject(new Player(1, 233, ID.Player, handler, game));
				game.addedCollisions = false;
			}
		}

		if (game.currentMap == Maps.room) {
			if (getX() > 463 && getX() < 493 && getY() <= 54) {
				game.currentMap = Maps.house;
				handler.removeObject(this);
				handler.addObject(new Player(241, 54, ID.Player, handler, game));
				game.addedCollisions = false;
			}
		}

		if (game.currentMap == Maps.castleWall) {
			if (getX() > 139 && getX() < 233 && getY() == 81) {
				for (int i = 0; i < handler.item.size(); i++) {
					Item item = handler.item.get(i);
					if (item.getID() == ID.SackOfMoney) {
						game.currentMap = Maps.dengeon;
						return;
					}
				}
				handler.addObject(new Speech(15, Game.HEIGHT, ID.speech,
						"Guard: I can't let you in unless *cough* *cough* you have somthing for me?", 10, handler, game));
				game.getConfig().set("checkpoint", "1");
				
				handler.addQuest(new GetIntoDungeon(game, handler));
				
			}
			if (getY() > 247 && getY() < 275 && getX() >= 592) {
				game.currentMap = Maps.richsHouse;
				handler.removeObject(this);
				handler.addObject(new Player(1, 233, ID.Player, handler, game));
				game.addedCollisions = false;
			}
		}
		if(game.currentMap == Maps.richsHouse){
			if(getX() > 297 && getX() < 313 && getY() == 54){
				handler.addObject(new Speech(15, Game.HEIGHT, ID.speech, "YOU: *Knock* *Knock*", 10, handler, game));
			}
		}
		collision();
	}

	public void walk() {
		if (game.walkingDown) {
			time++;
			if (time == 20) {
				try {
					player = ImageIO.read(getClass().getResourceAsStream("/characters/soldier_altcolor-01-02.png"));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (time == 40) {
				try {
					player = ImageIO.read(getClass().getResourceAsStream("/characters/soldier_altcolor-02-02.png"));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (time == 60) {
				try {
					player = ImageIO.read(getClass().getResourceAsStream("/characters/soldier_altcolor-03-02.png"));
				} catch (Exception e) {
					e.printStackTrace();
				}
				time = 0;
			}
		}
		if (game.walkingUp) {
			time++;
			if (time == 20) {
				try {
					player = ImageIO.read(getClass().getResourceAsStream("/characters/soldier_altcolor-01-00.png"));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (time == 40) {
				try {
					player = ImageIO.read(getClass().getResourceAsStream("/characters/soldier_altcolor-02-00.png"));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (time == 60) {
				try {
					player = ImageIO.read(getClass().getResourceAsStream("/characters/soldier_altcolor-03-00.png"));
				} catch (Exception e) {
					e.printStackTrace();
				}
				time = 0;
			}
		}
		if (game.walkingLeft) {
			time++;
			if (time == 20) {
				try {
					player = ImageIO.read(getClass().getResourceAsStream("/characters/soldier_altcolor-01-01.png"));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (time == 40) {
				try {
					player = ImageIO.read(getClass().getResourceAsStream("/characters/soldier_altcolor-02-01.png"));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (time == 60) {
				try {
					player = ImageIO.read(getClass().getResourceAsStream("/characters/soldier_altcolor-03-01.png"));
				} catch (Exception e) {
					e.printStackTrace();
				}
				time = 0;
			}
		}
		if (game.walkingRight) {
			time++;
			if (time == 20) {
				try {
					player = ImageIO.read(getClass().getResourceAsStream("/characters/soldier_altcolor-01-03.png"));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (time == 40) {
				try {
					player = ImageIO.read(getClass().getResourceAsStream("/characters/soldier_altcolor-02-03.png"));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (time == 60) {
				try {
					player = ImageIO.read(getClass().getResourceAsStream("/characters/soldier_altcolor-03-03.png"));
				} catch (Exception e) {
					e.printStackTrace();
				}
				time = 0;
			}
		}
	}

	public void collision() {
		for (int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			if (tempObject.getID() == ID.CollisionBox || tempObject.getID() == ID.Guard) {
				if (getBounds().intersects(tempObject.getBounds())) {
					setVelX(0);
					setVelY(0);
				}
			}
		}
	}

	public void render(Graphics g) {
		g.drawImage(player, (int) x, (int) y, 64, 64, null);
		g.drawImage(helmet, (int) x, (int) y, null);
		g.drawImage(chest, (int) x, (int) y, null);
		g.drawImage(leggings, (int) x, (int) y, null);
		// g.setColor(Color.RED);
		// g.fillRect((int)x, (int)y, 32, 32);
	}

	public Rectangle getBounds() {
		return new Rectangle((int) x + 16, (int) y + 16, 32, 48);
	}

	public void removePlayer() {
		handler.removeObject(this);
	}

}
