package snakegame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class HelpMenu {
	
	public Rectangle controlKeys = new Rectangle(GamePanel.WIDTH / 3 +50, 150, 100, 50);
	
	void render (Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		Font fnt0 = new Font("arial", Font.BOLD, 30);
		g.setFont(fnt0);
		g.setColor(Color.WHITE);
		g.drawString("How to control the snake", GamePanel.WIDTH / 3, 100);
		g.drawString("↑", GamePanel.WIDTH / 2, 200);
		g.drawString("←", GamePanel.WIDTH / 3, 300);
		g.drawString("↓", GamePanel.WIDTH / 2, 400);
		g.drawString("→", (GamePanel.WIDTH / 2) + 100, 300);
		g.drawString("How to control the snake", GamePanel.WIDTH / 3, 100);
		
	}
			
	

}
