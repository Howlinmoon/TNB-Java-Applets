import java.awt.Image;
import java.net.URL;


public class Pictures {
	static Image platform, ball;
	URL url;
	static StartingPoint sp;
	
	public Pictures(StartingPoint sp) {
		// TODO Auto-generated constructor stub
		try {
			url = sp.getDocumentBase();
		} catch (Exception e) {
			// handle it here
		}
		platform = sp.getImage(url, "images/platform.png");
		this.sp = sp;
	
	}
	
}
