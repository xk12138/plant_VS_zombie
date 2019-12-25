package viewer;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import bullet.LawnCleanerCar;
import bullet.Pea;
import card.ShovelCard;
import controller.MainController;
import controller.ZombieController;
import plant.CherryBomb;
import plant.Jalapeno;
import plant.LawnCleaner;
import plant.PeaShooter;
import plant.PotatoMine;
import plant.Repeater;
import plant.SnowPeaShooter;
import plant.SunFlower;
import plant.TallNut;
import plant.Torchwood;
import plant.WallNut;
import sun.Sun;
import zombie.BucketZombie;
import zombie.ConeheadZombie;
import zombie.FlagZombie;
import zombie.FootballZombie;
import zombie.NewspaperZombie;
import zombie.Zombie;

@SuppressWarnings("serial")
public class StartViewer extends JFrame {
	public ImageIcon startImg = new ImageIcon("resource\\images\\interface\\Selector1H.png");
	public ImageIcon endImg = new ImageIcon("resource\\images\\interface\\Selector1L.png");
	
	public StartViewer() {
		super("ֲ���ս��ʬ");
		
		JLabel label = new JLabel(startImg);
		label.setBounds(575, 120, startImg.getIconWidth(), startImg.getIconHeight());
		label.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				label.setIcon(endImg);
			}
			public void mouseExited(MouseEvent e) {
				label.setIcon(startImg);
			}
			public void mouseClicked(MouseEvent e) {
				new MainController();
			}
		});
		this.add(label);
		
		ImageIcon image = new ImageIcon("resource\\images\\interface\\Selector2L.png");
		JLabel t = new JLabel(image);
		t.setBounds(575, 180, image.getIconWidth(), image.getIconHeight());
		this.add(t);
		image = new ImageIcon("resource\\images\\interface\\Selector3L.png");
		t = new JLabel(image);
		t.setBounds(575, 240, image.getIconWidth(), image.getIconHeight());
		this.add(t);
		image = new ImageIcon("resource\\images\\interface\\Selector4L.png");
		t = new JLabel(image);
		t.setBounds(575, 300, image.getIconWidth(), image.getIconHeight());
		this.add(t);
		
		image = new ImageIcon("resource\\images\\interface\\Surface.png");
		JLabel bg = new JLabel(image);
		bg.setBounds(0, 0, 1110, 750);
		this.add(bg);
		
		this.setBounds(0, 0, 1110, 750);
		this.setLayout(null);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		//���������ӵ���ͼƬ
		Pea.loadImage();
		LawnCleanerCar.loadImage();
		//�������п�Ƭ��ͼƬ
		ShovelCard.loadImage();
		//��������ֲ���ͼƬ
		PeaShooter.loadImage();
		SunFlower.loadImage();
		Repeater.loadImage();
		SnowPeaShooter.loadImage();
		TallNut.loadImage();
		WallNut.loadImage();
		Torchwood.loadImage();
		Jalapeno.loadImage();
		CherryBomb.loadImage();
		PotatoMine.loadImage();
		
		LawnCleaner.loadImage();
		//��������̫����ͼƬ
		Sun.loadImage();
		
		//�������н�ʬ��ͼƬ
		Zombie.loadImage();
		ConeheadZombie.loadImage();
		BucketZombie.loadImage();
		FlagZombie.loadImage();
		NewspaperZombie.loadImage();
		FootballZombie.loadImage();
		//������ͼƬ
		ZombieController.loadImage();
		
		new StartViewer();
	}
}
