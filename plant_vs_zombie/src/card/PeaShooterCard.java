package card;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import controller.MainController;
import plant.PeaShooter;

public class PeaShooterCard extends BasicCard {
	private static ImageIcon image;
	public static void loadImage() {
		image = new ImageIcon("resource\\images\\card\\plants\\Peashooter_02.png");
	}
	public static ImageIcon getImage() {
		return image;
	}
	
	public PeaShooterCard(MainController mainController) {
		super(mainController);
		label = new JLabel(getImage());
		addMouseListener(label);
		plant = new PeaShooter(0, 0, mainController);
		coolDown = plant.coolDown;
		label.setSize(cardWidth, cardHeight);
	}
	
	public PeaShooter getPlant(int posX, int posY) {
		return new PeaShooter(posX, posY, mainController);
	}
}
