package snakegame;

import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseInput implements MouseListener{

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
		if (GamePanel.state != GamePanel.stateGame) {
		
			// public Rectangle playButton = new Rectangle(350, 325, 100, 50);
			// public Rectangle helpButton = new Rectangle(350, 425, 100, 50);
			// public Rectangle quitButton = new Rectangle(350, 525, 100, 50);
		
		if (mx >= 350 && mx <= 450) {
			if (my >= 325 && my <= 375) {
				GamePanel.state = GamePanel.stateGame;
			}
		}
		
		if (mx >= 350 / 3 +50 && mx <= 450) {
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
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	

}
