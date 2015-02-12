import java.awt.Color;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.net.MalformedURLException;
import java.util.ArrayList;


public class roaming {
	public static int lives = 3, invincible = 0;
	private static float damageAni = 0;
	public static int[][] lvl1_1= matrix(
			"1111111333111111",
			"1000000000000441",
			"1005011111111111",
			"1000114000000101",
			"1000140500001101",
			"1050140100000101",
			"1000114000000001",
			"1000011111111001",
			"1000400000000001",
			"1050000005000001",
			"1050010101010101",
			"1000011111111101",
			"1100001010101001",
			"1110000000000001",
			"1111000000000001",
			"1111111111111121"),
			lvl1_2= matrix(
			"1111111331111111",
			"1600000050000061",
			"1000500400000041",
			"1000111001111001",
			"1000001001000001",
			"1000000000000001",
			"1000000000050001",
			"1000001001000001",
			"1001111001111101",
			"1001440505044101",
			"1001000000000101",
			"1001111100111101",
			"1000000000000001",
			"1111110000000111",
			"1405000000005041",
			"5400000020000045"),
			lvl1_3= matrix(
			"4550051331000041",
			"4500051000000611",
			"4555051000000111",
			"4440000000001114",
			"1111111100011155",
			"0000000000111444",
			"0000000001150005",
			"0000000011110005",
			"0000000115000000",
			"5000001111000000",
			"5000011110000005",
			"0000011110000000",
			"1110011111111100",
			"5400005500000000",
			"4000000000000000",
			"0000002200000000"),
			lvl1_4= matrix(
			"4445541331445544",
			"5111111001455544",
			"4155551001111114",
			"4100005500000014",
			"4100111601110015",
			"4100111111115014",
			"5100114944110014",
			"4155114004110014",
			"4100111501110014",
			"4100111051110015",
			"4100111001110015",
			"5100010001110015",
			"0100000000000010",
			"0111000000001110",
			"0000000000000000",
			"0000000020000000"),
			lvl2_1= matrix(
			"1000000000000144",
			"1011114611110144",
			"1010000000010144",
			"1010114611000144",
			"1010100001000144",
			"1060101001010155",
			"1040101301010155",
			"1010101451010100",
			"1010100000010100",
			"1010111441110100",
			"1010000000000100",
			"1011000111111100",
			"1000000000000000",
			"1100111100451110",
			"2000000000000000",
			"1111111111111111"),
			lvl2_2= matrix(
			"2016111111111113",
			"0010000554441110",
			"0011100004441000",
			"0511100554441011", 
			"0011100111111000",
			"0011100000001110",
			"0011110054401000",
			"0001110000051011",
			"0001110500001000",
			"1001110050051110",
			"1001110111111000",
			"1001110050001011",
			"1001110000051000",
			"1000151110001110",
			"1000000000000000",
			"1110000000000001"),
			lvl2_3= matrix(
			"0551004445000105",
			"1155550040000400",
			"3015500001455005",
			"3001555111111150",
			"1000100105444155",
			"5100015100444105",
			"5510001100444155",
			"5001000100000150",
			"5555100000111155",
			"5005100011550005",
			"5550010001550005",
			"4000055100015055",
			"0050555010001505",
			"0060050001000155",
			"4050055555100015",
			"4004455005512221"),
			lvl2_4= matrix(
			"0500000000009000",
			"0111111100111110",
			"0050006000000615",
			"0000001111111010",
			"0101000000001010",
			"0101011001101010",
			"0100013000100010",
			"0100013000160010",
			"0001011100101010",
			"0001000000001014",
			"0101111111111014",
			"0100005000000014",
			"0100000000000014",
			"0144000000011114",
			"0111111110000011",
			"0000000000000002"),
			lvl3_1= matrix(
			"4130444060120000",
			"4130464010120000",
			"4130444010111110",
			"0111111110105000",
			"0000000050100000",
			"0001111111105000",
			"0501444144100000",
			"1101444140010000",
			"5101444100001001",
			"4101444100500100",
			"4101000100000000",
			"0001555111100000",
			"0001050111110000",
			"0111000111000000",
			"0000000100000001",
			"1110000000000011"),
			lvl3_2= matrix(
			"6011100330011106",
			"1000000000000001",
			"1000044405005001",
			"1000050000000051",
			"0005000000044000",
			"0504440000000050",
			"1005051151150000",
			"1051111111111105",
			"1000011111110000",
			"0500010444010050",
			"0005010005010000",
			"0500010000005000",
			"1000500000500051",
			"1000005000000001",
			"1000011001150001",
			"6011112222111106"),
			lvl3_3= matrix(
			"6131111111111111",
			"4100050000041041",
			"4100000000001001",
			"4100001111500001",
			"4105001001000001",
			"5100001001000091",
			"5144001001001001",
			"0111111001111001",
			"0000050000000001",
			"0500066000000001",
			"1111110010001001",
			"2000111151510101",
			"1000010000100001",
			"1100044000000011",
			"1110001110000111",
			"1111111111111111"),
			lvl3_4= matrix(
			"1111111111111111",
			"1111111111111121",
			"1113311114411000",
			"1105501140001000",
			"1000000110500100",
			"1005001100000101",
			"1000000110000101",
			"1105000100501104",
			"1100001110001104",
			"1110000100011001",
			"1111000000110004",
			"1111105001100004",
			"1111100011000001",
			"1110000110000011",
			"1100000000000111",
			"1114411111441111"),
			lvl4_1= matrix(
			"4444405000014401",
			"4444010050010900",
			"4444010150011100",
			"0510010010000105",
			"0010013001000100",
			"0010010501100100",
			"0000516665050100",
			"0150005050011100",
			"0100011110005044",
			"5100000105500044",
			"0151000150050100",
			"0001000111000100",
			"1010000501005000",
			"1510110000000000",
			"1000000000000000",
			"1111104401111112"),
			lvl4_2= matrix(
			"5050000000000013",
			"0500011111110010",
			"4411110040010000",
			"4410500000005000",
			"4410011111111111",
			"1110010004005011",
			"1110000050050001",
			"1111111111111100",
			"6100004410501110",
			"6100000410001000",
			"0100501110000005",
			"0100111000000001",
			"0190000001111001",
			"0111000001541001",
			"0111001001441111",
			"0000000000000002"),
			lvl4_3= matrix(
			"4441111333111144",
			"4441111000111144",
			"4441100600050144",
			"4441050050104155",
			"5511400110050115",
			"5551050050001110",
			"0001111000054110",
			"0011111110001110",
			"0111111100011110",
			"0011100110501110",
			"0001050005000110",
			"0011101050104110",
			"0111000050004100",
			"0001150001051100",
			"1000110000011100",
			"1100000222000001"),
			lvl4_4= matrix(
			"1111111111111111",
			"1111111111111111",
			"1111605335561111",
			"1111550600551551",
			"1151605555061551",
			"1551110000111551",
			"1555510000155551",
			"1555510060155551",
			"1544516000154451",
			"1544514444154451",
			"1555514444155551",
			"1500514444150051",
			"1500510440150051",
			"1555510440155551",
			"1111111441111111",
			"1111111221111111");

