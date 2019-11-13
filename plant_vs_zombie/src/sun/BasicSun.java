package sun;

/*
 * 太锟斤拷锟侥伙拷锟洁：
 * timer锟斤拷锟节硷拷时锟斤拷锟斤拷未锟斤拷锟斤拷幕锟教拷锟斤拷远锟斤拷锟绞�
 * energy锟斤拷太锟斤拷锟斤拷锟斤拷锟斤拷值锟斤拷锟斤拷太锟斤拷25锟斤拷小太锟斤拷15锟斤拷
 * posY锟斤拷锟斤拷前锟斤拷锟斤拷锟斤拷锟斤拷
 * targetY锟斤拷目锟斤拷锟斤拷锟斤拷锟斤拷
 * speedY锟斤拷锟斤拷锟斤拷锟劫讹拷
 */

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color ;
import java.awt.Dimension;
import javax.swing.Icon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import controller.MainController;

public class BasicSun {
	//锟饺憋拷锟剿达拷锟斤拷牵锟斤拷锟教拷锟斤拷锟缴兑残达拷锟斤拷锟斤拷锟斤拷锟�
	public int timer;
    public int energy;
    public int posY;
    public int targetY;
    public int speedY;
    public JLabel label;
	MainController mainController;
	
	//loadImage()
    public void loadImage(String picPath) {        //指锟斤拷图片锟斤拷路锟斤拷picPath
		JFrame frame = new JFrame("一锟斤拷太锟斤拷锟侥诧拷锟斤拷");
        Icon icon = new ImageIcon(picPath);               //使锟斤拷锟街斤拷锟斤拷锟介，实锟斤拷锟斤拷ImageIcon锟斤拷锟斤拷
        // 实锟斤拷锟斤拷锟斤拷签锟斤拷锟襟：达拷图片锟斤拷锟斤拷锟叫讹拷锟斤拷
        JLabel lab = new JLabel(icon, JLabel.CENTER); 
        BasicSun sun = new BasicSun();
        sun.mouseListener(lab);
        //锟斤拷锟矫憋拷签锟斤拷锟斤拷锟斤拷色
        lab.setOpaque(true);
        lab.setBackground(Color.PINK);
        //锟窖憋拷签锟斤拷拥锟斤拷锟斤拷锟斤拷
        frame.add(lab); // 锟斤拷锟斤拷锟斤拷锟斤拷氲斤拷锟斤拷之锟斤拷
        //锟斤拷锟矫达拷锟节匡拷群透叨锟�
        Dimension dim = new Dimension();
        dim.setSize(800,600 );
        frame.setSize(dim);
        frame.setVisible(true);
    }
	
//getImage()

    //太锟斤拷锟狡讹拷锟斤拷锟斤拷
	public void move() {
		posY += speedY;
		System.out.printf("present position:%d",posY);
	}
	
	//锟斤拷写锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟教拷锟斤拷录锟�
	class SunListener extends MouseAdapter{
		public void mouseClicked(MouseEvent e){
			//锟斤拷通知maincontroller锟秸硷拷锟斤拷一锟斤拷太锟斤拷锟斤拷锟斤拷锟揭硷拷锟节匡拷片锟侥硷拷锟斤拷锟斤拷
			//sumSun += energy;
			System.out.println("锟斤拷锟斤拷训锟斤拷!");
		}
	}
	public void mouseListener(JLabel label) {
		label.addMouseListener(new SunListener());
	}
}