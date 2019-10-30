package plant;

import bullet.BasicBullet;

public class BasicPlant {
	public int health;      //Ѫ��
    public int timer;       //��ʱ��
    public int attackSpeed;    //����
    public boolean attackReady;  //��������
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
    	attackReady = (this.timer == this.attackSpeed);
    }
    public boolean attackPrepare() { //�ڲ����������������㹥�ټ������͹�������
    	if(attackReady)
    		return true;
    	else {
    		this.timer++;
    		attackReady = (this.timer == this.attackSpeed);
    		return attackReady;
    	}
    }
    public boolean attack(boolean zombieExsit) {//�ⲿ�������������������޽�ʬ���ó���ǰ�Ƿ񹥻���ÿ֡����һ��
    	attackPrepare();
    	if(this.attackReady && zombieExsit) {
    		this.timer = 0;
    		this.attackReady = (this.timer == this.attackSpeed);
    		return true;
    	}else
    		return false;
    }
}
