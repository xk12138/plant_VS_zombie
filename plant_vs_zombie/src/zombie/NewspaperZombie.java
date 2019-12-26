package zombie;

import java.util.concurrent.CopyOnWriteArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import controller.MainController;

public class NewspaperZombie extends BasicZombie {
	public ImageIcon image;
	private ImageIcon imageMove;
	private ImageIcon imageAttack;
	
	public static ImageIcon imageNewspaperZombieStatic;
	public static ImageIcon imageNewspaperZombieMove;
	public static ImageIcon imageNewspaperZombieAttack;
	public static ImageIcon imageNewspaperZombieLostNewspaper;
	public static ImageIcon imageNewspaperZombieLostMove;
	public static ImageIcon imageNewspaperZombieLostAttack;
	public static ImageIcon imageNewspaperZombieDie;
	public static ImageIcon imageNewspaperZombieLostHead;
	public static ImageIcon imageNewspaperZombieLostHeadAttack;
	public static ImageIcon imageNewspaperZombieHead;
	
	private int normalHealth;
	private boolean normal;
	private int actionTimer;
	
	public final int TIME_NEWSPAPER_DIE = 22;
	public final int TIME_NEWSPAPER_HEAD = 15;
	
	public static void loadImage() {
		imageNewspaperZombieStatic = new ImageIcon("resource\\images\\zombie\\NewspaperZombie\\1.gif");
		imageNewspaperZombieMove = new ImageIcon("resource\\images\\zombie\\NewspaperZombie\\HeadWalk1.gif");
		imageNewspaperZombieAttack = new ImageIcon("resource\\images\\zombie\\NewspaperZombie\\HeadAttack1.gif");
		imageNewspaperZombieLostNewspaper = new ImageIcon("resource\\images\\zombie\\NewspaperZombie\\LostNewspaper.gif");
		imageNewspaperZombieLostMove = new ImageIcon("resource\\images\\zombie\\NewspaperZombie\\HeadWalk0.gif");
		imageNewspaperZombieLostAttack = new ImageIcon("resource\\images\\zombie\\NewspaperZombie\\HeadAttack0.gif");
		imageNewspaperZombieDie = new ImageIcon("resource\\images\\zombie\\NewspaperZombie\\Die.gif");
		imageNewspaperZombieLostHead = new ImageIcon("resource\\images\\zombie\\NewspaperZombie\\LostHeadWalk0.gif");
		imageNewspaperZombieLostHeadAttack = new ImageIcon("resource\\images\\zombie\\NewspaperZombie\\LostHeadAttack0.gif");
		imageNewspaperZombieHead = new ImageIcon("resource\\images\\zombie\\NewspaperZombie\\Head.gif");
	}
	private void loadOtherImage() {
		
		imageMove = imageNewspaperZombieMove;
		imageAttack = imageNewspaperZombieAttack;
	}
	public ImageIcon getImage() {
		return image;
	}
	
	public NewspaperZombie(MainController mainController) {
		super(mainController);
		normalHealth = 100;
		normal = false;
		health = 200;
		power = 8;
		attackSpeed = 20;
		timer = attackSpeed;
		speedX = 0.5;
		speedY = 0;
		actionTimer = 20;
		/*动态加载一些一次性图片，选择僵尸个性等*/
		loadOtherImage();
		/*选好了*/
		image = imageNewspaperZombieStatic;
		label = new JLabel(getImage());
		this.posX = 1000;
		label.setSize(image.getIconWidth(), image.getIconHeight());
	}
	public NewspaperZombie(int posY, MainController mainController) {
		super(posY, mainController);
		normalHealth = 100;
		normal = false;
		health = 200;
		power = 8;
		attackSpeed = 20;
		timer = attackSpeed;
		speedX = 0.5;
		speedY = 0;
		actionTimer = 20;
		/*动态加载一些一次性图片，选择僵尸个性等*/
		loadOtherImage();
		/*选好了*/
		image = imageNewspaperZombieStatic;
		label = new JLabel(getImage());
		this.posX = 1000;
		label.setSize(image.getIconWidth(), image.getIconHeight());
		label.setBounds((int)posX, (int)posY, image.getIconWidth(), image.getIconHeight());
	}
	private void action() {
		if(actionTimer != 0)
			actionTimer--;
		else {
			state = MOVE;
			normal = true;
			imageMove = imageNewspaperZombieLostMove;
			imageAttack = imageNewspaperZombieLostAttack;
			speedX = 2.5;
			image = imageMove;
			label.setIcon(image);
		}
	}
	public void move() {
		if(state == ACTION) {//变身期间，不操作
			action();
			return ;
		}else {
		if(health<=normalHealth&&normal == false) {//变身准备
			normal = true;
			state = ACTION;
			image = imageNewspaperZombieLostNewspaper;
			label.setIcon(image);
			return ;
		}
		//正常情况
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
		
	}
	public int getPower() {
		if(moderateTimer >= 0)
			moderateTimer--;
		if(state == ACTION) {//变身期间，不操作
			action();
			return 0;
		}
		if(health<normalHealth&&normal == false) {//变身准备
			normal = true;
			state = ACTION;
			image = imageNewspaperZombieLostNewspaper;
			label.setIcon(image);
			return 0;
		}
		//正常情况
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
	public void die(CopyOnWriteArrayList<BasicZombie> dieZombies, boolean isBoom) {
		
		if(isBoom) {//直接炸死
			image = imageZombieBoomDie;
			label.setIcon(image);
			timer = TIME_BOOM;
			dieZombies.add(this);
		}
		else {//人头分离
		
			if(state == ATTACK) {
				image = imageNewspaperZombieLostHeadAttack;
				timer = (int)(Math.random()*150);
			}
			else if((int)(Math.random()*3) == 1) {
				image = imageNewspaperZombieLostHead;
				timer = (int)(Math.random()*150);
			}else {
				image = imageNewspaperZombieDie;
				timer = TIME_NEWSPAPER_DIE;
			}
			label.setIcon(image);
			dieZombies.add(this);
			Zombie head = new Zombie(posX, posY, mainController);
			head.image = imageNewspaperZombieHead;
			head.label.setIcon(head.image);
			head.timer = TIME_NEWSPAPER_HEAD;
			dieZombies.add(head);
			mainController.mainViewer.addLabel(head.label);
		}
		
		
	}
	
}

