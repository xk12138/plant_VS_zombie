package plant;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import block.LawnBlock;
import bullet.Pea;
import card.PotatoMineCard;
import controller.MainController;
import zombie.BasicZombie;

public class PotatoMine extends BasicPlant {
	private static ImageIcon image1;
	private static ImageIcon imageReady;
	private static ImageIcon imageBoom;
	private static ImageIcon imageText;
	
	final private static int power = 1000;
	
	private PotatoMine text = null;
	
	private int readyTimer = 90;//准备计时器，到0说明可爆炸
	public static void loadImage() {
		image1 = new ImageIcon("resource\\images\\plant\\PotatoMine\\PotatoMineNotReady.gif");
		imageReady = new ImageIcon("resource\\images\\plant\\PotatoMine\\PotatoMine.gif");
		imageBoom = new ImageIcon("resource\\images\\plant\\PotatoMine\\PotatoMine_mashed.gif");
		imageText = new ImageIcon("resource\\images\\plant\\PotatoMine\\ExplosionSpudow.gif");
		
		PotatoMineCard.loadImage();
	}
	public ImageIcon getImage() {
		if(readyTimer > 1)
			return image1;
		else 
			return imageReady;
	}
	
	public PotatoMine(int posX, int posY, MainController mainController) {
		super(posX, posY, mainController);
		this.health = 100;
    	this.attackSpeed = 100;
    	coolDown = 80;
    	timer = coolDown;
    	price = 100;
    	label = new JLabel(getImage());
    	label.setSize(getImage().getIconWidth(), getImage().getIconHeight());
    	label.setBounds(posX, posY, getImage().getIconWidth(), getImage().getIconHeight());
	}
	
	public Pea attack(boolean zombieExist) {
		if(readyTimer > 0)
			readyTimer--;
		if(readyTimer == 1) {//变身，换图
			label.setIcon(getImage());
			label.setSize(getImage().getIconWidth(), getImage().getIconHeight());
	    	label.setBounds(posX, posY, getImage().getIconWidth(), getImage().getIconHeight());
		}
		
		if(dieTimer == 0) {
			mainController.mainViewer.removeLabel(label);
			mainController.mainViewer.removeLabel(text.label);
		}
		return null;
	}
	public boolean isEaten(int getPower) {
    	//被动效果，触发炸弹
		if(readyTimer == 0) {
			
	    	//杀死僵尸
	    	for(BasicZombie zombie:mainController.lineControllers[lineNum].zombies) {
	    		if(zombie.posX > this.posX - 1.6*LawnBlock.blockWidth &&
	    				zombie.posX < this.posX + LawnBlock.blockWidth*0.6) {
	    			zombie.health -= power;
	    			if(zombie.health <= 0) {
	    				zombie.die(mainController.lineControllers[lineNum].dieZombies, false);
						mainController.lineControllers[lineNum].zombies.remove(zombie);
	    			}
	    		}
	    	}
	    	readyTimer = 90;
	    	dieTimer = 30;
	    	//改自身的图
	    	label.setIcon(imageBoom);
	    	label.setSize(imageBoom.getIconWidth(), imageBoom.getIconHeight());
	    	label.setBounds(posX, posY, imageBoom.getIconWidth(), imageBoom.getIconHeight());
	    	// 新建一个文字的label
	    	text = new PotatoMine(posX,posY,mainController);
	    	text.dieTimer = 10;
	    	text.label.setIcon(imageText);
	    	text.label.setSize(imageText.getIconWidth(), imageText.getIconHeight());
	    	text.label.setBounds(posX, posY, imageText.getIconWidth(), imageText.getIconHeight());
	    	mainController.mainViewer.addLabel(text.label);
	    	
	    	
		}
    	//最普通模式
    	health -= getPower;
    	if(health > 0)
    		return false;
    	else
    		return true;
    }

}