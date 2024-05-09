package finalproject;

public interface Game {
	
	//sets the X range of spawnable targets
	public void setRangeX();
	
	//sets the Y range of spawnable targets
	public void setRangeY();
	
	public int getRangeX();
	
	public int getRangeY();

	//tracks the current score a player has
	public void ScoreTracker();
	
	//tells the program when and how to move to 'next' level
	public void setLevel(int newlevel);
	
	//gets the current score
	public int getScore();
	
	//gets the current level
	public int getLevel();
	
}
