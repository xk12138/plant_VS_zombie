package card;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import controller.MainController;
import plant.Torchwood;

public class TorchwoodCard extends BasicCard {
	private static ImageIcon image;
	public static void loadImage() {
		image = new ImageIcon("resource\\images\\card\\plants\\Torchwood_02.png");
	}
	public static ImageIcon getImage() {
		return image;
	}
	
	public TorchwoodCard(MainController mainController) {
		super(mainController);
		label = new JLabel(getImage());
		addMouseListener(label);
		plant = new Torchwood(0, 0, mainController);
		coolDown = plant.coolDown;
		label.setSize(cardWidth, cardHeight);
	}
	
	public Torchwood getPlant(int posX, int posY) {
		return new Torchwood(posX, posY, mainController);
	}
}




