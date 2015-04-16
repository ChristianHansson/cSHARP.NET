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
		try{
			
			JButton temp = (JButton) a.getSource();
			if(temp.getText() == "Starta nytt spel"){
				_GM.setNullGameState();
				String playerOne = (String)JOptionPane.showInputDialog("spelare ett namn");
				String playerTwo = (String)JOptionPane.showInputDialog("spelare två namn");
				setPlayerNames(playerOne, playerTwo);
				_GM.playersIsSet();
			}else{
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
					checkForWin();
				}else{
					JOptionPane.showMessageDialog(null, "Du måste skapa nytt spel, och fylla i användarnamn");
				}
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	public void checkForWin(){
		for(int outer = 0; outer < _GM.winCombos.length; outer++){
			
			if(_GM.btnValues[_GM.winCombos[outer][0]] == _GM.btnValues[_GM.winCombos[outer][1]] &&
					_GM.btnValues[_GM.winCombos[outer][1]] == _GM.btnValues[_GM.winCombos[outer][2]] &&
						_GM.btnValues[_GM.winCombos[outer][2]] != null){
							_GM.winBecomesTrue(_GM.btnValues[_GM.winCombos[outer][0]]);
			}
		}
	}
	public void setPlayerNames(String playerOne, String playerTwo){
		_GM.setPlayerOneName(playerOne);
		_GM.setPlayerTwoName(playerTwo);
	}
}
