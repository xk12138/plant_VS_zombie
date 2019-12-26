package plant;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import bullet.Pea;
import card.TallNutCard;
import controller.MainController;

public class TallNut extends BasicPlant {
	private static ImageIcon image3;
	private static ImageIcon image2;
	private static ImageIcon image1;
	
	final private static int totalHealth = 100;
	
	private int state;
	/*
	 * 3 : 血量在  66% ~ 100%
	 * 2：血量在 33% ~ 66%
	 * 1：血量在 33% ~ 0%
	 * 0：血量 0%
	*/
	
	public static void loadImage() {
		image3 = new ImageIcon("resource\\images\\plant\\TallNut\\TallNut.gif");
		image2 = new ImageIcon("resource\\images\\plant\\TallNut\\TallnutCracked1.gif");
		image1 = new ImageIcon("resource\\images\\plant\\TallNut\\TallNutCracked2.gif");
		TallNutCard.loadImage();
	}
	public static ImageIcon getImage() {
		return image3;
	}

	public TallNut(int posX, int posY, MainController mainController) {
		super(posX, posY, mainController);
		this.health = totalHealth;
		this.state = 3;
    	this.attackSpeed = 100;
    	coolDown = 80;
    	timer = coolDown;
    	price = 125;
    	label = new JLabel(getImage());
    	label.setSize(image3.getIconWidth(), image3.getIconHeight());
    	label.setBounds(posX, posY-40, image3.getIconWidth(), image3.getIconHeight());
	}
	public Pea attack(boolean zombieExist) {
		return null;
	}
	public boolean isEaten(int getPower) {

    	health -= getPower;
    	if(health > 0) {
    		if(health <= totalHealth/3 && state != 1) {
    			state = 1;
    			label.setIcon(image1);
    		}
    		if(health <= totalHealth*2/3 && health > totalHealth/3 && state != 2) {
    			state = 2;
    			label.setIcon(image2);
    		}
    		return false;
    	}
    	else
    		return true;
    }
}