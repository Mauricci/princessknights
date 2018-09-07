import Characters.Attributes.AttributeEnum;
import Characters.Skills.Skill;
import Characters.Enemy;
import Characters.Princess;
import Characters.Skills.Skills;
import GameLogic.Combat;
import GameLogic.CombatResult;
import GameLogic.CombatVariables;
import TrainingLogic.TrainingLogic;

import java.util.ArrayList;
import java.util.List;

public class Sandbox {
    public static void main(String[] args) {

        List<Skill> skills = new ArrayList<>();
        skills.add(new Skill("Skill 1", "Skill description", AttributeEnum.CHARISMA, 5, 10));
        skills.add(new Skill("Skill 2", "Skill description", AttributeEnum.CHARISMA, 3, 5));
        skills.add(new Skill("Skill 3", "Skill description", AttributeEnum.CHARISMA, 6, 3));
        skills.add(new Skill("Skill 4", "Skill description", AttributeEnum.CHARISMA, 6, 2));
        skills.add(new Skill("Skill 5", "Skill description", AttributeEnum.CHARISMA, 6, 1));

        Skills skillmap = new Skills(skills);

        Princess princess = new Princess(1, 2, 3, 4, 5, 6, skillmap);

        Skill skill = new Skill("test", "test", AttributeEnum.INTELLIGENCE, 5, 6);

        Enemy enemy = new Enemy("1", 2, 3, 4, 5,4);

        TrainingLogic trainingLogic = new TrainingLogic();
        trainingLogic.trainAttribute(princess, skill);

        Combat combat = new Combat();

        CombatResult combatResult = combat.calculateCombatResult(new CombatVariables(princess, AttributeEnum.INTELLIGENCE, skill),
                new CombatVariables(enemy, AttributeEnum.INTELLIGENCE));


        System.out.println(combatResult.getCombatText());

    }
}
