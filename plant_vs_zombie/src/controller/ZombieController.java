package controller;

import zombie.*;

public class ZombieController implements Runnable {
	// connect to MainController
	public MainController mainController;
	
	public int coolDown = 3000;
	public int timer;
	
	public int batch = 0;	// ���ڿ������ڵڼ���
	
	public Thread t;
	
	public ZombieController(MainController mainController) {
		this.mainController = mainController;
		timer = 500000;
		this.start();
	}
	
	public void start() {
		if(t == null) {
			t = new Thread(this);
			t.start();
		}
	}
	
	@SuppressWarnings("static-access")
	public void run() {
		while(mainController.alive) {
			timer--;
			
			if(timer == 0) {
				timer = coolDown;
				createZombies();
			}
			
			try {
				t.sleep(mainController.clock);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void createZombies() {
		int colomu;
		BasicZombie t;
		switch(batch) {
		case 0:
			colomu = (int)(Math.random() * mainController.lineNum);
			t = new Zombie(colomu, 10);
			mainController.lineControllers[colomu].zombies.add(t);
			mainController.mainViewer.addLabel(t.label);
			break;
		case 1:
			colomu = (int)(Math.random() * mainController.lineNum);
			t = new Zombie(colomu, 10);
			mainController.lineControllers[colomu].zombies.add(t);
			mainController.mainViewer.addLabel(t.label);
			break;
		case 2:
			colomu = (int)(Math.random() * mainController.lineNum);
			t = new Zombie(colomu, 10);
			mainController.lineControllers[colomu].zombies.add(t);
			mainController.mainViewer.addLabel(t.label);
			colomu = (int)(Math.random() * mainController.lineNum);
			t = new Zombie(colomu, 10);
			mainController.lineControllers[colomu].zombies.add(t);
			mainController.mainViewer.addLabel(t.label);
			break;
		case 3:
			for(int i=0;i<mainController.lineNum;i++) {
				t = new Zombie(i, 10);
				mainController.lineControllers[i].zombies.add(t);
				mainController.mainViewer.addLabel(t.label);
			}
		}
	}
}
