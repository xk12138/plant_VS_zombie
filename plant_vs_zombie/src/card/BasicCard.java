package card;

/*
 * plant = 植物;
 * coolDown = 对应植物冷却时间 ;
 * timer = coolDown ;
 * label = 卡片图片初始;
 * curtain 幕布初始全黑
 */

import plant.BasicPlant;
import javax.swing.JLabel;

import controller.MainController;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BasicCard {
	public BasicPlant plant;
	public int coolDown;

    public int timer;     //timer == 0 表示冷却终止
	public JLabel label;  //卡片的图片
	public JLabel curtain; // 幕布的图片
	
	public MainController mainController;
	public boolean isShovel;
	public static int cardHeight = 60,cardWidth = 100;
	public BasicCard(MainController mainController) {
		this.mainController = mainController;
		isShovel = false;
		plant = null;
		curtain = new JLabel();
		curtain.setSize(0, cardHeight-1);
		curtain.setBackground(new Color(0, 0, 0, 150));
		curtain.setOpaque(true);
	}
		
	public void addMouseListener(JLabel label) {
		BasicCard that = this;
		label.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if(mainController.plantAvailable == true) {
				if(timer != 0) {
					System.out.println("该植物正在冷却！");
					return;
				}
				
				if(mainController.sumSun < that.plant.price) {
					System.out.printf("你的阳光储量不足，只有%d，需要%d\n", mainController.sumSun, that.plant.price);
				}
				else {
					if(isShovel == true)
						mainController.backgroundAudio.add("resource\\audio\\used\\shovel.wav");
					else 
						mainController.backgroundAudio.add("resource\\audio\\used\\seedlift.wav");
					mainController.currentCard = that;
				}
				}
			}
		});
	}
	
	
	public void refresh() {
		/*
		 * 如果正在冷却，计时器减1，并更新幕布尺寸
		 * */
		if(timer != 0) {
			timer--;
			curtain.setSize((int)((float)timer*cardWidth/coolDown), cardHeight-1);
		}
		
	}
	
	public void setTimer() {
		timer = plant.coolDown;
		
	}
	
	public BasicPlant getPlant(int posX, int posY) {
		return null;
	}
	
	public void setBounds(int x, int y) {
		curtain.setBounds(x, y+1, cardWidth, cardHeight-1);
		if(label != null) {
			label.setBounds(x, y, cardWidth, cardHeight);
		}
		curtain.setSize((int)((float)timer*cardWidth/coolDown), cardHeight-1);
	}
}
