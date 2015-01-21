import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;


public class StartingPoint extends Applet implements Runnable {
	
	int x = 400;
	int y = 25;
	double dx = 0;
	double dy = 0;
	int radius = 20;
	private Image i;
	private Graphics doubleG;
	double gravity = 15;
	double energyloss = .65;
	double dt = .2;
	
	@Override
	public void init() {
		// this is called only once
		// set the size of the canvas
		setSize(800, 600);
	}
	
	@Override
	public void start() {
		// this gets called every time
		Thread thread = new Thread(this);
		thread.start();
		

	}
	
	@Override
	public void run() {
		// thread information - the thread runs down here
		while (true) {
			// X boundaries
			if ( x + dx > this.getWidth() - radius - 1) {
				x = this.getWidth() - radius - 1;
				dx = -dx;
			} else if (x + dx < 0 + radius ) {
					x = 0 + radius;
					dx = -dx;
			}
			x += dx;

//			// Y boundaries (simple - original)
//			if ( y + dy > this.getHeight() - radius - 1) {
//				y = this.getHeight() - radius - 1;
//				dy = -dy;
//			} else if (y + dy < 0 + radius ) {
//					y = 0 + radius;
//					dy = -dy;
//			}
//			y += dy;

			if (y > this.getHeight() - radius - 1) {
				// at the bottom of the applet
				y = this.getHeight() - radius - 1;
				dy *= energyloss;
				dy = -dy;
				
			} else {
				// velocity formula
				dy = dy + gravity * dt;
				// adjust y with gravity;
				y +=  dy * dt + .5 * gravity * dt * dt;
				
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
		// Color change depending on the deltas
		
		if (dx > 0 && dy > 0) {
			g.setColor(Color.BLUE);
		} else if (dx > 0 && dy < 0) {
			g.setColor(Color.RED);
		} else if (dx < 0 && dy > 0) {
			g.setColor(Color.GREEN);
		} else {
			g.setColor(Color.ORANGE);
		}
		g.fillOval(x-radius, y-radius, radius*2, radius*2);
		
		

	}

	
}
