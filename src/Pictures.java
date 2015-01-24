import java.applet.AudioClip;
import java.awt.Image;
import java.net.URL;


public class Pictures {
	static Image platform, ball;
	URL url;
	static StartingPoint sp;
	static AudioClip music, wind, bounce;
	
	
	public Pictures(StartingPoint sp) {
		// TODO Auto-generated constructor stub
		try {
			url = sp.getDocumentBase();
		} catch (Exception e) {
			// handle it here
		}
		
		music = sp.getAudioClip(url, "Music/music.au");
		bounce = sp.getAudioClip(url, "Music/bounce.au");
		wind = sp.getAudioClip(url, "Music/wind.au");
		
		
		platform = sp.getImage(url, "images/platform.png");
		this.sp = sp;
	
	}
	
}
