package zombie;

import javax.swing.JLabel;

/*
 * ��ʬ�Ļ��ࣺ
 *  λ�ã� posX��posY
 *  �ƶ��ٶȣ� speedX��speedY
 *  �������� power
 *  Ѫ���� health
 * */

public class BasicZombie {
	public int posX, posY;
	public int speedX, speedY;
	public int power;
	public int health;
	
	public JLabel label;
	
	// Debuff timer
	public int moderateTimer;
	private final int moderateCoolDown = 100;
	
	public BasicZombie(int posX, int posY) {
		this.posX = posX;
		this.posY = posY;
	}
	
	public void move() {
		if (moderateTimer > 0) {
			posX += (speedX / 2);
			posY += (speedY / 2);
			moderateTimer--;
		}
		else {
			posX += speedX;
			posY += speedY;
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
}
