import java.util.Scanner;

public class TicTacToe {
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private Board board;

    public TicTacToe() {
        player1 = new Player('X'); // Initializes Player 1 with the marker 'X'
        player2 = new Player('O'); // Initializes Player 2 with the marker 'O'
        currentPlayer = player1; // Sets the current player to Player 1
        board = new Board(); // Initializes the game board
    }

    public void start() { // Method that starts the game
        Scanner scanner = new Scanner(System.in);
        while (true) { // Infinite loop for the game
            board.print(); // Prints the current game board
            System.out.println("Current Player: " + currentPlayer.getMarker()); // Displays the current player
            System.out.print("row (0-2): "); // Asks for the row for the next move
            int row = scanner.nextInt(); // Reads the row
            System.out.print("column (0-2): "); // Asks for the column for the next move
            int col = scanner.nextInt();

            if (board.isCellEmpty(row, col)) { // Checks if the selected cell is empty
                board.place(row, col, currentPlayer.getMarker()); // Places the marker of the current player

                    board.print();
                    switchCurrentPlayer(); // Switches the current player

            } else {
                System.out.println("Cell is not empty! Try again."); // Outputs an error message if the cell is not empty
            }
        }

    }

    private void switchCurrentPlayer() { // Method that switches the current player
        currentPlayer = (currentPlayer == player1) ? player2 : player1; // Switches between Player 1 and Player 2
    }



    public static void main(String[] args) { // Main method that starts the program
        TicTacToe game = new TicTacToe(); // Creates a new TicTacToe game
        game.start(); // Starts the game
    }
}