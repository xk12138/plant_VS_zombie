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
	
	@SuppressWarnings("static-access")
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
	
	public LineController(int line, MainController mainController) {
		this.mainController = mainController;
		blocks = new CopyOnWriteArrayList<BasicBlock>();
		//一行有11格，默认第一格是小推车，最后一格是僵尸出生点
		for(int i=0;i<11;i++) {
			blocks.add(new BasicBlock(line, i, line, i));
		}
		bullets = new CopyOnWriteArrayList<BasicBullet>();
		zombies = new CopyOnWriteArrayList<BasicZombie>();
	}
	
	public void zombiesMove() {
		for(BasicZombie zombie: zombies) {
			zombie.move();
		}
	}
	
	public void bulletsResponse() {
		for(BasicBullet bullet: bullets) {
			if(bullet.ifBoom(zombies)) {
				bullets.remove(bullet);
			}
		}
	}
	
	public void zombiesAttack() {
		for(BasicZombie zombie: zombies) {
			int colomu = pos2index(zombie.posY);
			BasicBlock targetBlock = blocks.get(colomu);
			if(targetBlock.plant != null) {
				targetBlock.plant.health -= zombie.power;
			}
		}
	}
	
	public void plantsRefresh() {
		for(BasicBlock block: blocks) {
			BasicBullet bullet = block.plant.attack(!zombies.isEmpty());
			if(bullet != null) {
				bullets.add(bullet);
			}
		}
	}
	
	public int pos2index(int pos) {
		return pos;
	}
	
}
