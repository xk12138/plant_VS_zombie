package zombie;

import java.util.concurrent.CopyOnWriteArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import controller.MainController;

/*
 * 僵尸的基类：
 *  位置： posX、posY
 *  移动速度： speedX、speedY
 *  攻击力： power
 *  血量： health
 * */

public class BasicZombie {
	public double posX, posY;
	public double speedX, speedY;
	public int attackSpeed, timer;
	public int power;
	public int health;
	
	public final int STATIC = 0;
	public final int MOVE = 1;
	public final int ATTACK = 2;
	public final int DIE = 3;
	public final int SLOW = 4;
	public final int ACTION = 5;
	
	public final int TIME_DIE = 25;
	public final int TIME_FOOTBALL_DIE = 20;

	public final int TIME_HEAD = 18;
	public final int TIME_BOOM = 38;
	
	public int state = STATIC;
	
	
	public JLabel label;
	
	public static ImageIcon imageZombieDie;
	public static ImageIcon imageZombieBoomDie;
	public static ImageIcon imageZombieHead;
	public static ImageIcon imageZombieLostHeadAttack;
	public static ImageIcon imageZombieStatic;
	public static ImageIcon imageZombieLostHead;
	public static ImageIcon imageZombieAttack;
	public static ImageIcon imageZombieSlowMove;
	public static ImageIcon imageZombieMove1;
	public static ImageIcon imageZombieMove2;
	public static ImageIcon imageZombieMove3;
	
	
	

	
	
	
	public static void loadImage() {
		/*加载图片*/
		;
	}
	
	public MainController mainController;
	
	// Debuff timer
	public int moderateTimer;
	private final int moderateCoolDown = 100;
	
	public BasicZombie(int posY, MainController mainController) {
		this.posY = posY;
		this.mainController = mainController;
	}
	public BasicZombie(double posX, double posY, MainController mainController) {
		this.posY = posY;
		this.mainController = mainController;
	}
	
	public void move() {
		if (moderateTimer > 0) {
			posX -= (speedX / 2);
			posY -= (speedY / 2);
			moderateTimer--;
		}
		else {
			posX -= speedX;
			posY -= speedY;
		}
	}
	
	// 僵尸攻击函数，传入参数等待定
//	public void attack(BasicBlock block) {
//		block.plant.health -= power;
//		if(block.plant.health <= 0) {
//			block.plant = null;
//		}
//	}
	
	public void setModerateTimer() {
		moderateTimer = moderateCoolDown;
	}
	
	public int getPosX() {
		return (int)posX;
	}
	
	public int getPower() {
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
		/*进入死亡gif*/
		
		mainController.mainViewer.removeLabel(this.label);
	}
}
