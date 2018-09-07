package Story;

import GameLogic.CombatResult;

public class SceneData {
    String id;
    int flag;
    DialogData dialogData;

    public SceneData(CombatResult combatResult, String id, int flag, DialogData dialogData){
        this.id = id;
        this.flag = flag;
        this.dialogData = dialogData;
    }
  
    public String getId() {
        return id;
    }

    public int getFlag() {
        return flag;
    }
  
    public DialogData getDialogData(){
        return dialogData;
    }
  
    public Dialog getDialog(){
        return dialogData.getDialog();
    }
}
