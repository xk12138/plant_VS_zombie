package controller;

import java.util.concurrent.CopyOnWriteArrayList;

import bullet.*;

public class BulletController implements Runnable {
	public CopyOnWriteArrayList<BaseBullet> bullets;
	public Thread t;
	
	public BulletController() {
		bullets = new CopyOnWriteArrayList<BaseBullet>();
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
		System.out.println("The BulletController is running.");
		while(true) {
			System.out.printf("The number of bullets is: %d\n", bullets.size());
			for(BaseBullet bullet: bullets) {
				bullet.move();
				
				if(!bullet.isAvaiable(300, 1000)) {
					bullets.remove(bullet);
				}
			}
			
			try {
				t.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
