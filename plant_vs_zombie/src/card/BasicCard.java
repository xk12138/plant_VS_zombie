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
    public int timer;
	public JLabel label;
	
	//loadImage
	public void loadImage(String picPath) {//指定图片的路径
		JFrame frame = new JFrame("一张卡片的测试");
        Icon icon = new ImageIcon(picPath);               //使用字节数组，实例化ImageIcon对象
        // 实例化标签对象：带图片，居中对齐
        label = new JLabel(icon, JLabel.CENTER); 
        BasicCard card = new BasicCard();
        card.mouseListener(label);
        //设置标签背景颜色
        label.setOpaque(true);
        label.setBackground(Color.PINK);
        //把标签添加到面板中
        frame.add(label); // 将组件件入到面板之中
        // 设置窗体的背景颜色
        frame.getContentPane().setBackground(Color.WHITE);
        //设置窗口宽度和高度
        Dimension dim = new Dimension();
        dim.setSize(800,600 );
        frame.setSize(dim);
        frame.setVisible(true);
    }
	
	//getImage
	
	// 更新计时器
	//schedule(TimerTask task, long delay)  
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
	
	
	//重写方法，监听鼠标点击卡片事件
	class CardListener extends MouseAdapter{
		public void mouseClicked(MouseEvent e){
			System.out.println("点击了鼠标");
            //loadimage确定后，if(cd完成&&a >= plant.health)就拖拽出植物
			//sumSun是收集的阳光总量，从主控来
		}
	}
	public void mouseListener(JLabel label) {
		label.addMouseListener(new CardListener());
	}
}
