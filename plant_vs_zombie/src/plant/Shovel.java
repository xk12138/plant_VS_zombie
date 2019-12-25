package plant;

import javax.swing.ImageIcon;

import controller.MainController;

public class Shovel extends BasicPlant {
	private static ImageIcon image;
	public static void loadImage() {
		image = new ImageIcon("resource\\images\\interface\\SlantShovel.png");
	}
	
	public static ImageIcon getImage() {
		return image;
	}
	
	public Shovel(int posX, int posY, MainController mainController) {
		super(posX, posY, mainController);
	}
	
	public boolean isShovel() {
		return true;
	}
}
