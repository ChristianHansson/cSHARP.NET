package TictactoeGame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GameView extends JFrame implements Observer{
	
	private GameControl _GC;
	private JPanel topPanel, leftPanel;
	private JLabel playerOneTitle, playerOne,playerTwoTitle, playerTwo;
	private JButton startGameBtn;
	public GameView(GameControl inControl){
		_GC = inControl;
		this.setVisible(true);
		this.setSize(500,500);
		this.setLayout(new BorderLayout());
		
		//Panel that will hold the name of the user whos turn it is.
		topPanel = new JPanel();
		topPanel.setBackground(Color.RED);
		this.add(topPanel, BorderLayout.NORTH);
		
		//Panel with users names at the left side of application.
		leftPanel = new JPanel();
		leftPanel.setLayout(new GridLayout(10,1));
		this.add(leftPanel, BorderLayout.WEST);
		
		startGameBtn = new JButton("Starta nytt spel");
		//startGameBtn.setPreferredSize(new Dimension(50,50));
		startGameBtn.addActionListener(_GC);
		this.add(startGameBtn, BorderLayout.SOUTH);
		
		playerOneTitle = new JLabel("Spelare ett: ");
		leftPanel.add(playerOneTitle);
		playerOne = new JLabel();
		leftPanel.add(playerOne);
		playerTwoTitle = new JLabel("Spelare två: ");
		leftPanel.add(playerTwoTitle);
		playerTwo = new JLabel();
		leftPanel.add(playerTwo);
	
	}	
	
	public void update(Observable o, Object arg) {
		GameModel updateModel = (GameModel)o;
		if(updateModel.playerOne != null && updateModel.playerTwo != null){
			//System.out.println(updateModel.playerOne);
			playerOne.setText(updateModel.playerOne);
			playerTwo.setText(updateModel.playerTwo);
		}
	}
}
