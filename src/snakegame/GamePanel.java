package snakegame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable, KeyListener {

	public static final int WIDTH = 800;
	public static final int HEIGHT = 800;
	// Render
	private Graphics2D g2d;
	private BufferedImage image;
	private GameMenu menu;
	private HelpMenu helpMenu;
	// Game loop
	private Thread thread;
	private boolean running;
	private long targetTime;
	// Game stuff
	private int SIZE = 20;
	private Entity head, apple, bonus;
	private ArrayList<Entity> snake;
	private int score;
	private int level;
	private boolean gameover;
	// movement
	private int dx, dy;
	// key input
	private boolean up, down, right, left, start;

	public GamePanel() {
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setFocusable(true);
		requestFocus();
		addKeyListener(this);
		this.addMouseListener(new MouseInput());

	}

	private enum STATE {
		MENU, GAME, HELP;
	}

	public static STATE state = STATE.MENU;
	public static STATE stateGame = STATE.GAME;
	public static STATE stateHelp = STATE.HELP;

	public void addNotify() {
		super.addNotify();
		thread = new Thread(this);
		thread.start();
	}

	private void setFPS(int fps) {
		targetTime = 1000 / fps;
	}

	public void keyPressed(KeyEvent e) {
		int k = e.getKeyCode();
		if (k == KeyEvent.VK_UP )
			up = true;
		else if (k == KeyEvent.VK_DOWN )
			down = true;
		else if (k == KeyEvent.VK_LEFT )
			left = true;
		else if (k == KeyEvent.VK_RIGHT )
			right = true;
		else if (k == KeyEvent.VK_ENTER)
			start = true;

	}

	public void keyReleased(KeyEvent e) {
		int k = e.getKeyCode();
		if (k == KeyEvent.VK_UP )
			up = false;
		else if (k == KeyEvent.VK_DOWN )
			down = false;
		else if (k == KeyEvent.VK_LEFT )
			left = false;
		else if (k == KeyEvent.VK_RIGHT )
			right = false;
		else if (k == KeyEvent.VK_ENTER)
			start = false;

	}

	public void run() {
		init();
		long startTime;
		long elapsed;
		long wait;
		while (running) {
			startTime = System.nanoTime();

			update();
			requestRender();

			elapsed = System.nanoTime() - startTime;
			wait = targetTime - elapsed / 1000000;
			if (wait > 0) {
				try {
					Thread.sleep(wait);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

	}

	private void init() {
		image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_ARGB);
		menu = new GameMenu();
		helpMenu = new HelpMenu();
		g2d = image.createGraphics();
		running = true;
		setUplevel();
		
	}

	private void setUplevel() {
		dx = 0;
		dy = 0;
		snake = new ArrayList<Entity>();
		head = new Entity(SIZE);
		head.setPos(WIDTH / 2, HEIGHT / 2);
		snake.add(head);
		for (int i = 1; i < 3; i++) {
			Entity e = new Entity(SIZE);
			e.setPos(head.getX() + (i * SIZE), head.getY());
			snake.add(e);
		}
		apple = new Entity(SIZE);
		setApple();
		score = 0;
		gameover = false;
		dx = dy;
		dy = 0;
		level = 1;
		setFPS(level * 10);

	}

	public void setApple() {
		int x = (int) (Math.random() * (WIDTH - SIZE));
		int y = (int) (Math.random() * (HEIGHT - SIZE));
		x = x - (x % SIZE);
		y = y - (y % SIZE);
		apple.setPos(x, y);
	}

	private void requestRender() {
		render(g2d);
		Graphics g = getGraphics();
		g.drawImage(image, 0, 0, null);
		g.dispose();

	}

	private void update() {
		if (gameover) {
			if (start) {
				setUplevel();
			}
			return;
		}
		if (up && dy == 0) {
			dy = -SIZE;
			dx = 0;
		}
		if (down && dy == 0) {
			dy = SIZE;
			dx = 0;
		}
		if (left && dx == 0) {
			dy = 0;
			dx = -SIZE;
		}
		if (right && dx == 0 && dy != 0) {
			dy = 0;
			dx = SIZE;
		}
		if (dx != 0 || dy != 0) {
			for (int i = snake.size() - 1; i > 0; i--) {
				snake.get(i).setPos(snake.get(i - 1).getX(), snake.get(i - 1).getY());
			}
			head.move(dx, dy);
		}

		for (Entity e : snake) {
			if (e.isCollsion(head)) {
				gameover = true;
				break;
			}
		}

		if (apple.isCollsion(head)) {
			score++;
			setApple();

			Entity e = new Entity(SIZE);
			e.setPos(-100, -100);
			snake.add(e);
			if (score % 10 == 0) {
				level++;
				if (level > 10)
					level = 10;
				setFPS(level * 10);
			}
		}

		if (head.getX() < 0)
			head.setX(WIDTH);
		if (head.getY() < 0)
			head.setY(HEIGHT);

		if (head.getX() > WIDTH)
			head.setX(0);
		if (head.getY() > HEIGHT)
			head.setY(0);

	}

	public void render(Graphics2D g2d) {
		if (state == STATE.GAME) {
			g2d.clearRect(0, 0, WIDTH, HEIGHT);
			g2d.setColor(Color.GREEN);
			for (Entity e : snake) {
				e.render(g2d);
			}
			g2d.setColor(Color.RED);
			apple.render(g2d);
			if (gameover) {
				g2d.drawString("GameOver! Please press enter to start a new game", 150, 200);
			}

			g2d.setColor(Color.WHITE);
			Font font = new Font("arial", Font.ITALIC, 20);
			g2d.setFont(font);
			g2d.drawString("SCORE : " + score + " Level : " + level, 30, 30);
			
		} else if (state == STATE.MENU) {
			setBackground(Color.black);
			menu.render(g2d);
		} else if (state == STATE.HELP) {
			g2d.clearRect(0, 0, WIDTH, HEIGHT);
			setBackground(Color.black);
			helpMenu.render(g2d);
			
		}
			
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

}
