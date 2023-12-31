package basics;

/**
 * A class that represents a game of Four in a Row.
 * The game is played on a 6x7 board.
 * A player wins when he has 4 pieces in a row, column or diagonal.
 *
 * ForInARow is a two-player connection rack game, in which the players choose a color and
 * then take turns dropping colored tokens into a six-row, seven-column vertically suspended grid.
 * The pieces fall straight down, occupying the lowest available space within the column.
 *
 * The objective of the game is to be the first to form a horizontal,
 * vertical, or diagonal line of four of one's own tokens.
 *
 * Your taks is to model the game and implement the method hasWon(char player) that returns true.
 * if the player has won the game.
 * We advise you to model the state of the game with an internal 2D array of char.
 */
public class FourInARow {
    private static final int ROWS = 6;
    private static final int COLUMNS = 7;

    private static final char EMPTY = '-';
    private static final char[] PLAYERS = {'X', 'O'};

     // add your own instance variables here

    private static boolean[] IS_COLUMN_FULL = new boolean[7];

    private char [][] GRID = new char[ROWS][COLUMNS];

    public FourInARow() {
    }

    /**
     * Play a piece in column j for the given player.
     * @param j the column index
     * @param player the player (X or O)
     * @throws IllegalArgumentException if j is not a valid column index or if the column is full or if the player is not X or O
     */
    public void play(int j, char player) {
         if (j >= COLUMNS || (player != 'X' && player != 'O') || IS_COLUMN_FULL[j]){
             throw new IllegalArgumentException();
         }
         for (int i = 0; i < ROWS; i++){
             if (GRID[ROWS-i-1][j] == 0){
                 GRID[ROWS-i-1][j] = player;
                 if (i == ROWS-1) IS_COLUMN_FULL[j] = true;
                 return;
             }
         }
    }


    /**
     * Returns true if the player has won the game.
     * @param player the player (X or O)
     * @return true if the player has won the game
     * @throws IllegalArgumentException if the player is not X or O
     */
    public boolean hasWon(char player) {
        // TODO
        if (player != 'X' && player != 'O') throw new IllegalArgumentException();
        for (int i = 0; i < ROWS; i++){
            for (int j = 0; j < COLUMNS; j++){
                if (GRID[i][j] == player){
                    // checking right side
                    if(j+3 < COLUMNS){
                        if (GRID[i][j+1] == player && GRID[i][j+2] == player && GRID[i][j+3] == player) return true;
                    }
                    // checking down side
                    if (i+3 < ROWS){
                        if (GRID[i+1][j] == player && GRID[i+2][j] == player && GRID[i+3][j] == player) return true;
                    }
                    // checking diagonal right
                    if (i+3 < ROWS && j+3 < COLUMNS){
                        if (GRID[i+1][j+1] == player && GRID[i+2][j+2] == player && GRID[i+3][j+3] == player) return true;
                    }
                    // checking diagonal left
                    if (i-3 >= 0 && j+3 < COLUMNS){
                        if (GRID[i-1][j+1] == player && GRID[i-2][j+2] == player && GRID[i-3][j+3] == player) return true;
                    }
                }
            }
        }
        return false;
    }
}
