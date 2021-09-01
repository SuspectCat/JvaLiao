package game.panel;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

public class PlayerOne extends Tank {
	boolean up, right, down, left;

	public PlayerOne(String imagePath, int x, int y, GamePanel gamePanel, String upImg, String leftImg, String rightImg,
			String downImg) {
		super(imagePath, x, y, gamePanel, upImg, leftImg, rightImg, downImg);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void paintSelf(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(image, x, y, null);
		
		// ÖØÐÂ»æÍ¼
		move();
	}

	@Override
	public Rectangle getRec() {
		// TODO Auto-generated method stub
		return new Rectangle(x, y, width, height);
	}

	/**
	 * ÏìÓ¦¼üÅÌ
	 */
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		switch (key) {
		case KeyEvent.VK_W:
			up = true;
			break;
		case KeyEvent.VK_D:
			right = true;
			break;
		case KeyEvent.VK_S:
			down = true;
			break;
		case KeyEvent.VK_A:
			left = true;
			break;
		case KeyEvent.VK_SPACE:
			attach();
		}
	}
	
	/**
	 * ¼üÅÌËÉ¿ª
	 */
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		
		switch (key) {
		case KeyEvent.VK_W:
			up = false;
			break;
		case KeyEvent.VK_D:
			right = false;
			break;
		case KeyEvent.VK_S:
			down = false;
			break;
		case KeyEvent.VK_A:
			left = false;
			break;
		}
	}
	
	/**
	 * ÒÆ¶¯
	 */
	public void move() {
		if (left) {
			leftward();
		} else if (up) {
			upward();
		} else if (right) {
			rightward();
		} else if (down) {
			downward();
		}
	}
}
