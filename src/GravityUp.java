import java.awt.Color;
import java.awt.Graphics;


public class GravityUp extends Item  {

	public GravityUp(int x) {
		super(x);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void performAction(Ball b) {
		b.setGravity(b.getGravity() + 3);
	}
	
	@Override
	public void paint(Graphics g) {

		g.setColor(Color.RED);

		super.paint(g);
	}

}
