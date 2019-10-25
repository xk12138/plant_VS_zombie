package zombie;

/*
 * 僵尸的基类：
 *  位置： posX、posY
 *  移动速度： speedX、speedY
 *  攻击力： power
 *  血量： health
 * */

public class BasicZombie {
	public int posX, posY;
	public int speedX, speedY;
	public int power;
	public int health;
	
	public BasicZombie(int posX, int posY) {
		this.posX = posX;
		this.posY = posY;
	}
}
