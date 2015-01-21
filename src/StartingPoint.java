import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;


public class StartingPoint extends Applet implements Runnable {
	
	private Image i;
	private Graphics doubleG;
	Ball b, b2;
	
	@Override
	public void init() {
		// this is called only once
		// set the size of the canvas
		setSize(800, 600);
	}
	
	@Override
	public void start() {
		b = new Ball();
		b2 = new Ball(250,250);
		// this gets called every time
		Thread thread = new Thread(this);
		thread.start();
		

	}
	
	@Override
	public void run() {
		// thread information - the thread runs down here
		while (true) {
			b.update(this);
			b2.update(this);
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
		b2.paint(g);
	}

	
}
