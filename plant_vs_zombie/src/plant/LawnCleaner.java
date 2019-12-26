
package plant;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import block.LawnBlock;
import bullet.LawnCleanerCar;
import controller.MainController;
import zombie.BasicZombie;

public class LawnCleaner extends BasicPlant {
	
	private static ImageIcon image;
	
	public static void loadImage() {
		image = new ImageIcon("resource\\images\\cleaner\\LawnCleaner.png");
	}
	public ImageIcon getImage() {
		return image;
	}
	
	public LawnCleaner(int posX, int posY, MainController mainController) {
		super(posX, posY, mainController);
		this.health = 10000;
    	coolDown = 0;
    	timer = coolDown;
    	price = 0;
    	label = new JLabel(getImage());
    	label.setSize(getImage().getIconWidth(), getImage().getIconHeight());
    	label.setBounds(posX, posY, getImage().getIconWidth(), getImage().getIconHeight());
    	mainController.mainViewer.addLabel(label);
	}
	
	public LawnCleanerCar attack(boolean zombieExist) {
		for(BasicZombie zombie:mainController.lineControllers[lineNum].zombies) {
			if(zombie.posX < this.posX  && zombie.posX > this.posX - 60) {
				mainController.backgroundAudio.add("resource\\audio\\used\\pool_cleaner.wav");
				//LawnCleanerCar car = new LawnCleanerCar(posX,posY,mainController);
				dieTimer = 0;//告诉行控制器，让行控制器来删除格子里的植物
				mainController.mainViewer.removeLabel(label);
				return new LawnCleanerCar(posX,posY,mainController);
			}
		}
		return null;
	}

}
