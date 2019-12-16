package controller;

import java.util.concurrent.CopyOnWriteArrayList;
import block.BasicBlock;
import block.LawnBlock;
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
		int heightOffset = 100;
		int widthOffset = 80;
		for(int i=0;i<11;i++) {
			blocks.add(new LawnBlock(mainController,line, i, i*LawnBlock.blockWidth+widthOffset, line*LawnBlock.blockHeight+heightOffset));
		}
		bullets = new CopyOnWriteArrayList<BasicBullet>();
		zombies = new CopyOnWriteArrayList<BasicZombie>();
		
		this.start();
	}
	
	public void zombiesMove() {
		for(BasicZombie zombie: zombies) {
			int colomu = pos2index(zombie.getPosX());
			try {
				BasicBlock targetBlock = blocks.get(colomu);
				if(targetBlock.plant != null) {
					targetBlock.plant.health -= zombie.getPower();
					if(targetBlock.plant.health <= 0) {
						System.out.println("你的一株植物被吃掉了！");
						mainController.mainViewer.removeLabel(targetBlock.plant.label);
						targetBlock.plant = null;
					}
				}
				else
				{
					zombie.move();
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void bulletsResponse() {
		for(BasicBullet bullet: bullets) {
			if(bullet.ifBoom(zombies)) {
				System.out.println("BOOM!");
				mainController.mainViewer.removeLabel(bullet.label);
				bullets.remove(bullet);
			}
			else
			{
				bullet.move();
			}
		}
	}
	
	public void plantsRefresh() {
		for(BasicBlock block: blocks) {
			if(block.plant != null) {
				BasicBullet bullet = block.plant.attack(!zombies.isEmpty());
				if(bullet != null) {
					bullets.add(bullet);
					mainController.mainViewer.addLabel(bullet.label);
				}
			}
		}
	}
	
	public int pos2index(int pos) {
		return (int)(pos - 80) / LawnBlock.blockWidth;
	}
	
}
