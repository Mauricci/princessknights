package Story;

import UI.Drawable;

public class Dialog implements Drawable {
    private String text;
    private int flag;
    private String id;
    private String choiceOneID, choiceTwoID;
    private String defaultAtribute;

    private String selectedChoice;

    public Dialog(String text, int flag, String id, String choiceOneID, String choiceTwoID, String attribute) {
        this.text = text;
        this.flag = flag;
        this.id = id;
        this.choiceOneID = choiceOneID;
        this.choiceTwoID = choiceTwoID;
        this.defaultAtribute = attribute;
        selectedChoice = this.id;
    }

    public DialogData doDialog(int choice) {
        if (flag == StoryConstants.COMBAT || flag == StoryConstants.DONE) {
            selectedChoice = choiceOneID;
        } else {
            //if(selectedChoice == null){
            if (flag == StoryConstants.AUTO_NEXT_QUESTION) {
                selectedChoice = choiceOneID;
            } else {
                if (choice == 1) {
                    System.out.println("doing choice one");
                    selectedChoice = choiceOneID;
                } else if (choice == 2) {
                    selectedChoice = choiceTwoID;
                }
            }
            // }
        }

        DialogData dialogData = new DialogData(selectedChoice, flag, this);
        System.out.println(dialogData);
        return dialogData;
    }

    public String getText() {
        return text;
    }

    public String getID() {
        return id;
    }

    public int getFlag() {
        return flag;
    }
}
