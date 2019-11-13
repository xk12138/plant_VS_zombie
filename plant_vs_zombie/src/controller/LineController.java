package controller;

import java.util.concurrent.CopyOnWriteArrayList;
import block.BasicBlock;
import bullet.BasicBullet;
import zombie.BasicZombie;

public class LineController implements Runnable {
	// connect with MainController
	public MainController mainController;
	
	public CopyOnWriteArrayList<BasicBlock> blocks;
	public CopyOnWriteArrayList<BasicBullet> bullets;
	public CopyOnWriteArrayList<BasicZombie> zombies;
	
	public Thread t;
	
	public void start() {
		if(t == null) {
			t = new Thread(this);
			t.start();
		}
	}
	
	public void run() {
		while(mainController.alive) {
			zombiesMove();
			bulletsResponse();
			zombiesAttack();
			plantsRefresh();
			
			try {
				t.sleep(mainController.clock);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public LineController(MainController mainController) {
		this.mainController = mainController;
		blocks = new CopyOnWriteArrayList<BasicBlock>();
		// 一行应有多少格
		bullets = new CopyOnWriteArrayList<BasicBullet>();
		zombies = new CopyOnWriteArrayList<BasicZombie>();
	}
	
	public void zombiesMove() {
		
	}
	
	public void bulletsResponse() {
		
	}
	
	public void zombiesAttack() {
		
	}
	
	public void plantsRefresh() {
		
	}
}
