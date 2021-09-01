package game.panel;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;

/**
 * ��Ϸ�ĸ���
 * @author 32848
 *
 */

public abstract class GameObject {
	
	/**
	 * ͼƬ
	 */
	Image image;
	/**
	 * Ԫ������
	 */
	int x, y;
	/**
	 * Ԫ���������
	 */
	GamePanel gamePanel;
	
	/**
	 * ������
	 */
	public GameObject(String imagePath, int x, int y, GamePanel gamePanel) {
		super();
		this.image = Toolkit.getDefaultToolkit().getImage(imagePath);
		this.x = x;
		this.y = y;
		this.gamePanel = gamePanel;
	}
	
	/**
	 * ���Լ�
	 */
	public abstract void paintSelf(Graphics g);
	
	/**
	 * ��ȥ�������
	 */
	public abstract Rectangle getRec();
	
}
