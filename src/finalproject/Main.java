package finalproject;
import basicgraphics.BasicFrame;
import basicgraphics.ClockWorker;
import basicgraphics.Sprite;
import basicgraphics.SpriteComponent;
import basicgraphics.images.Picture;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Canvas;
public class Main extends Canvas implements Runnable {

	public static String score = "";
	public static String level = "";
	private int stage;
	private static boolean running = false;
	private int width = 1980;
	private int height = 1080;
	private static Thread thread;
	private static STATE State = STATE.MENU;
	static BasicFrame bf = new BasicFrame("GAME");
	static SpriteComponent sc = new SpriteComponent();
	static SpriteComponent sc2 = new SpriteComponent();
	static SpriteComponent sc3 = new SpriteComponent();
	static SpriteComponent sc4 = new SpriteComponent();
	static SpriteComponent sc5 = new SpriteComponent();
	static SpriteComponent sc6 = new SpriteComponent();
    Image im1 = BasicFrame.createImage(250, 250);
	final static Picture test = new Picture("ant-small.png");
	SpriteComponent tg = new SpriteComponent();
	static Random random = new Random();
	static GameImp Game = new GameImp();
    static JLabel scorelabel = new JLabel("SCORE: " + score, JLabel.CENTER);
    static JLabel levellabel = new JLabel("LEVEL: " + level, JLabel.CENTER);
    static Dimension d = new Dimension(840, 50);
    static Dimension playArea = new Dimension(1700, 900);
    static Target target = new Target(sc5);
	final static Picture targetPic = new Picture("target.png");
	

	
	//variables to track when game is in menu or not//
	public enum STATE{
		MENU,
		GAME,
	};
	
	//tells the program that the game is running//
	private synchronized void start() {
		if(running) {
			return;
		}
		running = true;
		thread = new Thread(this);
		thread.start();
	}

	private static synchronized void stop() {
		if(!running) {
			return;
		}
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.exit(1);
	}
		
	public static void gameStart() {
		System.out.println("Game Starting");
        KeyListener kl = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }
            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        };
        bf.addKeyListener(kl);
        MouseListener ml = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("click");
            }
            @Override
            public void mousePressed(MouseEvent e) {
            }
            @Override
            public void mouseReleased(MouseEvent e) {
            }
            @Override
            public void mouseEntered(MouseEvent e) {
            }
            @Override
            public void mouseExited(MouseEvent e) {
            }
        };
        sc5.addMouseListener(ml);
	}
	
	public void updates() {
        Game.ScoreTracker();
        score = String.valueOf(Game.getScore());
        scorelabel.setText("SCORE:" + String.valueOf(Game.getScore()));
        scorelabel.updateUI();
        levellabel.setText("LEVEL:" + String.valueOf(Game.getLevel()));
        if (Game.getScore()>250) {
        	Game.setLevel(2);
        }
        if (Game.getScore()>500) {
        	Game.setLevel(3);
        }
        if (Game.getScore()>1000) {
        	Game.setLevel(4);
        }
	}
	
    static String[][] layout = {
            {"topl", "row1", "row1"},
            {"row3", "row3", "row3"},
            {"row3", "row3", "row3"},
            {"row3", "row3", "row3"},
            {"botl", "row5", "botr"}
        };
    
	public void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if(bs==null) {
			createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		
		if(State == STATE.GAME) {
			
		}
		if(State == STATE.MENU) {
			
		}
		g.dispose();
		bs.show();
	}
	
	static class Target extends Sprite implements Runnable {
		
		boolean clicked = false;
		Picture blank = new Picture("blank.png");
		Random random = new Random();
		GameImp Game = new GameImp();
		private int level;
		Main main = new Main();
		
		public Target(SpriteComponent sc) {
			super(sc);
		}
	
	    @Override
	    public void mouseClicked(MouseEvent me) {
            setPicture(blank);
            sc5.repaint();
            main.updates();
            target.setX(Game.getRangeX());
            target.setY(Game.getRangeY());
            setPicture(targetPic);
            sc5.repaint();
	    }
		private void move() {
			Thread threadTarg = new Thread(this);
			Picture blank = new Picture("blank.png");
			Main main = new Main();
			while(running = true) {
				try {
					threadTarg.sleep(20);
		            setPicture(blank);
		            sc5.repaint();
		            main.updates();
		            target.setX(Game.getRangeX());
		            target.setY(Game.getRangeY());
		            setPicture(targetPic);
		            sc5.repaint();
				} 
				catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

		@Override
		public void run() {
		}
	}
	
	public static void main(String[] args) {
		int score2 = Game.getScore();
		int level2 = Game.getLevel();
		score = String.valueOf(score2);
		level = String.valueOf(level2);
	    scorelabel.setPreferredSize(d);
	    levellabel.setPreferredSize(d);
		Main main = new Main();
	    JButton exit = new JButton("EXIT");
	    JButton start = new JButton("START");
	    JButton pause = new JButton("PAUSE");
	    sc5.setPreferredSize(playArea);
        bf.setStringLayout(layout);
        bf.add("topl", scorelabel);
        bf.add("row1", levellabel);
        bf.add("botl", start);
        bf.add("row5", pause);
        bf.add("botr", exit);
    	target.setPicture(targetPic);
    	target.is_visible = false;
        bf.add("row3", sc5);
		bf.show();
        ClockWorker.initialize(10000);
		main.start();
        JOptionPane.showMessageDialog(sc,"Welcome to Target Clicker");
        JOptionPane.showMessageDialog(sc,"In this game you will need to click the targets");
        JOptionPane.showMessageDialog(sc,"As your score increases, more the targets will gradually get harder to click");
        exit.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        JOptionPane.showMessageDialog(exit, "Exiting Game");
		        bf.dispose();
		        System.exit(0);
		    }
		});
        pause.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        JOptionPane.showMessageDialog(pause, "Game is paused please press again to unpause");
		        boolean pause = true;
		        if (pause == true) {
		        	
		        }
		        if (pause == false) {

		        }
		        
		    }
		});
        start.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        gameStart();
		        target.is_visible = true;
		        target.setX(810);
		        target.setY(400);
		        sc5.repaint();
		    }
		});
	}

	@Override
	public void run() {
	}
}
