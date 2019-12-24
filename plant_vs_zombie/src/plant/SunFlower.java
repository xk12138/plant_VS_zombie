package plant;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import bullet.BasicBullet;
import controller.MainController;
import sun.Sun;

public class SunFlower extends BasicPlant {
	private static ImageIcon image;
	public static void loadImage() {
		image = new ImageIcon("resource\\images\\plant\\SunFlower\\SunFlower1.gif");
	}
	public static ImageIcon getImage() {
		return image;
	}
	
	public SunFlower(int posX, int posY, MainController mainController) {
		super(posX, posY, mainController);
		this.health = 100;
		this.coolDown = 1500;
		this.timer = 600;
		this.attackSpeed = 2400;
		this.price = 50;
		label = new JLabel(getImage());
		label.setSize(image.getIconWidth(), image.getIconHeight());
		label.setBounds(posX, posY, image.getIconWidth(), image.getIconHeight());
	}
	
	public BasicBullet attack(boolean zombieExist) {
		if(timer != 0) {
			timer--;
		}
		else {
			Sun sun = new Sun(posX, posY, posY, mainController);
			mainController.sunController.suns.add(sun);
			mainController.mainViewer.remove(label);
			mainController.mainViewer.addLabel(sun.label);
			mainController.mainViewer.addLabel(label);
			timer = attackSpeed;
		}
		
		return null;
	}
}
