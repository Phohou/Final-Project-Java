package finalproject;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter{
	
	Main main;

	public void keyPressed(KeyEvent e) {
		this.main = main;
	}
}
