package TictactoeGame;

import java.util.Observable;


public class GameModel extends Observable {

	/* Array that holds the positions and values of the game board */
	public String [] btnValues = new String[9];
	/* Combinations of win */
	public int [][] winCombos = new int[][] {
			{0,1,2},{3,4,5},{6,7,8},//Horizontal criteria of win.
			{0,3,6},{1,4,7},{2,5,8},//Vertical criteria of win.
			{2,4,6},{0,4,8}//Diagonal criteria of win.
			};
	/* value that will become true if a player has won. default is false */
	public boolean win = false;
	/* Value that will become true if noone has won. */
	public boolean noOneHasWon = false;
	/* string that will hold the name of playerone in the current game- */
	public String playerOne;
	/* sting that will hold the name of playertwo in the current game. */
	public String playerTwo;
	/* value that stands for if both usernames is set. */
	public boolean isPlayerNamessSet = false;
	/* Value that represents who's turn it is. */
	public boolean turn = true;
	/* if this value becomes true a new game will be created. */
	public boolean newGame = false;
	/**Set player one's name.
	 * @param: String from controler with name of player one.
	 * */
	public void setPlayerOneName(String inName){
		playerOne = inName;
		setChanged();
		notifyObservers();
	}
	/**Set player two's name.
	 * @param: String from controler with name of player two.
	 * */
	public void setPlayerTwoName(String inName){
		playerTwo = inName;
		setChanged();
		notifyObservers();
	}
	/**Method that will check if the players name is set. The it will notify observer.
	 * */
	public void playersIsSet(){
		if(playerOne != null && playerTwo != null){		
			isPlayerNamessSet = true;
			setChanged();
			notifyObservers();
		}
	}
	/**Returns true or false depending on if players names is set.
	 * */
	public boolean checkPlayerNames(){
		return isPlayerNamessSet;
	}
	/**Method will run if no one has won. notifying the observers.
	 * */
	public void setIfNoOneHasWon(){
		noOneHasWon = true;
		setChanged();
		notifyObservers();
	}
	/**Returning the value noOneHasWon. true or false.
	 * */
	public boolean checkIfNoOneHasWon(){
		return noOneHasWon;
	}
	/**Method will run if a player has won.
	 * @param: Symbol of the player who has won. And evaluating it and sending the winning
	 * players name to the View via notifyobserver call.
	 * */
	public void winBecomesTrue(String inPlayer){
		win = true;
		setChanged();
		if(inPlayer == "X"){
			notifyObservers(playerOne);
		}else if(inPlayer == "O"){
			notifyObservers(playerTwo);
		}
	}
	/**Returns true or false depending on if a player has won or not.
	 * */
	public boolean checkForWin(){
		return win;
	}
	/**Set specific value in the array btnValues to the incoming character, "X" or "O".
	 * notifying the observer.
	 *@param: the position where the symbol will be inserted to. is retrieved by the name of the
	 *current button being pressed.
	 *@param: Incoming symbol depending on who's turn it is.
	 * */
	public void setBtnValue(int pos, String symbol){
		btnValues[pos] = symbol;
		setChanged();
		notifyObservers();
	}
	/**Returns true or false. representing who's turn it is.
	 * */
	public boolean checkTurn(){
		return turn;
	}
	/**sets the value of turn to false. Indicating that its the other players turn
	 * */
	public void turnIsTrue(){
		turn = false;
		setChanged();
		notifyObservers();
	}
	/**sets the value of turn to true. Indicating that its the other players turn
	 * */
	public void turnIsFalse(){
		turn = true;
		setChanged();
		notifyObservers();
	}
	/**Sets the value of newGame to false.
	 * */
	public void newGameOngoing(){
		newGame = false;
	}
	/**Returns the value of newGame.
	 * */
	public boolean doNewGame(){
		return newGame;
	}
	/**This method represents the game state of when a new game is created.
	 * Resets all the variables and clears the array of values.
	 * */
	public void setNullGameState(){
		newGame = true;
		playerOne = null;
		playerTwo = null;
		turn = true;
		win = false;
		noOneHasWon = false;
		for(int i = 0; i < btnValues.length; i++){
			btnValues[i] = null;
		}
		setChanged();
		notifyObservers();
	}
}
