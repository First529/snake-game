package snakegame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class GameMenu {
	
	public Rectangle playButton = new Rectangle(GamePanel.WIDTH /3 + 50, 150, 100, 50);
	public Rectangle helpButton = new Rectangle(GamePanel.WIDTH /3 + 50, 250, 100, 50);
	public Rectangle quitButton = new Rectangle(GamePanel.WIDTH /3 + 50, 350, 100, 50);
	
	void render (Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		Font fnt0 = new Font("arial", Font.BOLD, 30);
		g.setFont(fnt0);
		g.setColor(Color.WHITE);
		g.drawString("SNAKE GAME", GamePanel.WIDTH / 3, 100);
		Font fnt1 = new Font("arial" , Font.BOLD, 30);
		g.setFont(fnt1);
		g.drawString("Play", playButton.x + 15, playButton.y + 32);
		g2d.draw(playButton);
		g.drawString("Help", helpButton.x + 15, helpButton.y + 32);
		g2d.draw(helpButton);
		g.drawString("Quit", quitButton.x + 15, quitButton.y + 32);
		g2d.draw(quitButton);
		
	}

}