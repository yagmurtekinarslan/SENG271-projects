package game;

public class Game1 {
	
	int seconds;
	
	public Game1(int seconds) {
		this.seconds=seconds;
	}
	
	public String convertTime(int seconds) {
		
		int hours = seconds/3600;
		int minutes=(seconds%3600)/60;
		int lastSeconds= (seconds%3600)%60;
		return hours + ":"+ minutes +":" + lastSeconds;
		

    }

}
