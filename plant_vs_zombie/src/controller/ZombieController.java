package controller;

public class ZombieController implements Runnable {
	// connect to MainController
	public MainController mainController;
	
	public int coolDown;
	public int timer;
	
	public Thread t;
	
	public void start() {
		if(t == null) {
			t = new Thread(this);
			t.start();
		}
	}
	
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
		
	}
}
