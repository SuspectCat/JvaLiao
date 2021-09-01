package game.panel;

import java.awt.Color;

public interface GameSettings {
	/**
	 * ��ȡѡ��ģʽͼƬ
	 */
	/* public static final */String IMAGE_PATH_MYTANK_RIGHT = "Images/mytank_right.gif";
	/* public static final */String IMAGE_PATH_MYTANK_LEFT = "Images/mytank_left.gif";
	/* public static final */String IMAGE_PATH_MYTANK_UP = "Images/mytank_up.gif";
	/* public static final */String IMAGE_PATH_MYTANK_DOWN = "Images/mytank_down.gif";
	
	/* public static final */String IMAGE_PATH_ENEMY_DOWN = "Images/enemy_down.gif";
	/* public static final */String IMAGE_PATH_ENEMY_LEFT = "Images/enemy_left.png";
	/* public static final */String IMAGE_PATH_ENEMY_RIGHT = "Images/enemy_right.png";
	/* public static final */String IMAGE_PATH_ENEMY_UP = "Images/enemy_up.png";
	
	String IMAGE_PATH_BASE = "Images/base.png";
	
	String IMAGE_PATH_WALL = "Images/wall.png";
	
	String IMAGE_BULLET = "Images/bullet.gif";
	
	/* public static final */int PANEL_WIDTH = 800;
	/* public static final */int PANEL_HEIGHT = 610;
	/* public static final */String PANEL_TITLE = "̹�˴�ս V0.0.1";
	
	/**
	 * ������ɫ
	 */
	Color BACKGROUND_COLOR = Color.GRAY;
	
	/**
	 * ������ɫ
	 */
	Color FONT_COLOR = Color.ORANGE;
	
	/* public static final */String FONT_FAMILY = "����";
	
	/**
	 * ������ȴʱ��
	 */
	int ATTACH_COOL_TIME = 200;
	/**
	 * �ڵ�����
	 */
	int BULLET_SPEED = 7;
	/**
	 * ̹�˵��ٶ�
	 */
	int TANK_SPEED = 3;
	
	/**
	 * �����˵��ػ����
	 */
	int BOT_REPAINT_COUNT = 1;
	/**
	 * ���˵ĸ���
	 */
	int ENEMY_COUNT = 3;
	
	/**
	 * �ƶ�����
	 */
	int MOVE_TIME = 20;
	
	/**
	 * �����ӵ��������
	 */
	int FIRE_PROPERTITY = 4;
	
}
