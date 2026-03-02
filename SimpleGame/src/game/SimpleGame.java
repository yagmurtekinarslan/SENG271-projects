package game;

import java.util.Scanner;

public class SimpleGame {
	
	

	public static void main(String[] args) {
		
		SimpleGame Game = new SimpleGame();
		
		Game.run();
		
	}
	 
	public void run() {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter 1 if you want to play the Convert Time game, enter 2 if you want to play Sum Of The Digits game: ");
		int choice = scanner.nextInt();


		if(choice == 1 ) {
			
			System.out.println("Enter the seconds you want to convert: ");
			int seconds =scanner.nextInt();
			Game1 game1 = new Game1(seconds);
			System.out.println("Converted version: ");
			System.out.println(game1.convertTime(seconds));
		}
	 
		if(choice == 2) {
			System.out.println("Enter the seconds you want to find sum of its digits: ");
			int seconds =scanner.nextInt();
			Game2 game2 = new Game2(seconds);
			System.out.println("Result is: ");
			System.out.println(game2.digitSum(seconds));
		}

	
	}
 
}
