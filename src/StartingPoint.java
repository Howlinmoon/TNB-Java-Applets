import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;


public class StartingPoint extends Applet implements Runnable {
	
	int x = 0;
	int y = 0;
	int dx = 1;
	int dy = 1;
	int radius = 20;
	
	@Override
	public void init() {
		// this is called only once
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
			x += dx;
			y += dy;
			
			// maximum limiting?
			
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
	public void paint(Graphics g) {
		
		g.setColor(Color.BLUE);
		g.fillOval(x-radius, y-radius, radius*2, radius*2);
		
		

	}

	
}
