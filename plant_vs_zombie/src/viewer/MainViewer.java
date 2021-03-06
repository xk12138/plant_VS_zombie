package viewer;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;

import audio.BasicAudio;
import block.BasicBlock;
import bullet.BasicBullet;
import card.TorchwoodCard;
import controller.MainController;
import plant.LawnCleaner;
import zombie.BasicZombie;
import zombie.BucketZombie;
import zombie.ConeheadZombie;
import zombie.FlagZombie;
import zombie.FootballZombie;
import zombie.NewspaperZombie;
import zombie.Zombie;

@SuppressWarnings("serial")
public class MainViewer extends JFrame {
	// 界面类属性
	public Container container;
	public JLayeredPane layeredPane;
	public JPanel jp, blockPanel;
	
	public MainController mainController;
	
	JLabel jl;
	// 用于显示太阳数的Label
	public JLabel sumSun;
	
	//用于显示进度条
	ImageIcon head = new ImageIcon("resource\\images\\interface\\FlagMeterParts1.png");
	ImageIcon empty = new ImageIcon("resource\\images\\interface\\FlagMeterEmptyCut.png");
	ImageIcon full = new ImageIcon("resource\\images\\interface\\FlagMeterFull.png");
	ImageIcon flag = new ImageIcon("resource\\images\\interface\\FlagMeterParts2.png");
	JLabel FlagMeterEmpty;
	JLabel FlagMeterHead;
	int sum_len;
	int step_len;
	//用于打印前动画
	ImageIcon prepare1 = new ImageIcon("resource\\images\\interface\\Prepare1.png");
	ImageIcon prepare2 = new ImageIcon("resource\\images\\interface\\Prepare2.png");
	ImageIcon prepare3 = new ImageIcon("resource\\images\\interface\\Prepare3.png");
	JLabel prepareLabel;
	//用于打印结束动画
	ImageIcon letter = new ImageIcon("resource\\images\\interface\\ZombieNote.png");
	ImageIcon lose = new ImageIcon("resource\\images\\interface\\ZombiesWon.png");
	JLabel afterLabel;
	
