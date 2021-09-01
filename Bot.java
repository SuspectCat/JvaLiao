package game.panel;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.Random;

public class Bot extends Tank implements GameSettings {
	
	int moveTime = 0;

	public Bot(String imagePath, int x, int y, GamePanel gamePanel, String upImg, String leftImg, String rightImg,
			String downImg) {
		super(imagePath, x, y, gamePanel, upImg, leftImg, rightImg, downImg);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void paintSelf(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(image, x, y, null);
		
		go();
	}

	@Override
	public Rectangle getRec() {
		// TODO Auto-generated method stub
		return new Rectangle(x, y, width, height);
	}
	
	public Dirction getRandomHoko() {
		Random random = new Random();
		int rand = random.nextInt(4);
		
		switch (rand) {
		case 0: return Dirction.LEFT;
		case 1: return Dirction.DOWN;
		case 2: return Dirction.RIGHT;
		case 3: return Dirction.UP;
		default: return null;
		}
	}

	public void go() {
		attack();
		
		if (moveTime >= MOVE_TIME) {
			dirction = getRandomHoko();
			moveTime = 0;
		} else {
			moveTime++;
		}
		
		switch (dirction) {
		case LEFT: leftward(); break;
		case RIGHT: rightward(); break;
		case DOWN: downward(); break;
		case UP: upward(); break;
		}
	}
	
	/**
	 * »úÆ÷ÈË¹¥»÷
	 */
	public void attack() {
		Point p = getHeadPoint();
		Random random = new Random();
		
		int num = random.nextInt(100);
		
		if (num < FIRE_PROPERTITY) {
			this.gamePanel.bulletList.add(new EnemyBullet(IMAGE_BULLET, p.x, p.y, this.gamePanel, this.dirction));
		}
	}
}
