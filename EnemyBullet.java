package game.panel;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.List;

public class EnemyBullet extends Bullet implements GameSettings {

	public EnemyBullet(String imagePath, int x, int y, GamePanel gamePanel, Dirction dirction) {
		super(imagePath, x, y, gamePanel, dirction);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void paintSelf(Graphics g) {
		g.drawImage(image, x, y, null);
		go();
		
		hitPlayer();
	}
	
	@Override
	public Rectangle getRec() {
		return new Rectangle(x, y, width, height);
	}
	
	public void hitPlayer() {
		List<Tank> playerList = this.gamePanel.playerList;
		
		for (Tank tank : playerList) {
			if (this.getRec().intersects(tank.getRec())) {
				this.gamePanel.playerList.remove(tank);
				this.gamePanel.removeList.add(this);
				break;
			}
		}
	}
}
