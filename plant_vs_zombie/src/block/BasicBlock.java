package block;

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

	public BasicPlant plant;//�����ϵ�ֲ��
    public int posX,posY;   //����λ��
    public int line,column; //�������(����)
    public static int blockHeight,blockWidth;//����Ŀ�Ⱥ͸߶ȣ��������أ�
              //��δʹ�ã�������úͼ������û���
    public BasicBlock(int line,int column,int posX,int posY){
    	this.line = line;
    	this.column = column;
    	this.posX = posX;
    	this.posY = posY;
    }
    
    //�����ϵ��¼���Ŀǰֻ�й����������Ƿ񹥻���ÿ֡����һ��
    public boolean event(boolean zombieExsit) {
    	return this.plant.attack(zombieExsit);
    }
}
