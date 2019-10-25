package bullet;

/*
 * 基础子弹类，包含子弹的所有属性：
 * 子弹的位置： posX, posY
 * 子弹的速度： speedX, speedY
 * 子弹的威力： power
 * 子弹的图片： image
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
	
	// 子弹移动
	public void move() {
		posX += speedX;
		posY += speedY;
		// System.out.printf("The bullet is moving: posX: %d, posY: %d\n", posX, posY);
	}
	
	// 检测子弹是否还可用（通过检测子弹位置）
	public boolean isAvaiable(int boundaryX, int boundaryY) {
		int padding = 20;
		return !(posX < -padding || posX > boundaryX + padding || posY < -padding || posY > boundaryY + padding);
	}
	public boolean isAvaiable(int boundaryX, int boundaryY, int padding) {
		return !(posX < -padding || posX > boundaryX + padding || posY < -padding || posY > boundaryY + padding);
	}
}
