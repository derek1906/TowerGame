import java.awt.*;

//Not sure how to use the native Button, that's why this class is created.
public class Button {
	private int[] Size, Pos;
	private Color[] BgColors;
	private String Title;
	private boolean isClicked = false;
	
	public Button(String title, int[] size, int[] pos, Color[] bgColors) {
		Title = title;
		Size = size;
		Pos = pos;
		BgColors = bgColors;
	}
	public void update(){
		Image bg = Zen.getWindowScreenShot();
		Zen.drawImage(bg, 0, 0);
		
		int mX = Zen.getMouseX(),
			mY = Zen.getMouseY();
		
		Zen.setColor(0, 0, 0);
		Zen.fillRect(Pos[0] - 1, Pos[1] - 1, Size[0] + 2, Size[1] + 2);
		if(mX >= Pos[0] && mX <= Pos[0] + Size[0] &&
		   mY >= Pos[1] && mY <= Pos[1] + Size[1]){
			Zen.setColor(BgColors[1]);
			Zen.fillRect(Pos[0], Pos[1], Size[0], Size[1]);
			if(Math.floor(Zen.getMouseClickTime()/100) == Math.floor(System.currentTimeMillis()/100)){
				isClicked = true;
			}else{
				isClicked = false;
			}
		}else{
			Zen.setColor(BgColors[0]);
			Zen.fillRect(Pos[0], Pos[1], Size[0], Size[1]);
			isClicked = false;
		}

		int metric[] = utils.getWordLength(new Font("Helvetica", Font.PLAIN, Size[1]-10), Title);
		
		Zen.setFont("Helvetica-" + (Size[1] - 10));
		Zen.setColor(255, 255, 255);
		Zen.drawText(Title, (Size[0] - metric[0]) / 2 + Pos[0], (Pos[1] - 10 + metric[1]));
		//Zen.flipBuffer();
	}
	public boolean isClicked(){
		return isClicked;
	}
}
