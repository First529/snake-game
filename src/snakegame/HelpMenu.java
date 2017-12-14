package snakegame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class HelpMenu {

	public Rectangle backToMenu = new Rectangle(42, 730, 150, 30);

	void render(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		Font fnt0 = new Font("arial", Font.BOLD, 24);
		Font fnt1 = new Font("arial", Font.ITALIC, 15);
		Font fnt2 = new Font("arial", Font.ROMAN_BASELINE, 17);
		g.setFont(fnt0);
		g.setColor(Color.WHITE);
		g.drawString("Description", GamePanel.WIDTH / 3 -200, 100);

		g.setFont(fnt2);
		g.drawString("This is the developed version of the most popular mobile and computer game named “SNAKE” in the", GamePanel.WIDTH / 2 -350 , 150);
		g.drawString("early 2000s. The main objective of this game is to feed an increasing length of a snake with", GamePanel.WIDTH / 2 - 350, 200);
		g.drawString("different type of food particles which are found at random positions in the game.", GamePanel.WIDTH/ 2 - 350, 250);
		
		
		g.setFont(fnt0);
		g.drawString("Type of particles",GamePanel.WIDTH / 3 -200, 325 );
		g2d.setColor(Color.RED);
		g2d.fillRect(75, 375, 20, 20);
		g2d.drawRect(75, 375, 20, 20);
		g.setFont(fnt2);
		g.setColor(Color.WHITE);
		g.drawString("Normal apple - spawn in every level of the game (score +1)", 125, 385);
		g2d.setColor(Color.YELLOW);
		g2d.fillRect(75, 425, 20, 20);
		g2d.drawRect(75, 425, 20, 20);
		g.setFont(fnt2);
		g.setColor(Color.WHITE);
		g.drawString("Flash apple - grant player speed, spawn only when your score is 30 or above (score +0)", 125, 440);
		g2d.setColor(Color.BLUE);
		g2d.fillRect(75, 475, 20, 20);
		g2d.drawRect(75, 475, 20, 20);
		g.setFont(fnt2);
		g.setColor(Color.WHITE);
		g.drawString("Blue apple - increase the length, spawn only when your score is 50 or above (score +0)", 125, 490);
		g2d.setColor(Color.BLACK);
		g2d.fillRect(75, 525, 20, 20);
		g2d.drawRect(75, 525, 20, 20);
		g.setFont(fnt2);
		g.setColor(Color.WHITE);
		g.drawString("Invisible apple - increase your score by 4 and reduce the speed, spawn only when your", 125, 540);
		g.drawString("score is 70 or above (score +4)", 125, 580);
		
		g.setFont(fnt1);
		g.setColor(Color.WHITE);
		g.drawString("Back to game menu", GamePanel.WIDTH/ 2 -350 , 750);
		g2d.draw(backToMenu);

	}

}
