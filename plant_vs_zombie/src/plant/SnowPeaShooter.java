package plant;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import bullet.Pea;
import card.SnowPeaShooterCard;
import controller.MainController;

public class SnowPeaShooter extends BasicPlant {
	private static ImageIcon image;
	public static void loadImage() {
		image = new ImageIcon("resource\\images\\plant\\SnowPea\\SnowPea.gif");
		SnowPeaShooterCard.loadImage();
	}
	public static ImageIcon getImage() {
		return image;
	}
	
	public SnowPeaShooter(int posX, int posY, MainController mainController) {
		super(posX, posY, mainController);
		this.health = 100;
    	this.attackSpeed = 100;
    	coolDown = 80;
    	timer = coolDown;
    	price = 175;
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
			timer = attackSpeed;
			bullet = new Pea(posX, posY, mainController,true,false);
		}
		return bullet;
	}
}
