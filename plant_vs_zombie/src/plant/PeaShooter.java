package plant;

import bullet.Pea;

public class PeaShooter extends BasicPlant {
	
	//public static Pea bullet(0,0);
	//暂时记录这种植物对应的子弹，但是有bug，不懂为啥报错
	
	public PeaShooter() {
		this.health = 100;
    	this.attackSpeed = 100;
    	this.timer = 100;
    	coolDown = 50;
    	price = 100;
	}

}
