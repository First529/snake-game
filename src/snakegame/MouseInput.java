package snakegame;
/**
 * This class is use to create mouse input to link between all of the state.
 */
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseInput implements MouseListener {

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void mousePressed(MouseEvent e) {
		int my = e.getY();
		int mx = e.getX();
		if (GamePanel.state != GamePanel.stateGame && GamePanel.state != GamePanel.stateHelp) {

			// public Rectangle playButton = new Rectangle(350, 325, 100, 50);
			// public Rectangle helpButton = new Rectangle(350, 425, 100, 50);
			// public Rectangle quitButton = new Rectangle(350, 525, 100, 50);

			if (mx >= 350 && mx <= 450) {
				if (my >= 325 && my <= 375) {
					GamePanel.state = GamePanel.stateGame;
				}
			}

			if (mx >= 350 / 3 + 50 && mx <= 450) {
				if (my >= 425 && my <= 475) {
					GamePanel.state = GamePanel.stateHelp;
				}
			}

			if (mx >= 350 && mx <= 450) {
				if (my >= 525 && my <= 575) {
					System.exit(1);
				}
			}

		}
		
		// public Rectangle backToMenu = new Rectangle(42, 730, 150, 30);

		if (GamePanel.state == GamePanel.stateHelp && GamePanel.state != GamePanel.stateGame) {
			if (mx >= 42 && mx <= 190) {
				if (my >= 730 && my <= 760) {
					GamePanel.state = GamePanel.stateMenu;
				}
			}
		}

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}
