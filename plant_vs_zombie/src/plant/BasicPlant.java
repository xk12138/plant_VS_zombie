package plant;

import bullet.*;

public class BasicPlant {
	public int health;      //Ѫ��
    public int timer;       //��ʱ��
    public int attackSpeed;    //����
    public int coolDown;//CD
    public int price;   //�۸�
    public int posX, posY;
    
    //ֲ������Ӧ���ӵ���ô��¼������ط���ôŪ��û�����
    //��ʱ������ڼ̳к��ֲ������дһ����Ӧ���ӵ���û��ʵ�����ã��𵽼�¼���ֲ����ʲô�ӵ�������
    //�������ӵ������ɣ����п�������д
    public BasicPlant(int posX, int posY) {
    	this.posX = posX;
    	this.posY = posY;
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
}
