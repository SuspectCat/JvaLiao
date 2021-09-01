package game.panel;

import java.awt.Graphics;
import java.awt.Rectangle;

public class Base extends GameObject {
	
	int length = 60;

	public Base(String imagePath, int x, int y, GamePanel gamePanel) {
		super(imagePath, x, y, gamePanel);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void paintSelf(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(image, x, y, null);
	}

	@Override
	public Rectangle getRec() {
		// TODO Auto-generated method stub
		return new Rectangle(x, y, length, length);
	}

}
