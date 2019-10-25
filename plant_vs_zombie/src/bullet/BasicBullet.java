package bullet;

/*
 * �����ӵ��࣬�����ӵ����������ԣ�
 * �ӵ���λ�ã� posX, posY
 * �ӵ����ٶȣ� speedX, speedY
 * �ӵ��������� power
 * �ӵ���ͼƬ�� image
 */

import javax.swing.JLabel;

public class BasicBullet {
	public int posX, posY;
	public int speedX, speedY;
	public int power;
	public JLabel label;
	
	// Buff
	boolean moderate;
	
	public BasicBullet(int posX, int posY) {
		this.posX = posX;
		this.posY = posY;
	}
	
	// �ӵ��ƶ�
	public void move() {
		posX += speedX;
		posY += speedY;
		// System.out.printf("The bullet is moving: posX: %d, posY: %d\n", posX, posY);
	}
	
	// ����ӵ��Ƿ񻹿��ã�ͨ������ӵ�λ�ã�
	public boolean isAvaiable(int boundaryX, int boundaryY) {
		int padding = 20;
		return !(posX < -padding || posX > boundaryX + padding || posY < -padding || posY > boundaryY + padding);
	}
	public boolean isAvaiable(int boundaryX, int boundaryY, int padding) {
		return !(posX < -padding || posX > boundaryX + padding || posY < -padding || posY > boundaryY + padding);
	}
}
