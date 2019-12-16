package bullet;

/*
 * 基础子弹类，包含子弹的所有属性：
 * 子弹的位置： posX, posY
 * 子弹的速度： speedX, speedY
 * 子弹的威力： power
 * 子弹的图片： image
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

	// 移除了寒冰减速效果，构造寒冰类子弹的时候重载实现。
	
	public BasicBullet(int posX, int posY, MainController mainController) {
		this.posX = posX;
		this.posY = posY;
		this.mainController = mainController;
	}
	
	// 子弹移动
	public void move() {
		posX += speedX;
		posY += speedY;
	}
	
	// 检测子弹是否还可用（通过检测子弹位置）
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
					boom(zombie);		//目前只考虑单体输出
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
