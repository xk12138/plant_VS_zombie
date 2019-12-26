package controller;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import block.LawnBlock;
import zombie.*;

public class ZombieController implements Runnable {
	// connect to MainController
	public MainController mainController;
	
	//public int coolDown = 750;
	public int coolDown = 500;
	public int timer;
	
	public int batch = 0;	// 用于控制正在第几波
	
	public static int zombieHeightOffset = LineController.heightOffset - 80;
	
	private static ImageIcon LargeWave;
	private static ImageIcon FinalWave;
	private JLabel txt;
	private boolean txtOpen = false;
	private boolean finalOpen = false;
	
	public Thread t;
	public static void loadImage() {
		LargeWave = new ImageIcon("resource\\images\\interface\\LargeWave.png");
		FinalWave = new ImageIcon("resource\\images\\interface\\FinalWave.png");
	}
	public ZombieController(MainController mainController) {
		this.mainController = mainController;
		timer = coolDown;
		txt = new JLabel(LargeWave);
		txt.setSize(LargeWave.getIconWidth(),LargeWave.getIconHeight());
		txt.setBounds(400, 300, LargeWave.getIconWidth(),LargeWave.getIconHeight());
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
			
			if(finalOpen == true) {
				if(timer == 110)
					mainController.mainViewer.addLabel(txt);
				else if(timer == 60) {
					mainController.mainViewer.removeLabel(txt);
					txt.setIcon(FinalWave);
					txt.setSize(FinalWave.getIconWidth(),FinalWave.getIconHeight());
					txt.setBounds(500, 300, FinalWave.getIconWidth(),FinalWave.getIconHeight());
					finalOpen = false;
					txtOpen = true;
				}
			}
			
			if(txtOpen == true && timer == 50) {
				mainController.mainViewer.addLabel(txt);
				txtOpen = false;
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
			t = new Zombie(zombieHeightOffset + LawnBlock.blockHeight *column, mainController);
			mainController.lineControllers[column].zombies.add(t);
			mainController.mainViewer.addLabel(t.label);
			break;
		case 1:
			mainController.mainViewer.addLabel(txt);
			//for(int j=0;j<10000;j++);
			column = (int)(Math.random() * mainController.lineNum);
			t = new ConeheadZombie(zombieHeightOffset + LawnBlock.blockHeight *column, mainController);
			mainController.lineControllers[column].zombies.add(t);
			mainController.mainViewer.addLabel(t.label);
			//mainController.mainViewer.removeLabel(txt);
			break;
		case 2:
			column = (int)(Math.random() * mainController.lineNum);
			t = new NewspaperZombie(zombieHeightOffset + LawnBlock.blockHeight *column, mainController);
			mainController.lineControllers[column].zombies.add(t);
			mainController.mainViewer.addLabel(t.label);
			column = (int)(Math.random() * mainController.lineNum);
			t = new BucketZombie(zombieHeightOffset + LawnBlock.blockHeight *column, mainController);
			mainController.lineControllers[column].zombies.add(t);
			mainController.mainViewer.addLabel(t.label);
			//mainController.mainViewer.removeLabel(txt);
			txtOpen = true;
			break;
		case 3:
			column = (int)(Math.random() * mainController.lineNum);
			t = new FootballZombie(zombieHeightOffset + LawnBlock.blockHeight *column, mainController);
			mainController.lineControllers[column].zombies.add(t);
			mainController.mainViewer.addLabel(t.label);
			
			for(int i=0;i<mainController.lineNum;i++) {
				t = new Zombie(zombieHeightOffset + LawnBlock.blockHeight *i, mainController);
				mainController.lineControllers[i].zombies.add(t);
				mainController.mainViewer.addLabel(t.label);
			}
			//mainController.mainViewer.removeLabel(txt);
			finalOpen = true;
			break;
		case 4:
			
			column = (int)(Math.random() * mainController.lineNum);
			t = new FlagZombie(zombieHeightOffset + LawnBlock.blockHeight *column, mainController);
			mainController.lineControllers[column].zombies.add(t);
			mainController.mainViewer.addLabel(t.label);
			
			for(int i=0;i<mainController.lineNum;i++) {
				t = new Zombie(zombieHeightOffset + LawnBlock.blockHeight *i, mainController);
				mainController.lineControllers[i].zombies.add(t);
				mainController.mainViewer.addLabel(t.label);
			}
			//mainController.mainViewer.removeLabel(txt);
			break;
		}
		batch++;
		mainController.mainViewer.removeLabel(txt);
		mainController.mainViewer.next_batch();
		System.out.println("成功创建一个僵尸");
	}
}
