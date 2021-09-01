package game.panel;

import java.awt.Color;

public interface GameSettings {
	/**
	 * 获取选择模式图片
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
	/* public static final */String PANEL_TITLE = "坦克大战 V0.0.1";
	
	/**
	 * 背景颜色
	 */
	Color BACKGROUND_COLOR = Color.GRAY;
	
	/**
	 * 字体颜色
	 */
	Color FONT_COLOR = Color.ORANGE;
	
	/* public static final */String FONT_FAMILY = "楷体";
	
	/**
	 * 技能冷却时间
	 */
	int ATTACH_COOL_TIME = 200;
	/**
	 * 炮弹射速
	 */
	int BULLET_SPEED = 7;
	/**
	 * 坦克的速度
	 */
	int TANK_SPEED = 3;
	
	/**
	 * 机器人的重绘次数
	 */
	int BOT_REPAINT_COUNT = 1;
	/**
	 * 敌人的个数
	 */
	int ENEMY_COUNT = 3;
	
	/**
	 * 移动次数
	 */
	int MOVE_TIME = 20;
	
	/**
	 * 设置子弹发射概率
	 */
	int FIRE_PROPERTITY = 4;
	
}
