package viewer;

import java.awt.*;

import javax.swing.*;

import block.BasicBlock;
import controller.MainController;

@SuppressWarnings("serial")
public class MainViewer extends JFrame {
	// ����������
	public Container container;
	public JLayeredPane layeredPane;
	public JPanel jp, blockPanel;
	
	
	public MainController mainController;
	
	JLabel jl;
	
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
		//image = new ImageIcon()
		jl = new JLabel(image);
		jl.setBounds(0, 0, 1110, 750);
	
		
		//background.add(jl);
		//layeredPane.add(background, JLayeredPane.DEFAULT_LAYER);
		//layeredPane.add(background, 3);
		
		// ���������
		blockPanel = new JPanel();
		blockPanel.setBounds(0, 0, 1110, 750);
		blockPanel.setLayout(null);
		blockPanel.setOpaque(false);
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
		jp.remove(jl);
		jp.add(label);
		jp.add(jl);
		jp.repaint();
		
	}
	public void removeLabel(JLabel label) {
		jp.remove(label);
		jp.repaint();
	}

}
