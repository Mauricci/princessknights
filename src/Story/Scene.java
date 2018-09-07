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
    String id;
    private DialogData currentDialogData;
    private String choiceOneID, choiceTwoID;
    private Map<String,Dialog> dialogs = new HashMap<>();
    private Enemy monster = new Enemy("2",2,2,2,2,2);
    private String selectedChoice;
    private int flag;
    private String firstDialogID;
    //combat mappat till olika dialoger

    public Scene(String sceneID,Map<String, Dialog> dialogs, String firstDialogID){
        this.id = sceneID;
        this.dialogs = dialogs;
        this.firstDialogID = firstDialogID;
        this.selectedChoice = this.id;
        currentDialogData = new DialogData(firstDialogID,StoryConstants.AUTONEXTQUESTION,dialogs.get(firstDialogID));
    }

    public SceneData doScene(Princess princess, int choice){
        CombatResult result = null;
        boolean combatDone = false;
        if(currentDialogData.getFlag() != StoryConstants.DONE && !combatDone){

            currentDialogData = dialogs.get(currentDialogData.getId()).doDialog(choice);

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
        System.out.println(currentDialogData);
        return new SceneData(result, selectedChoice, flag,currentDialogData);//, dialogs.get(currentDialogData.getId())
    }
    public String getFirstDialogID(){
        return dialogs.get(firstDialogID).getID();
    }
    public int getFirstDialogFlag(){
        return dialogs.get(firstDialogID).getFlag();
    }
}
