package TictactoeGame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

public class GameControl implements ActionListener{

	private GameModel _GM;
	public GameControl(GameModel inModel){
		_GM = inModel;
	}
	/** Method that runs when action listener is called.
	 * @param: Object that has a actionlistener on it and is, in this case, pressed.
	 * */
	public void actionPerformed(ActionEvent a) {
		try{
			/* Since we know that its only buttons in this program we will cast the incoming 
			 * object to be a JButton. */
			JButton temp = (JButton) a.getSource();
			/* This if case is for when a new game is about to start. Resetting the gamestate. 
			 * And displaying an JOptionPane to get the users names. And the passing it to a function
			 * that sets the names in the model.*/
			if(temp.getText() == "Starta nytt spel"){
				_GM.setNullGameState();
				String playerOne = (String)JOptionPane.showInputDialog("spelare ett namn");
				String playerTwo = (String)JOptionPane.showInputDialog("spelare två namn");
				setPlayerNames(playerOne, playerTwo);
				_GM.playersIsSet();
				_GM.newGameOngoing();
			}else{
				/* This will check model for wich player turn it is and setting the 
				 * appropriate symbol in the model. */
				if(_GM.checkPlayerNames()){				
					if(_GM.turn){
						int tempPos = Integer.parseInt(temp.getName());
						_GM.setBtnValue(tempPos, "X");
						_GM.turnIsTrue();
						temp.setEnabled(false);
						temp.setText(_GM.btnValues[tempPos]);
					}else{
						int tempPos = Integer.parseInt(temp.getName());
						_GM.setBtnValue(tempPos, "O");
						_GM.turnIsFalse();
						temp.setEnabled(false);
						temp.setText(_GM.btnValues[tempPos]);
					}
					/* This will run every time a game button is pressed. To se if a player has won or not. */
					checkForWinControl();
					if(hasNoOneWon()){
						_GM.setIfNoOneHasWon();
					}
				}else{
					JOptionPane.showMessageDialog(null, "Du måste skapa nytt spel, och fylla i användarnamn");
				}
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	/**Method that will check if noone has won.
	 * If the array in the model is full and noone has won it will return true.
	 * */
	public boolean hasNoOneWon(){
		for(int i = 0; i < _GM.btnValues.length; i++){
			if(_GM.btnValues[i] == null){
				return false;
			}
		}
		return true;
	}
	/**This method, that runs every time user presses a game button, will check the data in the model
	 * to see if any user has won or not. 
	 * */
	public void checkForWinControl(){
		for(int outer = 0; outer < _GM.winCombos.length; outer++){
			if(_GM.btnValues[_GM.winCombos[outer][0]] == _GM.btnValues[_GM.winCombos[outer][1]] &&
					_GM.btnValues[_GM.winCombos[outer][1]] == _GM.btnValues[_GM.winCombos[outer][2]] &&
						_GM.btnValues[_GM.winCombos[outer][2]] != null){
							_GM.winBecomesTrue(_GM.btnValues[_GM.winCombos[outer][0]]);
			}
		}
	}
	/**Method that sets player names Every time a new game is created.
	 * @param1: playerOne's name
	 * @param2: playerTwo's name
	 * */
	public void setPlayerNames(String playerOne, String playerTwo){
		_GM.setPlayerOneName(playerOne);
		_GM.setPlayerTwoName(playerTwo);
	}
}
