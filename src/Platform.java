import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;
import java.util.Random;


public class Platform {

	int dx;
	int x, y, width, height;
	Image plat;
	URL url;
	float frame = 0;
	
	public Platform(int x, int y) {
		this.x = x;
		this.y = y;
		width = 167;
		height = 55;
		dx = -1;
		plat = Pictures.platform;
	}
	
	
	public int getX() {
		return x;
	}


	public void setX(int x) {
		this.x = x;
	}


	public int getWidth() {
		return width;
	}


	public void setWidth(int width) {
		this.width = width;
	}


	public void update(StartingPoint sp, Ball b) {
		int tester = (int) (frame + .1);
		if (tester < 3) {
			frame +=.1;
		} else {
			frame = 0;
		}
		x -= Pictures.level;
		//check for collision
		checkForCollision(b);
		if (x < 0 - width) {
			Random r = new Random();
			y = sp.getHeight() - 40 - r.nextInt(400);
			//x = sp.getWidth() + r.nextInt(300);
		}
	}
	
	private void checkForCollision(Ball b) {
		// TODO Auto-generated method stub
		int ballX = b.getX();
		int ballY = b.getY();
		int radius = b.getRadius();
		
		if (ballY + radius > y && ballY + radius < y + height) {
			if (ballX > x && ballX < x + width) {
				double  newDy = b.getGameDy();
				b.setY(y - radius);
				b.setDy(newDy);
				Pictures.bounce.play();
			}
		}
		
	}

	public void paint(Graphics g) {
		g.drawImage(plat, x, y, x + width, y + height, 0, 55*(int)frame, 167, 55*(int)frame + 55, Pictures.sp);
	}

	// 167x55
	
}
