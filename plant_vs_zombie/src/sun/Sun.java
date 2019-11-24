package sun;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import controller.MainController;

public class Sun extends BasicSun {
	private static ImageIcon image;
	public static void loadImage() {
		image = new ImageIcon("resource\\images\\interface\\Sun.gif");
	}
	
	public static ImageIcon getImage() {
		return image;
	}
	
	public Sun(int targetX, int posY, int targetY, MainController mainController) {
		super(targetX, posY, targetY, mainController);
		energy = 25;
		label = new JLabel(getImage());
		label.setSize(image.getIconWidth(), image.getIconHeight());
		label.setBounds(targetX, posY, image.getIconWidth(), image.getIconHeight());
	}
	
	public void move() {
		if(posY <= targetY) {
			posY += speedY;
		}
		label.setBounds(targetX, posY, image.getIconWidth(), image.getIconHeight());
	}
}
