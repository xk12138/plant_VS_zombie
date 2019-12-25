package card;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import controller.MainController;
import plant.Shovel;

public class ShovelCard extends BasicCard {
	private static ImageIcon image;
	public static void loadImage() {
		image = new ImageIcon("resource\\images\\interface\\Shovel.png");
	}
	
	public static ImageIcon getImage() {
		return image;
	}
	
	
	public ShovelCard(MainController mainController) {
		super(mainController);
		
		label = new JLabel(getImage());
		addMouseListener(label);
		plant = new Shovel(0, 0, mainController);
		label.setSize(cardWidth, cardHeight);
		coolDown = 0;
	}
}
