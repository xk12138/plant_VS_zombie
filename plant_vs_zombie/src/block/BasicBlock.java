package block;

import javax.swing.JLabel;

import controller.MainController;
import plant.BasicPlant;

/*
 * 	������ࣺ
 *	BasicPlant plant;�����ϵ�ֲ��
 *	int posX,posY;   ����λ��
 *	int line,column; �������(����)
 *	int blockHeight,blockWidth;����Ŀ�ȸ߶�
 *
 **/
public class BasicBlock {

	public JLabel label;
	public BasicPlant plant;//�����ϵ�ֲ��
    public int posX,posY;   //����λ��
    public int line,column; //�������(����)
    public int blockHeight,blockWidth;//����Ŀ�Ⱥ͸߶ȣ��������أ�
              //��δʹ�ã�������úͼ������û���
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
