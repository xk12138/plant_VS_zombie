package controller;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import block.LawnBlock;
import zombie.*;

public class ZombieController implements Runnable {
	// connect to MainController
	public MainController mainController;
	
	//public int coolDown = 750;
	public int coolDown = 300;
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
		LargeWave = new ImageIcon("resource\\images\\interface\\LargeWave.gif");
		FinalWave = new ImageIcon("resource\\images\\interface\\FinalWave.gif");
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
				if(timer == 90)
					mainController.mainViewer.addLabel(txt);
				else if(timer == 50) {
					mainController.mainViewer.removeLabel(txt);
					txt.setIcon(FinalWave);
					txt.setSize(FinalWave.getIconWidth(),FinalWave.getIconHeight());
					txt.setBounds(500, 300, FinalWave.getIconWidth(),FinalWave.getIconHeight());
					finalOpen = false;
					txtOpen = true;
				}
			}
			
			if(txtOpen == true && timer == 40) {
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
			addZombie(new Zombie(mainController), 3);
			break;
		case 1:
			addZombie(new Zombie(mainController), 1);
			break;
		case 2:
			addZombie(new Zombie(mainController), 2);
			addZombie(new Zombie(mainController), 4);
			break;
		case 3:
			addZombie(new Zombie(mainController), 0);
			addZombie(new ConeheadZombie(mainController), 3);
			addZombie(new Zombie(mainController), 4);
			
			finalOpen = true;
			txtOpen = true;
			break;
		case 4:			//第一大波
			addZombie(new FlagZombie(mainController), 1);
			addZombie(new Zombie(mainController), 0);
			addZombie(new Zombie(mainController), 1);
			addZombie(new Zombie(mainController), 2);
			addZombie(new Zombie(mainController), 3);
			addZombie(new Zombie(mainController), 4);
			addZombie(new ConeheadZombie(mainController), 4);
			break;
		case 5:
			addZombie(new Zombie(mainController), 0);
			addZombie(new Zombie(mainController), 1);
			addZombie(new Zombie(mainController), 2);
			addZombie(new Zombie(mainController), 3);
			addZombie(new Zombie(mainController), 4);
			addZombie(new Zombie(mainController), 2);
			addZombie(new Zombie(mainController), 3);
			addZombie(new ConeheadZombie(mainController), 2);
			break;
		case 6:
			addZombie(new Zombie(mainController), 0);
			addZombie(new Zombie(mainController), 1);
			addZombie(new Zombie(mainController), 2);
			addZombie(new Zombie(mainController), 3);
			addZombie(new Zombie(mainController), 4);
			addZombie(new Zombie(mainController), 0);
			addZombie(new Zombie(mainController), 1);
			addZombie(new BucketZombie(mainController), 3);
			break;
		case 7:
			addZombie(new Zombie(mainController), 0);
			addZombie(new Zombie(mainController), 1);
			addZombie(new Zombie(mainController), 2);
			addZombie(new Zombie(mainController), 3);
			addZombie(new Zombie(mainController), 4);
			addZombie(new Zombie(mainController), 0);
			addZombie(new Zombie(mainController), 1);
			addZombie(new Zombie(mainController), 2);
			addZombie(new Zombie(mainController), 3);
			addZombie(new ConeheadZombie(mainController), 4);
			addZombie(new Zombie(mainController), 4);
			addZombie(new Zombie(mainController), 4);
			addZombie(new Zombie(mainController), 0);
			addZombie(new NewspaperZombie(mainController), 1);
			txtOpen = true;
			break;
		case 8:
			addZombie(new Zombie(mainController), 0);
			addZombie(new Zombie(mainController), 1);
			addZombie(new Zombie(mainController), 2);
			addZombie(new Zombie(mainController), 3);
			addZombie(new Zombie(mainController), 4);
			addZombie(new Zombie(mainController), 0);
			addZombie(new Zombie(mainController), 1);
			addZombie(new Zombie(mainController), 2);
			addZombie(new Zombie(mainController), 3);
			addZombie(new Zombie(mainController), 4);
			addZombie(new NewspaperZombie(mainController), 3);
			addZombie(new ConeheadZombie(mainController), 0);
			finalOpen = true;
			break;
		case 9:
			addZombie(new Zombie(mainController), 0);
			addZombie(new Zombie(mainController), 1);
			addZombie(new Zombie(mainController), 2);
			addZombie(new Zombie(mainController), 3);
			addZombie(new Zombie(mainController), 4);
			addZombie(new Zombie(mainController), 0);
			addZombie(new Zombie(mainController), 1);
			addZombie(new Zombie(mainController), 2);
			addZombie(new Zombie(mainController), 3);
			addZombie(new Zombie(mainController), 4);
			addZombie(new Zombie(mainController), 4);
			addZombie(new Zombie(mainController), 0);
			addZombie(new Zombie(mainController), 1);
			addZombie(new ConeheadZombie(mainController), 0);
			addZombie(new FootballZombie(mainController), 2);
			addZombie(new BucketZombie(mainController), 3);
			break;
		default:
				for(int i=0;i<mainController.lineNum;i++) {
					if(!mainController.lineControllers[i].zombies.isEmpty())
						state = 0;
				}
		}
		batch++;
		mainController.mainViewer.removeLabel(txt);
		mainController.mainViewer.next_batch();
		System.out.println("成功创建一个僵尸");
	}
	
	private void addZombie(BasicZombie zombie, int line) {
		zombie.setBounds(zombieHeightOffset+LawnBlock.blockHeight*line, zombie.getImage().getIconWidth(), zombie.getImage().getIconHeight());
		mainController.lineControllers[line].zombies.add(zombie);
		mainController.mainViewer.addLabel(zombie.label);
	}
	
	public boolean isClear() {
		for(int i=0;i<mainController.lineNum;i++) {
			if(!mainController.lineControllers[i].zombies.isEmpty()) {
				return false;
			}
		}
		return true;
	}
}
