package controller;

import sun.BasicSun;
import viewer.*;

public class MainController implements Runnable {
	// connect all controller
	public CardController cardController;
	int cardMaxNum = 6;
	public LineController[] lineControllers;
	int lineNum = 5;
	public SunController sunController;
	public ZombieController zombieController;
	
	public MainViewer mainViewer;
	public Thread t;
	
	public int sumSun;			//������������
	public int coolDown, timer;	//���������µ�̫���Ķ�ʱ��
	
	public int clock;			//ÿһ֡������ʱ��
	public boolean alive;		//��Ϸδ����
	
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
		sumSun = 0;
		coolDown = 300;
		timer = coolDown;
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
				sunController.suns.add(new BasicSun(50, 0, 200, 25, this));
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
		MainController mainController = new MainController();
	}
}
