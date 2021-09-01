package game.panel;

//import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JFrame;

public class GamePanel extends JFrame implements GameSettings {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 解决闪屏的问题
	 */
	Image offScreenImage = null;

	/**
	 * 获取选择模式图片
	 */
	/*
	 * public static final String IMAGE_PATH_MYTANK_RIGHT =
	 * "Images/mytank_right.gif"; public static final String IMAGE_PATH_MYTANK_LEFT
	 * = "Images/mytank_left.gif"; public static final String IMAGE_PATH_MYTANK_UP =
	 * "Images/mytank_up.gif"; public static final String IMAGE_PATH_MYTANK_DOWN =
	 * "Images/mytank_down.gif";
	 * 
	 * public static final String IMAGE_PATH_ENEMY_DOWN = "Images/enemy_down.gif";
	 * public static final String IMAGE_PATH_ENEMY_LEFT = "Images/enemy_left.png";
	 * public static final String IMAGE_PATH_ENEMY_RIGHT = "Images/enemy_right.png";
	 * public static final String IMAGE_PATH_ENEMY_UP = "Images/enemy_up.png";
	 */

	Image select = Toolkit.getDefaultToolkit().getImage(IMAGE_PATH_MYTANK_RIGHT);

	/**
	 * 用于保存坦克的纵坐标
	 */
	int y = 150;
	/**
	 * 选择模式 0 : 未选择 1 : 单人模式 2 ：双人模式
	 */
	int state = 0, a;

	/**
	 * 设置窗口的宽度
	 */
	/*
	 * public static final int PANEL_WIDTH = 800;
	 */
	/**
	 * 设置窗口的高度
	 */
	/*
	 * public static final int PANEL_HEIGHT = 610;
	 */
	/**
	 * 设置窗口的名称
	 */
	/*
	 * public static final String PANEL_TITLE = "坦克大战 v0.0.1";
	 */

	/**
	 * 创建一个玩家
	 */
	PlayerOne playerOne = new PlayerOne(IMAGE_PATH_MYTANK_UP, 125, 510, this, IMAGE_PATH_MYTANK_UP,
			IMAGE_PATH_MYTANK_LEFT, IMAGE_PATH_MYTANK_RIGHT, IMAGE_PATH_MYTANK_DOWN);
	
	/**
	 * 子弹的集合
	 */
	List<Bullet> bulletList = new ArrayList<Bullet>();
	
	/**
	 * 创建机器人集合
	 */
	List<Bot> botList = new ArrayList<Bot>();
	/**
	 * 需要删除的子弹
	 */
	List<Bullet> removeList = new ArrayList<Bullet>();
	/**
	 * 玩家列表
	 */
	List<Tank> playerList = new ArrayList<Tank>();
	/**
	 * 城墙
	 */
	List<Wall> wallList = new ArrayList<Wall>();
	/**
	 * 添加基地
	 */
	List<Base> baseList = new ArrayList<Base>();
	
	int count = 0;
	int enemyCount = 0;

