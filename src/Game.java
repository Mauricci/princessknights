import Characters.Princess;
import Characters.Skills.Skills;
import Repository.Repository;
import Story.Scenario;
import Story.SceneData;
import Story.StoryConstants;
import TrainingLogic.TrainingLogic;
import UI.Drawable;
import UI.NewWindow;
import UI.Panel;
import UI.Window;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {

    private String connstr;
    private Repository repository;
    private Princess princess;
    private TrainingLogic trainingLogic;
    private Scanner scanner;
    //    Map<String,Scene> scenes;
//    Map<String, Dialog> dialogs;
    private List<Scenario> scenarioList;
    private NewWindow window;

    public Game(String args, NewWindow window) {

        connstr = args;
        repository = new Repository(connstr);
        princess = new Princess(repository, 5,5,5,5,5,5,new Skills(new ArrayList<>()));
        trainingLogic = new TrainingLogic();
        this.window = window;
        scanner = new Scanner(System.in);
        scenarioList = repository.getAllScenarios();
//        scenes = new HashMap<>();
//        dialogs = new HashMap<>();
//        dialogs.put("2",new Dialog("Här är första dialogen", StoryConstants.DO_CHOICE, "2","3","4",""));
//        dialogs.put("3",new Dialog("Här är andra dialogen", StoryConstants.AUTO_NEXT_DIALOG, "3","4","4",""));
//        dialogs.put("4",new Dialog("Här är tredje dialogen", StoryConstants.DONE, "4","0","0",""));
//
//        scenes.put("5", new Scene("5",dialogs,"2"));

    }
    public void StartGame() {

        boolean running = true;
        boolean firstRun = true;
        int choice = 0;

        while(running) {
            if(!firstRun){
                choice = scanner.nextInt();
            }
            else {
                firstRun = false;
            }
            Scenario scenario = scenarioList.get(0);
            SceneData currentScene = scenario.doScenario(princess, choice);
            ArrayList<Drawable> drawable = new ArrayList<>();
            drawable.add(currentScene.getDialog());
            window.render(drawable);
            if(currentScene.getFlag() == StoryConstants.SCENARIO_DONE){
                 running = false;
            }
        }
    }

//    SceneData currentScene = scenario.doScenario(princess, choice);
//            ArrayList<Drawable> drawables = new ArrayList<>();
//            drawables.add(currentScene.getDialog());
//            window.render(drawables);

//
//            firstRun = false;
//        }
//
//        while(running){
//            //Get princess skills and as a list of them
//           List<Skill> currentSkills = princess.getCharacterSkillList();
//
//            //when press training button run following on chosen skill:
//            trainingLogic.trainPrincess(princess, princess.getCharacterSkills(), currentSkills.get(1));
//        }
}
