package TictactoeGame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GameView extends JFrame implements Observer{
	
	private GameControl _GC;
	private JOptionPane jp;
	private JPanel topPanel;
	private JTextField pOne, pTwo;
	private BorderLayout _bl = new BorderLayout();
	private String playerOne, playerTwo;
	public GameView(GameControl inControl){
		_GC = inControl;
		this.setVisible(true);
		this.setSize(500,500);
		this.setLayout(_bl);
		
		topPanel = new JPanel();
		topPanel.setBackground(Color.RED);
		this.add(topPanel, _bl.NORTH);
		
		jp = new JOptionPane();
		
		getPlayerNames(jp);
	}	
	public void getPlayerNames(JOptionPane option){
		playerOne = (String)option.showInputDialog("spelare ett namn");
		playerTwo = (String)option.showInputDialog("spelare två namn");
		_GC.setPlayerNames(playerOne, playerTwo);
	}
	public void update(Observable o, Object arg) {
		System.out.println("nått har ändrats");
	}
}
