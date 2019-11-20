package card;

/*
 * 卡片的基类：
 * plant:每张卡片所对应的植物
 * coolDown:植物的冷却时间
 * timer:计时器
 */

import plant.BasicPlant;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.TimerTask;
import java.util.Timer;

public class BasicCard {
	public BasicPlant plant; 
    public int coolDown;
<<<<<<< HEAD
    public int timer;     //timer == 0表示冷却结束
	public JLabel label;  //植物卡片的图片
	public JLabel curtain; //幕布的图片
	public static int cardHeight = 50,cardWidth = 50;
	public BasicCard() {
		/*
		 * plant = 特定植物 ;
		 * coolDown = 规定冷却时间 ;
		 * timer = coolDown ;
		 * label = 本植物的卡片;
		 * curtain 设置全黑
		 */
		coolDown = 100;
		timer = coolDown;
		curtain.setSize(cardWidth, cardHeight);
		
=======
    public int timer;
	public JLabel label;
	
	//loadImage
	public void loadImage(String picPath) {//鎸囧畾鍥剧墖鐨勮矾寰�
		JFrame frame = new JFrame("涓�寮犲崱鐗囩殑娴嬭瘯");
        Icon icon = new ImageIcon(picPath);               //浣跨敤瀛楄妭鏁扮粍锛屽疄渚嬪寲ImageIcon瀵硅薄
        // 瀹炰緥鍖栨爣绛惧璞★細甯﹀浘鐗囷紝灞呬腑瀵归綈
        label = new JLabel(icon, JLabel.CENTER); 
        BasicCard card = new BasicCard();
        card.mouseListener(label);
        //璁剧疆鏍囩鑳屾櫙棰滆壊
        label.setOpaque(true);
        label.setBackground(Color.PINK);
        //鎶婃爣绛炬坊鍔犲埌闈㈡澘涓�
        frame.add(label); // 灏嗙粍浠朵欢鍏ュ埌闈㈡澘涔嬩腑
        // 璁剧疆绐椾綋鐨勮儗鏅鑹�
        frame.getContentPane().setBackground(Color.WHITE);
        //璁剧疆绐楀彛瀹藉害鍜岄珮搴�
        Dimension dim = new Dimension();
        dim.setSize(800,600 );
        frame.setSize(dim);
        frame.setVisible(true);
    }
	
	//getImage
	
	// 鏇存柊璁℃椂鍣�
	//schedule(TimerTask task, long delay) 聽
	public void renewTimer(String path1,String path2) {
		this.loadImage(path1);
        TimerTask task = new TimerTask() {
			public void run() {
            	loadImage(path2);
            }
        };
        Timer timer = new Timer();
        long delay = 3000;
        timer.schedule(task, delay);
    }
	
	
	//閲嶅啓鏂规硶锛岀洃鍚紶鏍囩偣鍑诲崱鐗囦簨浠�
	class CardListener extends MouseAdapter{
		public void mouseClicked(MouseEvent e){
			System.out.println("鐐瑰嚮浜嗛紶鏍�");
            //loadimage纭畾鍚庯紝if(cd瀹屾垚&&a >= plant.health)灏辨嫋鎷藉嚭妞嶇墿
			//sumSun鏄敹闆嗙殑闃冲厜鎬婚噺锛屼粠涓绘帶鏉�
		}
>>>>>>> a21730ee9fa23d9b894709a1772b51429d25bd4c
	}
	public void refresh() {//执行定时器递减操作，若减后CD为0可以种植，返回true，反之false
		/*
		 * 计时器减1(最小为零)
		 * 设置幕布对应的尺寸
		 * */
		if(timer != 0) {
			timer--;
			curtain.setSize((int)((float)timer*cardWidth/coolDown), cardHeight);
		}
		
	}
	
	
}
