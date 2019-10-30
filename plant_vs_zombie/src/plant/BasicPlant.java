package plant;

import bullet.BasicBullet;

public class BasicPlant {
	public int health;      //血量
    public int timer;       //计时器
    public int attackSpeed;    //攻速
    public boolean attackReady;  //攻击就绪
    public static int coolDown;//CD
    public static int price;   //价格
    
           //植物所对应的子弹怎么记录？这个地方怎么弄还没想清楚
           //暂时想的是在继承后的植物类中写一个对应的子弹，没有实际作用，起到记录这个植物用什么子弹的作用
           //真正的子弹的生成，在行控制器中写
    public BasicPlant() {
 
    	this.health = 1000;
    	this.attackSpeed = 0;
    	coolDown = 0;
    	price = 25;
    	this.attackSpeed = 100;
    	this.timer = this.attackSpeed;
    	attackReady = (this.timer == this.attackSpeed);
    }
    public boolean attackPrepare() { //内部函数————计算攻速计数器和攻击就绪
    	if(attackReady)
    		return true;
    	else {
    		this.timer++;
    		attackReady = (this.timer == this.attackSpeed);
    		return attackReady;
    	}
    }
    public boolean attack(boolean zombieExsit) {//外部函数————给出有无僵尸，得出当前是否攻击，每帧调用一次
    	attackPrepare();
    	if(this.attackReady && zombieExsit) {
    		this.timer = 0;
    		this.attackReady = (this.timer == this.attackSpeed);
    		return true;
    	}else
    		return false;
    }
}
