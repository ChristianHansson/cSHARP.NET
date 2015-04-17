package TictactoeGame;

import java.util.Observable;


public class GameModel extends Observable {

	
	public String [] btnValues = new String[9];
	public int [][] winCombos = new int[][] {
			{0,1,2},{3,4,5},{6,7,8},//Horizontal kriteria of win.
			{0,3,6},{1,4,7},{2,5,8},//Vertical kriteria of win.
			{2,4,6},{0,4,8}//Diagonal kreiteria of win.
			};
	
	public boolean win = false;
	public void winBecomesTrue(String inPlayer){
		win = true;
		setChanged();
		if(inPlayer == "X"){
			notifyObservers(playerOne);
		}else if(inPlayer == "O"){
			notifyObservers(playerTwo);
		}
	}
	public boolean checkForWin(){
		return win;
	}
	
	public void setBtnValue(int pos, String symbol){
		btnValues[pos] = symbol;
		setChanged();
		notifyObservers();
	}
	/*
	 * Represents players names.
	 * */
	public String playerOne;
	public String playerTwo;
	public boolean isPlayersSet = false;
	public void playersIsSet(){
		if(playerOne != null && playerTwo != null){		
			isPlayersSet = true;
			setChanged();
			notifyObservers();
		}
	}
	public boolean checkPlayerNames(){
		return isPlayersSet;
	}
	/*
	 * Variable that is true if its playerOne's turn
	 * */
	public boolean turn = true;
	/*
	 * Will return variable turn.
	 * */
	public boolean checkTurn(){
		return turn;
	}
	/*
	 * Runs if value "turn" is true, meaning that its player one's turn.
	 * Sets turn to false.
	 * */
	public void turnIsTrue(){
		turn = false;
		setChanged();
		notifyObservers();
	}
	/*
	 * Runs if value "turn" is false, meaning that its player two's turn.
	 * Sets turn to true.
	 * */
	public void turnIsFalse(){
		turn = true;
		setChanged();
		notifyObservers();
	}
	public void setPlayerOneName(String inName){
		playerOne = inName;
		setChanged();
		notifyObservers();
	}
	public void setPlayerTwoName(String inName){
		playerTwo = inName;
		setChanged();
		notifyObservers();
	}
	public boolean newGame = false;
	public void newGameOngoing(){
		newGame = false;
	}
	public boolean doNewGame(){
		return newGame;
	}
	/* Set the game state to new game, resets all in model */
	public void setNullGameState(){
		newGame = true;
		playerOne = null;
		playerTwo = null;
		turn = true;
		win = false;
		for(int i = 0; i < btnValues.length; i++){
			btnValues[i] = null;
		}
		setChanged();
		notifyObservers();
	}
}
