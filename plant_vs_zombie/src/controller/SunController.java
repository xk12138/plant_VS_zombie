package controller;

import java.util.concurrent.CopyOnWriteArrayList;
import sun.BasicSun;

public class SunController implements Runnable {
	// connect to MainController
	public MainController mainController;
	
	public CopyOnWriteArrayList<BasicSun> suns;
	
	public Thread t;
	
	public SunController(MainController mainController) {
		suns = new CopyOnWriteArrayList<BasicSun>();
		this.mainController = mainController;
		
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
		// Refresh all suns in the game.
		while(mainController.alive) {
			sunsRefresh();
			
			try {
				t.sleep(mainController.clock);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void sunsRefresh() {
		for(BasicSun sun: suns) {
			sun.timer--;
			if(sun.timer == 0) {
				mainController.mainViewer.removeLabel(sun.label);
				suns.remove(sun);
				// We should remove the JLabel of this sun from the JPanel.
			}
		}
	}
}
