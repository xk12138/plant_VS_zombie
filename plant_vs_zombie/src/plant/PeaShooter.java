package plant;

import bullet.Pea;

public class PeaShooter extends BasicPlant {
	
	//public static Pea bullet(0,0);
	//暂时记录这种植物对应的子弹，但是有bug，不懂为啥报错
	
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
