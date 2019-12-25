package plant;

import javax.swing.JLabel;

import block.LawnBlock;
import bullet.*;
import controller.LineController;
import controller.MainController;

public class BasicPlant {
	public int health;      //Ѫ��
    public int timer;       //��ʱ��
    public int attackSpeed;    //����
    public int coolDown;//CD
    public int price;   //�۸�
    public int posX, posY;
    public int lineNum;//�������Ӷ�֪��ȥ�ĸ��п�������
    
    public int dieTimer;//����ʱ���ʱ����-1��ʾ�����������Ǹ�����ʾ����ʱ��0��ʾ�������Ƴ�
    
    public JLabel label;
    public MainController mainController;
    
    //ֲ������Ӧ���ӵ���ô��¼������ط���ôŪ��û�����
    //��ʱ������ڼ̳к��ֲ������дһ����Ӧ���ӵ���û��ʵ�����ã��𵽼�¼���ֲ����ʲô�ӵ�������
    //�������ӵ������ɣ����п�������д
    public BasicPlant(int posX, int posY, MainController mainController) {
    	this.posX = posX;
    	this.posY = posY;
    	this.lineNum = pos1index(posY);
    	this.dieTimer = -1;
    	this.mainController = mainController;
    }

    public BasicBullet attack(boolean zombieExist) {//�ⲿ�������������������޽�ʬ���ó���ǰ�Ƿ񹥻���ÿ֡����һ��
    	/*
    	 * ��⹥���Ƿ����
    	 * ���û�о������򹥻���ʱ������
    	 * �����ʱ����ʱ�Ҵ��ڽ�ʬ
    	 * ���������ط������ӵ�
    	 * */
    	
    	return null;
    }
    public boolean isEaten(int getPower) {
    	/*
    	 *  ����ʬ������
    	 *  ��Ѫ  OR ����������
    	 *  ����ֲ���Ƿ񱻳Ե�
    	*/
    	//����ͨģʽ
    	health -= getPower;
    	if(health > 0)
    		return false;
    	else
    		return true;
    }
    public int pos1index(int pos) {
		return (int)(pos - LineController.heightOffset) / LawnBlock.blockHeight;
	}
    
    // �ǲ��ǲ���
    public boolean isShovel() {
    	return false;
    }
}
