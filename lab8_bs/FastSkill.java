public class FastSkill extends Skill{
    public FastSkill(String name, int strength, int usageLimit){
        super(name,strength,usageLimit);
    }
    /*
     * exactly the same constructor as skill, no new inputs
     */
    
    public void applyChanges(CodeMonster me, CodeMonster foe){
        foe.adjustHealth(-this.getStrength());
        me.setNextTurnTime(me.getNextTurnTime()-me.getSpeedScore());
    } 
    /*
     * this still does damage to the opponent, but aslo gives the player who played
     * the turn their time back for doing so
     */
}
