package bullet;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Pea extends BasicBullet {
	private static ImageIcon peaImage;
	public static void loadImage() {
		peaImage = new ImageIcon("../../resource/images/plant/PB00.gif");
	}
	public static ImageIcon getImage() {
		return peaImage;
	}
	
	public Pea(int posX, int posY) {
		super(posX, posY);
		// ≥ı ºªØ Ù–‘
		power = 1;
		speedX = 0;
		speedY = 20;
		label = new JLabel(getImage());
		label.setBounds(posY, posX, peaImage.getIconWidth(), peaImage.getIconHeight());
	}
	
	
}
