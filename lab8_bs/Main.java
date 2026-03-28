public class Main {
    public static void main(String[] args) {
        Skill skill1 = new Skill("Regular", 5, 100);
        Skill skill2 = new HealingSkill("Healing", 2, 150);
        Skill skill3 = new VampiricSkill("Vampiric", 8, 50);
        Skill skill4 = new FastSkill("Fast", 4, 200);
        Skill[] skills1 = {skill1, skill2, skill3, skill4};
        Skill[] skills2 = { skill2, skill4, skill1, skill3 };
        CodeMonster m1 = new CodeMonster(100,5.2, "average guy", skills1);
        CodeMonster m2 = new CodeMonster(150, 9.5, "above-average guy", skills2);
        Battle.battle(m1,m2);
    }
}
