import Characters.Princess;
import Characters.Skills.Skills;
import Story.*;
import UI.Drawable;
import UI.Window;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PrincessKnights {
    public static void main(String[] args) {
        boolean running = true;
        boolean firstRun = true;
        Princess princess = new Princess(5,5,5,5,5,5,new Skills(new ArrayList<>()));
        Window window = new Window(null);

        Scanner scanner = new Scanner(System.in);
        Map<String,Scene> scenes = new HashMap<>();
        Map<String, Dialog> dialogs = new HashMap<>();
        dialogs.put("2",new Dialog("Här är första dialogen", StoryConstants.DOCHOICE, "2","3","4",""));
        dialogs.put("3",new Dialog("Här är andra dialogen", StoryConstants.AUTONEXTQUESTION, "3","4","4",""));
        dialogs.put("4",new Dialog("Här är tredje dialogen", StoryConstants.DONE, "4","0","0",""));

        scenes.put("5", new Scene("5",dialogs,"2"));
        Scenario scenario = new Scenario(scenes,"5");

        int choice = 0;
        while(running){
            if(!firstRun){
                 choice = scanner.nextInt();
            }

            SceneData currentScene = scenario.doScenario(princess, choice);
            ArrayList<Drawable> drawables = new ArrayList<>();
            drawables.add(currentScene.getDialog());
            window.render(drawables);

            if(currentScene.getFlag() == StoryConstants.SCENARIODONE){
                 running = false;
            }
            firstRun = false;
        }
    }
}
