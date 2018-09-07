package Story;

class DialogData {
    private String id;
    private int flag;
    DialogData(String id, int flag){
        this.id = id;
        this.flag = flag;
    }

    String getId() {
        return id;
    }

    int getFlag() {
        return flag;
    }
}
