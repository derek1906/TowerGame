
public class minigame {

	private int x , y, px, py;
	
	minigame(){
	
	}
	
	public boolean detectCollide(){
		System.out.println("Detecting collision of minigame"+","+px+","+PlayerC.x+";"+py+","+PlayerC.y);
		if(Math.abs(px - PlayerC.px) <= 25 && Math.abs(py - PlayerC.py) <= 25){
			return true;
		}
		return false;
	}
	
	public void setCoords(int x, int y){
		this.x = x; this.y = y;
		this.px = x*50; this.py = y*50;
	}
	
	public void draw(){
		Zen.drawImage("images/minigame.png", x*50, y*50);
	}
}