package TictactoeGame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameControl implements ActionListener{

	private GameModel _GM;
	public GameControl(GameModel inModel){
		_GM = inModel;
	}
	public void actionPerformed(ActionEvent a) {
		
	}
	public void setPlayerNames(String playerOne, String playerTwo){
		_GM.setPlayerOneName(playerOne);
		_GM.setPlayerTwoName(playerTwo);
	}
}
