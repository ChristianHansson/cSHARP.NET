package TictactoeGame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class GameControl implements ActionListener{

	private GameModel _GM;
	public GameControl(GameModel inModel){
		_GM = inModel;
	}
	public void actionPerformed(ActionEvent a) {
		//_GM.turnIsTrue();
		JButton temp = (JButton) a.getSource();
		if(temp.getText() == "Starta nytt spel"){
			_GM.setNullGameState();
			String playerOne = (String)JOptionPane.showInputDialog("spelare ett namn");
			String playerTwo = (String)JOptionPane.showInputDialog("spelare två namn");
			setPlayerNames(playerOne, playerTwo);
		}
	}
	public void setPlayerNames(String playerOne, String playerTwo){
		_GM.setPlayerOneName(playerOne);
		_GM.setPlayerTwoName(playerTwo);
	}
}
