package sun;

/*
 * The base of sun.
 * Attribute:
 * a clocker: timer;		The sun will be removed when the timer is zero.
 * current position: posY;	The sun will move vertically so the posX is the targetX.
 * target position: targetX, targetY;	The target of the sun.
 * the energy:				Usually the energy value of a sun is 25.
 * the speed of the sun: speedY.
 */

import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import controller.MainController;

public class BasicSun {
	public int timer;
    public int energy;
    public int posY;
    public int targetX, targetY;
    public int speedY;
    public JLabel label;
    
	MainController mainController;
	
	public BasicSun(int targetX, int posY, int targetY, MainController mainController) {
		this.targetX = targetX;
		this.targetY = targetY;
		this.posY = posY;
		this.mainController = mainController;
		speedY = 50;
		timer = 300;
	}

    // Every frame the sun moves to the target position.
	public void move() {
		if(posY <= targetY)
			posY += speedY;
		System.out.printf("present position:%d",posY);
	}

	// If the sun is clicked, it will be deleted from the SunController and the MainController's sumSun will increase.
	public void mouseListener(JLabel label) {
		BasicSun that = this;			// Use that to instead of this to avoid ambiguity.
		label.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				mainController.sumSun += energy;
				mainController.mainViewer.removeLabel(label);
				mainController.sunController.suns.remove(that);
				// We need to remove the sun's JLabel from the viewer.
			}
		});
	}
}