package viewer;

import java.awt.*;
import javax.swing.*;

public class MainViewer extends JFrame {
	public Container container;
	
	public MainViewer() {
		super("Plant VS Zombie");
		this.setIconImage(new ImageIcon("resource\\images\\interface\\SmallLogo.png").getImage());
		this.container = this.getContentPane();
		
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
