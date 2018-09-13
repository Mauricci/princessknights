import Characters.Princess;
import Characters.Skills.Skills;
import Repository.Repository;
import Story.Scenario;
import Story.SceneData;
import Story.StoryConstants;
import TrainingLogic.TrainingLogic;
import UI.Drawable;
import UI.NewWindow;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {

    private String connstr;
    private Repository repository;
    private Princess princess;
    private TrainingLogic trainingLogic;
    private Scanner scanner;
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
    }
    public void StartGame() {
        boolean running = true;
        boolean firstRun = true;
        SceneData currentScene = null;
        Scenario scenario = scenarioList.get(0);
        int choice = 0;

        while(running) {
            try{
                Thread thread = new Thread();
                thread.sleep(200);
            }catch(Exception e){
                e.printStackTrace();
            }
            boolean input = false;
            if(!firstRun){
                if(!doingScenario){
                    if (window.isAlternative3()) {
                        input = true;
                        choice = window.getSelectedChoice();
                        doingScenario = true;
                    }
                }else{
                    if(window.isAlternative1()) {
                        input = true;
                        choice = 1;
                    }
                    else if (window.isAlternative2()) {
                        input = true;
                        choice = 2;
                    }
                    else if (window.isAlternative3()) {
                        input = true;
                        choice = 0;
                    }
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
}
