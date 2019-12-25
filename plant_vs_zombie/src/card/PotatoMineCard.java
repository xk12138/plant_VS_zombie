package card;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import controller.MainController;
import plant.PotatoMine;

public class PotatoMineCard extends BasicCard {
	private static ImageIcon image;
	public static void loadImage() {
		image = new ImageIcon("resource\\images\\card\\plants\\PotatoMine_02.png");
	}
	public static ImageIcon getImage() {
		return image;
	}
	
	public PotatoMineCard(MainController mainController) {
		super(mainController);
		label = new JLabel(getImage());
		addMouseListener(label);
		plant = new PotatoMine(0, 0, mainController);
		coolDown = plant.coolDown;
		label.setSize(cardWidth, cardHeight);
	}
	
	public PotatoMine getPlant(int posX, int posY) {
		return new PotatoMine(posX, posY, mainController);
	}
}

