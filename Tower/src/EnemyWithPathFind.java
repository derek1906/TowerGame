
public class EnemyWithPathFind extends Enemy{
	private int[][] map;
	private int x, y;
	private float px, py;
	private int dir;
	private float[] original;
	private boolean animationDone = true;
	private String cachedPath;
	private boolean collided = false;

	EnemyWithPathFind(int[][] map) {
		super(map);
		this.map = map;
	}
	
	public void setCoords(int x, int y){
		this.x = x; this.px = x * 50;
		this.y = y; this.py = y * 50;
	}
	
	public void run(){
		char direction;
		if(animationDone){
			original = new float[]{px, py};
			cachedPath = findPath(map, x, y, PlayerC.x, PlayerC.y);
			System.out.println(cachedPath);
			animationDone = false;
		}
		cachedPath = (cachedPath.length() == 0) ? "." : cachedPath;
		int length = cachedPath.length();
					
		direction = cachedPath.charAt(0);
				
		if (direction == 'W') px -= 2;
		if (direction == 'E') px += 2;
		if (direction == 'N') py -= 2;
		if (direction == 'S') py += 2;
		if (direction == '.');
		
		switch(direction){
			case 'W':
			case 'S':
				dir = 3;
				break;
			case 'N':
			case 'E':
				dir = 1;
				break;
		}
		
		if(px % 50 == 0 && px != original[0]){
			x = (int) (px * 16 / 800);
			animationDone = true;
		}
		if(py % 50 == 0 && py != original[1]){
			y = (int) (py * 16 / 800);
			animationDone = true;
		}
		//System.out.println(px+","+ py);
		
		if(animationDone){
			System.out.println(cachedPath.length());
			if(cachedPath.length() <= 1){
				System.out.println("Collided");
				collided = true;
				cachedPath = ".";
			}else{
				cachedPath =  cachedPath.substring(1, length - 1);
			}
		}
	}
	
	public boolean detectCollide(){
		return collided;
	}
	
	public int safeStringLength(String s) {
		if (s == null) return Integer.MAX_VALUE;
		return s.length();
	}
	
	public int findShortestString(String[] paths, int lo, int hi) {
		if (lo == hi) return lo;
		int index = findShortestString(paths, lo + 1, hi);
		if (safeStringLength(paths[lo]) > safeStringLength(paths[index])) return index;
		return lo;
	}
	
	public String findPath(int[][] map, int x, int y, int mx, int my) {
		String[][] path = new String[map.length][map[0].length];
		for (int i = 0; i < map.length; i++)
			for (int j = 0; j < map[0].length; j++)
				path[i][j] = null;
		path[x][y] = "";
		findPathHelper(map,x,y,mx,my,path);
		return path[mx][my];
	}
	
	private boolean isValid(int[][] map, int x, int y) {
		return x>=0 && y>=0 && x<map.length && y<map[0].length && map[x][y]!=1;
	}
	private void findPathHelper(int[][] map, int x, int y, int mx, int my, String[][] path) {
		String base = path[x][y], temp;
		
		--x;
		if(isValid(map,x,y)) {
			temp = base + "W";
			if (path[x][y] == null || path[x][y].length() > temp.length()) {
				path[x][y]=temp;
				findPathHelper(map,x,y,mx,my,path);
			}
		}
		++x;
		
		++x;
		if(isValid(map,x,y)) {
			temp = base + "E";
			if (path[x][y] == null || path[x][y].length() > temp.length()) {
				path[x][y]=temp;
				findPathHelper(map,x,y,mx,my,path);
			}
		}
		--x;
		
		--y;
		if(isValid(map,x,y)) {
			temp = base + "N";
			if (path[x][y] == null || path[x][y].length() > temp.length()) {
				path[x][y]=temp;
				findPathHelper(map,x,y,mx,my,path);
			}
		}
		++y;
		
		++y;
		if(isValid(map,x,y)) {
			temp = base + "S";
			if (path[x][y] == null || path[x][y].length() > temp.length()) {
				path[x][y]=temp;
				findPathHelper(map,x,y,mx,my,path);
			}
		}
		--y;
	}
	/*
	public String findPath(int[][] map, int x, int y, int mx, int my){
		//System.out.println(px+","+py+","+mx+","+my);
		//System.out.println(x +","+y+","+mx+","+my+" ");
		if (x == mx && y == my){
			return "";
		}

		
		if (x < 0 || y < 0 || x >= 16 || y >= 16) return null;
		
		if (map[x][y] == 1) return null;
		
		//base cases above
		
		int temp = map[x][y]; 
		map[x][y] = 1; //set current location to wall		
		String paths[] = {
			findPath(map, x-1, y, mx, my),
			findPath(map, x+1, y, mx, my),
			findPath(map, x, y+1, mx, my),
			findPath(map, x, y-1, mx, my)
		};
		
		if (paths[0] != null) paths[0] = "W" + paths[0];
		if (paths[1] != null) paths[1] = "E" + paths[1];
		if (paths[2] != null) paths[2] = "S" + paths[2];
		if (paths[3] != null) paths[3] = "N" + paths[3];
		//for(int i=0;i<4;i++)if(paths[i]==null)System.out.print('.');
		map[x][y] = /*5/temp;
		
		if(paths[0] == null && paths[1] == null && paths[2] == null && paths[3] == null) return null;

		int index = findShortestString(paths, 0, 3);
		
		if (paths[index] == null) return null;
		return paths[index];
	}// */
	
	public void draw(){
		switch(dir){
			case 1:
				Zen.drawImage("images/enemy_pathfind.png", (int) Math.floor(px) - 25, (int) Math.floor(py) - 25);
				break;
			case 3:
				Zen.drawImage("images/enemy_pathfind_left.png", (int) Math.floor(px) - 25, (int) Math.floor(py) - 25);
				break;
		}
	}
}
