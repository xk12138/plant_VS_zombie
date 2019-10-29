package sun;

/*
 * 太阳的基类：
 * timer：在计时器内未点击的话太阳自动消失
 * energy：太阳的能量值（大太阳25，小太阳15）
 * posY：当前的纵坐标
 * targetY：目的纵坐标
 * speedY：降落速度
 */

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color ;
import java.awt.Dimension;
import java.awt.Point;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import javax.swing.Icon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import controller.MainController;

public class BasicSun {
	//先别看了大哥们，我太菜了啥也写不出来。
	public int timer;
    public int energy;
    public int posY;
    public int targetY;
    public int speedY;
    public JLabel label;
	MainController mainController;
	
	//loadImage()
    public void loadImage(String picPath) {        //指定图片的路径picPath
		JFrame frame = new JFrame("一个太阳的测试");
        Icon icon = new ImageIcon(picPath);               //使用字节数组，实例化ImageIcon对象
        // 实例化标签对象：带图片，居中对齐
        JLabel lab = new JLabel(icon, JLabel.CENTER); 
        BasicSun sun = new BasicSun();
        sun.mouseListener(lab);
        //设置标签背景颜色
        lab.setOpaque(true);
        lab.setBackground(Color.PINK);
        //把标签添加到面板中
        frame.add(lab); // 将组件件入到面板之中
        //设置窗口宽度和高度
        Dimension dim = new Dimension();
        dim.setSize(800,600 );
        frame.setSize(dim);
        frame.setVisible(true);
    }
	
//getImage()

    //太阳移动方法
	public void move() {
		posY += speedY;
		System.out.printf("present position:%d",posY);
	}
	
	//重写方法，监听鼠标点击太阳事件
	class SunListener extends MouseAdapter{
		public void mouseClicked(MouseEvent e){
			//就通知maincontroller收集了一个太阳，并且加在卡片的计算中
			//sumSun += energy;
			System.out.println("鼠标已点击!");
		}
	}
	public void mouseListener(JLabel label) {
		label.addMouseListener(new SunListener());
	}
	//测试一下
	public static void main(String[] args) {
		BasicSun sun = new BasicSun();
		sun.loadImage("F://Sun.gif");
	}
}