package card;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import controller.MainController;
import plant.SunFlower;

public class SunFlowerCard extends BasicCard {
	private static ImageIcon image;
	public static void loadImage() {
		image = new ImageIcon("resource\\images\\card\\plants\\SunFlower_02.png");
	}
	public static ImageIcon getImage() {
		return image;
	}
	
	public SunFlowerCard(MainController mainController) {
		super(mainController);
		label = new JLabel(getImage());
		addMouseListener(label);
		plant = new SunFlower(0, 0, mainController);
		coolDown = plant.coolDown;
		label.setSize(cardWidth, cardHeight);
	}
	
	public SunFlower getPlant(int posX, int posY) {
		return new SunFlower(posX, posY, mainController);
	}
}
