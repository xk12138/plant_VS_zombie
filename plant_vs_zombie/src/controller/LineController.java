package controller;

import java.util.concurrent.CopyOnWriteArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

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
	public CopyOnWriteArrayList<BasicZombie> dieZombies;
	
	int[] TorchArray = new int [11];//记录火炬树桩的数组，其中数字表示其横坐标，-1表示空，偏移量为其id

	public Thread t;
	
	public static int heightOffset = 110;
	public static int widthOffset = 80;
	
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
			dieZombieRefresh();
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
		//heightOffset = 90;
		//widthOffset = 80;
		for(int i=0;i<11;i++) {
			blocks.add(new LawnBlock(mainController,line, i, i*LawnBlock.blockWidth+widthOffset, line*LawnBlock.blockHeight+heightOffset));
			TorchArray[i] = -1;
		}
		//TorchArray[0] = 500;
		//TorchArray[1] = 800; 
		bullets = new CopyOnWriteArrayList<BasicBullet>();
		zombies = new CopyOnWriteArrayList<BasicZombie>();
		dieZombies = new CopyOnWriteArrayList<BasicZombie>();
		
		this.start();
	}
	
	public void zombiesMove() {
		for(BasicZombie zombie: zombies) {
			int colomu = pos2index(zombie.getPosX());
			try {
				BasicBlock targetBlock = blocks.get(colomu);
				if(targetBlock.plant != null) {
					if(targetBlock.plant.isEaten(zombie.getPower())) {
						System.out.println("你的一株植物被吃掉了！");
						mainController.mainViewer.removeLabel(targetBlock.plant.label);
						targetBlock.plant = null;
					}
					/*
					targetBlock.plant.health -= zombie.getPower();
					if(targetBlock.plant.health <= 0) {
						System.out.println("你的一株植物被吃掉了！");
						mainController.mainViewer.removeLabel(targetBlock.plant.label);
						targetBlock.plant = null;
					}
					*/
				}
				else
				{
					zombie.move();
				}
			}
			catch(Exception e) {
				//e.printStackTrace();
			}
		}
	}
	
	public void bulletsResponse() {
		for(BasicBullet bullet: bullets) {
			if(bullet.timer == -1) {//正常子弹
				if(bullet.ifBoom(this)) {
					System.out.println("BOOM!");
				}
				else{
					bullet.move(TorchArray);
				}
			}else {//已经爆炸的子弹
				if(bullet.timer > 0) {
					bullet.timer--;
				}else {
					mainController.mainViewer.removeLabel(bullet.label);
					bullets.remove(bullet);
				}
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
				if(block.plant.dieTimer > 0)
					block.plant.dieTimer--;
				else if(block.plant.dieTimer == 0)
					block.plant = null;
			}
		}
	}
	
	public int pos2index(int pos) {
		return (int)(pos - widthOffset) / LawnBlock.blockWidth+1;
	}
	public void dieZombieRefresh() {
		for(BasicZombie zombie:dieZombies) {
			if(zombie.timer > 0)
				zombie.timer--;
			else {
				System.out.println("彻底死了");
				dieZombies.remove(zombie);
				mainController.mainViewer.removeLabel(zombie.label);
			}
				
		}
	}
	public void addTorch(int posX) {
		int i = 0;
		while(TorchArray[i] != -1)
			i++;
		TorchArray[i] = posX;
		System.out.println("种了一个火炬树桩");
		for(int j=0;j<11;j++) {
			System.out.print(TorchArray[j]);
		}
	}
	public void removeTorch(int posX) {
		int i = 0;
		while(TorchArray[i] != posX) i++;
		TorchArray[i] = -1;
		System.out.println("删了一个火炬树桩");
	}
}
