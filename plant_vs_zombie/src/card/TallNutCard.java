package card;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import controller.MainController;
import plant.TallNut;

public class TallNutCard extends BasicCard {
	private static ImageIcon image;
	public static void loadImage() {
		image = new ImageIcon("resource\\images\\card\\plants\\TallNut_01.gif");
	}
	public static ImageIcon getImage() {
		return image;
	}
	
	public TallNutCard(MainController mainController) {
		super(mainController);
		label = new JLabel(getImage());
		addMouseListener(label);
		plant = new TallNut(0, 0, mainController);
		coolDown = plant.coolDown;
		label.setSize(cardWidth, cardHeight);
	}
	
	public TallNut getPlant(int posX, int posY) {
		return new TallNut(posX, posY, mainController);
	}
}


