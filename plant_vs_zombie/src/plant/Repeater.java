package plant;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import bullet.Pea;
import card.RepeaterCard;
import controller.MainController;

public class Repeater extends BasicPlant {
	private static ImageIcon image;
	private static int doubleShootTime = 10;
	
	public static void loadImage() {
		image = new ImageIcon("resource\\images\\plant\\Repeater\\Repeater.gif");
		RepeaterCard.loadImage();
	}
	public static ImageIcon getImage() {
		return image;
	}
	
	public Repeater(int posX, int posY, MainController mainController) {
		super(posX, posY, mainController);
		this.health = 100;
    	this.attackSpeed = 100;
    	coolDown = 80;
    	timer = coolDown;
    	price = 200;
    	label = new JLabel(getImage());
    	label.setSize(image.getIconWidth(), image.getIconHeight());
    	label.setBounds(posX, posY, image.getIconWidth(), image.getIconHeight());
	}
	
	public Pea attack(boolean zombieExist) {
		Pea bullet = null;
		
		if(zombieExist) {
			if(timer == doubleShootTime) {
				timer--;
				bullet = new Pea(posX,posY,mainController,false,false);
			}else if(timer <= 0) {
				timer = attackSpeed;
				bullet = new Pea(posX,posY,mainController,false,false);
			}else {
				timer--;
			}
		}
		
		return bullet;
	}
}