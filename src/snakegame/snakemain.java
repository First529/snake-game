package snakegame;
/**
 * The main class to run the game.
 */
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;

public class snakemain {

	public static void main(String[] args) {
		
		JFrame frame = new JFrame("Snake");
		frame.setContentPane(new GamePanel());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.pack();
		frame.setPreferredSize(new Dimension(GamePanel.WIDTH, GamePanel.HEIGHT));
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
	}

}
