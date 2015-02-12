import java.awt.Color;


public class CreditsScreen {

	public static void main() {
		//Zen.flipBuffer();
		Zen.drawImage("images/dirtroad.png", 0, 0);
		utils.drawText("Credits\n\nSomeone made this.", new int[]{100, 150}, "Arial-32", new Color(255, 255, 255));
		Zen.flipBuffer();
		Button back = new Button(
				"Back",
				new int[]{200, 35},
				new int[]{1100/2 - 200/2, Zen.getZenHeight() / 2 + 150},
				new Color[]{new Color(60, 60, 60), new Color(90, 90, 90)}
			);
		while(Zen.isRunning()){
			back.update();
			if(back.isClicked()){
				StartScreen.main();
				break;
			}
			Zen.flipBuffer();
		}
	}

}
