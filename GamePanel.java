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
	 * �������������
	 */
	Image offScreenImage = null;

	/**
	 * ��ȡѡ��ģʽͼƬ
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
	 * ���ڱ���̹�˵�������
	 */
	int y = 150;
	/**
	 * ѡ��ģʽ 0 : δѡ�� 1 : ����ģʽ 2 ��˫��ģʽ
	 */
	int state = 0, a;

	/**
	 * ���ô��ڵĿ��
	 */
	/*
	 * public static final int PANEL_WIDTH = 800;
	 */
	/**
	 * ���ô��ڵĸ߶�
	 */
	/*
	 * public static final int PANEL_HEIGHT = 610;
	 */
	/**
	 * ���ô��ڵ�����
	 */
	/*
	 * public static final String PANEL_TITLE = "̹�˴�ս v0.0.1";
	 */

	/**
	 * ����һ�����
	 */
	PlayerOne playerOne = new PlayerOne(IMAGE_PATH_MYTANK_UP, 125, 510, this, IMAGE_PATH_MYTANK_UP,
			IMAGE_PATH_MYTANK_LEFT, IMAGE_PATH_MYTANK_RIGHT, IMAGE_PATH_MYTANK_DOWN);
	
	/**
	 * �ӵ��ļ���
	 */
	List<Bullet> bulletList = new ArrayList<Bullet>();
	
	/**
	 * ���������˼���
	 */
	List<Bot> botList = new ArrayList<Bot>();
	/**
	 * ��Ҫɾ�����ӵ�
	 */
	List<Bullet> removeList = new ArrayList<Bullet>();
	/**
	 * ����б�
	 */
	List<Tank> playerList = new ArrayList<Tank>();
	/**
	 * ��ǽ
	 */
	List<Wall> wallList = new ArrayList<Wall>();
	/**
	 * ��ӻ���
	 */
	List<Base> baseList = new ArrayList<Base>();
	
	int count = 0;
	int enemyCount = 0;

	/**
	 * ���ڵ���������
	 */
	public void lunch() {
		/**
		 * ���ñ���
		 */
		setTitle(PANEL_TITLE);
		/**
		 * ���óߴ�
		 */
		setSize(PANEL_WIDTH, PANEL_HEIGHT);
		/**
		 * ���þ���
		 */
		setLocationRelativeTo(null);
		/**
		 * ��ֹ��������
		 */
		setResizable(false);
		/**
		 * ���ô��ڿɼ�
		 */
		setVisible(true);
		/**
		 * �رմ���
		 */
		setDefaultCloseOperation(3);
		/**
		 * Ϊ������Ӽ��̼���
		 */
		this.addKeyListener(new GamePanel.keyMonitor());
		
		/**
		 * ��ʼ����ǽ
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
		 * �������봰��
		 */
		while (true) {
			
			// ���ʤ��
			if (0 == botList.size() && ENEMY_COUNT == enemyCount) {
				state = 4;
			}
			
			// ����ʤ��
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
	 * ��ȡ����
	 */
	@Override
	public void paint(Graphics g) {

		if (null == offScreenImage) {
			offScreenImage = this.createImage(PANEL_WIDTH, PANEL_HEIGHT);
		}

		Graphics gImage = offScreenImage.getGraphics();

		// ���ñ�����ɫ
		gImage.setColor(BACKGROUND_COLOR);
		// ����ɫ�����������
		gImage.fillRect(0, 0, PANEL_WIDTH, PANEL_HEIGHT);

		// ����������ɫ
		gImage.setColor(FONT_COLOR);
		// ��������
		gImage.setFont(new Font(FONT_FAMILY, Font.BOLD, 50));

		if (0 == state) {
			// ��������
			gImage.drawString("��ѡ��ģʽ", 220, 100);
			gImage.drawString("����ģʽ", 220, 200);
			gImage.drawString("˫��ģʽ", 220, 300);

			// ����ͼƬ
			gImage.drawImage(select, 140, y, null);
		} else if (1 == state || 2 == state) {
			gImage.drawString("��ʼ��Ϸ", 220, 100);

			if (1 == state) {
				gImage.drawString("����ģʽ", 220, 200);
			} else if (2 == state) {
				gImage.drawString("˫��ģʽ", 220, 200);
			}

//			playerOne.paintSelf(gImage);
			// ��������б�
			for (Tank tank : playerList) tank.paintSelf(gImage);
			
			// �����ӵ�
			for (Bullet bullet : bulletList) bullet.paintSelf(gImage);
			
			// ɾ��������ײ��̹��
			bulletList.removeAll(removeList);
			
			for (Bot bot : botList) bot.paintSelf(gImage);
			
			// ���Ƴ�ǽ
			for (Wall wall : wallList) wall.paintSelf(gImage);
			
			// ���ƻ���
			for (Base base : baseList) base.paintSelf(gImage);
			
			count++;
		} else if (4 == state) gImage.drawString("��Ӯ��", 200, 100);
		else if (5 == state) gImage.drawString("������ʤ��", 220, 100);
		

		// �����»��Ƶ�ͼƬ���뵽������
		g.drawImage(offScreenImage, 0, 0, null);
	}

	/**
	 * ��ؼ���
	 * 
	 * @author 32848
	 *
	 */
	class keyMonitor extends KeyAdapter {

		// ������̵Ļص�����
		@Override
		public void keyPressed(KeyEvent e) {
			// ��ӡ����ļ��̵ļ�
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
				// ����س���ѡ����Ӧģʽ
//				state = key;
				state = a;
				
				// ȷ����Ϸģʽ
				playerList.add(playerOne);
				// ˫��ģʽ����չ
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
