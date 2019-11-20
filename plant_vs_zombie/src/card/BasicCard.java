package card;

/*
 * ¿¨Æ¬µÄ»ùÀà£º
 * plant:Ã¿ÕÅ¿¨Æ¬Ëù¶ÔÓ¦µÄÖ²Îï
 * coolDown:Ö²ÎïµÄÀäÈ´Ê±¼ä
 * timer:¼ÆÊ±Æ÷
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
    public int timer;     //timer == 0±íÊ¾ÀäÈ´½áÊø
	public JLabel label;  //Ö²Îï¿¨Æ¬µÄÍ¼Æ¬
	public JLabel curtain; //Ä»²¼µÄÍ¼Æ¬
	public static int cardHeight = 50,cardWidth = 50;
	public BasicCard() {
		/*
		 * plant = ÌØ¶¨Ö²Îï ;
		 * coolDown = ¹æ¶¨ÀäÈ´Ê±¼ä ;
		 * timer = coolDown ;
		 * label = ±¾Ö²ÎïµÄ¿¨Æ¬;
		 * curtain ÉèÖÃÈ«ºÚ
		 */
		coolDown = 100;
		timer = coolDown;
		curtain.setSize(cardWidth, cardHeight);
		
=======
    public int timer;
	public JLabel label;
	
	//loadImage
	public void loadImage(String picPath) {//æŒ‡å®šå›¾ç‰‡çš„è·¯å¾„
		JFrame frame = new JFrame("ä¸€å¼ å¡ç‰‡çš„æµ‹è¯•");
        Icon icon = new ImageIcon(picPath);               //ä½¿ç”¨å­—èŠ‚æ•°ç»„ï¼Œå®ä¾‹åŒ–ImageIconå¯¹è±¡
        // å®ä¾‹åŒ–æ ‡ç­¾å¯¹è±¡ï¼šå¸¦å›¾ç‰‡ï¼Œå±…ä¸­å¯¹é½
        label = new JLabel(icon, JLabel.CENTER); 
        BasicCard card = new BasicCard();
        card.mouseListener(label);
        //è®¾ç½®æ ‡ç­¾èƒŒæ™¯é¢œè‰²
        label.setOpaque(true);
        label.setBackground(Color.PINK);
        //æŠŠæ ‡ç­¾æ·»åŠ åˆ°é¢æ¿ä¸­
        frame.add(label); // å°†ç»„ä»¶ä»¶å…¥åˆ°é¢æ¿ä¹‹ä¸­
        // è®¾ç½®çª—ä½“çš„èƒŒæ™¯é¢œè‰²
        frame.getContentPane().setBackground(Color.WHITE);
        //è®¾ç½®çª—å£å®½åº¦å’Œé«˜åº¦
        Dimension dim = new Dimension();
        dim.setSize(800,600 );
        frame.setSize(dim);
        frame.setVisible(true);
    }
	
	//getImage
	
	// æ›´æ–°è®¡æ—¶å™¨
	//schedule(TimerTask task, long delay) Â 
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
	
	
	//é‡å†™æ–¹æ³•ï¼Œç›‘å¬é¼ æ ‡ç‚¹å‡»å¡ç‰‡äº‹ä»¶
	class CardListener extends MouseAdapter{
		public void mouseClicked(MouseEvent e){
			System.out.println("ç‚¹å‡»äº†é¼ æ ‡");
            //loadimageç¡®å®šåï¼Œif(cdå®Œæˆ&&a >= plant.health)å°±æ‹–æ‹½å‡ºæ¤ç‰©
			//sumSunæ˜¯æ”¶é›†çš„é˜³å…‰æ€»é‡ï¼Œä»ä¸»æ§æ¥
		}
>>>>>>> a21730ee9fa23d9b894709a1772b51429d25bd4c
	}
	public void refresh() {//Ö´ĞĞ¶¨Ê±Æ÷µİ¼õ²Ù×÷£¬Èô¼õºóCDÎª0¿ÉÒÔÖÖÖ²£¬·µ»Øtrue£¬·´Ö®false
		/*
		 * ¼ÆÊ±Æ÷¼õ1(×îĞ¡ÎªÁã)
		 * ÉèÖÃÄ»²¼¶ÔÓ¦µÄ³ß´ç
		 * */
		if(timer != 0) {
			timer--;
			curtain.setSize((int)((float)timer*cardWidth/coolDown), cardHeight);
		}
		
	}
	
	
}