	public void setMainController(MainController mainController) {
		this.mainController = mainController;
	}
	public void afterView(boolean win) {
		mainController.backgroundAudio.change("resource\\audio\\used\\null.wav");
		//mainController.backgroundAudio.stop();
		if(win == true)
			winView();
		else 
			loseView();
		StartViewer.startAudio.change("resource\\audio\\used\\Theme.wav");
		this.dispose();
	}
	private void winView() {
		mainController.backgroundAudio.add("resource\\audio\\used\\winmusic.wav");
		JLabel afterLabel = new JLabel(letter);
		afterLabel.setBounds(200, 150, letter.getIconWidth(), letter.getIconHeight());
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		addLabel(afterLabel);
		repaintLabels();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		removeLabel(afterLabel);
	}
	private void loseView() {
		mainController.backgroundAudio.add("resource\\audio\\used\\losemusicScream.wav");
		JLabel afterLabel = new JLabel(lose);
		afterLabel.setBounds(350, 150, lose.getIconWidth(), lose.getIconHeight());
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i = -150;i < 0;i++) {
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			jl.setBounds(i, -30, 1710, 750);
			for(int j = 0;j<mainController.lineNum;j++) {
				for(BasicBlock block:mainController.lineControllers[j].blocks) {
					if(block.plant != null)
						block.plant.label.setBounds(block.plant.posX+i+150, block.plant.posY, block.plant.label.getIcon().getIconWidth(), block.plant.label.getIcon().getIconHeight());		
				}
				for(BasicZombie zombie:mainController.lineControllers[j].zombies) {
					zombie.label.setBounds((int)zombie.posX+i+150, (int)zombie.posY, zombie.label.getIcon().getIconWidth(), zombie.label.getIcon().getIconHeight());
				}
				for(BasicZombie zombie:mainController.lineControllers[j].dieZombies) {
					zombie.label.setBounds((int)zombie.posX+i+150, (int)zombie.posY, zombie.label.getIcon().getIconWidth(), zombie.label.getIcon().getIconHeight());
				}
				for(BasicBullet bullet:mainController.lineControllers[j].bullets) {
					bullet.label.setBounds(bullet.posX+i+150, bullet.posY, bullet.label.getIcon().getIconWidth(), bullet.label.getIcon().getIconHeight());
				}
			}
		
		}
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		addLabel(afterLabel);
		repaintLabels();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void repaintLabels() {
		for(int j = 0;j<mainController.lineNum;j++) {
			for(BasicBlock block:mainController.lineControllers[j].blocks) {
				if(block.plant != null)
					repaintLabel(block.plant.label);
			}
			for(BasicZombie zombie:mainController.lineControllers[j].zombies) {
				repaintLabel(zombie.label);
			}
			for(BasicZombie zombie:mainController.lineControllers[j].dieZombies) {
				repaintLabel(zombie.label);
			}
			for(BasicBullet bullet:mainController.lineControllers[j].bullets) {
				repaintLabel(bullet.label);
			}
		}
		removeLabel(jl);
		addLabel(jl);
	}
	public void preVideo() {
		BasicAudio choice = new BasicAudio("resource\\audio\\used\\choice.wav");
		double flash = 3;
		JLabel image1 = new JLabel(Zombie.imageZombieStatic);
		JLabel image2 = new JLabel(ConeheadZombie.imageConeheadZombieStatic);
		JLabel image3 = new JLabel(BucketZombie.imageBucketZombieStatic);
		JLabel image4 = new JLabel(FlagZombie.imageFlagZombieStatic);
		JLabel image5 = new JLabel(FootballZombie.imageFootballZombieStatic);
		JLabel image6 = new JLabel(NewspaperZombie.imageNewspaperZombieStatic);
		
		image1.setBounds(1260+160, 500, Zombie.imageZombieStatic.getIconWidth(), Zombie.imageZombieStatic.getIconHeight());
		image2.setBounds(1260+60, 270, ConeheadZombie.imageZombieStatic.getIconWidth(), ConeheadZombie.imageZombieStatic.getIconHeight());
		image3.setBounds(1260+80, 620, BucketZombie.imageZombieStatic.getIconWidth(), BucketZombie.imageZombieStatic.getIconHeight());
		image4.setBounds(1260+100, 346, FlagZombie.imageFlagZombieStatic.getIconWidth(), FlagZombie.imageFlagZombieStatic.getIconHeight());
		image5.setBounds(1260+10, 550, FootballZombie.imageFootballZombieStatic.getIconWidth(), ConeheadZombie.imageZombieStatic.getIconHeight());
		image6.setBounds(1260+140, 180, NewspaperZombie.imageNewspaperZombieStatic.getIconWidth(), NewspaperZombie.imageNewspaperZombieStatic.getIconHeight());

		addLabel(image1);
		addLabel(image2);
		addLabel(image3);
		addLabel(image4);
		addLabel(image5);
		addLabel(image6);
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i = 0;i > -500;i--) {
			try {
				Thread.sleep((long)flash);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//jl.setIcon(new ImageIcon("resource\\images\\interface\\background1SL.jpg"));
			jl.setBounds(i, -30, 1710, 750);
			image1.setBounds(1110+150+200+i, 500, Zombie.imageZombieStatic.getIconWidth(), Zombie.imageZombieStatic.getIconHeight());
			image2.setBounds(1260+5+i, 70, ConeheadZombie.imageZombieStatic.getIconWidth(), ConeheadZombie.imageZombieStatic.getIconHeight());
			image3.setBounds(1260+80+i, 420, BucketZombie.imageZombieStatic.getIconWidth(), BucketZombie.imageZombieStatic.getIconHeight());
			image4.setBounds(1260+100+i, 146, FlagZombie.imageFlagZombieStatic.getIconWidth(), FlagZombie.imageFlagZombieStatic.getIconHeight());
			image5.setBounds(1260+10+i, 350, FootballZombie.imageFootballZombieStatic.getIconWidth(), ConeheadZombie.imageZombieStatic.getIconHeight());
			image6.setBounds(1260+140+i, 80, NewspaperZombie.imageNewspaperZombieStatic.getIconWidth(), NewspaperZombie.imageNewspaperZombieStatic.getIconHeight());
			
			if(i == -300)
				flash = 2;
			
		}
		try {
			Thread.sleep((long)4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i=-500;i < -150;i++) {
			try {
				Thread.sleep((long)flash);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//jl.setIcon(new ImageIcon("resource\\images\\interface\\background1SL.jpg"));
			jl.setBounds(i, -30, 1710, 750);
			image1.setBounds(1110+150+200+i, 500, Zombie.imageZombieStatic.getIconWidth(), Zombie.imageZombieStatic.getIconHeight());
			image2.setBounds(1260+5+i, 70, ConeheadZombie.imageZombieStatic.getIconWidth(), ConeheadZombie.imageZombieStatic.getIconHeight());
			image3.setBounds(1260+80+i, 420, BucketZombie.imageZombieStatic.getIconWidth(), BucketZombie.imageZombieStatic.getIconHeight());
			image4.setBounds(1260+100+i, 146, FlagZombie.imageFlagZombieStatic.getIconWidth(), FlagZombie.imageFlagZombieStatic.getIconHeight());
			image5.setBounds(1260+10+i, 350, FootballZombie.imageFootballZombieStatic.getIconWidth(), ConeheadZombie.imageZombieStatic.getIconHeight());
			image6.setBounds(1260+140+i, 80, NewspaperZombie.imageNewspaperZombieStatic.getIconWidth(), NewspaperZombie.imageNewspaperZombieStatic.getIconHeight());

			if(i == -300)
				flash = 3;
		}
		removeLabel(image1);
		removeLabel(image2);
		removeLabel(image3);
		removeLabel(image4);
		removeLabel(image5);
		removeLabel(image6);
		
		//换音乐
		choice.stop();
		BasicAudio duang = new BasicAudio("resource\\audio\\used\\readysetplant.wav");
		duang.setLoop(false);
		
		prepareLabel = new JLabel(prepare1);
		prepareLabel.setBounds(400, 300, prepare1.getIconWidth(), prepare1.getIconHeight());
		addLabel(prepareLabel);
		
			try {
				Thread.sleep(400);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		removeLabel(prepareLabel);
		prepareLabel.setIcon(prepare2);
		prepareLabel.setBounds(400, 300, prepare2.getIconWidth(), prepare2.getIconHeight());
		
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		addLabel(prepareLabel);
		
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		removeLabel(prepareLabel);
		prepareLabel.setIcon(prepare3);
		prepareLabel.setBounds(400, 300, prepare3.getIconWidth(), prepare3.getIconHeight());
	
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		addLabel(prepareLabel);
		mainController.plantAvailable = true;
		//draw
		for(int i=0;i<5;i++) {
			mainController.lineControllers[i].blocks.get(0).plant 
			= new LawnCleaner(mainController.lineControllers[i].blocks.get(0).posX,mainController.lineControllers[i].blocks.get(0).posY,mainController);
			try {
				Thread.sleep((long)200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		removeLabel(prepareLabel);
		mainController.backgroundAudio = new BasicAudio("resource\\audio\\used\\LawnGarden.wav");
		duang.stop();
		
	}
	public MainViewer() {
		super("Plant VS Zombie");
		this.setIconImage(new ImageIcon("resource\\images\\interface\\SmallLogo.png").getImage());
		this.container = this.getContentPane();
		
		
		// 增加窗口的内容
		layeredPane = new JLayeredPane();
	
		ImageIcon image = new ImageIcon("resource\\images\\interface\\background1SL.jpg");
		//image = new ImageIcon()
		
		jp = new JPanel();
		jp.setLayout(null);
		jp.setBounds(0, 0, 1110, 750);
		layeredPane.add(jp, 0);
		
		jl = new JLabel(image);
		//jl.setSize(image.getIconWidth(), image.getIconHeight());
		jl.setBounds(0, -30, 1710, 750);
		jp.add(jl);
		jp.repaint();
		//开场动画
		
		
		// 创建方块层
		blockPanel = new JPanel();
		blockPanel.setBounds(0, 0, 1110, 750);
		blockPanel.setLayout(null);
		blockPanel.setOpaque(false);
		layeredPane.add(blockPanel, -1);
		
		

		// 绘制太阳总数的边框
		sumSun = new JLabel("25");
		sumSun.setBounds(60, 5, 120, 30);
		jp.add(sumSun);
		ImageIcon sunBack = new ImageIcon("resource\\images\\interface\\SunBack.png");
		JLabel back = new JLabel(sunBack);
		back.setBounds(0, 0, sunBack.getIconWidth(), sunBack.getIconHeight());
		jp.add(back);
		
		
		// 窗口被关闭时释放所有资源
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				super.windowClosing(e);
				StartViewer.startAudio.change("resource\\audio\\used\\Theme.wav");
				mainController.backgroundAudio.stop();
				
			}
		});
		
		// 让窗口显示出来
		this.setLayeredPane(layeredPane);
		this.setSize(1110, 750);
		this.setVisible(true);
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		
	}
	
	public void draw() {
		for(int i=0;i<mainController.lineNum;i++) {
			for(BasicBlock block: mainController.lineControllers[i].blocks) {
				blockPanel.add(block.label);
			}
		}
		//将所有的card添加进窗口来显示
	}
	
	public void addLabel(JLabel label) {
		jp.remove(jl);
		jp.add(label);
		
		jp.add(jl);
		jp.repaint();
		
	}
	public void removeLabel(JLabel label) {
		jp.remove(label);
		jp.repaint();
	}
	public void repaintLabel(JLabel label) {
		jp.remove(label);
		jp.add(label);
	}
	
	public void initFlagMeter(int batch) {
		// 绘制关卡进度条
		
		sum_len = 145;
		step_len = 145/(batch*5);

		FlagMeterHead = new JLabel(head);
		FlagMeterHead.setBounds(840 + sum_len, 675, head.getIconWidth(), head.getIconHeight());
		jp.add(FlagMeterHead);

		JLabel FlagMeterFlag = new JLabel(flag);
		FlagMeterFlag.setBounds(860, 675, flag.getIconWidth(), flag.getIconHeight());
		jp.add(FlagMeterFlag);
		int length = 145 / batch;
		for(int i=1;i<batch;i++) {
			FlagMeterFlag = new JLabel(flag);
			FlagMeterFlag.setBounds(860 + length*i, 675, flag.getIconWidth(), flag.getIconHeight());
			jp.add(FlagMeterFlag);
		}
		
		ImageIcon process = new ImageIcon("resource\\images\\interface\\FlagMeterLevelProgress.png");
		JLabel FlagMeterProcess = new JLabel(process);
		FlagMeterProcess.setBounds(883, 686, process.getIconWidth(), process.getIconHeight());
		addLabel(FlagMeterProcess);
		//jp.add(FlagMeterProcess);
		
		FlagMeterEmpty = new JLabel(empty);
		FlagMeterEmpty.setBounds(855, 675, empty.getIconWidth(), empty.getIconHeight());
		jp.add(FlagMeterEmpty);
		JLabel FlagMeterFull = new JLabel(full);
		FlagMeterFull.setBounds(850, 675, full.getIconWidth(), full.getIconHeight());
		jp.add(FlagMeterFull);
	}
	
	public void next_batch() {
		sum_len -= step_len;
		if(sum_len > 0) {
			FlagMeterHead.setBounds(840 + sum_len, 675, head.getIconWidth(), head.getIconHeight());
			FlagMeterEmpty.setSize(sum_len, empty.getIconHeight());
		}
	}
}
