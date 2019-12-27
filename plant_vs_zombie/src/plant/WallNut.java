package plant;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import bullet.Pea;
import card.WallNutCard;
import controller.MainController;

public class WallNut extends BasicPlant {
	private static ImageIcon image3;
	private static ImageIcon image2;
	private static ImageIcon image1;
	
	final private static int totalHealth = 500;
	
	private int state;
	/*
	 * 3 : 血量在  66% ~ 100%
	 * 2：血量在 33% ~ 66%
	 * 1：血量在 33% ~ 0%
	 * 0：血量 0%
	*/
	
	public static void loadImage() {
		image3 = new ImageIcon("resource\\images\\plant\\WallNut\\WallNut.gif");
		image2 = new ImageIcon("resource\\images\\plant\\WallNut\\Wallnut_cracked1.gif");
		image1 = new ImageIcon("resource\\images\\plant\\WallNut\\WallNut_cracked2.gif");
		WallNutCard.loadImage();
	}
	public static ImageIcon getImage() {
		return image3;
	}

	public WallNut(int posX, int posY, MainController mainController) {
		super(posX, posY, mainController);
		this.health = totalHealth;
		this.state = 3;
    	this.attackSpeed = 100;
    	coolDown = 600;
    	timer = coolDown;
    	price = 50;
    	label = new JLabel(getImage());
    	label.setSize(image3.getIconWidth(), image3.getIconHeight());
    	label.setBounds(posX, posY, image3.getIconWidth(), image3.getIconHeight());
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