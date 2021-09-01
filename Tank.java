package game.panel;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.util.List;

public abstract class Tank extends GameObject implements GameSettings {
	
	/**
	 * ����̹�˵Ŀ��
	 */
	public int width = 40;
	public int height = 50;
	
	/**
	 * �ٶ�
	 */
	public int speed = TANK_SPEED;
	
	/**
	 * ����
	 */
	public Dirction dirction = Dirction.UP;
	
	/**
	 * ������ȴʱ���ж�
	 */
	boolean attackCoolState = true;
	
	/**
	 * �ĸ������ͼƬ
	 */
	public String upImg;
	public String leftImg;
	public String rightImg;
	public String downImg;
	
	public Tank(String imagePath, int x, int y, GamePanel gamePanel, String upImg, 
			String leftImg, String rightImg, String downImg) {
		super(imagePath, x, y, gamePanel);
		// TODO Auto-generated constructor stub
		this.upImg = upImg;
		this.leftImg = leftImg;
		this.rightImg = rightImg;
		this.downImg = downImg;
	}
	
	/**
	 * ̹���ƶ�
	 */
	/*
	 * public void leftWard() {
	 * 
	 * if (! hitWall(x - speed, y) && ! moveToBorder(x - speed, y)) x -= speed;
	 * 
	 * dirction = Dirction.LEFT; setImg(leftImg); }
	 * 
	 * public void upWard() {
	 * 
	 * if (! hitWall(x, y -= speed) && ! moveToBorder(x, y -= speed)) { y -= speed;
	 * }
	 * 
	 * dirction = Dirction.UP; setImg(upImg); }
	 * 
	 * public void rightWard() {
	 * 
	 * if (! hitWall(x += speed, y) && ! moveToBorder(x += speed, y)) { x += speed;
	 * }
	 * 
	 * dirction = Dirction.RIGHT; setImg(rightImg); }
	 * 
	 * public void downWard() {
	 * 
	 * if (! hitWall(x, y += speed) && ! moveToBorder(x, y += speed)) { y += speed;
	 * }
	 * 
	 * dirction = Dirction.DOWN; setImg(downImg); }
	 */
	
	//�ƶ�����   ����
	public void leftward() {
		if (!hitWall(x - speed, y) && !moveToBorder(x - speed, y)) x -= speed;
		dirction = Dirction.LEFT;
		setImg(leftImg);
	}

	// �ƶ����� ����
	public void rightward() {
		if (!hitWall(x + speed, y) && !moveToBorder(x + speed, y)) x += speed;

		dirction = Dirction.RIGHT;
		setImg(rightImg);
	}

	// �ƶ����� ����
	public void upward() {
		if (!hitWall(x, y - speed) && !moveToBorder(x, y - speed)) y -= speed;
		dirction = Dirction.UP;
		setImg(upImg);
	}

	// �ƶ����� ����
	public void downward() {
		if (!hitWall(x, y + speed) && !moveToBorder(x, y + speed)) y += speed;

		dirction = Dirction.DOWN;
		setImg(downImg);
	}
			
	public void setImg(String img) {
		this.image = Toolkit.getDefaultToolkit().getImage(img);
	}
	
	/**
	 * ��ȡ̹�˵�ͷ������
	 * @return
	 */
	public Point getHeadPoint() {
		switch (dirction) {
		case LEFT: return new Point(x, y + height/2);
		case DOWN: return new Point(x + width/2, y + height/2);
		case RIGHT:return new Point(x + width, y + height/2);
		case UP:   return new Point(x + width/2, y);
		default:   return null;
		}
	}
	
	/**
	 * �����ӵ�
	 */
	public void attach() {
		if (attackCoolState) {
			Point point = getHeadPoint();
			Bullet bullet = new Bullet(IMAGE_BULLET, point.x, point.y, this.gamePanel, this.dirction);
			this.gamePanel.bulletList.add(bullet);
			
			// ���뼰����ȴʱ��
			new AttackCool().start();
		}
	}
	
	class AttackCool extends Thread {

		@Override public void run() { 
			attackCoolState = false;
		  
			try { 
				Thread.sleep(ATTACH_COOL_TIME); 
			} catch (InterruptedException e) { 
			//TODO Auto-generated catch block 
				e.printStackTrace(); 
			}
		 
			attackCoolState = true; 
		}
	}
	
	public boolean hitWall(int x, int y) {
		List<Wall> wallList = this.gamePanel.wallList;
		// �@ȡ��һ���Ƅӵľ���
		Rectangle rec = new Rectangle(x, y, width, height);
		
		for (Wall wall : wallList) {
			if (wall.getRec().intersects(rec)) {
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * �߽���ײ���
	 */
	public boolean moveToBorder(int x, int y) {
		if (x < 0) return true;
		else if (x + width > GameSettings.PANEL_WIDTH) return true;
		else if (y < 0) return true;
		else if (y + this.height > GameSettings.PANEL_HEIGHT) return true;
		
		return false;
	}
}
