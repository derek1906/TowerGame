import java.awt.Color;


public class Enemy {
	private int[][] map;
	private int x = 0, y = 0, dir = 1; float px = 0, py = 0;
	private boolean running = false;
	private int[] target;
	private int timeout = 0;
	Enemy(int[][] map){
		this.map = map;
	}

	public void setCoords(int x, int y){
		this.x = x; this.px = x * 50;
		this.y = y; this.py = y * 50;
	}
	
	public void draw(){
		switch(dir){
			case 1:
			case 0:
				Zen.drawImage("images/enemy_right.png", (int) px, (int) py);
				break;
			case 3:
			case 2:
				Zen.drawImage("images/enemy_left.png", (int) px, (int) py);
				break;
		}
	}
	
	public boolean detectCollide(){
		if(Math.abs(this.px - PlayerC.px) < 50 && Math.abs(this.py - PlayerC.py) < 50 && roaming.invincible == 0){
			PlayerC.isCollided = true;
			return true;
		}
		return false;
	}
	
	public void run(){
		if(!running){
			dir = (int) Math.floor(Math.random()*4);
			target = findAvailSpace(dir, x, y, map);
			running = true;
		}else{
			if(timeout > 0){
				timeout--;
				return;
			}
			if(x == target[0] && y == target[1]){
				running = false;
				timeout = 100;
				return;
			}
			switch(dir){
				case 0:
					py-=1;
					break;
				case 1:
					px+=1;
					break;
				case 2:
					py+=1;
					break;
				case 3:
					px-=1;
					break;
			}
			if(px % 50 == 0){
				x = (int) (px * 16 / 800);
			}
			if(py % 50 == 0){
				y = (int) (py * 16 / 800);
			}
			//Zen.setColor(new Color(1f, 0f, 1f, 0.2f));
			//Zen.fillRect(x * 50, y * 50, 50, 50);
		}
	}
	
	private int[] findAvailSpace(int dir, int x, int y, int[][] map){
		if(Math.random() < 0.2) return new int[]{x,y};
		switch(dir){
			case 0:
				if(y-1 <= 0 || map[x][y-1] == 1){
					return new int[]{x,y};
				}else{
					return findAvailSpace(dir, x, y-1, map);
				}
			case 1:
				if(x+1 >= 16 || map[x+1][y] == 1){
					return new int[]{x,y};
				}else{
					return findAvailSpace(dir, x+1, y, map);
				}
			case 2:
				if(y+1 >= 16 || map[x][y+1] == 1){
					return new int[]{x,y};
				}else{
					return findAvailSpace(dir, x, y+1, map);
				}
			case 3:
				if(x-1 <= 0 || map[x-1][y] == 1){
					return new int[]{x,y};
				}else{
					return findAvailSpace(dir, x-1, y, map);
				}
		}
		return null;
	}
}