				public static int[][] matrix(String... lines){
		int[][] opt = new int[16][16];
		for(int i = 0; i < lines.length; i++){
			char[] chars = lines[i].toCharArray();
			for(int j = 0; j < chars.length; j++){
				opt[j][i] = Character.getNumericValue(chars[j]);
			}
		}
		return opt;
	}
	
	public static boolean main(int[][] lvl, int lvln, int sublvln) {
		LevelScreen.main("Level " + (lvln + 1) + " - " + (sublvln + 1));
		drawSidebar.draw(lvln, sublvln);
		int startX = 0, startY = 0;
		ArrayList<int[]> winCoords = new ArrayList<int[]>();
		ArrayList<Enemy> enemiesL = new ArrayList<Enemy>();
		ArrayList<Strawberry> StrawberryL = new ArrayList<Strawberry>();
		ArrayList<EnemyWithPathFind> enemiesPFL = new ArrayList<EnemyWithPathFind>();
		ArrayList<minigame> minigameL = new ArrayList<minigame>();
		
		for(int x = 0; x < 16; x++){
			for(int y = 0; y < 16; y++){
				if(lvl[x][y] == 5){
					Enemy en = new Enemy(lvl);
					en.setCoords(x, y);
					enemiesL.add(en);
				}else if(lvl[x][y] == 4){
					Strawberry s = new Strawberry();
					s.setCoords(x, y);
					StrawberryL.add(s);
				}else if(lvl[x][y] == 6){
					EnemyWithPathFind en = new EnemyWithPathFind(lvl);
					en.setCoords(x, y);
					enemiesPFL.add(en);
				}else if(lvl[x][y] == 9){
					minigame en = new minigame();
					en.setCoords(x, y);
					minigameL.add(en);
				}
				String path = "";
				switch(lvl[x][y]){
					case 0:
					case 5:
					case 4:
					case 6:
					case 9:
						path = "images/path.png";
						break;
					case 1:
						path = "images/wall.png";
						break;
					case 2:
							path = "images/entrance.png";
						startX = x; startY = y;
						break;
					case 3:
						path = "images/exit.png";
						winCoords.add(new int[]{x, y});
						break;
				}
				Zen.drawImage(path, x*50, y*50, 50, 50);
			}
		}
		Zen.flipBuffer();
		Image bg = Zen.getWindowScreenShot();
		PlayerC p = new PlayerC(lvl);
		p.setCoor(startX, startY);
		p.setWinCoords(winCoords);
		//Enemy[] enemies = new Enemy[enemiesL.size()];
		//enemiesL.toArray(enemies);
		//for(Enemy en : enemies){
		for(int i = 0; i < enemiesL.size(); i++){
			//en.run();
			enemiesL.get(i).run();
		}
		while(Zen.isRunning()){
			if(invincible > 0) invincible--;
			Zen.drawImage(bg, 0, 0);
			if(Zen.isVirtualKeyPressed(KeyEvent.VK_UP)){
				p.move(0);
			}else if(Zen.isVirtualKeyPressed(KeyEvent.VK_RIGHT)){
				p.move(1);
			}else if(Zen.isVirtualKeyPressed(KeyEvent.VK_DOWN)){
				p.move(2);
			}else if(Zen.isVirtualKeyPressed(KeyEvent.VK_LEFT)){
				p.move(3);
			}else{
				p.stop();
			}
			p.draw();
			//Enemy entity = null; 
			//for(Enemy en : enemiesL){
			for(int i = 0; i < enemiesL.size(); i++){
				Enemy en = enemiesL.get(i);
				en.run();
				en.draw();
				if(en.detectCollide()){
					//entity = en;
					enemiesL.remove(en);
					
					invincible = 100;
					System.out.println("Collided!");
					lives-=1;
					damageAni = 0.7f;
				}
			}
			for(int i = 0; i < enemiesPFL.size(); i++){
				EnemyWithPathFind en = enemiesPFL.get(i);
				en.run();
				en.draw();
				if(en.detectCollide()){
					enemiesPFL.remove(en);
					invincible = 100;
					System.out.println("Collided!");
					lives-=2;
					damageAni = 0.7f;
				}
			}
			for(int i = 0; i < StrawberryL.size(); i++){
				Strawberry currentS = StrawberryL.get(i);
				currentS.draw();
				if(currentS.detectCollide()){
					if(lives < 25) lives++;
					StrawberryL.remove(currentS);
				}
			}
			for(int i = 0; i < minigameL.size(); i++){
				minigame currentG = minigameL.get(i);
				currentG.draw();
				if(currentG.detectCollide()){
					startMinigame();
					minigameL.remove(currentG);
				}
			}
			if(lives <= 0 && damageAni < 0f){
				GameOver.main();
				System.out.println("No more life!");
				return false;
			}
			//lives
			for(int i = 0; i < lives; i++){ //13
				Zen.drawImage("images/heart.png", 1100 - 30 - (i*20)%(13*20) - 18, 800 - 30 - 18 - 20*(int) Math.floor(i/13));
			}
			Zen.setColor(new Color(1f, 0, 0, damageAni));
			Zen.fillRect(0, 0, 1100, 800);
			if(damageAni > 0) damageAni -= 0.05;
			Zen.flipBuffer();
//			if(p.isCollided){
//				System.out.println("Collided!");
//				lives--;
//				if(lives == 0){
//					System.out.println("No more life!");
//					return false;
//				}
//			}
			if(p.isWon()){
				return true;
				//break;
			}
		}
		return true;
	}

	private static void startMinigame() {
		//double n = Math.random();
		//if(n < 0.3){
			guessGame.main();
		//}
		
	}

}
