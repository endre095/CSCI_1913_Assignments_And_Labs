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

    public Skill() {
        this.name = "";
        this.strengthScore = 0;
        this.maxUses = 0;
        this.usesRemaining = 0;
    }

    public String getName(){return this.name;}

    public int getStrength(){return this.strengthScore;}

    public int getUsageLimit(){return this.maxUses;}

    public int getUsageLeft() {return this.usesRemaining;}
    /*
     * simple getters/setters
     */

    public void setUsageLeft() {
        if (this.usesRemaining > 1) {
            this.usesRemaining--;
        }
        else {
            this.usesRemaining = 0;
        }
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
        int usesRem = this.getUsageLeft();

        System.out.println(me.toString() + " uses " + this.toString() + " on " + foe.toString());
        if (usesRem > 0) {
            applyChanges(me, foe);
            this.setUsageLeft();
        }
    }
    /*
     * uses a skill by determining if it has any uses left, if it does it is used,
     * otherwise it sets the uses left to 0 and prints the results
     */

    public void applyChanges(CodeMonster me, CodeMonster foe){
        int skillDamage = this.getStrength();
        foe.adjustHealth(-skillDamage);
    }
    /*
     * adjusts the opponents health by decreasing it by the strength of the others skill
     */
}
