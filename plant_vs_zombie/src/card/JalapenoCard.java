package card;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import controller.MainController;
import plant.Jalapeno;

public class JalapenoCard extends BasicCard {
	private static ImageIcon image;
	public static void loadImage() {
		image = new ImageIcon("resource\\images\\card\\plants\\Jalapeno_02.png");
	}
	public static ImageIcon getImage() {
		return image;
	}
	
	public JalapenoCard(MainController mainController) {
		super(mainController);
		label = new JLabel(getImage());
		addMouseListener(label);
		plant = new Jalapeno(0, 0, mainController);
		coolDown = plant.coolDown;
		label.setSize(cardWidth, cardHeight);
	}
	
	public Jalapeno getPlant(int posX, int posY) {
		return new Jalapeno(posX, posY, mainController);
	}
}

