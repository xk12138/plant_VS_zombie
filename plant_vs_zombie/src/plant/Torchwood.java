package plant;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import bullet.Pea;
import card.TorchwoodCard;
import controller.MainController;

public class Torchwood extends BasicPlant {
	private static ImageIcon image3;
	
	public static void loadImage() {
		
		image3 = new ImageIcon("resource\\images\\plant\\Torchwood\\Torchwood.gif");
		TorchwoodCard.loadImage();
	}
	public static ImageIcon getImage() {
		return image3;
	}

	public Torchwood(int posX, int posY, MainController mainController) {
		super(posX, posY, mainController);
		this.health = 100;
    	coolDown = 80;
    	timer = coolDown;
    	price = 100;
    	label = new JLabel(getImage());
    	label.setSize(image3.getIconWidth(), image3.getIconHeight());
    	label.setBounds(posX, posY, image3.getIconWidth(), image3.getIconHeight());
    	if(posX != 0)
    		mainController.lineControllers[lineNum].addTorch(posX);
	}
	
	public Pea attack(boolean zombieExist) {
		
		return null;
	}
	public boolean isEaten(int getPower) {
    	health -= getPower;
    	if(health > 0) 
    		return false;
    	else{
    		mainController.lineControllers[lineNum].removeTorch(posX);
    		return true;
    	}
    }
}



