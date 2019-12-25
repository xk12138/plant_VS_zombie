package bullet;

import javax.swing.ImageIcon;

/*
 * �����ӵ��࣬�����ӵ����������ԣ�
 * �ӵ���λ�ã� posX, posY
 * �ӵ����ٶȣ� speedX, speedY
 * �ӵ��������� power
 * �ӵ���ͼƬ�� image
 */

import javax.swing.JLabel;

import controller.LineController;
import controller.MainController;

import java.util.concurrent.CopyOnWriteArrayList;
import zombie.BasicZombie;

public class BasicBullet {
	
	public int posX, posY;
	public int speedX, speedY;
	public int power;
	public JLabel label;
	public MainController mainController;
	
	
	public int timer;//�ӵ���ը������ʱ����ƽʱ����-1����ը���Ϊ����

	// �Ƴ��˺�������Ч�������캮�����ӵ���ʱ������ʵ�֡�
	
	public BasicBullet(int posX, int posY, MainController mainController) {
		this.posX = posX;
		this.posY = posY;
		this.mainController = mainController;
		this.timer = -1;
	}
	
	// �ӵ��ƶ�
	public void move(int TorchArray[]) {
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
	
	public boolean ifBoom(LineController lineController) {
	
		return false;
		/*
		 * �趨һ������
		 * ����ÿһ����ʬ�Ƿ���������
		 * ���ڣ��ӵ���ը����ʬ���ˣ�����ʬ���˺���������ʬ��������
		 * �������ӵ��Ƿ�ը����boolean
		 * */
	}
}
