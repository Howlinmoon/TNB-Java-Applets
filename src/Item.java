import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;


public class Item {
		
	private int x, y, dx, radius;
	private StartingPoint sp;
	private boolean createNew = false;
	
	public boolean isCreateNew() {
		return createNew;
	}

	public void setCreateNew(boolean createNew) {
		this.createNew = createNew;
	}

	public Item(int x) {
		// TODO Auto-generated constructor stub
		this.x = x;
		Random r = new Random();
		radius = 10;
		y = r.nextInt(400) + radius;
		dx = -2;
	}
		
	public void update(StartingPoint sp, Ball b) {
		x += dx;
		this.sp = sp;
		//check for collision
		checkForCollision(b);
		if (x < 0 - radius) {
			createNew = true;
		}
	}
	
	private void checkForCollision(Ball b) {
		int ballX = b.getX();
		int ballY = b.getY();
		int ballR = b.getRadius();
		
		int aSide = x - ballX;
		int bSide = y - ballY;
		int collide = radius + ballR;
		// c = distance between the centers
		double c = Math.sqrt( (double) (aSide * aSide) + (double) (bSide * bSide));
		if (c < collide) {
			performAction(b);
			createNew = true;
		}
		
	}

	public void performAction(Ball b) {
		// TODO Auto-generated method stub
		
	}

	public void paint(Graphics g) {
//		g.setColor(Color.GREEN);
		g.fillOval(x-radius, y-radius, radius*2, radius*2);

	}

	// random getters and setters
	public int getY() {
		return y;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	
}
