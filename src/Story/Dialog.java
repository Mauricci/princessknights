package Story;

import java.util.Scanner;

public class Dialog {


    private String text;
    private int flag;
    private int id;
    private int choiceOneID, choiceTwoID;
    private int selectedChoice = 0;

    public Dialog(String text, int flag, int id, int choiceOneID, int choiceTwoID) {
        this.text = text;
        this.flag = flag;
        this.id = id;
        this.choiceOneID = choiceOneID;
        this.choiceTwoID = choiceTwoID;
    }

    public DialogData doDialog(){
        System.out.println(text);
        if(flag == StoryConstants.COMBAT || flag == StoryConstants.DONE){
            selectedChoice = choiceOneID;
        }else{
            while(selectedChoice == 0){
                if(flag == StoryConstants.AUTONEXTQUESTION){
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
