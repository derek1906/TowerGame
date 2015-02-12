import java.awt.Color;


public class drawSidebar {
	public static void draw(int lvl, int sublvl) {
		int totalLevel = 4, totalSublevel = 4;
		Zen.drawImage("images/sidebartower.png", 800, 0);
		
		int height = 800 - 200 - (lvl*totalSublevel + sublvl)*(600-100)/(totalSublevel*totalLevel);
		Zen.drawImage("images/arrow.png", 1020, height);  //600 - 100
		utils.drawText((lvl+1)+"-"+(sublvl+1), new int[]{1060, height + 17}, "Arial-16", new Color(255, 255, 255), true, new int[]{1,1}, new Color(10, 10, 10));
		utils.drawText("Level-o-meter", new int[]{967,50}, "Arial-18", new Color(255, 255, 255));
	}

}
