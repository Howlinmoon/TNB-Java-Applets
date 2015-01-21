import java.awt.Color;
import java.awt.Graphics;


public class Platform {

	int dx;
	int x, y, width, height;
	
	public Platform() {
		// TODO Auto-generated constructor stub
		dx = -10;
		x = 300;
		y = 300;
		width = 120;
		height = 40;
	}
	
	public void update(StartingPoint sp, Ball b) {

		//check for collision
		checkForCollision(b);
	}
	
	private void checkForCollision(Ball b) {
		// TODO Auto-generated method stub
		int ballX = b.getX();
		int ballY = b.getY();
		int radius = b.getRadius();
		
		if (ballY + radius > y && ballY + radius < y + height) {
			double  newDy = b.getDy() * -1;
			b.setDy(newDy);
		}
		
	}

	public void paint(Graphics g) {
		g.setColor(Color.BLUE);
//		g.drawRect(x, y, width, height);
		g.fillRect(x, y, width, height);

	}

	
	
}
