package plant;

import bullet.*;

public class BasicPlant {
	public int health;      //Ѫ��
    public int timer;       //��ʱ��
    public int attackSpeed;    //����
    public static int coolDown;//CD
    public static int price;   //�۸�
    
           //ֲ������Ӧ���ӵ���ô��¼������ط���ôŪ��û�����
           //��ʱ������ڼ̳к��ֲ������дһ����Ӧ���ӵ���û��ʵ�����ã��𵽼�¼���ֲ����ʲô�ӵ�������
           //�������ӵ������ɣ����п�������д
    public BasicPlant() {
 
    	this.health = 1000;
    	this.attackSpeed = 0;
    	coolDown = 0;
    	price = 25;
    	this.attackSpeed = 100;
    	this.timer = this.attackSpeed;
    }
    public void attackPrepare() { //�ڲ����������������㹥�ټ������͹�������
    	/*
    	 * ��⹥���Ƿ����
    	 * ���û�о������򹥻���ʱ������
    	 * */
    }
    public BasicBullet attack(boolean zombieExist) {//�ⲿ�������������������޽�ʬ���ó���ǰ�Ƿ񹥻���ÿ֡����һ��
    	attackPrepare();
    	
    	/*
    	 * �����ʱ����ʱ�Ҵ��ڽ�ʬ
    	 * ���������ط������ӵ�
    	 * */
    	
    	return null;
    }
}
