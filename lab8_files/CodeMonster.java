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

    public void setNextTurnTime(double nextTurnTime) {
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

    public void incrementMoveIndex() {
        if (this.moves.length > 1) {
            this.moveIndex++;
        }
        if (this.getMoveIndex() > this.moves.length) {
            this.setMoveIndex((moveIndex-1) % moves.length);
        }
    }

    public void prepForBattle() {
        this.currentHP = this.maxHP;
        this.nextTurnTime = this.speedScore;
        this.moveIndex = 0;
        for (int j = 0; j < this.moves.length; j++) {
            moves[j].refresh();
        }
    }

    public Skill takeTurn() {
        this.nextTurnTime += this.speedScore;
        return moves[(moveIndex-1) % moves.length];
    }

    public boolean isAlive() {
        return (currentHP > 0);
    }

    public int getMoveIndex() {
        return this.moveIndex;
    }

    public void adjustHealth(int amount) {
        int temp = this.currentHP + amount; //damage would be a negative input, healing -> positive
        if (temp > this.maxHP) {
            this.currentHP = this.maxHP;
        }
        else if (temp < 0) {
            this.currentHP = 0;
        }
        else {
            this.currentHP = temp;
        }
        
    }


    public String toString() {
        return (name + " " + this.currentHP + "/" + this.maxHP);
    }
}
