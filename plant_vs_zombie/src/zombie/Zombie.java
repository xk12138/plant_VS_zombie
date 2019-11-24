package zombie;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Zombie extends BasicZombie {
	private static ImageIcon image;
	public static void loadImage() {
		image = new ImageIcon("../../resource/images/zombie/Zombie/Zombie.gif");
	}
	public static ImageIcon getImage() {
		return image;
	}
	
	public Zombie(int posX, int posY) {
		super(posX, posY);
		health = 100;
		power = 2;
		speedX = 0;
		speedY = 20;
		label = new JLabel(getImage());
	}
}
