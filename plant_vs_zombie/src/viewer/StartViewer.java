package viewer;

import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import audio.BasicAudio;
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
	public ImageIcon startImg = new ImageIcon("resource\\images\\interface\\Selector1L.png");
	public ImageIcon endImg = new ImageIcon("resource\\images\\interface\\Selector1H.png");
	
	public Container container;
	private BasicAudio startAudio; 
	public StartViewer() {
		super("植物大战僵尸 ");
		this.setIconImage(new ImageIcon("resource\\images\\interface\\SmallLogo.png").getImage());
		this.container = this.getContentPane();
		
		//添音乐
		startAudio = new BasicAudio("resource\\audio\\used\\Faster.wav");
		
		JLabel label = new JLabel(startImg);
		label.setBounds(575, 60, startImg.getIconWidth(), startImg.getIconHeight());
		label.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				label.setIcon(endImg);
			}
			public void mouseExited(MouseEvent e) {
				label.setIcon(startImg);
			}
			public void mouseClicked(MouseEvent e) {
				startAudio.stop();
				new MainController();
			}
		});
		this.add(label);
		
		ImageIcon image = new ImageIcon("resource\\images\\interface\\Selector2L.png");
		JLabel t = new JLabel(image);
		t.setBounds(575, 190, image.getIconWidth(), image.getIconHeight());
		this.add(t);
		image = new ImageIcon("resource\\images\\interface\\Selector3L.png");
		t = new JLabel(image);
		t.setBounds(575, 300, image.getIconWidth(), image.getIconHeight());
		this.add(t);
		image = new ImageIcon("resource\\images\\interface\\Selector4L.png");
		t = new JLabel(image);
		t.setBounds(575, 400, image.getIconWidth(), image.getIconHeight());
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
		//加载所有子弹的图片
		Pea.loadImage();
		LawnCleanerCar.loadImage();
		//加载所有卡片的图片
		ShovelCard.loadImage();
		//加载所有植物的图片
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
		//加载所有太阳的图片
		Sun.loadImage();
		
		//加载所有僵尸的图片
		Zombie.loadImage();
		ConeheadZombie.loadImage();
		BucketZombie.loadImage();
		FlagZombie.loadImage();
		NewspaperZombie.loadImage();
		FootballZombie.loadImage();
		//控制器图片
		ZombieController.loadImage();
		
		new StartViewer();
	}
}
