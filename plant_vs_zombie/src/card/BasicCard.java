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

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BasicCard {
	public BasicPlant plant;
	public int coolDown;

    public int timer;     //timer == 0 表示冷却终止
	public JLabel label;  //卡片的图片
	public JLabel curtain; // 幕布的图片
	
	public MainController mainController;

	public static int cardHeight = 50,cardWidth = 50;
	public BasicCard(MainController mainController) {
		this.mainController = mainController;
		plant = null;
		curtain = new JLabel();
		curtain.setSize(cardWidth, cardHeight);
	}
		
	public void addMouseListener(JLabel label) {
		BasicCard that = this;
		label.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				mainController.currentCard = that;
			}
		});
	}
	
	
	public void refresh() {
		/*
		 * 如果正在冷却，计时器减1，并更新幕布尺寸
		 * */
		if(timer != 0) {
			timer--;
			curtain.setSize((int)((float)timer*cardWidth/coolDown), cardHeight);
		}
		
	}
	
	public void setTimer() {
		timer = plant.coolDown;
	}
	
	public BasicPlant getPlant(int posX, int posY) {
		return null;
	}
}
