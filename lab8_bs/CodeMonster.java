public class CodeMonster {
    private String name;
    private int currentHP;
    private int maxHP;
    private Skill[] moves;
    private int moveIndex;
    private double speedScore;
    private double nextTurnTime;

    public CodeMonster(int maxHp, double speedScore, String name, Skill[] moves){
        this.maxHP = maxHp;
        this.speedScore = speedScore;
        this.name = name;
        this.moves = moves;
        this.currentHP = maxHp;
        this.nextTurnTime = speedScore;
        this.moveIndex = 0;
    }
    /*
     * constructs the codemonster object by setting all required values to the input
     * parametrs and initializing others as neccesary
     */

    public void setNextTurnTime(double nextTurnTime) {
        //System.out.println(this.getNextTurnTime() + "---" + nextTurnTime);
        this.nextTurnTime = nextTurnTime;
    }

    public double getNextTurnTime() {
        return this.nextTurnTime;
    }

    public int getHp() {
        return this.currentHP;
    }

    public int getMaxHp() {
        return this.maxHP;
    }

    public Skill[] getMoves() {
        return this.moves;
    }

    public String getName() {
        return this.name;
    }

    public double getSpeedScore( ){
        return this.speedScore;
    }

    public void setMoveIndex(int n) {
        this.moveIndex = n;
    }
    
    /*
     * required getter/setters
     */
    public void incrementMoveIndex() {
        this.moveIndex++;
        if (this.moveIndex >= this.moves.length){
            this.moveIndex = 0;
        }
    }
    /*
     * increments the move index by one if the length of the skills array is
     * greater than one, if the index of the the move index is larger than the
     * length of the move index, it wraps the index back to 0 to prevent out of
     * bounds access
     */

    public void prepForBattle() {
        this.currentHP = this.maxHP;
        this.nextTurnTime = this.speedScore;
        this.moveIndex = 0;
        for (int j = 0; j < this.moves.length; j++) {
            moves[j].refresh();
        }
    }
    /*
     * preps a monster for battle by resetting all required members, and refreshes
     * all moves
     */

    public Skill takeTurn() {
        //System.out.println(this.moveIndex);
        this.nextTurnTime += this.speedScore;
        Skill currentSkill = this.getCurrentSkill();
        this.incrementMoveIndex();
        return currentSkill;
    }
    /*
     * adds the speed score of the monster to its next turn time, then returns the
     * next move it should be using
     */

    public boolean isAlive() {
        return (currentHP > 0);
    }
    /*
     * checks if health points are greater than zero
     */

    public int getMoveIndex() {
        return this.moveIndex;
    }
    /*
     * returns move index
     */

    public void adjustHealth(int amount) {
        if (amount < this.maxHP) { // heal
            this.currentHP += amount;
        } else if (amount < 0) { // damage
            this.currentHP -= amount; 
        }
        if (this.currentHP > this.maxHP)
            this.currentHP = this.maxHP;
        if (this.currentHP < 0)
            this.currentHP = 0;
        
    }
    /*
     * adjusts health by subtracting from the input, if this result =< 0 it returns
     * 0, else it just returns the subtracted amount
     */


    public String toString() {
        return (name + " " + this.currentHP + "/" + this.maxHP);
    }
    /*
     * returns a string with the name of the monsters and their current health
     */

    public Skill getCurrentSkill() {
        return this.moves[this.moveIndex];
    }
}
