import java.applet.Applet;
import java.applet.AudioClip;
import java.net.MalformedURLException;
import java.net.URL;

	public class Music{
		AudioClip m;
		public Music(String url) throws MalformedURLException{
			m = Applet.newAudioClip(new URL("file:" + url));
		}
		public void loop(){
			m.loop();
		}
		public void play(){
			m.play();
		}
		public void stop(){
			m.stop();
		}
	}