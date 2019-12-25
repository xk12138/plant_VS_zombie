package card;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import controller.MainController;
import plant.Repeater;

public class RepeaterCard extends BasicCard {
	private static ImageIcon image;
	public static void loadImage() {
		image = new ImageIcon("resource\\images\\card\\plants\\Repeater_01.gif");
	}
	public static ImageIcon getImage() {
		return image;
	}
	
	public RepeaterCard(MainController mainController) {
		super(mainController);
		label = new JLabel(getImage());
		addMouseListener(label);
		plant = new Repeater(0, 0, mainController);
		coolDown = plant.coolDown;
		label.setSize(cardWidth, cardHeight);
	}
	
	public Repeater getPlant(int posX, int posY) {
		return new Repeater(posX, posY, mainController);
	}
}
