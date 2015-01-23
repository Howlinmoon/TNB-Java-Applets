import java.awt.Color;
import java.awt.Graphics;


public class GravityDown extends Item  {

	public GravityDown(int x) {
		super(x);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void performAction(Ball b) {
		if (b.getGravity() > 3) {
			b.setGravity(b.getGravity() - 3);
			if (b.getGravity() < 3) {
				b.setGravity(3);
			}
		}
	}
	
	@Override
	public void paint(Graphics g) {

		g.setColor(Color.YELLOW);

		super.paint(g);
	}

}
