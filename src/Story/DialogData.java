package Story;

public class DialogData {
    String id;
    int flag;
    Dialog dialog;
    public DialogData(String id, int flag, Dialog dialog){
        this.id = id;
        this.flag = flag;
        this.dialog = dialog;
    }

    public String getId() {
        return id;
    }

    public int getFlag() {
        return flag;
    }
    public Dialog getDialog(){
        return dialog;
    }
}
