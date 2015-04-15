package TictactoeGame;

import java.util.Observable;


public class GameModel extends Observable {

	/*
	 * Represents players names.
	 * */
	public String playerOne;
	public String playerTwo;
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
	/* Set the game state to new game, resets all in model */
	public void setNullGameState(){
		playerOne = null;
		playerTwo = null;
		turn = true;
	}
}
