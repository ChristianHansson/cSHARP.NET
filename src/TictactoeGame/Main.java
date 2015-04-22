package TictactoeGame;

public class Main {
	/**
	 * @author <ul><li>Christian Hansson</li><li>Jesper Karnerfors</li></ul>
	 * */
	public static void main(String [] args){
		GameModel gm = new GameModel();
		GameControl gc = new GameControl(gm);
		GameView gv = new GameView(gc);
		gm.addObserver(gv);
	}
}
