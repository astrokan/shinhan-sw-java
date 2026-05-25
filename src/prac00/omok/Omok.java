package prac00.omok;

public class Omok {
    public static void main(String[] args) {
        Player youna = new Player("Youna", "O");
        Player gun = new Player("Gun", "X");
        Board board = new Board(19);
        play(board, youna, gun);
    }
    private static void play(Board board, Player player1, Player player2) {
    	board.print();
    	
    	while (true) {
    		Controller.move(board, player1);
        	board.print();
        	// 오목이 완성되었는지 check.
        	if (Controller.hasOmok(board)) break;
        	
        	Controller.move(board, player2);
        	board.print();
        	// 오목이 완성되었는지 check.
        	if (Controller.hasOmok(board)) break;
    	}
    }
}
