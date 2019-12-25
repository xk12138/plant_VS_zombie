package card;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import controller.MainController;
import plant.SnowPeaShooter;

public class SnowPeaShooterCard extends BasicCard {
	private static ImageIcon image;
	public static void loadImage() {
		image = new ImageIcon("resource\\images\\card\\plants\\SnowPea_01.gif");
	}
	public static ImageIcon getImage() {
		return image;
	}
	
	public SnowPeaShooterCard(MainController mainController) {
		super(mainController);
		label = new JLabel(getImage());
		addMouseListener(label);
		plant = new SnowPeaShooter(0, 0, mainController);
		coolDown = plant.coolDown;
		label.setSize(cardWidth, cardHeight);
	}
	
	public SnowPeaShooter getPlant(int posX, int posY) {
		return new SnowPeaShooter(posX, posY, mainController);
	}
}