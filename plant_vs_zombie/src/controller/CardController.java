package controller;

import java.util.concurrent.CopyOnWriteArrayList;
import card.BasicCard;
import card.PeaShooterCard;
import card.SunFlowerCard;

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
		this.mainController = mainController;
		cards = new CopyOnWriteArrayList<BasicCard>();
		addCard(new PeaShooterCard(mainController));
		addCard(new SunFlowerCard(mainController));
		this.maxNum = maxNum;
		this.start();
	}
	
	public void cardsRefresh() {
		for(BasicCard card: cards) {
			card.refresh();
		}
	}
	
	public void addCard(BasicCard card) {
		cards.add(card);
		int index = cards.size() - 1;
		card.label.setBounds(0, 150 + 60*index, 120, 60);
		mainController.mainViewer.addLabel(card.label);
	}
}
