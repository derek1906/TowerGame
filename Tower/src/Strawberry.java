
public class Strawberry {
	private int x, y;
	
	Strawberry(){
		
	}
	
	public void setCoords(int x, int y){
		this.x = x; this.y = y;
	}
	public boolean detectCollide(){
		if(Math.abs(this.x*50 - PlayerC.px) < 50 && Math.abs(this.y*50 - PlayerC.py) < 50){
			System.out.println("Strawberry acquired.");
			return true;
		}
		return false;
	}
	
	public void draw(){
		Zen.drawImage("images/strawberry.png", x*50, y*50);
	}
}
