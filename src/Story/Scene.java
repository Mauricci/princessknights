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
    private String choiceOneID, choiceTwoID;
    private Map<String,Dialog> dialogs = new HashMap<>();
    private Enemy monster = new Enemy("2",2,2,2,2,2);
    private String selectedChoice;
    private int flag;
    //combat mappat till olika dialoger

    public Scene(Map<String, Dialog> dialogs, String firstDialogID){
        this.dialogs = dialogs;
        currentDialogData = new DialogData(firstDialogID,StoryConstants.AUTONEXTQUESTION);
    }

    public SceneData doScene(Princess princess){
        CombatResult result = null;
        boolean combatDone = false;
        while(currentDialogData.getFlag() != StoryConstants.DONE && !combatDone){

            currentDialogData = dialogs.get(currentDialogData.getId()).doDialog();

            if(currentDialogData.getFlag() == StoryConstants.COMBAT){
                Combat combat = new Combat();
                result = combat.calculateCombatResult(new CombatVariables(princess, AttributeEnum.CHARISMA), new CombatVariables(monster, AttributeEnum.CHARISMA));
                combatDone = true;
            }
        }
        if(currentDialogData.getFlag() == StoryConstants.DONE) {
            flag = StoryConstants.SCENARIODONE;
        }else if(combatDone){
            flag = StoryConstants.COMBATDONE;
            if(result.getResult() < 1){
                selectedChoice = choiceTwoID;
            }else{
                selectedChoice = choiceOneID;
            }
        }
        return new SceneData(result, selectedChoice, flag);
    }
}
