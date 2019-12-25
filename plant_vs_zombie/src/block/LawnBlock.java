package block;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.border.Border;

import controller.MainController;
import card.BasicCard;
public class LawnBlock extends BasicBlock{

	public static int blockHeight = 120, blockWidth = 97;
	
	public LawnBlock(MainController mainController,int line,int column,int posX,int posY) {
		super(mainController,line,column,posX,posY);
		label = new JLabel("草方块");
		label.setSize(blockHeight, blockWidth);
		label.setBounds(posX, posY, blockWidth, blockHeight);
		label.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if(plant ==  null && mainController.currentCard != null) {
					plant = mainController.currentCard.getPlant(posX,posY);
					mainController.currentCard.setTimer();
					mainController.currentCard = null;

					mainController.mainViewer.addLabel(plant.label);
					System.out.println("植物已被种植");
				}
				System.out.printf("位置（%d, %d）的方块被点击\n", line, column);
			}
		});
	}
}
