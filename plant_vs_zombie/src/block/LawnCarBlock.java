package block;

import javax.swing.JLabel;

import controller.MainController;
public class LawnCarBlock extends BasicBlock{

	public static int blockHeight = LawnBlock.blockHeight, blockWidth = LawnBlock.blockWidth;
	
	public LawnCarBlock(MainController mainController,int line,int column,int posX,int posY) {
		super(mainController,line,column,posX,posY);
		label = new JLabel("草平推车方块");
		label.setSize(blockHeight, blockWidth);
		label.setBounds(posX, posY, blockWidth, blockHeight);
	}
}
