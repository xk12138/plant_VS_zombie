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
	
	public int sumSun;			//������������
	public int coolDown, timer;	//���������µ�̫���Ķ�ʱ��
	
	public int clock;			//ÿһ֡������ʱ��
	public boolean alive;		//��Ϸδ����
	public boolean WIN;         //��Ϸ��Ӯ
	
	public BasicCard currentCard;
	public boolean plantAvailable;
	
	//�ؿ��ڱ�������
	public BasicAudio backgroundAudio = null;
	public BasicAudio otherAudio = null;
	
	public MainController() {
		clock = 30;
		sumSun = 5000;
		coolDown = 300;
		timer = 1;
		alive = true;

		mainViewer = new MainViewer();
		mainViewer.setMainController(this);
		mainViewer.initFlagMeter(2);
		
		//��ʼ�����п�����
		cardController = new CardController(this, cardMaxNum);
		// ��ʼ�п�����
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
				// ��ʱ����ʱ��ɾ����̫����
				Sun t = new Sun(((int)Math.random()*800+120), 60, 200, this);
				sunController.suns.add(t);
				mainViewer.addLabel(t.label);

				timer = coolDown;
				System.out.println("Successfully create a sun.");
			}
			// ����ö���߳��ܹ�ͬ������������ĵȴ���������ġ�
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
