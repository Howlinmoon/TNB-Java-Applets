import java.awt.Color;
import java.awt.Graphics;


public class Ball {

	private int x = 400;
	private int y = 25;
	private double dx = 20;
	private double dy = 0;
	private int radius = 20;
	private double gravity = 15;
	private double energyloss = 1.0;
	private double dt = .2;
	private double xFriction = .9;
	private double gameDy = -75;
	private int agility = 3;
	private int maxSpeed = 20;
	private boolean game_over = false;

	public int getAgility() {
		return agility;
	}

	public void setAgility(int agility) {
		this.agility = agility;
	}

	public int getMaxSpeed() {
		return maxSpeed;
	}

	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}

	public Ball() {
		// boring default constructor
	}
	
	public Ball(int i, int j) {
		// constructor that allow specification of starting co-ords
		x = i;
		y = j;
	}
	
	// generic getters and setters
	
	public double getGameDy() {
		return gameDy;
	}
	
	public void setGameDy(double gameDy) {
		this.gameDy = gameDy;
	}
	
	public int getY() {
		return y;
	}
	
	public int getX() {
		return x;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public double getDx() {
		return dx;
	}
	
	public int getRadius() {
		return radius;
	}
	
	public void setDx(double dx) {
		this.dx = dx;
	}
	
	public double getDy() {
		return dy;
	}
	
	public void setDy(double dy) {
		this.dy = dy;
	}
	
	public void setGravity(double gravity) {
		this.gravity = gravity;
	}
	
	public double getGravity() {
		return gravity;
	}
	
	public void moveRight() {
		if (dx+agility < maxSpeed) {
			dx +=agility;
		}
	}
	
	public void moveLeft() {
		if (dx-agility > -maxSpeed) {
			dx -= agility ;
		}
	}

	public void update(StartingPoint sp) {
		// X boundaries
		if ( x + dx > sp.getWidth() - radius - 1) {
			x = sp.getWidth() - radius - 1;
			dx = -dx;
		} else if (x + dx < 0 + radius ) {
				x = 0 + radius;
				dx = -dx;
		}
		x += dx;

		if (y == sp.getHeight() - radius - 1) {
			// ball is exactly at the bottom
			dx *= xFriction;
			if (Math.abs(dx) < .8) {
				dx = 0;
			}
		}
		

		if (y - 200 > sp.getHeight() - radius - 1) {
			game_over = true;
//			// at the bottom of the applet
//			y = sp.getHeight() - radius - 1;
//			dy *= energyloss;
//			//dy = -dy;
//			dy = gameDy;
			
		} else {
			// velocity formula
			dy = dy + gravity * dt;
			// adjust y with gravity;
			y +=  dy * dt + .5 * gravity * dt * dt;
			
		}
		
	}
	
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

	public boolean getGameOver() {
		// TODO Auto-generated method stub
		return game_over;
	}

	
}
