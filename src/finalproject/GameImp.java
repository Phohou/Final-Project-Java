package finalproject;

import java.awt.event.MouseEvent;
import java.util.Random;

import basicgraphics.BasicFrame;
import basicgraphics.SpriteComponent;
import basicgraphics.images.Picture;

public class GameImp implements Game{
	
	private int score;
	private int level = 1;
	private int xUpRange = 936;
	private int xLowRange = 684;
	private int yUpRange = 547;
	private int yLowRange = 267;
	Random random = new Random();
	
	@Override
	public void ScoreTracker() {
		if (level == 1 ) {
			score = score + random.nextInt(0, 50);
		}
		if (level>1 && level<5) {
			score = score + random.nextInt(50, 100);
		}
		if (level>5 && level<10) {
			score = score + random.nextInt(100, 200);
		}
	}

	@Override
	public void setLevel(int newlevel) {
		level = newlevel;
	}
	
	@Override
	public int getScore() {
		return score;
	}

	@Override
	public int getLevel() {
		return level;
	}

	@Override
	public void setRangeX() {
		if (level == 2) {
			xUpRange = 1380;
			xLowRange = 250;
		}
		if (level==3) {
			xUpRange = 1630;
			xLowRange = 0;
		}
	}

	@Override
	public void setRangeY() {
		if (level==2) {
			yUpRange = 830;
			yLowRange = 150;
		}
		if (level==3) {
			yUpRange = 830;
			yLowRange = -5;
		}		
	}

	@Override
	public int getRangeX() {
		return random.nextInt(xLowRange, xUpRange);
	}

	@Override
	public int getRangeY() {
		return random.nextInt(yLowRange, yUpRange);
	}
}
