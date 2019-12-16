package zombie;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import controller.MainController;

public class Zombie extends BasicZombie {
	private ImageIcon image;
	private static ImageIcon imageStatic;
	private static ImageIcon imageDie;
	private static ImageIcon imageBoomDie;
	private static ImageIcon imageHead;
	private static ImageIcon imageLostHeadMove;
	private static ImageIcon imageLostHeadAttack;
	private static ImageIcon imageAttack;
	private static ImageIcon imageSlowMove;
	private ImageIcon imageMove;
	private static ImageIcon imageMove1;
	private static ImageIcon imageMove2;
	private static ImageIcon imageMove3;
	
	final int STATIC = 0;
	final int MOVE = 1;
	final int ATTACK = 2;
	final int DIE = 3;
	
	private int state = STATIC;
	
	public static void loadImage() {
		imageStatic = new ImageIcon("resource\\images\\zombie\\Zombie\\1.gif");
		imageMove1 = new ImageIcon("resource\\images\\zombie\\Zombie\\Zombie.gif");
		imageDie = new ImageIcon("resource\\images\\zombie\\Zombie\\ZombieDie.gif");
		imageHead = new ImageIcon("resource\\images\\zombie\\Zombie\\ZombieHead.gif");
		imageLostHeadMove = new ImageIcon("resource\\images\\zombie\\Zombie\\ZombieLostHead.gif");
		imageLostHeadAttack = new ImageIcon("resource\\images\\zombie\\Zombie\\ZombieLostHeadAttack.gif");
		imageBoomDie = new ImageIcon("resource\\images\\zombie\\Zombie\\BoomDie.gif");
		imageAttack = new ImageIcon("resource\\images\\zombie\\Zombie\\ZombieAttack.gif");
		imageSlowMove = new ImageIcon("resource\\images\\zombie\\Zombie\\SnowZombie.gif");
		imageMove2 = new ImageIcon("resource\\images\\zombie\\Zombie\\Zombie2.gif");
		imageMove3 = new ImageIcon("resource\\images\\zombie\\Zombie\\Zombie3.gif");
	}
	public ImageIcon getImage() {
		return image;
	}
	
	public Zombie(int posY, MainController mainController) {
		super(posY, mainController);
		health = 100;
		power = 8;
		attackSpeed = 20;
		timer = attackSpeed;
		speedX = 0.5;
		speedY = 0;
		/*选一个固定的移动姿势*/
		int rand = (int)(Math.random()*3);
		if(rand == 1)
			imageMove = imageMove2;
		else if(rand == 2)
			imageMove = imageMove3;
		else
			imageMove = imageMove1;		
		/*选好了*/
		image = imageStatic;
		label = new JLabel(getImage());
		this.posX = 900;
		label.setSize(image.getIconWidth(), image.getIconHeight());
		label.setBounds((int)posX, (int)posY, image.getIconWidth(), image.getIconHeight());
	}
	
	public void move() {
		if(state != MOVE) {
			state = MOVE;
			image = imageMove;
			label.setIcon(image);
		}
		if (moderateTimer > 0) {
			posX -= (speedX / 2);
			posY -= (speedY / 2);
			moderateTimer--;
		}
		else {
			posX -= speedX;
			posY -= speedY;
		}
		label.setBounds((int)posX, (int)posY, image.getIconWidth(), image.getIconHeight());
	}
	public int getPower() {
		if(state != ATTACK) {
			image = imageAttack;
			label.setIcon(image);
			state = ATTACK;
		}
		if(timer == 0) {
			timer = attackSpeed;
			return power;
		}
		else {
			timer--;
			return 0;
		}
	}
	public void die() {
		image = imageBoomDie;
		label.setIcon(image);
		try { Thread.sleep ( 1000 ) ;
		} catch (InterruptedException ie){}
		mainController.mainViewer.removeLabel(this.label);
	}
}
