package bullet;

import javax.swing.ImageIcon;

/*
 * 基础子弹类，包含子弹的所有属性：
 * 子弹的位置： posX, posY
 * 子弹的速度： speedX, speedY
 * 子弹的威力： power
 * 子弹的图片： image
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
	
	
	public int timer;//子弹爆炸动画计时器，平时处于-1，爆炸后改为正数

	// 移除了寒冰减速效果，构造寒冰类子弹的时候重载实现。
	
	public BasicBullet(int posX, int posY, MainController mainController) {
		this.posX = posX;
		this.posY = posY;
		this.mainController = mainController;
		this.timer = -1;
	}
	
	// 子弹移动
	public void move(int TorchArray[]) {
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
	
	public boolean ifBoom(LineController lineController) {
	
		return false;
		/*
		 * 设定一个区间
		 * 遍历每一个僵尸是否在区间内
		 * 若在，子弹爆炸，僵尸承伤，若僵尸承伤后死亡，僵尸死亡函数
		 * 最后根据子弹是否爆炸返回boolean
		 * */
	}
}
