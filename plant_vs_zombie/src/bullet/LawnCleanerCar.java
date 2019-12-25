package bullet;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import controller.LineController;
import controller.MainController;
import zombie.BasicZombie;

public class LawnCleanerCar extends BasicBullet {
	
	
	public static ImageIcon carImage;
	
	public int generate;
	public static void loadImage() {
		carImage = new ImageIcon("resource\\images\\cleaner\\LawnCleaner.png");
	}
	public ImageIcon getImage() {
		return carImage;
	}
	
	public LawnCleanerCar(int posX, int posY, MainController mainController) {
		super(posX, posY, mainController);
		// 初始化属性
		power = 20000;
		speedX = 10;
		speedY = 0;
		label = new JLabel(getImage());
		label.setSize(getImage().getIconWidth(), getImage().getIconHeight());
		label.setBounds(posX, posY, getImage().getIconWidth(), getImage().getIconHeight());
	}
	
	public void move(int TorchArray[]) {
		posX += speedX;
		posY += speedY;
		
		label.setIcon(getImage());
		label.setBounds(posX, posY, getImage().getIconWidth(), getImage().getIconHeight());
	}
	public boolean ifBoom(LineController lineController) {
		int start = this.posX-80, end = this.posX+21;
		for(BasicZombie zombie: lineController.zombies) {
			//System.out.printf("start:%d end:%d zombie:%f\n", start,end,zombie.posX);
				if(zombie.posX <= end&&zombie.posX >= start) {
					//小推车直接推平
					zombie.health = 0;
					zombie.die(lineController.dieZombies, false);
					lineController.zombies.remove(zombie);		
				}
		}
		return false;
	}
}
