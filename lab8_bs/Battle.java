public class Battle {
    public static void doOneTurn(CodeMonster one, CodeMonster two) {
        Skill tempSkill;
        if (one.getNextTurnTime() <= two.getNextTurnTime()) {
            tempSkill = one.takeTurn();
            tempSkill.useSkill(one, two);
        } else {
            tempSkill = two.takeTurn();
            tempSkill.useSkill(two, one);
        }
    }
    /*
     * this function creates a skill object with a specific skill from the monsters
     * skill array, then uses that skill against the other one if it has a lower
     * skill time, otherwise the other monster does damage to them
     */

    public static CodeMonster battle(CodeMonster one, CodeMonster two){
        one.prepForBattle();
        two.prepForBattle();
        System.out.println(one.toString() + " vs. " + two.toString());
        while(one.isAlive() && two.isAlive()) {
            doOneTurn(one,two);
        }
        if (one.getHp() == 0) {
            System.out.println(two.toString() + " wins!");
            return two;
        }
        else {
            System.out.println(one.toString() + " wins!");
            return one;
        }
    }
    /*
     * this runs the dooneturn function while both players are alive, otherwise it
     * ends and prints the player who still has health remaining
     */
}
