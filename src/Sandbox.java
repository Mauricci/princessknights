import Characters.Data.AttributeEnum;
import Characters.Data.Skill;
import Characters.Enemy;
import Characters.Princess;
import GameLogic.Combat;
import GameLogic.CombatResult;
import GameLogic.CombatVariables;
import TrainingLogic.TrainingLogic;

public class Sandbox {
    public static void main(String[] args) {

        Princess princess = new Princess(1, 2, 3, 4, 5, 6);

        Skill skill = new Skill("test", AttributeEnum.INTELLIGENCE, 5, 1);

        Enemy enemy = new Enemy(1, 2, 3, 4, 5);

        TrainingLogic trainingLogic = new TrainingLogic();
        trainingLogic.trainAttribute(princess, skill);

        Combat combat = new Combat();

        CombatResult combatResult = combat.calculateCombatResult(new CombatVariables(princess, AttributeEnum.INTELLIGENCE, skill),
                new CombatVariables(enemy, AttributeEnum.INTELLIGENCE));


        System.out.println(combatResult.getCombatText());

    }
}
