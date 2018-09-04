import Characters.Attributes.AttributeEnum;
import Characters.Skills.Skill;
import Characters.Enemy;
import Characters.Princess;
import GameLogic.Combat;
import GameLogic.CombatVariables;
import TrainingLogic.TrainingLogic;

public class Sandbox {
    public static void main(String[] args) {

        Princess princess = new Princess(1, 2, 3, 4, 5, 6);

        Skill skill = new Skill("test", AttributeEnum.INTELLIGENCE, 20, 1);

        Enemy enemy = new Enemy(1, 2, 3, 4, 5);

        TrainingLogic trainingLogic = new TrainingLogic();
        trainingLogic.trainAttribute(princess, skill);

        Combat combat = new Combat();
        combat.calculateCombatResult(new CombatVariables(princess, AttributeEnum.INTELLIGENCE, skill),
                new CombatVariables(enemy, AttributeEnum.INTELLIGENCE));

        System.out.println();

    }
}
