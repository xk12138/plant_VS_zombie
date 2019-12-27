package plant;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import bullet.Pea;
import card.PeaShooterCard;
import controller.MainController;

public class PeaShooter extends BasicPlant {
	private static ImageIcon image;
	public static void loadImage() {
		image = new ImageIcon("resource\\images\\plant\\Peashooter\\Peashooter.gif");
		PeaShooterCard.loadImage();
	}
	public static ImageIcon getImage() {
		return image;
	}
	
	public PeaShooter(int posX, int posY, MainController mainController) {
		super(posX, posY, mainController);
		this.health = 100;
    	this.attackSpeed = 60;
    	coolDown = 200;
    	timer = coolDown;
    	price = 100;
    	label = new JLabel(getImage());
    	label.setSize(image.getIconWidth(), image.getIconHeight());
    	label.setBounds(posX, posY , image.getIconWidth(), image.getIconHeight());
	}
	
	public Pea attack(boolean zombieExist) {
		Pea bullet = null;
		if(timer != 0) {
			timer--;
		}
		else if(zombieExist) {
			mainController.backgroundAudio.add("resource\\audio\\used\\kernelpult.wav");
			timer = attackSpeed;
			bullet = new Pea(posX, posY, mainController,false,false);
		}
		return bullet;
	}
}
