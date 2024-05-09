package finalproject;
import basicgraphics.BasicFrame;
import basicgraphics.SpriteComponent;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Title {
	
	
	
	public void render(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		Font font = new Font("arial", Font.BOLD,50);
		g.setFont(font);
		g.setColor(Color.black);
		g.drawString("FINAL PROJECT PLACEHOLDER", 1080/2, 100);

	}
	
}
