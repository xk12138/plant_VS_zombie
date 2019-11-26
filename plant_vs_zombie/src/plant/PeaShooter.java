package plant;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import bullet.Pea;

public class PeaShooter extends BasicPlant {
	private static ImageIcon image;
	public static void loadImage() {
		image = new ImageIcon("resource\\images\\plant\\Peashooter\\Peashooter.gif");
	}
	public static ImageIcon getImage() {
		return image;
	}
	
	public PeaShooter(int posX, int posY) {
		super(posX, posY);
		this.health = 100;
    	this.attackSpeed = 100;
    	coolDown = 50;
    	timer = coolDown;
    	price = 100;
    	label = new JLabel(getImage());
    	label.setSize(image.getIconWidth(), image.getIconHeight());
    	label.setBounds(posX, posY, image.getIconWidth(), image.getIconHeight());
	}
	
	public Pea attack(boolean zombieExist) {
		Pea bullet = null;
		if(timer != 0) {
			timer--;
		}
		else if(zombieExist) {
			timer = coolDown;
			bullet = new Pea(posX, posY);
		}
		return bullet;
	}
}
