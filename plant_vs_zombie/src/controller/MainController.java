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
	
	public int sumSun;			//������������
	public int coolDown, timer;	//���������µ�̫���Ķ�ʱ��
	
	public int clock;			//ÿһ֡������ʱ��
	public boolean alive;		//��Ϸδ����
	
	public BasicCard currentCard;
	
	public MainController() {
		clock = 30;
		sumSun = 5000;
		coolDown = 300;
		timer = 1;
		alive = true;

		mainViewer = new MainViewer();
		mainViewer.setMainController(this);
		
		// ��ʼ�����п�����
		lineControllers = new LineController[lineNum];
		for(int i=0;i<lineNum;i++) {
			lineControllers[i] = new LineController(i, this); 
		}
		cardController = new CardController(this, cardMaxNum);
		sunController = new SunController(this);
		zombieController = new ZombieController(this);

		mainViewer.draw();
		
		//���Թ�������
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
	}
	
	public static void main(String[] args) {
		//���������ӵ���ͼƬ
		Pea.loadImage();
		
		//�������п�Ƭ��ͼƬ
		PeaShooterCard.loadImage();
		SunFlowerCard.loadImage();
		
		//��������ֲ���ͼƬ
		PeaShooter.loadImage();
		SunFlower.loadImage();
		
		//��������̫����ͼƬ
		Sun.loadImage();
		
		//�������н�ʬ��ͼƬ
		Zombie.loadImage();
		ConeheadZombie.loadImage();
		BucketZombie.loadImage();
		FlagZombie.loadImage();
		NewspaperZombie.loadImage();
		FootballZombie.loadImage();

		new MainController();
	}
}
