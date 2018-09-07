package Story;

import GameLogic.CombatResult;

class SceneData {
    String id;
    int flag;
    DialogData dialogData;

    public SceneData(CombatResult combatResult, String id, int flag, DialogData dialogData){
        this.id = id;
        this.flag = flag;
        this.dialogData = dialogData;
    }
  
    String getId() {
        return id;
    }

    int getFlag() {
        return flag;
    }
  
    public DialogData getDialogData(){
        return dialogData;
    }
  
    public Dialog getDialog(){
        return dialogData.getDialog();
    }
}
