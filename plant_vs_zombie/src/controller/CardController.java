package controller;

import java.util.concurrent.CopyOnWriteArrayList;

import javax.swing.JLabel;

import card.BasicCard;
import card.CherryBombCard;
import card.JalapenoCard;
import card.PeaShooterCard;
import card.PotatoMineCard;
import card.RepeaterCard;
import card.ShovelCard;
import card.SnowPeaShooterCard;
import card.SunFlowerCard;
import card.TallNutCard;
import card.TorchwoodCard;
import card.WallNutCard;

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
		//addCard(new PeaShooterCard(mainController));
		addCard(new SunFlowerCard(mainController));
		addCard(new RepeaterCard(mainController));
		addCard(new WallNutCard(mainController));
		addCard(new JalapenoCard(mainController));
		//addCard(new TorchwoodCard(mainController));
		addCard(new CherryBombCard(mainController));
		addCard(new PotatoMineCard(mainController));
		//addCard(new TallNutCard(mainController));  //边界有些小bug
		//addCard(new SnowPeaShooterCard(mainController));
		addCard(new SnowPeaShooterCard(mainController));
		
		this.maxNum = maxNum;
		
		//增加铲子
		addCard(new ShovelCard(mainController));
		
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
		card.label.setBounds(0, 90 + 60*index, 120, 60);
		mainController.mainViewer.addLabel(card.label);
	}
}
