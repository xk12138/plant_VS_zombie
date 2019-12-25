package bullet;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import controller.LineController;
import controller.MainController;
import zombie.BasicZombie;

public class Pea extends BasicBullet {
	
	final private static int snowZombieTime = 120;
	
	public boolean snow;
	public boolean fire;
	/*   		pea     snowPea    firePea
	 *  snow	0		1			0
 	 *  fire	0		0			1
	*/
	
	public static ImageIcon peaImage;
	public static ImageIcon peaImageHit;
	public static ImageIcon snowPeaImage;
	public static ImageIcon firePeaImage;
	public static ImageIcon firePeaImageHit;
	
	public int generate;
	public static void loadImage() {
		peaImage = new ImageIcon("resource\\images\\plant\\PB00.gif");
		peaImageHit = new ImageIcon("resource\\images\\plant\\PeaBulletHit.gif");
		snowPeaImage = new ImageIcon("resource\\images\\plant\\PB-10.gif");
		firePeaImage = new ImageIcon("resource\\images\\plant\\PB10.gif");
		firePeaImageHit = new ImageIcon("resource\\images\\plant\\Torchwood\\SputteringFire.gif");
	}
	public ImageIcon getImage() {
		if(snow == false && fire == false)
			return peaImage;
		else if(snow == true)
			return snowPeaImage;
		else 
			return firePeaImage;
	}
	
	public Pea(int posX, int posY, MainController mainController,boolean snow,boolean fire) {
		super(posX, posY, mainController);
		// 初始化属性
		// power = 10;
		power = 20;
		speedX = 10;//原来是6
		speedY = 0;
		generate = -1;
		this.snow = snow;
		this.fire = fire;
		label = new JLabel(getImage());
		label.setSize(getImage().getIconWidth(), getImage().getIconHeight());
		label.setBounds(posX, posY, getImage().getIconWidth(), getImage().getIconHeight());
	}
	
	public void move(int TorchArray[]) {
		posX += speedX;
		posY += speedY;
		int offset = 10;
		for(int i=0;i<11;i++) {
			if(posX >= TorchArray[i]-offset
				&& posX<=TorchArray[i]+offset) {
				System.out.printf("generate:%d\n", generate);
				if(this.generate != i) {
					//还未改变
					if(snow == true) {
						snow = false;
						fire = false;
					}else {
						snow = false;
						fire = true;
					}
					generate = i;
				}
			}
		}
		
		label.setIcon(getImage());
		label.setBounds(posX, posY, getImage().getIconWidth(), getImage().getIconHeight());
	}
	public boolean ifBoom(LineController lineController) {
		int start = this.posX-80, end = this.posX;
		for(BasicZombie zombie: lineController.zombies) {
			//System.out.printf("start:%d end:%d zombie:%f\n", start,end,zombie.posX);
				if(zombie.posX <= end&&zombie.posX >= start) {
					//子弹自身进入爆炸动画倒计时
					if(snow == false && fire == false) {
						//普通豌豆，有爆炸效果，更改图片信息
						timer = 4;
						label.setBounds(posX+60, posY-20, peaImageHit.getIconWidth(),peaImageHit.getIconHeight());
						label.setIcon(peaImageHit);
					}else if(snow == true) {
						//冰弹没有爆炸效果图
						zombie.snowZombie(snowZombieTime);
						timer = 0;
					}else {
						//火焰爆炸有效果图
						timer = 4;
						label.setBounds(posX+60, posY-30, firePeaImageHit.getIconWidth(),firePeaImageHit.getIconHeight());
						label.setIcon(firePeaImageHit);
					}
					
					boom(zombie);		//目前只考虑单体输出
					if(zombie.health <= 0) {

						zombie.die(lineController.dieZombies, false);
						lineController.zombies.remove(zombie);
						
					}
					return true;
				}
			
		}
		return false;
	}
	public void boom(BasicZombie zombie) {
		zombie.health -= power;
		if(fire == true)
			zombie.health -= power;
	}
}
