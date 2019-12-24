package controller;

import zombie.*;

public class ZombieController implements Runnable {
	// connect to MainController
	public MainController mainController;
	
	//public int coolDown = 750;
	public int coolDown = 150;
	public int timer;
	
	public int batch = 0;	// 用于控制正在第几波
	
	public Thread t;
	
	public ZombieController(MainController mainController) {
		this.mainController = mainController;
		timer = coolDown;
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
		int column;
		BasicZombie t;
		switch(batch) {
		case 0:
			column = (int)(Math.random() * mainController.lineNum);
			t = new NewspaperZombie(80+125*column, mainController);
			mainController.lineControllers[column].zombies.add(t);
			mainController.mainViewer.addLabel(t.label);
			break;
		case 1:
			column = (int)(Math.random() * mainController.lineNum);
			t = new Zombie(80+125*column, mainController);
			mainController.lineControllers[column].zombies.add(t);
			mainController.mainViewer.addLabel(t.label);
			break;
		case 2:
			column = (int)(Math.random() * mainController.lineNum);
			t = new Zombie(80+125*column, mainController);
			mainController.lineControllers[column].zombies.add(t);
			mainController.mainViewer.addLabel(t.label);
			column = (int)(Math.random() * mainController.lineNum);
			t = new Zombie(80+125*column, mainController);
			mainController.lineControllers[column].zombies.add(t);
			mainController.mainViewer.addLabel(t.label);
			break;
		case 3:
			for(int i=0;i<mainController.lineNum;i++) {
				t = new Zombie(80+125*i, mainController);
				mainController.lineControllers[i].zombies.add(t);
				mainController.mainViewer.addLabel(t.label);
			}
		}
		
		System.out.println("成功创建一个僵尸");
	}
}
