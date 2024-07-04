public class Board {
    private char[][] cells; // Declares a two-dimensional array of chars to represent the game board

    public Board() {
        cells = new char[3][3];
        clear(); // Calls the "clear()" method to clear the board
    }

    public boolean isCellEmpty(int x, int y) { // Method to check if a specific cell is empty
        return cells[x][y] == ' '; // Returns true if the cell at position (x, y) is a space
    }

    public void place(int x, int y, char marker) { // Method to place a marker (e.g., 'X' or 'O') in a cell
        if (isCellEmpty(x, y)) { // Checks if the cell is empty
            cells[x][y] = marker; // Places the marker in the cell if it is empty
        }
    }

    public boolean isFull() { // Method to check if the board is full
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (cells[i][j] == ' ') { // Checks if the cell is empty
                    return false; // Returns false if an empty cell is found
                }
            }
        }
        return true; // Returns true if no empty cell is found
    }

    public void clear() { // Method to clear the board
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cells[i][j] = ' '; // Sets each cell to a space
            }
        }
    }

    public void print() { // Method to print the board
        System.out.println("▁▁▁▁▁▁▁"); // Prints a top border line
        for (int i = 0; i < 3; i++) {
            System.out.print("|"); // Prints a left border line
            for (int j = 0; j < 3; j++) {
                System.out.print(cells[i][j] == ' ' ? " " : cells[i][j]); // Prints the cell character or a space
                System.out.print("|"); // Prints a vertical separator between cells
            }
            System.out.println(); // Line break after each row
        }
        System.out.println("▔▔▔▔▔▔▔"); // Prints a bottom border line
    }

    public char[][] getCells() { // Method to return the board
        return cells; // Returns the array "cells"
    }
}