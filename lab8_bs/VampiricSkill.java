public class VampiricSkill extends Skill{
    public VampiricSkill(String name, int strength, int usageLimit){
        super(name,strength,usageLimit);
    }
    /*
     * exactly the same constructor as skill, no new inputs
     */

    @Override
    public void applyChanges(CodeMonster me, CodeMonster foe){
        foe.adjustHealth(-this.getStrength());
        me.adjustHealth(this.getStrength());
    }
    /*
     * does damage to the opponent as the other classes besides healingskill do, but
     * also heals the monster who did the damage
     */
}
