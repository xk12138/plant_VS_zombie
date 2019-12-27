package plant;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import block.LawnBlock;
import bullet.Pea;
import card.CherryBombCard;
import controller.MainController;
import zombie.BasicZombie;

public class CherryBomb extends BasicPlant {
	private static ImageIcon image1;
	private static ImageIcon imageBoom;
	
	final private static int power = 1000;
	
	final private static int TIME_TRANSFORM = 18;
	
	public static void loadImage() {
		image1 = new ImageIcon("resource\\images\\plant\\CherryBomb\\CherryBomb.gif");
		imageBoom = new ImageIcon("resource\\images\\plant\\CherryBomb\\Boom.gif");
		CherryBombCard.loadImage();
	}
	public ImageIcon getImage() {
		if(dieTimer > TIME_TRANSFORM)
			return image1;
		else 
			return imageBoom;
	}
	
	public CherryBomb(int posX, int posY, MainController mainController) {
		super(posX, posY, mainController);
		this.health = 100;
    	this.attackSpeed = 100;
    	dieTimer = 40;
    	coolDown = 750;
    	timer = coolDown;
    	price = 150;
    	label = new JLabel(getImage());
    	label.setSize(getImage().getIconWidth(), getImage().getIconHeight());
    	label.setBounds(posX, posY, getImage().getIconWidth(), getImage().getIconHeight());
	}
	
	public Pea attack(boolean zombieExist) {
		if(dieTimer == TIME_TRANSFORM) {
			label.setIcon(getImage());
			label.setSize(getImage().getIconWidth(), getImage().getIconHeight());
	    	label.setBounds(posX-60, posY-80, getImage().getIconWidth(), getImage().getIconHeight());
	    	//É±ËÀ½©Ê¬
	    	mainController.backgroundAudio.add("resource\\audio\\used\\cherrybomb.wav");
	    	for(BasicZombie zombie:mainController.lineControllers[lineNum].zombies) {
	    		if(zombie.posX > this.posX - 2.2*LawnBlock.blockWidth &&
	    				zombie.posX < this.posX + LawnBlock.blockWidth*0.8) {
	    			zombie.health -= power;
	    			if(zombie.health <= 0) {
	    				zombie.die(mainController.lineControllers[lineNum].dieZombies, true);
						mainController.lineControllers[lineNum].zombies.remove(zombie);
	    			}
	    		}
	    	}
	    	if(lineNum-1 >= 0)
	    		for(BasicZombie zombie:mainController.lineControllers[lineNum-1].zombies) {
		    		if(zombie.posX > this.posX - 1.4*LawnBlock.blockWidth &&
		    				zombie.posX < this.posX + LawnBlock.blockWidth*0.3) {
		    			zombie.health -= power;
		    			if(zombie.health <= 0) {
		    				zombie.die(mainController.lineControllers[lineNum-1].dieZombies, true);
							mainController.lineControllers[lineNum-1].zombies.remove(zombie);
		    			}
		    		}
		    	}
	    	if(lineNum+1 < mainController.lineNum)
	    		for(BasicZombie zombie:mainController.lineControllers[lineNum+1].zombies) {
		    		if(zombie.posX > this.posX - 1.4*LawnBlock.blockWidth &&
		    				zombie.posX < this.posX + LawnBlock.blockWidth*0.3) {
		    			zombie.health -= power;
		    			if(zombie.health <= 0) {
		    				zombie.die(mainController.lineControllers[lineNum+1].dieZombies, true);
							mainController.lineControllers[lineNum+1].zombies.remove(zombie);
		    			}
		    		}
		    	}
	   
		}
		else if(dieTimer == 0) {
			mainController.mainViewer.removeLabel(label);
		}
		return null;
	}

}

