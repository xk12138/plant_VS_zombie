package controller;

import audio.BasicAudio;
import bullet.LawnCleanerCar;
import bullet.Pea;
import card.BasicCard;
import card.PeaShooterCard;
import card.RepeaterCard;
import card.SunFlowerCard;
import card.TorchwoodCard;
import card.ShovelCard;
import plant.CherryBomb;
import plant.Jalapeno;
import plant.LawnCleaner;
import plant.PeaShooter;
import plant.Repeater;
import plant.SnowPeaShooter;
import plant.SunFlower;
import plant.TallNut;
import plant.Torchwood;
import plant.WallNut;
import plant.PotatoMine;
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
	public int cardMaxNum = 8;
	public LineController[] lineControllers;
	public int lineNum = 5;
	public SunController sunController;
	public ZombieController zombieController;
	public MainViewer mainViewer;
	public Thread t;
	
	public int sumSun;			//储存阳光总数
	public int coolDown, timer;	//用于生成新的太阳的定时器
	
	public int clock;			//每一帧的休眠时间
	public boolean alive;		//游戏未结束
	public boolean WIN;         //游戏输赢
	
	public BasicCard currentCard;
	public boolean plantAvailable;
	
	//关卡内背景音乐
	public BasicAudio backgroundAudio = null;
	public BasicAudio otherAudio = null;
	
	public MainController() {
		clock = 30;
		sumSun = 50;
		coolDown = 300;
		timer = 300;
		alive = true;

		mainViewer = new MainViewer();
		mainViewer.setMainController(this);
		mainViewer.initFlagMeter(2);
		
		//初始化所有控制器
		cardController = new CardController(this, cardMaxNum);
		// 初始行控制器
		lineControllers = new LineController[lineNum];
		for(int i=0;i<lineNum;i++) {
			lineControllers[i] = new LineController(i, this); 
		}
		plantAvailable = false;
		
		sunController = new SunController(this);
		zombieController = new ZombieController(this);

		changeSun(0);
		mainViewer.draw();
		
		
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
		//******
		mainViewer.preVideo();
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
		
		mainViewer.afterView(WIN);
	}
	
	public static void main(String[] args) {

		new MainController();
	}
	public void changeSun(int energy) {
		sumSun += energy;
		mainViewer.sumSun.setText(String.valueOf(sumSun));
	}
}
