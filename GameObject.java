package game.panel;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;

/**
 * 游戏的父类
 * @author 32848
 *
 */

public abstract class GameObject {
	
	/**
	 * 图片
	 */
	Image image;
	/**
	 * 元素坐标
	 */
	int x, y;
	/**
	 * 元素所在面板
	 */
	GamePanel gamePanel;
	
	/**
	 * 构造器
	 */
	public GameObject(String imagePath, int x, int y, GamePanel gamePanel) {
		super();
		this.image = Toolkit.getDefaultToolkit().getImage(imagePath);
		this.x = x;
		this.y = y;
		this.gamePanel = gamePanel;
	}
	
	/**
	 * 画自己
	 */
	public abstract void paintSelf(Graphics g);
	
	/**
	 * 过去自身矩形
	 */
	public abstract Rectangle getRec();
	
}
