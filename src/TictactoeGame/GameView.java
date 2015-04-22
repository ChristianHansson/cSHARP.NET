package TictactoeGame;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GameView extends JFrame implements Observer{
	
	/* All the variables for View class. Not yet initialized */
	private GameControl _GC; // Private attribute of the class GameControl, not yet initialized.
	/* All the panels that will make the layout */
	private JPanel leftPanel, gameBoard, playerOneInfo,playerTwoInfo,startGameBtnPanel;
	/* Every Label that will hold text(displayed to the user) */
	private JLabel playerOneTitleText, playerOne,playerOneMarker,playerTwoTitleText, playerTwo, playerTwoMarker,currentPlayer;
	/* Buttons, one for the actual game and one for function start new game. */
	private JButton startGameBtn,b0,b1,b2,b3,b4,b5,b6,b7,b8;
	/* Fonts */
	private Font playerTitleFont, playerNamesFont, playerMarkerFont, currentPlayerFont;
	/**
	 * Contructor for GameView.
	 * @param: Object of the class GameControl
	 * */
	public GameView(GameControl inControl){
		_GC = inControl;
		this.setVisible(true);
		//this.setSize(500,500);
		this.setLayout(new BorderLayout());
		
		//Creating font properties for text.
		playerTitleFont = new Font("Verdana", Font.BOLD, 24);
		playerNamesFont = new Font("Verdana", Font.PLAIN, 18);
		playerMarkerFont = new Font("Verdana", Font.ITALIC, 16);
		currentPlayerFont = new Font("Verdana", Font.BOLD, 14);
		//Panel with users names at the left side of application.
		leftPanel = new JPanel();
		leftPanel.setPreferredSize(new Dimension(200,HEIGHT));
		leftPanel.setLayout(new GridLayout(3,1));
		this.add(leftPanel, BorderLayout.WEST);
		//placeHolder for player one's information on leftside of screen
		playerOneInfo = new JPanel();
		playerOneInfo.setLayout(new GridLayout(3,1));
		leftPanel.add(playerOneInfo);
			//information about player one inside the placeholder
			playerOneTitleText = new JLabel("Spelare ett: ");
			playerOneTitleText.setFont(playerTitleFont);
			playerOneInfo.add(playerOneTitleText);
			playerOne = new JLabel();
			playerOne.setFont(playerNamesFont);
			playerOneInfo.add(playerOne);
			playerOneMarker = new JLabel();
			playerOneMarker.setFont(playerMarkerFont);
			playerOneInfo.add(playerOneMarker);
		//placeholder for player two's information on leftside of screen
		playerTwoInfo = new JPanel();
		playerTwoInfo.setLayout(new GridLayout(3,1));
		leftPanel.add(playerTwoInfo);
			//information about player two inside the placeholder
			playerTwoTitleText = new JLabel("Spelare två: ");
			playerTwoTitleText.setFont(playerTitleFont);
			playerTwoInfo.add(playerTwoTitleText);
			playerTwo = new JLabel();
			playerTwo.setFont(playerNamesFont);
			playerTwoInfo.add(playerTwo);
			playerTwoMarker = new JLabel();
			playerTwoMarker.setFont(playerMarkerFont);
			playerTwoInfo.add(playerTwoMarker);
		//placeholder for start game button and the display of current player
		startGameBtnPanel = new JPanel();
		startGameBtnPanel.setLayout(new GridLayout(2,1));
		leftPanel.add(startGameBtnPanel);
			//the start game button.
			startGameBtn = new JButton("Starta nytt spel");
			startGameBtn.addActionListener(_GC);
			startGameBtnPanel.add(startGameBtn);
			//label that displays current user who is playing.
			currentPlayer = new JLabel();
			currentPlayer.setFont(currentPlayerFont);
			startGameBtnPanel.add(currentPlayer);
		//This panel contains all the buttons wich players will use to play the game.
		gameBoard = new JPanel();
		gameBoard.setLayout(new GridLayout(3,3));
		gameBoard.setPreferredSize(new Dimension(400,400));
		this.add(gameBoard, BorderLayout.CENTER);
		//Here we create and add all the game's buttons. And assigning each one a name. That name will end up in the Model
		//for mapping the buttons.
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
		//resize the window to fit the content.
		this.pack();
	}	
	/**Method that runs with the Observer:Observable framework.
	 * Every time its updated in the model this method will run in View.
	 * */
	public void update(Observable o, Object arg) {
		GameModel updateModel = (GameModel)o;
		if(updateModel.playerOne != null && updateModel.playerTwo != null){
			playerOne.setText(updateModel.playerOne);
			playerOneMarker.setText("Din symbol är: X");
			playerTwo.setText(updateModel.playerTwo);
			playerTwoMarker.setText("Din symbol är: O");
		}
		if(updateModel.checkTurn()){
			currentPlayer.setText(updateModel.playerOne+" spelar nu");
		}else{
			currentPlayer.setText(updateModel.playerTwo+" spelar nu");
		}
		/*CheckForWin becomes true in the model. So when this update function runs
		 * it will check if a user has won and displays a dialog with the name of the winning user.
		 * */
		if(updateModel.checkForWin()){
			JOptionPane.showMessageDialog(null, arg+" har vunnit, spela igen om du törs!");
			currentPlayer.setText(arg+" vann");
			b0.setEnabled(false);
			b1.setEnabled(false);
			b2.setEnabled(false);
			b3.setEnabled(false);
			b4.setEnabled(false);
			b5.setEnabled(false);
			b6.setEnabled(false);
			b7.setEnabled(false);
			b8.setEnabled(false);
		}
		/*resets all the game's buttons. This will initiate when user presses new game.
		 * doNewGame in this context is the creation of a new game. In the model it resets
		 * all data.
		 * */
		if(updateModel.doNewGame()){
			b0.setEnabled(true);
			b0.setText(null);
			b1.setEnabled(true);
			b1.setText(null);
			b2.setEnabled(true);
			b2.setText(null);
			b3.setEnabled(true);
			b3.setText(null);
			b4.setEnabled(true);
			b4.setText(null);
			b5.setEnabled(true);
			b5.setText(null);
			b6.setEnabled(true);
			b6.setText(null);
			b7.setEnabled(true);
			b7.setText(null);
			b8.setEnabled(true);
			b8.setText(null);
		}
		if(updateModel.noOneHasWon){
			JOptionPane.showMessageDialog(null, "Ingen har vunnit, spela igen om du törs!");			
		}
	}
}
