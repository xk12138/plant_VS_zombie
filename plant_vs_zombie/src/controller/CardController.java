package controller;

import java.util.concurrent.CopyOnWriteArrayList;
import card.BasicCard;

public class CardController implements Runnable {
	// connect to MainController
	public MainController mainController;
	
	public CopyOnWriteArrayList<BasicCard> cards;
	public int maxNum;
	
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
			cardsRefresh();
			
			try {
				t.sleep(mainController.clock);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public CardController(MainController mainController, int maxNum) {
		cards = new CopyOnWriteArrayList<BasicCard>();
		this.maxNum = maxNum;
		this.mainController = mainController;
	}
	
	public void cardsRefresh() {
		for
	}
}
