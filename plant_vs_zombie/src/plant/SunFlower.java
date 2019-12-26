package plant;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import bullet.BasicBullet;
import card.SunFlowerCard;
import controller.MainController;
import sun.Sun;

public class SunFlower extends BasicPlant {
	private static ImageIcon image;
	private static ImageIcon imageReady;
	public static void loadImage() {
		image = new ImageIcon("resource\\images\\plant\\SunFlower\\SunFlower1.gif");
		imageReady = new ImageIcon("resource\\images\\plant\\SunFlower\\SunFlower.gif");
		SunFlowerCard.loadImage();
	}
	public static ImageIcon getImage() {
		return image;
	}
	
	
	public SunFlower(int posX, int posY, MainController mainController) {
		super(posX, posY, mainController);
		this.health = 100;
		this.coolDown = 300;
		this.timer = 600;
		this.attackSpeed = 700;
		this.price = 50;
		label = new JLabel(getImage());
		label.setSize(image.getIconWidth(), image.getIconHeight());
		label.setBounds(posX, posY, image.getIconWidth(), image.getIconHeight());
	}
	
	public BasicBullet attack(boolean zombieExist) {
		if(timer != 0) {
			timer--;
			if(timer == 30) {
				label.setIcon(imageReady);
			}
		}
		else {
			//œ»ªÿµΩ¿‰»¥◊¥Ã¨
			label.setIcon(image);
			
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
