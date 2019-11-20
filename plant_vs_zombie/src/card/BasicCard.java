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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BasicCard {
	public BasicPlant plant; 
    public int coolDown;

    public int timer;     //timer == 0 表示冷却终止
	public JLabel label;  //卡片的图片
	public JLabel curtain; // 幕布的图片

	public static int cardHeight = 50,cardWidth = 50;
	public BasicCard() {
		coolDown = 100;
		timer = coolDown;
		curtain.setSize(cardWidth, cardHeight);
		label.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {			
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
}
