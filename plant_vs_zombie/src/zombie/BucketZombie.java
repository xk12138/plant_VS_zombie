package zombie;


import java.util.concurrent.CopyOnWriteArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import controller.MainController;


public class BucketZombie extends BasicZombie {
	private ImageIcon image;
	private ImageIcon imageMove;
	private ImageIcon imageAttack;

	public static ImageIcon imageBucketZombieStatic;
	public static ImageIcon imageBucketZombieMove;
	public static ImageIcon imageBucketZombieAttack;
	
	private int normalHealth;
	private boolean normal;
	
	public static void loadImage() {
		imageBucketZombieStatic =  new ImageIcon("resource\\images\\zombie\\BucketheadZombie\\1.gif");
		imageBucketZombieMove =  new ImageIcon("resource\\images\\zombie\\BucketheadZombie\\BucketheadZombie.gif");
		imageBucketZombieAttack =  new ImageIcon("resource\\images\\zombie\\BucketheadZombie\\BucketheadZombieAttack.gif");
	
	}
	private void loadOtherImage() {
		imageMove = imageBucketZombieMove;
		imageAttack = imageBucketZombieAttack;
	}
	public ImageIcon getImage() {
		return image;
	}
	
	public BucketZombie(MainController mainController) {
		super(mainController);
		normalHealth = 100;
		normal = false;
		health = 300;
		power = 8;
		attackSpeed = 20;
		timer = attackSpeed;
		speedX = 0.5;
		speedY = 0;
		/*动态加载一些一次性图片，选择僵尸个性等*/
		loadOtherImage();
		/*选好了*/
		image = imageBucketZombieStatic;
		label = new JLabel(getImage());
		this.posX = 1000;
		label.setSize(image.getIconWidth(), image.getIconHeight());
	}
	public BucketZombie(int posY, MainController mainController) {
		super(posY, mainController);
		normalHealth = 100;
		normal = false;
		health = 300;
		power = 8;
		attackSpeed = 20;
		timer = attackSpeed;
		speedX = 0.5;
		speedY = 0;
		/*动态加载一些一次性图片，选择僵尸个性等*/
		loadOtherImage();
		/*选好了*/
		image = imageBucketZombieStatic;
		label = new JLabel(getImage());
		this.posX = 1000;
		label.setSize(image.getIconWidth(), image.getIconHeight());
		
		label.setBounds((int)posX, (int)posY, image.getIconWidth(), image.getIconHeight());
	}
	
	public void move() {
		if(health < normalHealth&&normal == false) {
			normal = true;
			imageAttack = imageZombieAttack;
			imageMove = imageZombieMove1;
			image = imageMove;
			label.setIcon(image);
		}
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
		if(health < normalHealth&&normal == false) {
			normal = true;
			imageAttack = imageZombieAttack;
			imageMove = imageZombieMove1;
			image = imageAttack;
			label.setIcon(image);
		}
		if(state != ATTACK) {
			image = imageAttack;
			label.setIcon(image);
			state = ATTACK;
		}
		if(moderateTimer >= 0)
			moderateTimer--;
		
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
			mainController.backgroundAudio.add("resource\\audio\\used\\shoop.wav");
			if(state == ATTACK) {
				image = imageZombieLostHeadAttack;
				timer = (int)(Math.random()*120);
			}
			else if((int)(Math.random()*3) == 1) {
				image = imageZombieLostHead;
				timer = (int)(Math.random()*150);
			}else {
				image = imageZombieDie;
				timer = TIME_DIE;
			}
			label.setIcon(image);
			dieZombies.add(this);
			Zombie head = new Zombie(posX, posY, mainController);
			head.image = imageZombieHead;
			head.label.setIcon(head.image);
			head.timer = TIME_HEAD;
			dieZombies.add(head);
			mainController.mainViewer.addLabel(head.label);
		}
		
		
	}
	
}
