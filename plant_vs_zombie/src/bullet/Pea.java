package bullet;

import javax.swing.ImageIcon;

public class Pea extends BaseBullet {

	public Pea(int posX, int posY) {
		super(posX, posY);
		// ≥ı ºªØ Ù–‘
		power = 1;
		speedX = 0;
		speedY = 20;
		image = (new ImageIcon("resource\\images\\plant\\PB00.gif").getImage());
	}
	
}
