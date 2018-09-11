package Story;

import Characters.Attributes.AttributeEnum;
import Characters.Enemy;
import Characters.Princess;
import GameLogic.Combat;
import GameLogic.CombatResult;
import GameLogic.CombatVariables;

import java.util.Map;

public class Scene {
    String id;
    private DialogData currentDialogData;
    private Map<String,Dialog> dialogs;
    private Enemy enemy;
    private String selectedChoice;
    private int flag;
    private String firstDialogID;

    public Scene(String sceneID, Enemy enemy, Map<String, Dialog> dialogs, String firstDialogID){
        this.id = sceneID;
        this.enemy = enemy;
        this.dialogs = dialogs;
        this.firstDialogID = firstDialogID;
        this.selectedChoice = this.id;
        currentDialogData = new DialogData(firstDialogID, "", StoryConstants.AUTO_NEXT_DIALOG, dialogs.get(firstDialogID));
    }

    public SceneData doScene(Princess princess, int choice){
        CombatResult result = null;
        boolean combatDone = false;

        if(currentDialogData.getFlag() != StoryConstants.DONE){
            currentDialogData = dialogs.get(currentDialogData.getSelectedChoice()).doDialog(choice);
            if(currentDialogData.getFlag() == StoryConstants.COMBAT){
                Combat combat = new Combat();
                AttributeEnum attributeEnum = currentDialogData.getDialog().getDefaultAtribute();
                result = combat.calculateCombatResult(new CombatVariables(princess, attributeEnum), new CombatVariables(enemy, attributeEnum));
                combatDone = true;
                flag = StoryConstants.COMBAT_DONE;
            }
        }

        if(currentDialogData.getFlag() == StoryConstants.DONE) {
            if(currentDialogData.selectedChoice == null){
                flag = StoryConstants.SCENARIO_DONE;
            }
            else {
                selectedChoice = currentDialogData.selectedChoice;
            }
//
            // IF DEPENDING ON CHOICES
//            if (choice == 1) {
//
//
//            } else if (choice == 2) {
//                selectedChoice = currentDialogData.otherChoice;
//            }
        }else if(combatDone){
            if(result.getResult() == 1){
                selectedChoice = currentDialogData.selectedChoice;
            }else{
                selectedChoice = currentDialogData.otherChoice;
            }
        }
        return new SceneData(selectedChoice, flag, currentDialogData);
    }

    public String getFirstDialogID(){
        return dialogs.get(firstDialogID).getID();
    }

    public int getFirstDialogFlag(){
        return dialogs.get(firstDialogID).getFlag();
    }
}
