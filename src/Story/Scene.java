package Story;

import Characters.Attributes.AttributeEnum;
import Characters.Enemy;
import Characters.Princess;
import GameLogic.Combat;
import GameLogic.CombatResult;
import GameLogic.CombatVariables;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Scene {
    private DialogData currentDialogData;
    //collection av dialog
    private Map<Integer,Dialog> theMap = new HashMap<>();
    private Princess princess;
    private Enemy monster = new Enemy(2,2,2,2,2);
    //combat mappat till olika dialoger
    public Scene(Princess princess, List<Integer> dialogIDs){
        this.princess = princess;
        //hämta in alla aktuella dialoger
    }

    public SceneData doScene(){
        CombatResult result = null;
        boolean combatDone = false;
        while(currentDialogData.getFlag() != StoryConstants.DONE || !combatDone){

            currentDialogData = theMap.get(currentDialogData.getId()).doDialog();

            if(currentDialogData.getFlag() == StoryConstants.COMBAT){
                Combat combat = new Combat();
                result = combat.calculateCombatResult(new CombatVariables(princess, AttributeEnum.CHARISMA), new CombatVariables(monster, AttributeEnum.CHARISMA));
                combatDone = true;
            }

        }
        return new SceneData(result);
    }
}
