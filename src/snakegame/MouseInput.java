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
		
		//public Rectangle playButton = new Rectangle(GamePanel.WIDTH /3 + 50, 150, 100, 50);
		//public Rectangle helpButton = new Rectangle(GamePanel.WIDTH /3 + 50, 250, 100, 50);
		//public Rectangle quitButton = new Rectangle(GamePanel.WIDTH /3 + 50, 350, 100, 50);
		
		if (mx >= GamePanel.WIDTH / 3 +50 && mx <= GamePanel.WIDTH / 3 + 150) {
			if (my >= 150 && my <= 200) {
				GamePanel.state = GamePanel.stateGame;
			}
		}
		
		if (mx >= GamePanel.WIDTH / 3 +50 && mx <= GamePanel.WIDTH / 3 + 250) {
			if (my >= 250 && my <= 300) {
				GamePanel.state = GamePanel.stateHelp;
			}
		}
		
		if (mx >= GamePanel.WIDTH / 3 +50 && mx <= GamePanel.WIDTH / 3 + 150) {
			if (my >= 350 && my <= 400) {
				System.exit(1);
			}
		}
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	

}
