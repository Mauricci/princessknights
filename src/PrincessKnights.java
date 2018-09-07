import Characters.Princess;
import Characters.Skills.CharacterSkills;
import Characters.Skills.Skill;
import Characters.Skills.Skills;
import Story.*;
import UI.Drawable;
import UI.Window;
import Repository.Repository;
import Story.Dialog;
import Story.Scenario;
import Story.Scene;
import Story.StoryConstants;
import TrainingLogic.TrainingLogic;
import java.util.*;

public class PrincessKnights {
    public static void main(String[] args) {
        String connstr = args[0];
        Repository repository = new Repository(connstr);

        Princess princess = new Princess(repository, 5,5,5,5,5,5,new Skills(new ArrayList<>()));

        boolean firstRun = true;
        Window window = new Window(null);

        Scanner scanner = new Scanner(System.in);
        Map<String,Scene> scenes = new HashMap<>();
        Map<String, Dialog> dialogs = new HashMap<>();
        dialogs.put("2",new Dialog("Här är första dialogen", StoryConstants.DO_CHOICE, "2","3","4",""));
        dialogs.put("3",new Dialog("Här är andra dialogen", StoryConstants.AUTO_NEXT_QUESTION, "3","4","4",""));
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

            if(currentScene.getFlag() == StoryConstants.SCENARIO_DONE){
                 running = false;
            }
            firstRun = false;
        }
      
        boolean running = true;
        while(running){
            //Get princess skills and as a list of them
           List<Skill> currentSkills = princess.getCharacterSkillList();

            //when press training button run following on chosen skill:
            trainingLogic.trainPrincess(princess, princess.getCharacterSkills(), currentSkills.get(1));

        }
    }
}
