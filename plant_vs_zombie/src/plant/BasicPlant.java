package plant;

import bullet.*;

public class BasicPlant {
	public int health;      //血量
    public int timer;       //计时器
    public int attackSpeed;    //攻速
    public int coolDown;//CD
    public int price;   //价格
    public int posX, posY;
    
    //植物所对应的子弹怎么记录？这个地方怎么弄还没想清楚
    //暂时想的是在继承后的植物类中写一个对应的子弹，没有实际作用，起到记录这个植物用什么子弹的作用
    //真正的子弹的生成，在行控制器中写
    public BasicPlant(int posX, int posY) {
    	this.posX = posX;
    	this.posY = posY;
    }

    public BasicBullet attack(boolean zombieExist) {//外部函数————给出有无僵尸，得出当前是否攻击，每帧调用一次
    	/*
    	 * 检测攻击是否就绪
    	 * 如果没有就绪，则攻击计时器减少
    	 * 如果计时器到时且存在僵尸
    	 * 攻击并返回发出的子弹
    	 * */
    	
    	return null;
    }
}
