package block;

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

	public BasicPlant plant;//方块上的植物
    public int posX,posY;   //绝对位置
    public int line,column; //相对坐标(行列)
    public static int blockHeight,blockWidth;//方格的宽度和高度（绝对像素）
              //暂未使用，这个引用和计算机制没想好
    public BasicBlock(int line,int column,int posX,int posY){
    	this.line = line;
    	this.column = column;
    	this.posX = posX;
    	this.posY = posY;
    }
    
    //方格上的事件，目前只有攻击，返回是否攻击，每帧调用一次
    public boolean event(boolean zombieExsit) {
    	return this.plant.attack(zombieExsit);
    }
}