	/**
	 * 窗口的启动方法
	 */
	public void lunch() {
		/**
		 * 设置标题
		 */
		setTitle(PANEL_TITLE);
		/**
		 * 设置尺寸
		 */
		setSize(PANEL_WIDTH, PANEL_HEIGHT);
		/**
		 * 设置居中
		 */
		setLocationRelativeTo(null);
		/**
		 * 禁止窗口拉伸
		 */
		setResizable(false);
		/**
		 * 设置窗口可见
		 */
		setVisible(true);
		/**
		 * 关闭窗口
		 */
		setDefaultCloseOperation(3);
		/**
		 * 为窗口添加键盘监听
		 */
		this.addKeyListener(new GamePanel.keyMonitor());
		
		/**
		 * 初始化城墙
		 */
		for (int i = 0; i < 14; i++) {
			wallList.add(new Wall(IMAGE_PATH_WALL, i * 60, 170, this));
		}
		
		wallList.add(new Wall(IMAGE_PATH_WALL, 305, 560, this));
		wallList.add(new Wall(IMAGE_PATH_WALL, 305, 500, this));
		wallList.add(new Wall(IMAGE_PATH_WALL, 365, 500, this));
		wallList.add(new Wall(IMAGE_PATH_WALL, 425, 500, this));
		wallList.add(new Wall(IMAGE_PATH_WALL, 425, 560, this));

		baseList.add(new Base(IMAGE_PATH_BASE, 365, 560, this));
		
		/**
		 * 重新载入窗口
		 */
		while (true) {
			
			// 玩家胜利
			if (0 == botList.size() && ENEMY_COUNT == enemyCount) {
				state = 4;
			}
			
			// 机器胜利
			if ((0 == playerList.size() && (1 == state || 2 == state)) || 0 == baseList.size() ) {
				state = 5;
			}
			
			if (count % 100 == BOT_REPAINT_COUNT && enemyCount < ENEMY_COUNT) {
				Random random = new Random();
				int rNum = random.nextInt(800);
				
				botList.add(new Bot(IMAGE_PATH_ENEMY_DOWN, rNum, 120, this, 
						IMAGE_PATH_ENEMY_UP, IMAGE_PATH_ENEMY_LEFT, IMAGE_PATH_ENEMY_RIGHT, 
						IMAGE_PATH_ENEMY_DOWN));
				
				enemyCount++;
			}
			
			this.repaint();

			try {
				Thread.sleep(25);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * 获取画笔
	 */
	@Override
	public void paint(Graphics g) {

		if (null == offScreenImage) {
			offScreenImage = this.createImage(PANEL_WIDTH, PANEL_HEIGHT);
		}

		Graphics gImage = offScreenImage.getGraphics();

		// 设置背景颜色
		gImage.setColor(BACKGROUND_COLOR);
		// 把颜色填充整个窗口
		gImage.fillRect(0, 0, PANEL_WIDTH, PANEL_HEIGHT);

		// 设置字体颜色
		gImage.setColor(FONT_COLOR);
		// 设置字体
		gImage.setFont(new Font(FONT_FAMILY, Font.BOLD, 50));

		if (0 == state) {
			// 设置文字
			gImage.drawString("请选择模式", 220, 100);
			gImage.drawString("单人模式", 220, 200);
			gImage.drawString("双人模式", 220, 300);

			// 加载图片
			gImage.drawImage(select, 140, y, null);
		} else if (1 == state || 2 == state) {
			gImage.drawString("开始游戏", 220, 100);

			if (1 == state) {
				gImage.drawString("单人模式", 220, 200);
			} else if (2 == state) {
				gImage.drawString("双人模式", 220, 200);
			}

//			playerOne.paintSelf(gImage);
			// 绘制玩家列表
			for (Tank tank : playerList) tank.paintSelf(gImage);
			
			// 绘制子弹
			for (Bullet bullet : bulletList) bullet.paintSelf(gImage);
			
			// 删除发生碰撞的坦克
			bulletList.removeAll(removeList);
			
			for (Bot bot : botList) bot.paintSelf(gImage);
			
			// 绘制城墙
			for (Wall wall : wallList) wall.paintSelf(gImage);
			
			// 绘制基地
			for (Base base : baseList) base.paintSelf(gImage);
			
			count++;
		} else if (4 == state) gImage.drawString("你赢了", 200, 100);
		else if (5 == state) gImage.drawString("机器人胜利", 220, 100);
		

		// 把重新绘制的图片放入到窗口中
		g.drawImage(offScreenImage, 0, 0, null);
	}

	/**
	 * 监控键盘
	 * 
	 * @author 32848
	 *
	 */
	class keyMonitor extends KeyAdapter {

		// 点击键盘的回调方法
		@Override
		public void keyPressed(KeyEvent e) {
			// 打印点击的键盘的键
			System.out.println(e.getKeyChar());

			int key = e.getKeyChar();

			switch (key) {
			case KeyEvent.VK_1:
				y = 150;
				a = 1;
				break;
			case KeyEvent.VK_2:
				y = 250;
				a = 2;
				break;
			case 65535:
				a = 0;
				break;
			case KeyEvent.VK_ENTER:
				// 点击回车，选择相应模式
//				state = key;
				state = a;
				
				// 确认游戏模式
				playerList.add(playerOne);
				// 双人模式待拓展
			default:
				playerOne.keyPressed(e);
			}
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			playerOne.keyReleased(e);
		}
	}

	public static void main(String[] args) {
		GamePanel gamePanel = new GamePanel();
		gamePanel.lunch();
	}
}
