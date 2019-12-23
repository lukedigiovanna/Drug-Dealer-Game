package display;

import java.awt.*;
import java.awt.event.KeyEvent;

import main.Program;
import display.component.*;
import display.component.Button;
import display.component.Component;

public class UpdateNotesDisplay extends Display {
	private String[] notes = {
		"Implemented VSync",
		"Fixed collision with walls",
		"Implementing data files to store regions",
		"Newer, more detailed tile art (temporary)",
		"Developed a JSON parser for reading and generating JSON files",
		"Implemented Texture Packs which now take advantage of sprite sheets",
		"Added position correction to camera zooming",
		"Added ridable vehicles",
		"    Press 'F' near a car to enter it",
		"Music demo -- plays a song while game is active",
		"Gun sound effect demo while shooting",
		"Player movement/shooting demos",
		"    Press number keys to try each type",
		"        1: Cardinal movement with WASD, and shoot with arrow keys",
		"        2: Face to cursor, WASD for relative mvt, click and shoot",
		"        3: Turn player with AD, WS to move back and forth, space to shoot",
	};
	
	private Button backButton = new Button("Back to menu",ptpX(0.025f),ptpY(0.025f),0,0,Component.FORM_LEFT) {
		@Override
		public void onMouseDown() {}

		@Override
		public void onMouseUp() {
			DisplayController.setScreen(DisplayController.Screen.MAIN);
		}

		@Override
		public void onMouseMoved(int dx, int dy) {}

		@Override
		public void onMouseOver() {
			c = Color.gray;
		}

		@Override
		public void onMouseOut() {
			c = Color.white;
		}
		
		Color c = Color.white;
		Font f = new Font(Program.FONT_FAMILY,Font.BOLD,ptpY(0.025f));
		public void draw(Graphics2D g) {
			g.setFont(f);
			setDimension(g.getFontMetrics().stringWidth(this.getText()),g.getFontMetrics().getHeight());
			g.setColor(c);
			g.drawString(getText(), x, y+getHeight());
		}
	};
	
	public UpdateNotesDisplay() {
		super();
		add(backButton);
	}
	
	@Override
	public void draw(Graphics2D g) {
		if (Program.keyboard.keyPressed(KeyEvent.VK_ESCAPE))
			DisplayController.setScreen(DisplayController.Screen.MAIN);
		
		fillBackground(g, Color.BLACK);
		g.setColor(Color.GRAY);
		g.setFont(new Font(Program.FONT_FAMILY,Font.BOLD,ptpY(0.1f)));
		drawText(g,"UPDATE NOTES",0.5f,0.15f,Display.CENTER_ALIGN);
		g.setColor(Color.LIGHT_GRAY);
		g.setFont(new Font(Program.FONT_FAMILY,Font.ITALIC,ptpY(0.05f)));
		drawText(g,"Version "+Program.getVersionString(),0.5f,0.20f,Display.CENTER_ALIGN);
		float size = 0.03f;
		float y = 0.3f;
		g.setColor(Color.WHITE);
		g.setFont(new Font(Program.FONT_FAMILY,Font.PLAIN,ptpY(size)));
		for (String s : notes) {
			int i = 0;
			String str = "";
			while (s.charAt(0) == ' ') {
				str+=" ";
				s = s.substring(1);
			}
			str+="* "+s;
			drawText(g,str,0.05f,y,Display.LEFT_ALIGN);
			y+=size;
		}
		
		backButton.draw(g);
	}

	@Override
	public void set() {
		
	}
}
