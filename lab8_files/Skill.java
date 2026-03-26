public class Skill {
    private String name;
    private int strengthScore;
    private int maxUses;
    private int usesRemaining;

    public Skill(String name, int strength, int usageLimit){
            this.name = name;
            this.strengthScore = strength;
            this.maxUses = usageLimit;
            this.usesRemaining = this.maxUses;
    }
    /*
     * constructs the skill object with its name, strength, and max uses
     */

    public String getName(){return this.name;}

    public int getStrength(){return this.strengthScore;}

    public int getUsageLimit(){return this.maxUses;}

    public int getUsageLeft() {return this.usesRemaining;}
    /*
     * simple getters/setters
     */

    public void setUsageLeft() {
        this.usesRemaining--;
    }

    public void refresh() {
        this.usesRemaining = this.maxUses;
    }
    /*
     * refreshes the amount of uses of the skill called on
     */

    public String toString() {
        return (this.name + " " + this.usesRemaining + "/" + this.maxUses);
    }
    /*
    * returns the name of the skill with the amount of uses left in a message
    */

    public void useSkill(CodeMonster me, CodeMonster foe){
        System.out.println(me.getMoveIndex());
        int usesRem = me.getMoves()[me.getMoveIndex()].getUsageLeft();
        if (usesRem > 0) {
            applyChanges(me, foe);
        }
        me.getMoves()[me.getMoveIndex()].setUsageLeft();
    }

    public void applyChanges(CodeMonster me, CodeMonster foe){
        foe.adjustHealth(me.getMoves()[me.getMoveIndex()].getStrength());
        me.incrementMoveIndex();
    }
    /*
     * gets the index element from the move list and gets its strength score
     */
}
