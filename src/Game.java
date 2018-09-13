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
    private boolean doingScenario = true;
    private boolean scenariosRendered;

    public Game(Repository repository, NewWindow window, List<Scenario> scenarios) {

        this.repository = repository;
        princess = new Princess(repository, 5,5,5,5,5,5,new Skills(new ArrayList<>()));
        trainingLogic = new TrainingLogic();
        this.window = window;
        scanner = new Scanner(System.in);
        this.scenarioList = scenarios;
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
        SceneData currentScene = null;
        Scenario scenario = scenarioList.get(0);

        while(running) {
            try{
                Thread thread = new Thread();
                thread.sleep(200);
            }catch(Exception e){

            }
            boolean input = false;
            if(!firstRun){
//                window.isAlternative1();
//                choice = scanner.nextInt();
                if(window.isAlternative1()) {
                    input = true;
                    choice = 1;
                    System.out.println("startgame alternative 1");
                }
                else if (window.isAlternative2()) {
                    input = true;
                    choice = 2;
                    System.out.println("startgame alternative 2");
                }
                else if (window.isAlternative3()) {
                    input = true;
                    choice = 0;
                    System.out.println("startgame alternative 3");
                }
            }

            if(!doingScenario && !scenariosRendered){
                ArrayList<Drawable> drawable = new ArrayList<>();
                for(Scenario scenarioElement : scenarioList){
                    drawable.add(scenarioElement);
                }
                window.render(drawable);
                scenariosRendered = true;
            }else if(input || firstRun) {
                System.out.println("input firstfun");
                if (currentScene != null && currentScene.getDialogData().getSelectedChoice() == null) {
                    scenario = scenarioList.get(choice);
                    currentScene = scenario.doScenario(princess, choice);
                    ArrayList<Drawable> drawable = new ArrayList<>();
                    drawable.add(currentScene.getDialog());
                    window.render(drawable);
                } else {
                    currentScene = scenario.doScenario(princess, choice);
                    ArrayList<Drawable> drawable = new ArrayList<>();
                    drawable.add(currentScene.getDialog());
                    window.render(drawable);
                }
                window.resetAlternatives();

                if (firstRun) {
                    firstRun = false;
                }
                if(currentScene.getFlag() == StoryConstants.SCENARIO_DONE){
                    doingScenario = false;
                    scenariosRendered = false;
                }
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
