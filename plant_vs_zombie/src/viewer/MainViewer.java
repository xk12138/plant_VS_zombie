package viewer;

import java.awt.*;
import javax.swing.*;

import block.BasicBlock;
import bullet.BasicBullet;
import controller.MainController;
import zombie.BasicZombie;

@SuppressWarnings("serial")
public class MainViewer extends JFrame {
	// ����������
	public Container container;
	public JLayeredPane layeredPane;
	public JPanel jp;
	
	public MainController mainController;
	public void setMainController(MainController mainController) {
		this.mainController = mainController;
	}
	
	public MainViewer() {
		super("Plant VS Zombie");
		this.setIconImage(new ImageIcon("resource\\images\\interface\\SmallLogo.png").getImage());
		this.container = this.getContentPane();
		
		// ���Ӵ��ڵ�����
		layeredPane = new JLayeredPane();
		ImageIcon image = new ImageIcon("resource\\images\\interface\\background1.jpg");
		jp = new JPanel();
		jp.setBounds(0, 0, image.getIconWidth(), image.getIconHeight());
		JLabel jl = new JLabel(image);
		jp.add(jl);
		layeredPane.add(jp, JLayeredPane.DEFAULT_LAYER);
		
		// �ô�����ʾ����
		this.setLayeredPane(layeredPane);
		this.setSize(905, 640);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
	}
	
	public void draw() {
		for(int i=0;i<mainController.lineNum;i++) {
			for(BasicBlock block: mainController.lineControllers[i].blocks) {
				jp.add(block.label);
			}
		}
		//�����е�card��ӽ���������ʾ
		
	}
	
	public void addLabel(JLabel label) {
		jp.add(label);
	}
	public void removeLabel(JLabel label) {
		jp.remove(label);
	}
}
