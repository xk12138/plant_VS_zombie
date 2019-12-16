package bullet;

/*
 * �����ӵ��࣬�����ӵ����������ԣ�
 * �ӵ���λ�ã� posX, posY
 * �ӵ����ٶȣ� speedX, speedY
 * �ӵ��������� power
 * �ӵ���ͼƬ�� image
 */

import javax.swing.JLabel;

import controller.MainController;

import java.util.concurrent.CopyOnWriteArrayList;
import zombie.BasicZombie;

public class BasicBullet {
	public int posX, posY;
	public int speedX, speedY;
	public int power;
	public JLabel label;
	public MainController mainController;

	// �Ƴ��˺�������Ч�������캮�����ӵ���ʱ������ʵ�֡�
	
	public BasicBullet(int posX, int posY, MainController mainController) {
		this.posX = posX;
		this.posY = posY;
		this.mainController = mainController;
	}
	
	// �ӵ��ƶ�
	public void move() {
		posX += speedX;
		posY += speedY;
	}
	
	// ����ӵ��Ƿ񻹿��ã�ͨ������ӵ�λ�ã�
	public boolean isAvaliable(int boundary) {
		return !(posX >= boundary || posX <= 0);
	}
	
	public void boom(BasicZombie zombie) {
		zombie.health -= power;
	}
	
	public boolean ifBoom(CopyOnWriteArrayList<BasicZombie> zombies) {
		int start = posX, end = posX + speedX;
		for(BasicZombie zombie: zombies) {
			if(zombie.posX >= start) {
				if(zombie.posX <= end) {
					boom(zombie);		//Ŀǰֻ���ǵ������
					if(zombie.health <= 0) {
						zombies.remove(zombie);
						zombie.die();
					}
					return true;
				}
				else {
					return false;
				}
			}
		}
		return false;
	}
}
