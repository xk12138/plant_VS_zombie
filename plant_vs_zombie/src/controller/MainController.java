package controller;

import bullet.Pea;
import card.BasicCard;
import card.PeaShooterCard;
import card.SunFlowerCard;
import plant.PeaShooter;
import plant.SunFlower;
import sun.Sun;
import viewer.*;
import zombie.BucketZombie;
import zombie.ConeheadZombie;
import zombie.FlagZombie;
import zombie.FootballZombie;
import zombie.NewspaperZombie;
import zombie.Zombie;

public class MainController implements Runnable {
	// connect all controller
	public CardController cardController;
	public int cardMaxNum = 6;
	public LineController[] lineControllers;
	public int lineNum = 6;
	public SunController sunController;
	public ZombieController zombieController;
	
	public MainViewer mainViewer;
	public Thread t;
	
	public int sumSun;			//储存阳光总数
	public int coolDown, timer;	//用于生成新的太阳的定时器
	
	public int clock;			//每一帧的休眠时间
	public boolean alive;		//游戏未结束
	
	public BasicCard currentCard;
	
	public MainController() {
		clock = 30;
		sumSun = 5000;
		coolDown = 300;
		timer = 1;
		alive = true;

		mainViewer = new MainViewer();
		mainViewer.setMainController(this);
		
		// 初始化所有控制器
		lineControllers = new LineController[lineNum];
		for(int i=0;i<lineNum;i++) {
			lineControllers[i] = new LineController(i, this); 
		}
		cardController = new CardController(this, cardMaxNum);
		sunController = new SunController(this);
		zombieController = new ZombieController(this);

		mainViewer.draw();
		
		//测试功能区域
		currentCard = new PeaShooterCard(this);
		
		start();
	}
	
	public void start() {
		if(t == null) {
			t = new Thread(this);
			t.start();
		}
	}
	
	@SuppressWarnings("static-access")
	public void run() {
		System.out.println("The MainController is running.");
		while(alive) {
			timer--;
			if(timer == 0) {
				// 计时器到时，删除该太阳。
				Sun t = new Sun(((int)Math.random()*800+120), 60, 200, this);
				sunController.suns.add(t);
				mainViewer.addLabel(t.label);

				timer = coolDown;
				System.out.println("Successfully create a sun.");
			}
			// 如何让多个线程能够同步，先运行完的等待后运行完的。
			try {
				t.sleep(clock);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		//加载所有子弹的图片
		Pea.loadImage();
		
		//加载所有卡片的图片
		PeaShooterCard.loadImage();
		SunFlowerCard.loadImage();
		
		//加载所有植物的图片
		PeaShooter.loadImage();
		SunFlower.loadImage();
		
		//加载所有太阳的图片
		Sun.loadImage();
		
		//加载所有僵尸的图片
		Zombie.loadImage();
		ConeheadZombie.loadImage();
		BucketZombie.loadImage();
		FlagZombie.loadImage();
		NewspaperZombie.loadImage();
		FootballZombie.loadImage();

		new MainController();
	}
}
