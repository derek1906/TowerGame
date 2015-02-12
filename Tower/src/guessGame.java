import java.awt.Color;
import java.awt.event.KeyEvent;

public class guessGame{
	public static void main(){
		int answer = (int)(Math.random()*100);
		
		for(int chance = 3; chance >=0; chance--){
			Zen.drawText("", 0, 0);
			Zen.setEditText("");
			Long guessNum = 0l;
			while(Zen.isRunning()){
				Zen.setColor(new Color(255, 255, 255));
				utils.drawText("Please guess a number between 1 to 100: ", new int[]{10,50}, "Times-40", new Color (255,255,255));
				String txt = Zen.getEditText(); 
				if(txt.length() > 0) guessNum = Long.parseLong(txt);
				utils.drawText(""+guessNum, new int[]{10,75}, "Times-25", new Color (255,255,255));
				if(Zen.isVirtualKeyPressed(KeyEvent.VK_ENTER)){
					System.out.println(guessNum);
					Zen.flipBuffer();
					break;
				}
				Zen.flipBuffer();
				Zen.sleep(20);
			}
			Zen.sleep(20);
			Zen.flipBuffer();
			if(chance == 0){
				System.out.println(6);
				utils.drawText("Game over! The correct answer is "+ answer,new int[]{10,50}, "Times-40", new Color (255,255,255));
			}else if(guessNum > answer && guessNum-answer < 20){
				System.out.println(1);
				utils.drawText("A little bit high! You now have "+chance+" times",new int[]{10,50}, "Times-40", new Color (255,255,255));
			}else if(guessNum > answer && guessNum-answer > 20){
				System.out.println(2);
				utils.drawText("Too high! You now have "+chance+" times",new int[]{10,50}, "Times-40", new Color (255,255,255));
			}else if(guessNum < answer && answer-guessNum < 20){
				System.out.println(3);
				utils.drawText("A little bit low! You now have "+chance+" times",new int[]{10,50}, "Times-40", new Color (255,255,255));	
			}else if(guessNum < answer && answer-guessNum > 20){
				System.out.println(4);
				utils.drawText("Too low! You now have "+chance+" times",new int[]{10,50}, "Times-40", new Color (255,255,255));	
			}else if(guessNum == answer){
				System.out.println(5);
				utils.drawText("You win!",new int[]{10,50}, "Times-40", new Color (255,255,255));
			}
			Zen.flipBuffer();

			Zen.sleep(100);
			while(Zen.isRunning()){
				if(Zen.isVirtualKeyPressed(KeyEvent.VK_ENTER)){
					break;
				}
			}
			Zen.sleep(100);
		}
	}
}