package Story;

public class DialogData {
    String selectedChoice;
    String otherChoice;
    int flag;
    Dialog dialog;
  
  public DialogData(String selectedChoice, String otherChoice, int flag, Dialog dialog){
        this.selectedChoice = selectedChoice;
        this.otherChoice = otherChoice;
        this.flag = flag;
        this.dialog = dialog;
    }

    String getSelectedChoice() {
        return selectedChoice;
    }

    String getOtherChoice() {
      return otherChoice;
    }

    int getFlag() {
        return flag;
    }
  
    public Dialog getDialog(){
        return dialog;
    }
}
