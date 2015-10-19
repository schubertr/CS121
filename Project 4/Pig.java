import java.util.Scanner;

public class Pig 

{	

	/**
	 * Calls the other methods to run the game
	 * @param args
	 */
	public static void main(String[] args)

	{	
		Scanner in = new Scanner(System.in);

		System.out.println("The Game of Pig");								//prints out the main menu of the game
		System.out.println("--------------------------------------");	
		System.out.println("1. Human vs. Human");									
		System.out.println("2. Human vs. Computer");								
		System.out.println("3. Computer vs. Computer \n");				
		System.out.print("What kind of game do you want to play? ");		//asks the user to choose what kind of game they want to play

		int gameKind = in.nextInt();

		System.out.println();

		if(gameKind == 1)
			playGame(true, true);
		else if(gameKind == 2)
			playGame(true, false);				//based on what the user entered (1,2, or 3) decided which game type it should run
		else if(gameKind == 3)
			playGame(false, false);
	}

	/**
	 * Loops through the game executing each turn until one of the player reaches a score > 100
	 * @param player1 True = Human, False = Computer
	 * @param player2 True = Human, False = Computer
	 */
	public static void playGame( boolean player1, boolean player2 )

	{
		int totalScore1 = 0;
		int totalScore2 = 0;
		boolean turn = true;				//stores which player's turn it is. True = player one's turn, False = player two's turn

		while( totalScore1 < 100 && totalScore2 < 100)						//do while loop that runs the game until either player reaches >= 100
		{
			System.out.println("Player 1 Score: " + totalScore1);
			System.out.println("Player 2 Score: " + totalScore2 + "\n");


			if(turn)							//if statement that calls the playTurn method with the appropriate parameters for each player
				totalScore1 += playTurn(player1, 1, totalScore1);
			else if(!turn)
				totalScore2 += playTurn(player2, 2, totalScore2);
			
			turn = !turn;						//sets turn to the opposite of whatever it was, which tells the above if statement to call the playTurn method with the other player's parameters (switches the turn to the other player)

		}
		System.out.println("Player 1 Score: " + totalScore1);				//prints out the final scores after a player has won
		System.out.println("Player 2 Score: " + totalScore2);

		if(totalScore1 > totalScore2)					//prints out who the winner is
			System.out.println("Player 1 Wins!");					
		else
			System.out.println("Player 2 Wins!");

	}

	/**
	 * Loops through each turn sequence
	 * @param player True = Human, False = Computer
	 * @param number 1 = Player 1, 2 = Player 2
	 * @param totalScore The total accumulative score of the player from the whole game
	 * @return
	 */
	public static int playTurn( boolean player, int number, int totalScore )
	{
		Scanner in = new Scanner(System.in);

		int turnScore = 0;
		int roll = 0;
		boolean isHolding = false;

		if(player)
			System.out.println("Player " + number + "'s Turn (Human)");
		else
			System.out.println("Player " + number + "'s Turn (Computer)");	


		do			//loops through the turn sequence until the player decides to hold or rolls a one
		{
			roll = roll();								//calls the roll method and sets int roll to the random number it returns
			turnScore += roll;			//adds the roll to the turn score
			System.out.println("Rolled a " + roll);
			if( roll != 1)		//calls the getDecision method as long as the roll does not equal 1
				isHolding = getDecision(player, turnScore, totalScore); //stores the boolean value from getDecision into isHolding which determines whether or not to roll again or to hold
			else
			{
				turnScore = 0;						//if they roll a one, it resets their turnScore and ends their turn by setting isHolding to true
				isHolding = true;
			}
		} while (!isHolding); 




		System.out.println("Turn Over\n");			//prints out that the turn is over and returns their turnScore
		return turnScore;	

	}

	/**
	 * Decide whether the given player should continue or hold
	 * @param player True = Human, False = Computer
	 * @param turnScore The accumulative amount the player has scored during the current turn
	 * @param totalScore The total accumulative score of the player from the whole game
	 * @return
	 */
	public static boolean getDecision( boolean player, int turnScore, int totalScore )
	{
		Scanner in = new Scanner(System.in);

		System.out.println("Turn Score: " + turnScore);
		if (player)		//if it is a human player's turn, asks if they want to hold or roll and returns a boolean value based on their answer
		{
			System.out.print("Hold or Roll? (h or r) ");			
			String choice = in.next();
			if(choice.charAt(0) == 'h')
			{
				System.out.println("Human player holds");
				return true;
			}
			else
			{
				System.out.println("Human player rolls");
				return false;
			}
		}
		else	//checks to see if the computer wants to hold or roll and returns a boolean value based on their answer
		{
			int turnAndTotal = turnScore + totalScore;
//employs the Hold-at-20-or-Goal strategy for the computer	
			if( turnAndTotal >= 100 )		//checks to see if the computer would win the game by holding (turnScore totalScore >= 100)
			{	
				System.out.println("Computer player holds");
				return true;
			}	
			else if (turnScore >= 20)   //checks to see if the computer has accumulated 20 or more points during the turn
			{
				System.out.println("Computer player holds");
				return true;
			}
			else
			{			//otherwise it rolls again
				System.out.println("Computer player rolls");
				return false;
			}
		}
	}
	/**
	 * Generates and returns a random integer from 1-6
	 * @return
	 */
	public static int roll()
	{
		return (int) (Math.random() * 6) + 1;
	}

}
