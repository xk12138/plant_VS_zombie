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
	
	public int sumSun;			//������������
	public int coolDown, timer;	//���������µ�̫���Ķ�ʱ��
	
	public int clock;			//ÿһ֡������ʱ��
	public boolean alive;		//��Ϸδ����
	
	public BasicCard currentCard;
	
	public MainController() {
		// ��ʼ�����п�����
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
				// ��ʱ����ʱ��ɾ����̫����
				Sun t = new Sun(50,0,200,this);
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
