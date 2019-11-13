package controller;

import java.util.concurrent.CopyOnWriteArrayList;
import sun.BasicSun;

public class SunController implements Runnable {
	// connect to MainController
	public MainController mainController;
	
	public CopyOnWriteArrayList<BasicSun> suns;
	
	public Thread t;
	
	public void start() {
		if(t == null) {
			t = new Thread(this);
			t.start();
		}
	}
	
	public void run() {
		while(mainController.alive) {
			sunsRefresh();
			
			try {
				t.sleep(mainController.clock);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void sunsRefresh() {
		
	}
}
