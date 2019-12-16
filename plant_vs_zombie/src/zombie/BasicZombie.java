package zombie;

import javax.swing.JLabel;

import controller.MainController;

/*
 * ��ʬ�Ļ��ࣺ
 *  λ�ã� posX��posY
 *  �ƶ��ٶȣ� speedX��speedY
 *  �������� power
 *  Ѫ���� health
 * */

public class BasicZombie {
	public double posX, posY;
	public double speedX, speedY;
	public int attackSpeed, timer;
	public int power;
	public int health;
	
	public JLabel label;
	public MainController mainController;
	
	// Debuff timer
	public int moderateTimer;
	private final int moderateCoolDown = 100;
	
	public BasicZombie(int posY, MainController mainController) {
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
	
	// ��ʬ������������������ȴ���
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
	public void die() {
		/*��������gif*/
		try { Thread.sleep ( 1000 ) ;
		} catch (InterruptedException ie){}
		mainController.mainViewer.removeLabel(this.label);
	}
}
