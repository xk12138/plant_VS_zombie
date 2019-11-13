package controller;

import viewer.*;

public class MainController implements Runnable {
	// connect all controller
	public CardController cardController;
	public LineController lineController;
	public SunController sunController;
	public ZombieController zombieController;
	
	public MainViewer mainViewer;
	public Thread t;
	public int sumSun;
	public int clock;
	public boolean alive;		//��Ϸδ����
	
	public MainController() {
		// ��ʼ�����п�����
		
		mainViewer = new MainViewer();
		start();
		sumSun = 0;
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
		while(true) {
			
			// ����ö���߳��ܹ�ͬ������������ĵȴ���������ġ�
			try {
				t.sleep(300);
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
