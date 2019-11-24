package controller;

import bullet.Pea;
import card.BasicCard;
import card.PeaShooterCard;
import plant.PeaShooter;
import sun.Sun;
import viewer.*;
import zombie.Zombie;

public class MainController implements Runnable {
	// connect all controller
	public CardController cardController;
	public int cardMaxNum = 6;
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
	
	public BasicCard currentCard;
	
	public MainController() {
		// 初始化所有控制器
		lineControllers = new LineController[lineNum];
		for(int i=0;i<lineNum;i++) {
			lineControllers[i] = new LineController(i, this); 
		}
		cardController = new CardController(this, cardMaxNum);
		sunController = new SunController(this);
		zombieController = new ZombieController(this);
		
		mainViewer = new MainViewer();
		mainViewer.setMainController(this);
		clock = 30;
		sumSun = 0;
		coolDown = 300;
		timer = 10;
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
				Sun t = new Sun(50,0,200,this);
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
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Pea.loadImage();
		PeaShooterCard.loadImage();
		PeaShooter.loadImage();
		Sun.loadImage();
		Zombie.loadImage();
		MainController mainController = new MainController();
	}
}
