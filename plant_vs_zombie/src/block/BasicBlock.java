package block;

import javax.swing.JLabel;

import controller.MainController;
import plant.BasicPlant;

/*
 * 	方块基类：
 *	BasicPlant plant;方块上的植物
 *	int posX,posY;   绝对位置
 *	int line,column; 相对坐标(行列)
 *	int blockHeight,blockWidth;方格的宽度高度
 *
 **/
public class BasicBlock {

	public JLabel label;
	public BasicPlant plant;//方块上的植物
    public int posX,posY;   //绝对位置
    public int line,column; //相对坐标(行列)
    public int blockHeight,blockWidth;//方格的宽度和高度（绝对像素）
              //暂未使用，这个引用和计算机制没想好
    public MainController mainController;
    public BasicBlock(MainController mainController,int line,int column,int posX,int posY){
    	this.mainController = mainController;
    	this.line = line;
    	this.column = column;
    	this.posX = posX;
    	this.posY = posY;
    	this.plant = null;
    }
}
