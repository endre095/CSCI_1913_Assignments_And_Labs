/*
 * CSCI 1913
 * Lab 06
 * Author: TODO: FILL ME IN
 * */


public class NIM {

    /**
     * create a game state array
     *
     * @param size     -- the number of rows
     * @param stickMax -- the largest value
     * @return an array representing a token array. The array in the first position will be one, each following will be
     * one larger up to the max.
     */
    public static int[] createGameState(int size, int stickMax) {
        int[] game_state = new int[size];
        if (size == 0) {
            return game_state;
        }
        for (int i = 0; i < size ; i++) {
            if (i < stickMax) {
                game_state[i] = i+1;
            } else {
                game_state[i] = stickMax;
            }
        }
        return game_state;
    }


    /**
     * This provided function operators similarly to the python isDigit method. You give it a string and it will tell
     * you if the string contains only digits. Give it a read -- the actual design isn't hard, basically a linear search.
     *
     * @param str any string
     * @return true if all letters in the string are digits.
     */
    private static boolean isDigit(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * Checks if a given move (as represented by two input strings) is valid. This should check if the inputs are numbers
     * if those numbers are in the valid range.
     *
     * @param gameState an array representing the number of tokens in each row.
     * @param row       a string representing which row the user wants to take from. 1-indexed.
     * @param takes     a string representing how many tokens the user wants to take.
     * @return true if and only if the move would be valid
     */
    public static boolean isValidMove(int[] gameState, String row, String takes) {
        if (!isDigit(row) || !isDigit(takes)) {
            return false;
        }
        int takesInt = Integer.parseInt(takes);
        int rowInt = Integer.parseInt(row) ;
        if (rowInt < 1) {
            return false;
        }
        if (rowInt > gameState.length) {
            return false;
        }
        if (takesInt > 3 || takesInt < 1) {
            return false;
        }
        if (takesInt > gameState[rowInt - 1]) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * User System.out.println to represent a token grid to the program user.
     *
     * @param gameState an array representing the number of tokens in each row.
     */
    public static void drawGameState(int[] gameState) {
        String bar = "====================";
        String hash = "#";
        String line = "";
        System.out.println(bar);
        for (int i = 0; i < gameState.length; i++) {
            for (int j = 0; j < gameState[i]; j++) {
                line = line.concat(hash);
            }
            System.out.println(i + 1 + " " + line);
            line = "";
        }
        System.out.println(bar);
    }


    /**
     * Create an updated version of the game state. You can assume the row and takes are valid for the gameState array provided.
     *
     * @param gameState an array representing the number of tokens in each row.
     * @param row       the row the user wants to take from (0-indexed)
     * @param takes     the number of tokens the user wants to take
     * @return a new array representing the state number of tokens in each row after the given numbers were removed.
     */
    public static int[] update(int[] gameState, int row, int takes) {
        int[] newGameState = new int[gameState.length];
        for (int i = 0; i < gameState.length; i++){
            newGameState[i] = gameState[i];
        }
        newGameState[row] -= takes;
        return newGameState;
    }

    /**
     *
     * @param gameState an array representing the number of tokens in each row.
     * @return true if and only if every element of gameState is false.
     */
    public static boolean isOver(int[] gameState) {
        int total = 0;
        for (int i = 0; i < gameState.length; i++) {
            total += gameState[i];
        }
        if (total != 0) {
            return false;
        }
        return true;
    }


    public static void main(String[] args) {
        /*int[] new_state = createGameState(5, 3);
        if (new_state.length == 0) {
            System.out.println("empty");
        }
        for (int i = 0; i < new_state.length; i++){
            System.out.println(new_state[i]);
        }

        int[] testState1 = {5, 3, 4, 1};
        int[] testState1_ = update(testState1, 2, 3);
        for (int i = 0; i < testState1.length; i++) {
            System.out.println(testState1[i]);
        }
        for (int i = 0; i < testState1_.length; i++) {
            System.out.println(testState1_[i]);
        }

        int[] testArr = {5,2,3,1};
         drawGameState(testArr);
         */

    }
}

