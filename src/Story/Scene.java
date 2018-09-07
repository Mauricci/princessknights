package Story;

import Characters.Attributes.AttributeEnum;
import Characters.Enemy;
import Characters.Princess;
import GameLogic.Combat;
import GameLogic.CombatResult;
import GameLogic.CombatVariables;

import java.util.Map;

public class Scene {
    private DialogData currentDialogData;
    private String choiceOneID, choiceTwoID;
    private Map<String,Dialog> dialogs;
    private Enemy monster;
    private String selectedChoice;
    private int flag;

    public Scene(Map<String, Dialog> dialogs, String firstDialogID){
        this.dialogs = dialogs;
        currentDialogData = new DialogData(firstDialogID,StoryConstants.AUTO_NEXT_QUESTION);
    }

    SceneData doScene(Princess princess){
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
            flag = StoryConstants.SCENARIO_DONE;
        }else if(combatDone){
            flag = StoryConstants.COMBAT_DONE;
            if(result.getResult() < 1){
                selectedChoice = choiceTwoID;
            }else{
                selectedChoice = choiceOneID;
            }
        }
        return new SceneData(result, selectedChoice, flag);
    }
}
