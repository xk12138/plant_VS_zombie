package zombie;

import java.util.concurrent.CopyOnWriteArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import controller.MainController;

public class Zombie extends BasicZombie {
	public ImageIcon image;
	private ImageIcon imageMove;
	

	
	private void loadOtherImage() {
		//if((int)(Math.random()*3) == 1)
			//imageDie = imageLostHead;s
		//else	
		
		int rand = (int)(Math.random()*3);
		if(rand == 1)
			imageMove = imageZombieMove2;
		else if(rand == 2)
			imageMove = imageZombieMove3;
		else
			imageMove = imageZombieMove1;
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
		/*动态加载一些一次性图片，选择僵尸个性等*/
		loadOtherImage();
		/*选好了*/
		image = imageZombieStatic;
		label = new JLabel(getImage());
		this.posX = 1000;
		label.setSize(image.getIconWidth(), image.getIconHeight());
		label.setBounds((int)posX, (int)posY, image.getIconWidth(), image.getIconHeight());
	}
	public Zombie(double posX, double posY, MainController mainController) {
		super(posX, posY, mainController);
		health = 100;
		//power = 8;
		power = 20;
		attackSpeed = 20;
		timer = attackSpeed;
		speedX = 0.5;
		speedY = 0;
		/*动态加载一些一次性图片，选择僵尸个性等*/
		loadOtherImage();
		image = imageZombieStatic;
		label = new JLabel(getImage());
		this.posX = 1000;
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
			image = imageZombieAttack;
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
				image = imageZombieLostHeadAttack;
				timer = (int)(Math.random()*150);
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
