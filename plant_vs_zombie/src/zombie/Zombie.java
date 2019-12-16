package zombie;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import controller.MainController;

public class Zombie extends BasicZombie {
	private static ImageIcon image;
	public static void loadImage() {
		image = new ImageIcon("resource\\images\\zombie\\Zombie\\Zombie.gif");
	}
	public static ImageIcon getImage() {
		return image;
	}
	
	public Zombie(int posY, MainController mainController) {
		super(posY, mainController);
		health = 100;
		power = 8;
		attackSpeed = 20;
		timer = attackSpeed;
		speedX = 0.5;
		speedY = 0;
		label = new JLabel(getImage());
		this.posX = 900;
		label.setSize(image.getIconWidth(), image.getIconHeight());
		label.setBounds((int)posX, (int)posY, image.getIconWidth(), image.getIconHeight());
	}
	
	public void move() {
		if (moderateTimer > 0) {
			posX -= (speedX / 2);
			posY -= (speedY / 2);
			moderateTimer--;
		}
		else {
			posX -= speedX;
			posY -= speedY;
		}
		label.setBounds((int)posX, (int)posY, image.getIconWidth(), image.getIconHeight());
	}
}
