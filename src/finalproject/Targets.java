package finalproject;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import basicgraphics.Sprite;
import basicgraphics.BasicFrame;
import basicgraphics.SpriteComponent;
import basicgraphics.images.Picture;

public class Targets{
	
    Image im1 = BasicFrame.createImage(250, 250);
	final Picture target = new Picture("target.jpg");
	final static Picture test = new Picture("ant-small.png");
	SpriteComponent sc = new SpriteComponent();
	
	static class Target extends Sprite {
		
		boolean clicked = false;
		
		public Target(SpriteComponent sc) {
			super(sc);
		}
		
	    @Override
	    public void mouseClicked(MouseEvent me) {
            setPicture(test);
	    }
		
	}


	public static void main(String[] args) {
		
	}
}
