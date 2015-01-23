import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;


public class StartingPoint extends Applet implements Runnable, KeyListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Image i;
	private Graphics doubleG;
	Ball b, b2;
	Platform p[] = new Platform[7];
	Item item[] = new Item[3];
	
	@Override
	public void init() {
		// this is called only once
		// set the size of the canvas
		setSize(800, 600);
		// refers to the 3 default key listener
		addKeyListener(this);
		
	}
	
	@Override
	public void start() {
		b = new Ball();
		//b2 = new Ball(250,250);
		for (int i = 0; i < p.length ; i++) {
			Random r = new Random();
			p[i] = new Platform(getWidth() + 200 * i, getHeight() - 40 - r.nextInt(400));
		}

		for (int i = 0; i < item.length ; i++) {
			//Random r = new Random();
			item[i] = new GravityUp(getWidth() + 2000 * i);
		}

		
		// this gets called every time
		Thread thread = new Thread(this);
		thread.start();
		

	}
	
	@Override
	public void run() {
		// thread information - the thread runs down here
		while (true) {
		
			for (int i = 0; i < item.length; i ++) {
				if (item[i].getY() == this.getHeight() + 100) {
					item[i] = null;
					item[i] = new GravityUp(getWidth());
				}
			}
		
			b.update(this);
			for (int i = 0; i < p.length; i++) {
				p[i].update(this, b);
			}

			for (int i = 0; i < item.length; i++) {
				item[i].update(this, b);
			}

			
			// repaint calls the paint method
			repaint();
			try {
				Thread.sleep(17);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	
	
	@Override
	public void stop() {

	}
	
	@Override
	public void destroy() {

	}
	
	@Override
	public void update(Graphics g) {
		// called prior to painting
		if (i == null) {
			// create the image for the first time
			i = createImage(this.getSize().width, this.getSize().height);
			doubleG = i.getGraphics();
		}
		
		doubleG.setColor(getBackground());
		doubleG.fillRect(0, 0, this.getSize().width, this.getSize().height);
		
		doubleG.setColor(getForeground());
		paint(doubleG);
		g.drawImage(i, 0, 0, this);
	}
	
	@Override
	public void paint(Graphics g) {
		b.paint(g);
		for (int i = 0; i < p.length; i++) {
			p[i].paint(g);
		}
		
		for (int i = 0; i < item.length; i++) {
			item[i].paint(g);
		}

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		switch(e.getKeyCode()) {
		case KeyEvent.VK_A:
			// left key
			System.out.println("A key detected");
			b.moveLeft();
			break;

		case KeyEvent.VK_D:
			// right key
			System.out.println("D key detected");
			b.moveRight();
			break;
		}
		
	}

	
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	
}
