package block;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;

import controller.MainController;
import card.BasicCard;
public class LawnBlock extends BasicBlock{

	public LawnBlock(MainController mainController,int line,int column,int posX,int posY) {
		super(mainController,line,column,posX,posY);
		label = new JLabel();
		label.setSize(blockHeight, blockWidth);
		label.setBounds(posX, posY, blockWidth, blockHeight);
		label.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if(plant ==  null && mainController.currentCard != null) {
					plant = mainController.currentCard.getPlant(posX,posY);
					mainController.currentCard.setTimer();
					mainController.currentCard = null;
				}
			}
		});
	}
}
