package Dialog;

import Characters.Attributes.AttributeEnum;
import Characters.Enemy;
import Characters.Princess;
import Characters.Skills.Skill;
import GameLogic.Combat;
import GameLogic.CombatVariables;

import java.util.List;

public class Scenes {
    private String scenarioID;
    private List<Dialog> dialogs;
    private Combat combat = new Combat();
    private Princess princessPlayer;
    private Enemy enemyInScene;

    public Scenes(List<Dialog> dialogs, Combat combat, Princess princess) {
//        this.scenarioID = getScenearioIDFromDB(scenarioID);
        this.dialogs = dialogs;
        this.combat = combat;
        this.princessPlayer = princess;
        //this.enemyInScene = getEnemyFromDB(sceneID);
        this.loopScene();
    }

    public Scenes(List<Dialog> dialogs) {
        this.dialogs = dialogs;
    }

    private void loopScene() {
        while (true) {
            Skill skill;
            //get attributeEnum and skill from input
            if ("userInput" == "nextDialog") {
                nextInOrder(1);
            } else if ("userInput" == "combat")
                combat.calculateCombatResult(new CombatVariables(princessPlayer, AttributeEnum.STRENGTH, skill),
                        new CombatVariables(enemyInScene, AttributeEnum.STRENGTH));

            //check what combatresult is and play next appropriate scene
        }
    }

    private int nextInOrder(int current) {
        return current++;
    }
}
