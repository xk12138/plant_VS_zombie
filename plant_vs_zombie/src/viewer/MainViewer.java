package viewer;

import java.awt.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class MainViewer extends JFrame {
	public Container container;
	
	public MainViewer() {
		super("Plant VS Zombie");
		this.setIconImage(new ImageIcon("resource\\images\\interface\\SmallLogo.png").getImage());
		this.container = this.getContentPane();
		
		// 增加窗口的内容
		JLayeredPane layeredPane = new JLayeredPane();
		ImageIcon image = new ImageIcon("resource\\images\\interface\\Surface.png");
		JPanel jp = new JPanel();
		jp.setBounds(0, 0, image.getIconWidth(), image.getIconHeight());
		JLabel jl = new JLabel(image);
		jp.add(jl);
		layeredPane.add(jp, JLayeredPane.DEFAULT_LAYER);
		
		// 让窗口显示出来
		this.setLayeredPane(layeredPane);
		this.setSize(905, 640);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
	}
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		MainViewer mainViewer = new MainViewer();
	}
}
