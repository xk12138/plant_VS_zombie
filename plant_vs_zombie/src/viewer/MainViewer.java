package viewer;

import java.awt.*;

import javax.swing.*;

import block.BasicBlock;
import card.TorchwoodCard;
import controller.MainController;

@SuppressWarnings("serial")
public class MainViewer extends JFrame {
	// ����������
	public Container container;
	public JLayeredPane layeredPane;
	public JPanel jp, blockPanel;
	
	
	public MainController mainController;
	
	JLabel jl;
	// ������ʾ̫������Label
	public JLabel sumSun;
	
	//������ʾ������
	ImageIcon head = new ImageIcon("resource\\images\\interface\\FlagMeterParts1.png");
	ImageIcon empty = new ImageIcon("resource\\images\\interface\\FlagMeterEmptyCut.png");
	ImageIcon full = new ImageIcon("resource\\images\\interface\\FlagMeterFull.png");
	ImageIcon flag = new ImageIcon("resource\\images\\interface\\FlagMeterParts2.png");
	JLabel FlagMeterEmpty;
	JLabel FlagMeterHead;
	int sum_len;
	int step_len;
	
	public void setMainController(MainController mainController) {
		this.mainController = mainController;
	}
	
	public MainViewer() {
		super("Plant VS Zombie");
		this.setIconImage(new ImageIcon("resource\\images\\interface\\SmallLogo.png").getImage());
		this.container = this.getContentPane();
		
		
		// ���Ӵ��ڵ�����
		layeredPane = new JLayeredPane();
	
		ImageIcon image = new ImageIcon("resource\\images\\interface\\background1SL.jpg");
		//image = new ImageIcon()
		jl = new JLabel(image);
		//jl.setSize(image.getIconWidth(), image.getIconHeight());
		jl.setBounds(-150, -30, 1710, 750);
	
		
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

		// ����̫�������ı߿�
		sumSun = new JLabel("25");
		sumSun.setBounds(60, 5, 120, 30);
		jp.add(sumSun);
		ImageIcon sunBack = new ImageIcon("resource\\images\\interface\\SunBack.png");
		JLabel back = new JLabel(sunBack);
		back.setBounds(0, 0, sunBack.getIconWidth(), sunBack.getIconHeight());
		jp.add(back);
		
		initFlagMeter(1);
		next_batch();
		next_batch();
		
		// �ô�����ʾ����
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

	public void initFlagMeter(int batch) {
		// ���ƹؿ�������
		
		sum_len = 145;
		step_len = 145/(batch*5);

		FlagMeterHead = new JLabel(head);
		FlagMeterHead.setBounds(840 + sum_len, 675, head.getIconWidth(), head.getIconHeight());
		jp.add(FlagMeterHead);

		JLabel FlagMeterFlag = new JLabel(flag);
		FlagMeterFlag.setBounds(860, 675, flag.getIconWidth(), flag.getIconHeight());
		jp.add(FlagMeterFlag);
		int length = 145 / batch;
		for(int i=1;i<batch;i++) {
			FlagMeterFlag = new JLabel(flag);
			FlagMeterFlag.setBounds(860 + length*i, 675, flag.getIconWidth(), flag.getIconHeight());
			jp.add(FlagMeterFlag);
		}
		
		ImageIcon process = new ImageIcon("resource\\images\\interface\\FlagMeterLevelProgress.png");
		JLabel FlagMeterProcess = new JLabel(process);
		FlagMeterProcess.setBounds(875, 700, process.getIconWidth(), process.getIconHeight());
		
		FlagMeterEmpty = new JLabel(empty);
		FlagMeterEmpty.setBounds(860, 675, empty.getIconWidth(), empty.getIconHeight());
		jp.add(FlagMeterEmpty);
		JLabel FlagMeterFull = new JLabel(full);
		FlagMeterFull.setBounds(850, 675, full.getIconWidth(), full.getIconHeight());
		jp.add(FlagMeterFull);
	}
	
	public void next_batch() {
		sum_len -= step_len;
		if(sum_len > 0) {
			FlagMeterHead.setBounds(840 + sum_len, 675, head.getIconWidth(), head.getIconHeight());
			FlagMeterEmpty.setSize(sum_len, empty.getIconHeight());
		}
	}
}
