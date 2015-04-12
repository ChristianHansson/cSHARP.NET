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
		notifyObservers();
		setChanged();
	}
	/*
	 * Runs if value "turn" is false, meaning that its player two's turn.
	 * Sets turn to true.
	 * */
	public void turnIsFalse(){
		turn = true;
		notifyObservers();
		setChanged();
	}
	public void setPlayerOneName(String inName){
		playerOne = inName;
		notifyObservers();
		setChanged();
	}
	public void setPlayerTwoName(String inName){
		playerTwo = inName;
		notifyObservers();
		setChanged();
	}
}
