import java.awt.Color;


public class StartScreen {

	/**
	 * @param args
	 */
	public static void main() {
		// TODO Auto-generated method stub
		System.out.println("Start Screen.");
		Button start = new Button(
				"Start",
				new int[]{200, 35},
				new int[]{1100/2 - 200/2, Zen.getZenHeight() / 2 + 100},
				new Color[]{new Color(60, 60, 60), new Color(90, 90, 90)}
			),
			credits = new Button(
					"Credits",
					new int[]{200, 35},
					new int[]{1100/2 - 200/2, Zen.getZenHeight() / 2 + 150},
					new Color[]{new Color(60, 60, 60), new Color(90, 90, 90)}
				);
		
		//Zen.flipBuffer();
		while(Zen.isRunning()){
			//background
			//Zen.setColor(200, 200, 200);
			//Zen.fillRect(0, 0, Zen.getZenWidth(), Zen.getZenHeight());
			Zen.drawImage("images/dirtroad.png", 0, 0);
			
			//Text
//			int[] textMetrics = utils.getWordLength("Times", 100, "Subject X");
//			utils.drawText("Subject X",
//					new int[]{1100 / 2 - textMetrics[0] / 2, 150},
//					"Times-100" ,
//					new Color(255, 255, 255),
//					true,
//					new int[]{3,3},
//					new Color(100, 100, 100)
//			);
			utils.drawText("A complete 2D game developed entirely wth Zen.\nZen is graphical library made by Professor Lawrence Angrave\nwhich has very limited methods since it is for beginners.\n(By \"very\" I really mean it.)\n\nIn this demo, the library is ultilized to create a 2D game engine.\n\nImages are borrowed from the Internet.",
					new int[]{50, 200},
					"Times-32" ,
					new Color(255, 255, 255),
					false,
					new int[]{3,3},
					new Color(100, 100, 100)
			);
			Zen.drawImage("images/gametitle.png", 1100 / 2 - 444 / 2, 25);
			
			start.update();
			credits.update();
			if(start.isClicked()){
				System.out.println("Start!");
				if(!roaming.main(roaming.lvl1_1, 0, 0)) return;
				if(!roaming.main(roaming.lvl1_2, 0, 1)) return;
				if(!roaming.main(roaming.lvl1_3, 0, 2)) return;
				if(!roaming.main(roaming.lvl1_4, 0, 3)) return;
				if(!roaming.main(roaming.lvl2_1, 1, 0)) return;
				if(!roaming.main(roaming.lvl2_2, 1, 1)) return;
				if(!roaming.main(roaming.lvl2_3, 1, 2)) return;
				if(!roaming.main(roaming.lvl2_4, 1, 3)) return;
				if(!roaming.main(roaming.lvl3_1, 2, 0)) return;
				if(!roaming.main(roaming.lvl3_2, 2, 1)) return;
				if(!roaming.main(roaming.lvl3_3, 2, 2)) return;
				if(!roaming.main(roaming.lvl3_4, 2, 3)) return;
				if(!roaming.main(roaming.lvl4_1, 3, 0)) return;
				if(!roaming.main(roaming.lvl4_2, 3, 1)) return;
				if(!roaming.main(roaming.lvl4_3, 3, 2)) return;
				if(!roaming.main(roaming.lvl4_4, 3, 3)) return;
				GameOver.main();
				return;
			}else if(credits.isClicked()){
				System.out.println("Credits");
				CreditsScreen.main();
				//return;
			}
			Zen.flipBuffer();
			Zen.sleep(8);
		}
	}

}
