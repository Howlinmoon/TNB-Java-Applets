import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class StartingPoint extends Applet implements Runnable, KeyListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Image i;
	private Graphics doubleG;
	Ball b, b2;
	Platform p,p2;
	
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
		p = new Platform();
		p2 = new Platform(100, 425);
		//p2 = new Platform(100, 550);
		// this gets called every time
		Thread thread = new Thread(this);
		thread.start();
		

	}
	
	@Override
	public void run() {
		// thread information - the thread runs down here
		while (true) {
			b.update(this);
			//b2.update(this);
			p.update(this, b);
			p2.update(this,  b);
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
		//b2.paint(g);
		p.paint(g);
		p2.paint(g);
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
