package controller;

import zombie.BasicZombie;

public class ZombieController implements Runnable {
	// connect to MainController
	public MainController mainController;
	
	public int coolDown = 3000;
	public int timer;
	
	public int batch = 0;	// 用于控制正在第几波
	
	public Thread t;
	
	public ZombieController(MainController mainController) {
		this.mainController = mainController;
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
		switch(batch) {
		case 0:
			colomu = (int)(Math.random() * mainController.lineNum);
			mainController.lineControllers[colomu].zombies.add(new BasicZombie(colomu, 10));
			break;
		case 1:
			colomu = (int)(Math.random() * mainController.lineNum);
			mainController.lineControllers[colomu].zombies.add(new BasicZombie(colomu, 10));
			break;
		case 2:
			colomu = (int)(Math.random() * mainController.lineNum);
			mainController.lineControllers[colomu].zombies.add(new BasicZombie(colomu, 10));
			colomu = (int)(Math.random() * mainController.lineNum);
			mainController.lineControllers[colomu].zombies.add(new BasicZombie(colomu, 10));
			break;
		case 3:
			for(int i=0;i<mainController.lineNum;i++) {
				mainController.lineControllers[i].zombies.add(new BasicZombie(i, 10));
			}
		}
	}
}
