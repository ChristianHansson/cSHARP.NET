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
	private JPanel topPanel, leftPanel, gameBoard;
	private JLabel playerOneTitle, playerOne,playerOneSymbol,playerTwoTitle, playerTwo, playerTwoSymbol;
	private JButton startGameBtn,b0,b1,b2,b3,b4,b5,b6,b7,b8;
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
		startGameBtn.addActionListener(_GC);
		this.add(startGameBtn, BorderLayout.SOUTH);
		
		playerOneTitle = new JLabel("Spelare ett: ");
		leftPanel.add(playerOneTitle);
		playerOne = new JLabel();
		leftPanel.add(playerOne);
		playerOneSymbol = new JLabel();
		leftPanel.add(playerOneSymbol);
		
		playerTwoTitle = new JLabel("Spelare två: ");
		leftPanel.add(playerTwoTitle);
		playerTwo = new JLabel();
		leftPanel.add(playerTwo);
		playerTwoSymbol = new JLabel();
		leftPanel.add(playerTwoSymbol);
		
		gameBoard = new JPanel();
		gameBoard.setLayout(new GridLayout(3,3));
		gameBoard.setBackground(Color.YELLOW);
		gameBoard.setPreferredSize(new Dimension(400,400));
		this.add(gameBoard, BorderLayout.CENTER);
	
		b0 = new JButton();
		b0.addActionListener(_GC);
		b0.setName("0");
		gameBoard.add(b0);
		
		b1 = new JButton();
		b1.addActionListener(_GC);
		b1.setName("1");
		gameBoard.add(b1);
		
		b2 = new JButton();
		b2.addActionListener(_GC);
		b2.setName("2");
		gameBoard.add(b2);
		
		b3 = new JButton();
		b3.addActionListener(_GC);
		b3.setName("3");
		gameBoard.add(b3);
		
		b4 = new JButton();
		b4.addActionListener(_GC);
		b4.setName("4");
		gameBoard.add(b4);
		
		b5 = new JButton();
		b5.addActionListener(_GC);
		b5.setName("5");
		gameBoard.add(b5);
		
		b6 = new JButton();
		b6.addActionListener(_GC);
		b6.setName("6");
		gameBoard.add(b6);
		
		b7 = new JButton();
		b7.addActionListener(_GC);
		b7.setName("7");
		gameBoard.add(b7);
		
		b8 = new JButton();
		b8.addActionListener(_GC);
		b8.setName("8");
		gameBoard.add(b8);
		
		this.pack();
	}	
	
	public void update(Observable o, Object arg) {
		GameModel updateModel = (GameModel)o;
		if(updateModel.playerOne != null && updateModel.playerTwo != null){
			playerOne.setText(updateModel.playerOne);
			playerOneSymbol.setText("Din symbol är: X");
			playerTwo.setText(updateModel.playerTwo);
			playerTwoSymbol.setText("Din symbol är: O");
		}
		if(updateModel.checkForWin()){
			JOptionPane.showMessageDialog(null, arg+" har vunnit, spela igen om du törs!");
		}
	}
}
