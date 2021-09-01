package game.panel;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.List;

public class Bullet extends GameObject implements GameSettings {
	/**
	 * �ӵ��ĳߴ�
	 */
	int width = 10;
	int height = 10;
	
	/**
	 * �ٶ�
	 */
	int speed = BULLET_SPEED;
	
	/**
	 * �ӵ��ķ���
	 */
	Dirction dirction;

	/**
	 * ���췽��
	 * @param imagePath ͼƬ·��
	 * @param x			������
	 * @param y			������
	 * @param gamePanel	��Ϸ���
	 * @param dirction	����
	 */
	public Bullet(String imagePath, int x, int y, GamePanel gamePanel, Dirction dirction) {
		super(imagePath, x, y, gamePanel);
		// TODO Auto-generated constructor stub
		this.dirction = dirction;
	}

	@Override
	public void paintSelf(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(image, x, y, null);
		
		go();
		hitBot();
	}

	@Override
	public Rectangle getRec() {
		// TODO Auto-generated method stub
		return new Rectangle(x, y, width, height);
	}
	
	public void leftWard() {
		x -= speed;
	}
	
	public void upWard() {
		y -= speed;
	}
	
	public void downWard() {
		y += speed;
	}
	
	public void rightWard() {
		x += speed;
	}
	
	public void go() {
		switch (dirction) {
		case LEFT: 
			leftWard();
			break;
		case RIGHT:
			rightWard();
			break;
		case DOWN:
			downWard();
			break;
		case UP:
			upWard();
			break;
		}
		
		hitWall();
		moveToBorder();
		hitBase();
	}
	
	/**
	 * ��������ײ���
	 */
	public void hitBot() {
		List<Bot> botList = this.gamePanel.botList;
		
		for (Bot bot : botList) {
			
			// intersects �����ж���������֮���Ƿ����ص�
			if (bot.getRec().intersects(this.getRec())) {
				this.gamePanel.botList.remove(bot);
				this.gamePanel.removeList.add(this);
				break;
			}
			
		}
	}
	
	/**
	 * ��ǽ��ײ���
	 */
	public void hitWall() {
		List<Wall> wallList = this.gamePanel.wallList;
		
		for (Wall wall : wallList) {
			if (this.getRec().intersects(wall.getRec())) {
				this.gamePanel.removeList.add(this);
				this.gamePanel.wallList.remove(wall);
				break;
			}
		}
	}
	
	/**
	 * �ӵ�Խ����
	 */
	public void moveToBorder() {
		if (x < 0 || x + width > GameSettings.PANEL_WIDTH) this.gamePanel.removeList.add(this);
		if (y < 0 || y + height > GameSettings.PANEL_HEIGHT) this.gamePanel.removeList.add(this);
	}
	
	/**
	 * �ӵ��ͻ�����ײ���
	 */
	public void hitBase() {
		List<Base> baseList = this.gamePanel.baseList;
		
		for (Base base : baseList) {
			if (base.getRec().intersects(this.getRec())) {
				this.gamePanel.baseList.remove(base);
				this.gamePanel.removeList.add(this);
				break;
			}
		}
	}

}
