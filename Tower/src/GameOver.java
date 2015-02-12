import java.awt.Color;
import java.awt.Image;


public class GameOver {

	public static void main() {
		Image bg = Zen.getWindowScreenShot();
		int steps = 0;
		float opacity = 0;
		int size;
		Button restart = new Button(
				"Restart",
				new int[]{200, 35},
				new int[]{1100/2 - 200/2, Zen.getZenHeight() / 2 + 150},
				new Color[]{new Color(60, 60, 60), new Color(90, 90, 90)}
			);
		while(/*opacity < 0.7*/ steps < 70){
			Zen.drawImage(bg, 0, 0);
			Zen.setColor(new Color(10/255, 10/255, 10/255, opacity));
			Zen.fillRect(0, 0, 1100, 800);
			size = (int) (-6.2*steps+500);
			int[] textMetrics = utils.getWordLength("Arial", size, "GAME OVER");
			utils.drawText("GAME OVER!",
					new int[]{1100 / 2 - textMetrics[0] / 2, 800 / 2 - textMetrics[1]},
					"Times-"+size,
					new Color(255, 255, 255)
			);
			steps++;
			opacity += 0.01;
			Zen.flipBuffer();
		}
		while(true){
			//restart.update();
			//if(restart.isClicked()){
			//	StartScreen.main();
			//	return;
			//}
			//Zen.flipBuffer();
		}
	}

}
