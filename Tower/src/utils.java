import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;


public class utils {
	public static void main(String[] args) {
	}
	public static int[] getWordLength(Font font, String text){
		FontMetrics metric = Zen.getBufferGraphics().getFontMetrics(font);
		return new int[]{metric.stringWidth(text), metric.getHeight()};
	}
	public static int[] getWordLength(String fontFamily, int fontSize, String text){
		FontMetrics metric = Zen.getBufferGraphics().getFontMetrics(new Font(fontFamily, Font.PLAIN, fontSize));
		return new int[]{metric.stringWidth(text), metric.getHeight()};
	}
	
	public static void drawText(String txt, int[] pos, String font, Color col, boolean shadow, int[] offset, Color sCol){
		String[] lines = txt.split("\n");
		int fontSize = Integer.parseInt(font.split("-")[1]);
		for(int i = 0; i < lines.length; i++){
			Zen.setFont(font);
			if(shadow){
				Zen.setColor(sCol);
				Zen.drawText(lines[i], pos[0] + offset[0], pos[1] + offset[1] + 16 * i);
			}
			Zen.setColor(col);
			Zen.drawText(lines[i], pos[0], pos[1] + fontSize * i);
		}
	}
	public static void drawText(String txt, int[] pos, String font, Color col){
		String[] lines = txt.split("\n");
		int fontSize = Integer.parseInt(font.split("-")[1]);
		for(int i = 0; i < lines.length; i++){
			Zen.setFont(font);
			Zen.setColor(col);
			Zen.drawText(lines[i], pos[0], pos[1] + fontSize * i);
		}
	}
}
