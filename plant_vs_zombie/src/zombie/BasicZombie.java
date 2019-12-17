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
	public final int TIME_NEWSPAPER_DIE = 25;
	public final int TIME_NEWSPAPER_HEAD = 25;
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
	
	public static ImageIcon imageConeheadZombieStatic;
	public static ImageIcon imageConeheadZombieMove;
	public static ImageIcon imageConeheadZombieAttack;
	
	public static ImageIcon imageFlagZombieStatic;
	public static ImageIcon imageFlagZombieMove;
	public static ImageIcon imageFlagZombieAttack;
	public static ImageIcon imageFlagZombieLostHead;
	public static ImageIcon imageFlagZombieLostHeadAttack;
	
	public static ImageIcon imageBucketZombieStatic;
	public static ImageIcon imageBucketZombieMove;
	public static ImageIcon imageBucketZombieAttack;
	
	public static ImageIcon imageFootballZombieStatic;
	public static ImageIcon imageFootballZombieDie;
	public static ImageIcon imageFootballZombieMove;
	public static ImageIcon imageFootballZombieOrnLostMove;
	public static ImageIcon imageFootballZombieAttack;
	public static ImageIcon imageFootballZombieOrnLostAttack;
	public static ImageIcon imageFootballZombieLostHead;
	public static ImageIcon imageFootballZombieLostHeadAttack;
	
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
	
	
	
	public static void loadImage() {
		imageZombieStatic = new ImageIcon("resource\\images\\zombie\\Zombie\\1.gif");
		imageZombieMove1 = new ImageIcon("resource\\images\\zombie\\Zombie\\Zombie.gif");
		imageZombieLostHead = new ImageIcon("resource\\images\\zombie\\Zombie\\ZombieLostHead.gif");
		imageZombieAttack = new ImageIcon("resource\\images\\zombie\\Zombie\\ZombieAttack.gif");
		imageZombieLostHeadAttack = new ImageIcon("resource\\images\\zombie\\Zombie\\ZombieLostHeadAttack.gif");
		imageZombieSlowMove = new ImageIcon("resource\\images\\zombie\\Zombie\\SnowZombie.gif");
		imageZombieMove2 = new ImageIcon("resource\\images\\zombie\\Zombie\\Zombie2.gif");
		imageZombieMove3 = new ImageIcon("resource\\images\\zombie\\Zombie\\Zombie3.gif");
		imageZombieHead = new ImageIcon("resource\\images\\zombie\\Zombie\\ZombieHead.gif");
		imageZombieBoomDie = new ImageIcon("resource\\images\\zombie\\Zombie\\BoomDie.gif");
		imageZombieDie = new ImageIcon("resource\\images\\zombie\\Zombie\\ZombieDie.gif");
		
		imageConeheadZombieStatic = new ImageIcon("resource\\images\\zombie\\ConeheadZombie\\1.gif");
		imageConeheadZombieMove = new ImageIcon("resource\\images\\zombie\\ConeheadZombie\\ConeheadZombie.gif");
		imageConeheadZombieAttack = new ImageIcon("resource\\images\\zombie\\ConeheadZombie\\ConeheadZombieAttack.gif");
		
		imageFlagZombieStatic = new ImageIcon("resource\\images\\zombie\\FlagZombie\\1.gif");
		imageFlagZombieMove = new ImageIcon("resource\\images\\zombie\\FlagZombie\\FlagZombie.gif");
		imageFlagZombieAttack = new ImageIcon("resource\\images\\zombie\\FlagZombie\\FlagZombieAttack.gif");
		imageFlagZombieLostHead = new ImageIcon("resource\\images\\zombie\\FlagZombie\\FlagZombieLostHead.gif");
		imageFlagZombieLostHeadAttack = new ImageIcon("resource\\images\\zombie\\FlagZombie\\FlagZombieLostHeadAttack.gif");
		
		imageBucketZombieStatic =  new ImageIcon("resource\\images\\zombie\\BucketheadZombie\\1.gif");
		imageBucketZombieMove =  new ImageIcon("resource\\images\\zombie\\BucketheadZombie\\BucketheadZombie.gif");
		imageBucketZombieAttack =  new ImageIcon("resource\\images\\zombie\\BucketheadZombie\\BucketheadZombieAttack.gif");
		
		imageFootballZombieStatic = new ImageIcon("resource\\images\\zombie\\FootballZombie\\1.gif");
		imageFootballZombieAttack = new ImageIcon("resource\\images\\zombie\\FootballZombie\\Attack.gif");
		imageFootballZombieMove = new ImageIcon("resource\\images\\zombie\\FootballZombie\\FootballZombie.gif");
		imageFootballZombieOrnLostMove = new ImageIcon("resource\\images\\zombie\\FootballZombie\\FootballZombieOrnLost.gif");
		imageFootballZombieOrnLostAttack = new ImageIcon("resource\\images\\zombie\\FootballZombie\\FootballZombieOrnLostAttack.gif");
		imageFootballZombieDie = new ImageIcon("resource\\images\\zombie\\FootballZombie\\Die.gif");
		imageFootballZombieLostHead = new ImageIcon("resource\\images\\zombie\\FootballZombie\\LostHead.gif");
		imageFootballZombieLostHeadAttack = new ImageIcon("resource\\images\\zombie\\FootballZombie\\LostHeadAttack.gif");

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
