import java.applet.Applet;
import java.awt.Graphics;


public class StartingPoint extends Applet implements Runnable {
	
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

	}

	
}
