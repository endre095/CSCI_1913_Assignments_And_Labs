public class HealingSkill extends Skill {

    public HealingSkill(String name, int strength, int usageLimit) {
        super(name, strength, usageLimit);
    }
    /*
     * exactly the same constructor as skill, no new inputs
     */

    @Override
    public void applyChanges(CodeMonster me, CodeMonster foe) {
        me.adjustHealth(-1*this.getStrength());
    }
    /*
     * instead of taking away health, this gives a player health by adding it to
     * their currentHp
     */
}
