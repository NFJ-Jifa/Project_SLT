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
                if (hasWinner()) { // Checks if the current player has won
                    board.print();
                    System.out.println("Player " + currentPlayer.getMarker() + " wins!"); // Announces the winner
                    break; // Ends the loop and thus the game
                } else if (board.isFull()) { // Checks if the board is full
                    board.print();
                    System.out.println("It's a draw!"); // Announces that the game is a draw
                    break; // Ends the loop and thus the game
                } else {
                    switchCurrentPlayer(); // Switches the current player
                }
            } else {
                System.out.println("Cell is not empty! Try again."); // Outputs an error message if the cell is not empty
            }
        }
        System.out.println("Do you want to start a new Game?"); // Asks for another Game
        System.out.println("Press Enter to start a game or any other key to exit the Game!"); //Option to press enter to restart or any other key to exit
        scanner.nextLine();
        String esc = scanner.nextLine();
        if (esc.trim().isEmpty()) { // Checks if the input is empty
            System.out.println("Starting a new Round!");
            board.clear(); // Clears the game board
            start(); // Starts the game again
        } else {
            System.out.println("exiting the Game");
        }

    }

    private void switchCurrentPlayer() { // Method that switches the current player
        currentPlayer = (currentPlayer == player1) ? player2 : player1; // Switches between Player 1 and Player 2
    }

    private boolean hasWinner() { // Method that checks if there is a winner
        char[][] cells = board.getCells();
        for (int i = 0; i < 3; i++) { // Loop that checks each row and column
            // Checks if a row or column has the same marker
            if ((cells[i][0] == currentPlayer.getMarker() && cells[i][1] == currentPlayer.getMarker() && cells[i][2] == currentPlayer.getMarker()) ||
                    (cells[0][i] == currentPlayer.getMarker() && cells[1][i] == currentPlayer.getMarker() && cells[2][i] == currentPlayer.getMarker())) {
                return true; // Returns true if there is a winner
            }
        } // Checks the diagonals

        if ((cells[0][0] == currentPlayer.getMarker() && cells[1][1] == currentPlayer.getMarker() && cells[2][2] == currentPlayer.getMarker()) ||
                (cells[0][2] == currentPlayer.getMarker() && cells[1][1] == currentPlayer.getMarker() && cells[2][0] == currentPlayer.getMarker())) {
            return true; // Returns true if there is a winner on a diagonal
        }
        return false; // Returns false if there is no winner
    }

    public static void main(String[] args) { // Main method that starts the program
        TicTacToe game = new TicTacToe(); // Creates a new TicTacToe game
        game.start(); // Starts the game
    }
}