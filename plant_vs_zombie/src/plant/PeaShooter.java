package plant;

import bullet.Pea;

public class PeaShooter extends BasicPlant {
	
	//public static Pea bullet(0,0);
	//��ʱ��¼����ֲ���Ӧ���ӵ���������bug������Ϊɶ����
	
	public PeaShooter() {
		this.health = 100;
    	this.attackSpeed = 100;
    	this.timer = 100;
    	coolDown = 50;
    	price = 100;
	}

}
