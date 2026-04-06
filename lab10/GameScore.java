public class GameScore implements Comparable<GameScore>{
    private double score;
    private String recordName;
    private boolean hardMode;

    public GameScore(String name, double score, boolean mode) {
        recordName = name;
        this.score = score;
        hardMode = mode;
    }

    public String getName() { //returns current name
        return this.recordName;
    }

    public double getScore() { //returns current score
        return this.score;
    }

    public boolean isHardMode() { //returns current game difficulty 
        return this.hardMode;
    }

    public String toString() {
        if (this.hardMode) {
            return (this.recordName + " " + this.score + "*");
        }
        return (this.recordName + " " + this.score);
    }
    /*
     * this function returns a string based on the difficulty of the game played
     */
    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (this == o) return true;
        if (!(o instanceof GameScore)) return false;

        GameScore temp = (GameScore) o;
        if (this.recordName.equals(temp.recordName) && // tricky, i forgot you had to use this version for strings because they are also objects 
            this.score == temp.score && 
            this.hardMode == temp.hardMode) {
                return true;
            }
        return false;
    }
    /*
     * this function checks if the object passed into the function has all equal
     * data members to the current instance object its being called on, if it does
     * it returns true, else returns false
     */

    public int compareTo(GameScore other) {
        if (this.isHardMode() && !other.isHardMode()) { // determins if one game is on hard mode and the other isnt, if
                                                        // so, returns the winner
            return 1;
        }
        else if (!this.isHardMode()  && other.isHardMode()) {
            return -1;
        }

        if (this.getScore() > other.getScore()) {
            return 1;
        }
        else if (this.getScore() < other.getScore()) {
            return -1;
        }
        else {
            return 0;
        }
    }
    /*
     * sees if two gamescores are equal to each other by first checking if either is
     * hard mode, then going next to the game score, and returning 1 for this is
     * bigger, -1 for other is bigger, and 0 if they are equal
     */
}
