import java.awt.Color;
import java.awt.Image;


public class LevelScreen {

	public static void main(String txt) {
		Image bg = Zen.getWindowScreenShot();
		Zen.setColor(new Color(0, 0, 0));
		Zen.fillRect(0, 0, 1100, 800);
		int[] textMetrics = utils.getWordLength("Times", 50, txt);
		utils.drawText(txt,
				new int[]{1100 / 2 - textMetrics[0] / 2, 400},
				"Times-50" ,
				new Color(255, 255, 255)
		);
		Zen.flipBuffer();
		Zen.sleep(1000);
		Zen.drawImage(bg, 0, 0);
	}

}
