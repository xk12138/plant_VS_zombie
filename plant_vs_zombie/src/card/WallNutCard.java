package card;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import controller.MainController;
import plant.WallNut;

public class WallNutCard extends BasicCard {
	private static ImageIcon image;
	public static void loadImage() {
		image = new ImageIcon("resource\\images\\card\\plants\\WallNut_01.gif");
	}
	public static ImageIcon getImage() {
		return image;
	}
	
	public WallNutCard(MainController mainController) {
		super(mainController);
		label = new JLabel(getImage());
		addMouseListener(label);
		plant = new WallNut(0, 0, mainController);
		coolDown = plant.coolDown;
		label.setSize(cardWidth, cardHeight);
	}
	
	public WallNut getPlant(int posX, int posY) {
		return new WallNut(posX, posY, mainController);
	}
}

