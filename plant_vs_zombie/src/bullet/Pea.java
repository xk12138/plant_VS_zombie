package bullet;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import controller.MainController;

public class Pea extends BasicBullet {
	private static ImageIcon peaImage;
	public static void loadImage() {
		peaImage = new ImageIcon("resource\\images\\plant\\PB00.gif");
	}
	public static ImageIcon getImage() {
		return peaImage;
	}
	
	public Pea(int posX, int posY, MainController mainController) {
		super(posX, posY, mainController);
		// ≥ı ºªØ Ù–‘
		power = 10;
		speedX = 6;
		speedY = 0;
		label = new JLabel(getImage());
		label.setSize(peaImage.getIconWidth(), peaImage.getIconHeight());
		label.setBounds(posX, posY, peaImage.getIconWidth(), peaImage.getIconHeight());
	}
	
	public void move() {
		posX += speedX;
		posY += speedY;
		label.setBounds(posX, posY, peaImage.getIconWidth(), peaImage.getIconHeight());
	}
}
