package plant;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import bullet.Pea;
import card.JalapenoCard;
import controller.MainController;
import zombie.BasicZombie;

public class Jalapeno extends BasicPlant {
	private static ImageIcon image1;
	private static ImageIcon imageBoom;
	
	final private static int power = 1000;
	
	final private static int TIME_TRANSFORM = 10;
	
	private Jalapeno fireLine;
	public static void loadImage() {
		image1 = new ImageIcon("resource\\images\\plant\\Jalapeno\\Jalapeno.gif");
		imageBoom = new ImageIcon("resource\\images\\plant\\Jalapeno\\JalapenoAttack.gif");
		JalapenoCard.loadImage();
	}
	public ImageIcon getImage() {
		if(dieTimer > TIME_TRANSFORM)
			return image1;
		else 
			return imageBoom;
	}
	
	public Jalapeno(int posX, int posY, MainController mainController) {
		super(posX, posY, mainController);
		this.health = 100;
    	this.attackSpeed = 100;
    	dieTimer = 35;
    	coolDown = 80;
    	timer = coolDown;
    	price = 125;
    	fireLine = null;
    	label = new JLabel(getImage());
    	label.setSize(getImage().getIconWidth(), getImage().getIconHeight());
    	label.setBounds(posX, posY-20, getImage().getIconWidth(), getImage().getIconHeight());
	}
	
	public Pea attack(boolean zombieExist) {
		//System.out.printf("dieTimer:%d\n", dieTimer);
		if(dieTimer == TIME_TRANSFORM) {
			label.setIcon(getImage());
			label.setSize(getImage().getIconWidth(), getImage().getIconHeight());
	    	label.setBounds(0, posY-50, getImage().getIconWidth(), getImage().getIconHeight());
	    	//…±À¿Ω© ¨
	    	for(BasicZombie zombie:mainController.lineControllers[lineNum].zombies) {
	    		zombie.health -= power;
	    		if(zombie.health <= 0) {
	    			zombie.die(mainController.lineControllers[lineNum].dieZombies, true);
					mainController.lineControllers[lineNum].zombies.remove(zombie);
	    		}
	    	}
	    	//ª—Ê–ßπ˚
	    	fireLine = new Jalapeno(0,posY,mainController);
	    	fireLine.dieTimer = 10;
	    	fireLine.label.setIcon(getImage());
	    	fireLine.label.setSize(getImage().getIconWidth(), getImage().getIconHeight());
	    	fireLine.label.setBounds(600, posY-50, getImage().getIconWidth(), getImage().getIconHeight());
	    	mainController.mainViewer.addLabel(fireLine.label);
		}
		else if(dieTimer == 0) {
			mainController.mainViewer.removeLabel(label);
			mainController.mainViewer.removeLabel(fireLine.label);
		}
		return null;
	}

}
