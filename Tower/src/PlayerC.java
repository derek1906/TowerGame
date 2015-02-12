import java.awt.Color;
import java.util.ArrayList;


public class PlayerC {
	private int[][] map;
	public static int x = 0, y = 0, px = 0, py = 0, dir = -1;
	private int[][] winCoords;
	private boolean isWon = false;
	private int ani = 0;
	public static boolean isCollided = false;
	
	PlayerC(int[][] map){
		this.map = map;
	}

	public void setCoor(int x, int y){
		this.x = x; this.px = x * 50;
		this.y = y; this.py = y * 50;
		this.draw();
	}
	
	public void setWinCoords(ArrayList<int[]> c){
		winCoords = new int[c.size()][];
		c.toArray(winCoords);
	}
	
	public boolean isWon(){
		return isWon;
	}
	
	public void move(int dir){
		this.dir = dir;
		int v = 2;
		Zen.setColor(new Color(1f, 0f, 0f, 0.2f));
		switch(dir){
			case 0:
				//Zen.fillRect(50*this.x, 50*(int) Math.floor((py + 0 - v)/50), 50, 50);
				//Zen.fillRect(50*(this.x+1), 50*(int) Math.floor((py + 0 - v)/50), 50, 50);
				if(this.py + 0 > 0 && this.map[this.x][(int) Math.floor((py + 0 - v)/50)] != 1 &&
						(this.px % 50 == 0 || this.map[this.x+1][(int) Math.floor((py + 0 - v)/50)] != 1)){
					py -= v;
				}
				break;
			case 1:
				//Zen.fillRect(50*(int) Math.floor((px + v + 49)/50), 50*this.y, 50, 50);
				//Zen.fillRect(50*(int) Math.floor((px + v + 49)/50), 50*(this.y-1), 50, 50);
				if(this.px + 50 < 800 && this.map[(int) Math.floor((px + v + 49)/50)][this.y] != 1 &&
						(this.py % 50 == 0 || this.map[(int) Math.floor((px + v + 49)/50)][this.y+1] != 1)){
					px += v;
				}
				break;
			case 2:
				//Zen.fillRect(50*this.x, 50*(int) Math.floor((py + 80 + v - 2)/50), 50, 50);
				//Zen.fillRect(50*(this.x+1), 50*(int) Math.floor((py + 80 + v - 2)/50), 50, 50);
				if(this.py + v + 49 < 800 && this.map[this.x][(int) Math.floor((py + 50 + v - 2)/50)] != 1 &&
						(this.px % 50 == 0 || this.map[this.x+1][(int) Math.floor((py + 50 + v - 2)/50)] != 1)){
					py += v;
				}
				break;
			case 3:
				//Zen.fillRect(50*(int) Math.floor((px - v)/50), 50*this.y, 50, 50);
				//Zen.fillRect(50*((int) Math.floor((px - v)/50)), 50*(1+this.y), 50, 50);
				if(this.px > 0 && this.map[(int) Math.floor((px - v)/50)][this.y] != 1 && 
						(this.py % 50 == 0 || this.map[(int) Math.floor((px - v)/50)][1+this.y] != 1)){
					px -= v;
				}
				break;
		}
		x = px * 16 / 800;
		y = py * 16 / 800;
		
		for(int[] coords : winCoords){
			if(coords[0] == this.x && coords[1] == this.y && (this.px % 50 == 0 || this.py % 50 == 0)){
				this.isWon = true;
				System.out.println("Win.");
			}
		}
	}
	
	public void stop(){
		dir = -1*dir - 1;
	}
	
	public void draw(){
		ani += 1;
		if(dir < 0){
			ani = 0;
			if(dir == -1 || dir == -2){
				Zen.drawImage("images/character_running_0.png", px, py - 10);
			}else{
				Zen.drawImage("images/character_running_left_0.png", px, py - 10);
			}
		}else{
			ani++;
			switch(dir){
				case 0:
				case 1:
					Zen.drawImage("images/character_running_" + (int) Math.floor(ani/30)%7 + ".png", px, py - 10);
					break;
				case 2:
				case 3:
					Zen.drawImage("images/character_running_left_" + (int) Math.floor(ani/30)%7 + ".png", px, py - 10);
					break;
			}
			
		}
		
	}
}
