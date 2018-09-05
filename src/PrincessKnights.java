import Characters.Princess;
import Characters.Skills.Skills;
import Story.Dialog;
import Story.Scenario;
import Story.Scene;
import Story.StoryConstants;
import UI.Window;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PrincessKnights {
    public static void main(String[] args) {
        boolean running = true;
        Princess princess = new Princess(5,5,5,5,5,5,new Skills(new ArrayList<>()));
        while(running){
            Scanner scanner = new Scanner(System.in);
            Map<Integer,Scene> scenes = new HashMap<>();
            Map<Integer, Dialog> dialogs = new HashMap<>();
            dialogs.put(2,new Dialog("Här är första dialogen", StoryConstants.DOCHOICE, 2,3,4));
            dialogs.put(3,new Dialog("Här är andra dialogen", StoryConstants.AUTONEXTQUESTION, 3,4,4));
            dialogs.put(4,new Dialog("Här är tredje dialogen", StoryConstants.DONE, 4,0,0));

            scenes.put(5, new Scene(dialogs,2));
            Scenario scenario = new Scenario(scenes,5);
            running = scenario.doScenario(princess);
        }
    }
}
