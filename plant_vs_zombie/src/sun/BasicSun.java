package sun;

/*
 * ̫���Ļ��ࣺ
 * timer���ڼ�ʱ����δ����Ļ�̫���Զ���ʧ
 * energy��̫��������ֵ����̫��25��С̫��15��
 * posY����ǰ��������
 * targetY��Ŀ��������
 * speedY�������ٶ�
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
	//�ȱ��˴���ǣ���̫����ɶҲд��������
	public int timer;
    public int energy;
    public int posY;
    public int targetY;
    public int speedY;
    public JLabel label;
	MainController mainController;
	
	//loadImage()
    public void loadImage(String picPath) {        //ָ��ͼƬ��·��picPath
		JFrame frame = new JFrame("һ��̫���Ĳ���");
        Icon icon = new ImageIcon(picPath);               //ʹ���ֽ����飬ʵ����ImageIcon����
        // ʵ������ǩ���󣺴�ͼƬ�����ж���
        JLabel lab = new JLabel(icon, JLabel.CENTER); 
        BasicSun sun = new BasicSun();
        sun.mouseListener(lab);
        //���ñ�ǩ������ɫ
        lab.setOpaque(true);
        lab.setBackground(Color.PINK);
        //�ѱ�ǩ��ӵ������
        frame.add(lab); // ��������뵽���֮��
        //���ô��ڿ�Ⱥ͸߶�
        Dimension dim = new Dimension();
        dim.setSize(800,600 );
        frame.setSize(dim);
        frame.setVisible(true);
    }
	
//getImage()

    //̫���ƶ�����
	public void move() {
		posY += speedY;
		System.out.printf("present position:%d",posY);
	}
	
	//��д���������������̫���¼�
	class SunListener extends MouseAdapter{
		public void mouseClicked(MouseEvent e){
			//��֪ͨmaincontroller�ռ���һ��̫�������Ҽ��ڿ�Ƭ�ļ�����
			//sumSun += energy;
			System.out.println("����ѵ��!");
		}
	}
	public void mouseListener(JLabel label) {
		label.addMouseListener(new SunListener());
	}
	//����һ��
	public static void main(String[] args) {
		BasicSun sun = new BasicSun();
		sun.loadImage("F://Sun.gif");
	}
}