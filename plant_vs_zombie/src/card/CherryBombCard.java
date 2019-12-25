package card;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import controller.MainController;
import plant.CherryBomb;

public class CherryBombCard extends BasicCard {
	private static ImageIcon image;
	public static void loadImage() {
		image = new ImageIcon("resource\\images\\card\\plants\\CherryBomb_02.png");
	}
	public static ImageIcon getImage() {
		return image;
	}
	
	public CherryBombCard(MainController mainController) {
		super(mainController);
		label = new JLabel(getImage());
		addMouseListener(label);
		plant = new CherryBomb(0, 0, mainController);
		coolDown = plant.coolDown;
		label.setSize(cardWidth, cardHeight);
	}
	
	public CherryBomb getPlant(int posX, int posY) {
		return new CherryBomb(posX, posY, mainController);
	}
}

