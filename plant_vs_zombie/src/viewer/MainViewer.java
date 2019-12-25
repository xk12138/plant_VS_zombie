package viewer;

import java.awt.*;

import javax.swing.*;

import block.BasicBlock;
import card.TorchwoodCard;
import controller.MainController;

@SuppressWarnings("serial")
public class MainViewer extends JFrame {
	// 界面类属性
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
		
		
		// 增加窗口的内容
		layeredPane = new JLayeredPane();
	
		ImageIcon image = new ImageIcon("resource\\images\\interface\\background1SL.jpg");
		//image = new ImageIcon()
		jl = new JLabel(image);
		//jl.setSize(image.getIconWidth(), image.getIconHeight());
		jl.setBounds(-150, -30, 1710, 750);
	
		
		// 创建方块层
		blockPanel = new JPanel();
		blockPanel.setBounds(0, 0, 1110, 750);
		blockPanel.setLayout(null);
		blockPanel.setOpaque(false);
		layeredPane.add(blockPanel, -1);
		
		jp = new JPanel();
		jp.setLayout(null);
		jp.setBounds(0, 0, 1110, 750);
		layeredPane.add(jp, 0);

		
		// 让窗口显示出来
		this.setLayeredPane(layeredPane);
		this.setSize(1110, 750);
		this.setVisible(true);
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
	}
	
	public void draw() {
		for(int i=0;i<mainController.lineNum;i++) {
			for(BasicBlock block: mainController.lineControllers[i].blocks) {
				blockPanel.add(block.label);
			}
		}
		//将所有的card添加进窗口来显示
	}
	
	public void addLabel(JLabel label) {
		jp.remove(jl);
		jp.add(label);
		
		for(int i=0;i<5;i++) {
			for(BasicBlock block: mainController.lineControllers[i].blocks) {
				if(block.plant != null) {
					jp.remove(block.plant.label);
					jp.add(block.plant.label);
				}
			}
		}
		
		
		jp.add(jl);
		jp.repaint();
		
	}
	public void removeLabel(JLabel label) {
		jp.remove(label);
		jp.repaint();
	}

}
