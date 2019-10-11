package controller;

import bullet.*;

public class MainController implements Runnable {
	public BulletController bulletController;
	public Thread t;
	
	public MainController() {
		bulletController = new BulletController();
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
		while(true) {
			if(bulletController.bullets.size() < 10) {
				bulletController.bullets.add(new Pea(50, 0));
			}
			
			try {
				t.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
