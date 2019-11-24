package plant;

import bullet.Pea;

public class PeaShooter extends BasicPlant {
	
	//public static Pea bullet(0,0);
	//��ʱ��¼����ֲ���Ӧ���ӵ���������bug������Ϊɶ����
	
	public PeaShooter(int posX, int posY) {
		super(posX, posY);
		this.health = 100;
    	this.attackSpeed = 100;
    	coolDown = 50;
    	timer = coolDown;
    	price = 100;
	}
	
	public Pea attack(boolean zombieExist) {
		Pea bullet = null;
		if(timer != 0) {
			timer--;
		}
		else if(zombieExist) {
			timer = coolDown;
			bullet = new Pea(posX, posY);
		}
		return bullet;
	}
}
