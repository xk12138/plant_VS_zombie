package viewer;

import java.awt.*;

import javax.swing.*;

import block.BasicBlock;
import controller.MainController;
import plant.PeaShooter;

@SuppressWarnings("serial")
public class MainViewer extends JFrame {
	// ����������
	public Container container;
	public JLayeredPane layeredPane;
	public JPanel jp, background, blockPanel;
	
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
		//ImageIcon image = new ImageIcon("resource\\images\\interface\\background1.jpg");
		//background = new JPanel();
		//background.setBounds(0, 0, image.getIconWidth(), image.getIconHeight());
		//JLabel jl = new JLabel(image);
		//background.add(jl);
		//layeredPane.add(background, JLayeredPane.DEFAULT_LAYER);
		
		// ���������
		blockPanel = new JPanel();
		blockPanel.setBounds(0, 0, 1110, 750);
		blockPanel.setLayout(null);
		layeredPane.add(blockPanel, -1);
		
		jp = new JPanel();
		jp.setLayout(null);
		jp.setBounds(0, 0, 1110, 750);
		layeredPane.add(jp, 0);
		
		// �ô�����ʾ����
		this.setLayeredPane(layeredPane);
		this.setSize(1110, 750);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
	}
	
	public void draw() {
		for(int i=0;i<mainController.lineNum;i++) {
			for(BasicBlock block: mainController.lineControllers[i].blocks) {
				blockPanel.add(block.label);
			}
		}
		//�����е�card��ӽ���������ʾ
	}
	
	public void addLabel(JLabel label) {
		jp.add(label);
	}
	public void removeLabel(JLabel label) {
		jp.remove(label);
		jp.repaint();
	}

}
