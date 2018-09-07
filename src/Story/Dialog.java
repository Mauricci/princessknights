package Story;

import java.util.Scanner;

public class Dialog {


    private String text;
    private int flag;
    private String id;
    private String choiceOneID, choiceTwoID;
    private String defaultAtribute;

    private String selectedChoice = "";

    public Dialog(String text, int flag, String id, String choiceOneID, String choiceTwoID, String attribute) {
        this.text = text;
        this.flag = flag;
        this.id = id;
        this.choiceOneID = choiceOneID;
        this.choiceTwoID = choiceTwoID;
        this.defaultAtribute = attribute;
    }

    public DialogData doDialog(){
        System.out.println(text);
        if(flag == StoryConstants.COMBAT || flag == StoryConstants.DONE){
            selectedChoice = choiceOneID;
        }else{
            while(selectedChoice == null){
                if(flag == StoryConstants.AUTO_NEXT_QUESTION){
                    selectedChoice = choiceOneID;
                }else{
                    Scanner scanner = new Scanner(System.in);

                    int choice = scanner.nextInt();

                    if(choice == 1){
                        selectedChoice = choiceOneID;
                    }else if(choice == 2){
                        selectedChoice = choiceTwoID;
                    }
                }
            }
        }

        return new DialogData(selectedChoice,flag);
    }
}
