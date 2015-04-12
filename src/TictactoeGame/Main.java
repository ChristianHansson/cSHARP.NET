package TictactoeGame;

public class Main {
	public static void main(String [] args){
		GameModel gm = new GameModel();
		GameControl gc = new GameControl(gm);
		GameView gv = new GameView(gc);
		gm.addObserver(gv);
	}
}
