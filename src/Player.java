public class Player {
    private char marker;
    // Constructor to initialize the player with a given marker
    public Player(char marker) {
        this.marker = marker;// Assign the marker to the instance variable
    }
    // Method to retrieve the marker of the player
    public char getMarker() {
        return marker;// Return the player's marker
    }
}